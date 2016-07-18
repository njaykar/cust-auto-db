package hello;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Vehicle")
public class Vehicle implements Serializable {
	private String vehicle_rego;
	private String vehicle_model;
	private String color;
	private Customer customer;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String vehicle_rego, String vehicle_model, String color, Customer customer) {
		this.vehicle_rego = vehicle_rego;
		this.vehicle_model = vehicle_model;
		this.color = color;
		this.customer = customer;
	}
	
	@Id
	public String getVehicle_rego() {
		return vehicle_rego;
	}
	
	public void setVehicle_rego(String vehicle_rego) {
		this.vehicle_rego = vehicle_rego;
	}
	
	public String getVehicle_model() {
		return vehicle_model;
	}
	
	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@ManyToOne
	@JoinColumn(name = "customer_customer_id")
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
