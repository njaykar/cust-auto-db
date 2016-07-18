package hello;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@RequestMapping(value="/customers",method=RequestMethod.GET)
	public String customerList(Model model) {
		model.addAttribute("customers", repository.findAll());
		return "customers";
	}
	
	@RequestMapping(value="/customer/{customerId}",method=RequestMethod.GET)
	public String customer(@PathVariable Long customerId, Model model) {
		model.addAttribute("customer", repository.findOne(customerId));
		model.addAttribute("vehicles", vehicleRepository.findAll());
		return "customer";
	}
	
	@RequestMapping(value="/customers",method=RequestMethod.POST)
	public String customersAdd(@RequestParam String customer_name, @RequestParam String customer_address, Model model) {
        Customer c1 = new Customer();
        c1.setCustomer_name(customer_name);
        c1.setCustomer_address(customer_address);
        repository.save(c1);

        model.addAttribute("customer", c1);
        model.addAttribute("vehicles", vehicleRepository.findAll());
        String tmpId = "" + c1.getCustomerId();
        return "redirect:/customer/" + tmpId;
	}
	
	@RequestMapping(value="/customer/{customerId}/vehicles",method=RequestMethod.POST)
	public String customerAddVehicle(@PathVariable Long customerId, @RequestParam String vehicle_rego, @RequestParam String vehicle_model, @RequestParam String color, Model model) {
		//Vehicle v1 = vehicleRepository.findOne(vehicle_rego);
		Vehicle v1 = new Vehicle();
		v1.setVehicle_rego(vehicle_rego);
		v1.setVehicle_model(vehicle_model);
		v1.setColor(color);
		
		Customer c1 = repository.findOne(customerId);
		v1.setCustomer(c1);
		
		if(c1 != null) {
			if(!c1.hasVehicles(v1)) {
				c1.getVehicles().add(v1);
			}
			repository.save(c1);
			model.addAttribute("customer", repository.findOne(customerId));
			model.addAttribute("vehicles", vehicleRepository.findAll());
			String tmpId = "" + c1.getCustomerId();
			return "redirect:/customer/" + tmpId;
		}
		
		model.addAttribute("customers", repository.findAll());
		return "redirect:/customers";
	}
	
	@RequestMapping(value="/downloadPDF",method=RequestMethod.GET)
	public ModelAndView downloadPDF() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		for(Customer c : repository.findAll()){
			customerList.add(c);
		}
		
		return new ModelAndView("pdfView", "customerList", customerList);
	}
}
