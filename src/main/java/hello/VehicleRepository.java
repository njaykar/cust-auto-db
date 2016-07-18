package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
	public List<Vehicle> findByColor(String color);
}
