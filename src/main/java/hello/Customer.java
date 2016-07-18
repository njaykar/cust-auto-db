package hello;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
	private long customerId;
	private String customer_name;
	private String customer_address;
	private Set<Vehicle> vehicles;
	
	
	public Customer() {
		
	}
	
	public Customer(String customer_name, String customer_address) {
		this.customer_name = customer_name;
		this.customer_address = customer_address;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getCustomerId() {
        return customerId;
    }
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public String getCustomer_address() {
		return customer_address;
	}
	
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public boolean hasVehicles(Vehicle vehicle) {
		for (Vehicle containedVehicle: getVehicles()) {
			if (containedVehicle.getVehicle_rego().equals(vehicle.getVehicle_rego())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String result = String.format("Customer[id = %d, Name = '%s', Address = '%s']%n", this.customerId, this.customer_name, this.customer_address);
		if(this.vehicles != null) {
			for(Vehicle v: vehicles) {
				result += String.format("Vehicle[Rego = '%s', Model = '%s', Color = '%s']%n", v.getVehicle_rego(), v.getVehicle_model(), v.getColor());
			}
		}
		return result;
	}
		//return getClass().getName() + " ID: " + this.customerId + " Name: " + this.customer_name + " Address: " + this.customer_address + " \nVehcles : " + this.vehicles;
	}
