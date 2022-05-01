package entitiy;

public class Vehicle {

	private int vehicleId;
	private String make;
	private String model;
	private int year_made;
	
	public Vehicle(int vehicleId, String make, String model, int year_made) {
		this.vehicleId = vehicleId;
		this.make = make;
		this.model = model;
		this.year_made = year_made;
	}
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear_made() {
		return year_made;
	}
	
	public void setYear_made(int year_made) {
		this.year_made = year_made;
	}
	
}
