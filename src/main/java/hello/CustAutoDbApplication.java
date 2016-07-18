package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CustAutoDbApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(CustAutoDbApplication.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustAutoDbApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		//Save a few customers
		/*Customer cust1 = new Customer("Lewis Ziino", "105 Bays Street");
		Set car1s = new HashSet<Vehicle>(){{
			add(new Vehicle("LAF 07", "Renault Duster", "Silver", cust1));
			//add(new Vehicle("PIN 00", "BMW X5", "Black", cust1));
		}};
		cust1.setVehicles(car1s);
		
		
		Customer cust2 = new Customer("Brad Aland", "101 Green Street");
		Set car2s = new HashSet<Vehicle>(){{
			add(new Vehicle("LUV MC", "Ford Territory", "Blue", cust2));
			add(new Vehicle("FRY725", "Holden Astra", "Pale", cust2));
		}};
		cust2.setVehicles(car2s);
		
		customerRepository.save(new HashSet<Customer>(){{
			add(cust1);
			//add(cust2);
		}});*/
		
		//fetch all customers
		for(Customer c : customerRepository.findAll()){
			logger.info(c.toString());
		}
	}
	
}