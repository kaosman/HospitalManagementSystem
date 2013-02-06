package impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;
import dao.DataAccessObject;

/**
 * This class will register new patient.
 */
public class NewPatientRegistration extends HttpServlet{

	private Patient patient;
	private DataAccessObject dataAccessObject;
	
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		this.patient = this.populatePatient(req,resp);
		
		if(this.patient != null){
		
			boolean result = this.dataAccessObject.populatePatient(this.patient);
			if(result){
				httpSession.setAttribute("patientObject", this.patient);
				resp.sendRedirect("Success_Patient_Registration.jsp");
			}else{
				resp.sendRedirect("Error_New_Patient_Registration.jsp");
			}
			
		}
		
	}
	
	private Patient populatePatient(HttpServletRequest req, HttpServletResponse resp) throws IOException{

		final String firstName = req.getParameter("First_Name");
		final String lastName = req.getParameter("Last_Name");
		final String gender = req.getParameter("gender");
		
		String month = req.getParameter("Month");
		String date = req.getParameter("date");
		String year = req.getParameter("year");
		final String dateOfBirth = year+"-"+month+"-"+date;
		
		final String healthInsuranceNumber = req.getParameter("Health_Insurance_Number");
		final String address = req.getParameter("Address");
		final String city = req.getParameter("city");
		final String province = req.getParameter("Province");
		final String country = req.getParameter("Country");
		final String postalCode = req.getParameter("Postal_Code");
		final String registrationDate = getCurrentDate();
		final String familyDoctorName = req.getParameter("Family_Doctor_Name");
		final String familyDoctorContactNumber = req.getParameter("Family_Doctor_Contact_Number");
		final String emergencyContactName = req.getParameter("Emergency_Contact_Person");
		final String emergencyContactNumber = req.getParameter("Emergency_Contact_Number");
		final String contactNumber = req.getParameter("Contact_Number");
		final String other = req.getParameter("other");
		
		String medicalHistory = "";
		String heartDisorder = req.getParameter("heart");
		String endocrineDisorder = req.getParameter("endocrine");
		String breathingDisorder = req.getParameter("breathing");
		String stomachDisorder = req.getParameter("stomach");
		if (heartDisorder.equals("yes")) medicalHistory = medicalHistory + "heart";
		if (endocrineDisorder.equals("yes")) medicalHistory = medicalHistory + "endocrine";
		if (breathingDisorder.equals("yes")) medicalHistory = medicalHistory + "breathing";
		if (stomachDisorder.equals("yes")) medicalHistory = medicalHistory + "stomach";
		
		if((firstName.equals("")) || (lastName.equals("")) || (dateOfBirth.equals("")) || (gender.equals("")) || (address.equals("")) ||(city.equals("")) || (country.equals("")) || (province.equals("")) || (postalCode.equals("")) || (registrationDate.equals("")) || (contactNumber.equals("")) || (familyDoctorName.equals("")) || (familyDoctorContactNumber.equals("")) || (medicalHistory.equals("")) || (healthInsuranceNumber.equals("")) || checkAfterDate(dateOfBirth)){
			
			resp.sendRedirect("Error_New_Patient_Registration.jsp");
		}else{
			Patient patient = new Patient(firstName, lastName, dateOfBirth, gender, address, city, country, province, postalCode, registrationDate, familyDoctorContactNumber, familyDoctorName, familyDoctorContactNumber, healthInsuranceNumber, emergencyContactName, emergencyContactNumber, other,medicalHistory);
			return patient;
		}
		return null;
	}
	
	/*
	 * Returns true in input date is after the current date.
	 */
	private boolean checkAfterDate(String date){
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date inputDate = (Date) dateFormat.parse(date);

			Date currentDate = new Date();

			Calendar current = Calendar.getInstance();
			current.setTime(currentDate);

			Calendar input = Calendar.getInstance();
			input.setTime(inputDate);

			return input.after(current);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private String getCurrentDate(){

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			return dateFormat.format(date);
		}
		
}
