package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.VehicleDao;
import entitiy.Vehicle;

public class menu {

	private VehicleDao vehicleDoa;
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Vehicle",
			"Insert Vehicle", 
			"Delete Vehicle", 
			"Update Vehicle", 
			"Display all vehicles");
	
	public void start() {
		String selection = "";
		
		do {
			
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayVehicle(); // read
				} else if (selection.equals("2")) {
					insertVehicle(); // create
				} else if (selection.equals("3")) {
					deleteVehicle(); // delete
				} else if (selection.equals("4")) {
					updateVehicle(); // updates vehicle
				} else if (selection.equals("5")) {
					//displayAllVehicle(); // view all vehicles
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue....");
			scanner.nextLine();
		} while (!selection.equals("-1"));
		
	}
	
	private void printMenu() {
		System.out.println("Select an Option: \n -----------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	private void displayVehicle() throws SQLException {
		List<Vehicle> vehicles = vehicleDoa.getVehicle();
		for (Vehicle vehicle: vehicles) {
			System.out.println(vehicle.getVehicleId() + ": " + vehicle.getMake());
		}
	}
	
	private void insertVehicle() throws SQLException {
		System.out.print("Enter new vehicle id: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter vehicle make: ");
		String make = scanner.nextLine();
		System.out.println("Enter vehicle model: ");
		String model = scanner.nextLine();
		System.out.println("Enter vehicle year: ");
		int yearMade = Integer.parseInt(scanner.nextLine());
		
		vehicleDoa.createNewVehicle(id, make, model, yearMade);
		
	
	}
	
	private void deleteVehicle() throws SQLException {
		System.out.println("Enter vehicle id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		VehicleDao vehicleDao = new VehicleDao();
		vehicleDao.deleteVehicleById(id);
		
	}
	
	public void updateVehicle() throws SQLException {
		System.out.println("Enter the vehicle id to update: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the make: ");
		String updateMake= scanner.nextLine();
		System.out.println("Enter the model: ");
		String updateModel = scanner.nextLine();
		System.out.println("Enter the year");
		int updateYear = Integer.parseInt(scanner.nextLine());
		VehicleDao vehicleDao = new VehicleDao();
		vehicleDao.updateVehicle(id, updateMake, updateModel, updateYear);
	}
	
	
}
