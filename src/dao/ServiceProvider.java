package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * This class connects to the MySQL Database. patient and hospital
 * 
 * 
 */
public class ServiceProvider {

	private Connection connectionPatient= null;
	private Connection connectionHospital = null;
	private final String username = "root";
	private final String password = "root";
	private final String urlPatient = "jdbc:mysql://localhost:3306/hospital_management_system_1";
	private final String urlHospital = "jdbc:mysql://localhost:3306/hospital_management_system_2";
	
	private static ServiceProvider serviceProvider = new ServiceProvider();
	
	private ServiceProvider(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connectionPatient = DriverManager.getConnection(urlPatient,username, password);
			this.connectionHospital = DriverManager.getConnection(urlHospital, username, password);
		}catch(SQLException e){
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ServiceProvider getInstance(){
		return serviceProvider;
	}
	
	public Connection getPatientConnection(){
		return this.connectionPatient;
	}
	
	public Connection getHospitalConnection(){
		return this.connectionHospital;
	}
}

