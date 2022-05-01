package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entitiy.Vehicle;

public class VehicleDao {
	
	private Connection connection = DBConnection.getConnection();
	
	private final String GET_VEHICLE_QUERY = "SELECT * FROM vehicle";
	private final String GET_VEHICLE_BY_ID = "SELECT * FROM vehilce vehicle_id = ?";
	private final String CREATE_NEW_VEHICLE = "INSERT INTO vehicle(vehicle_id, make, model, year_made) VALUES(?, ?, ?, ?)";
	private final String DELETE_VEHICLE_BY_ID_QUERY = "DELETE FROM vehicle WHERE vehicle_id = ?";
	private final String UPDATE_VEHICLE_QUERY = "UPDATE vehicle SET make = ?, model = ? year = ? WHERE vehicle_id = ?";
	
	public VehicleDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Vehicle> getVehicle() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_VEHICLE_QUERY).executeQuery();
		List<Vehicle> vehicle = new ArrayList<>();
		
		while (rs.next()) {
			vehicle.add(populateVehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		return vehicle;
	}
	
	public void createNewVehicle(int id, String vehiclemake, String vehiclemodel, int yearMade) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_VEHICLE);
		ps.setInt(1, id);
		ps.setString(2, vehiclemake);
		ps.setString(3, vehiclemodel);
		ps.setInt(4, yearMade);
		ps.executeUpdate();
	} 
	
	private Vehicle populateVehicle(int id, String make, String model, int  year) {
		return new Vehicle(id, make, model, year);
	}
	
	public void deleteVehicleById(int id) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement(DELETE_VEHICLE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateVehicle(int id, String make, String model, int year) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_VEHICLE_QUERY);
		ps.setString(2, make);
		ps.setString(2, model);
		ps.setInt(3, year);
		ps.executeUpdate();
	}
	
}
