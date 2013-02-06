package impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;
import dao.DataAccessObject;

/**
 * this class gets the new patient personal record and update it in DB 
 * @author Owner
 *
 */
public class EditPatientPersonalRecord extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		Patient oldPatient = (Patient) httpSession.getAttribute("patient");
		Patient newPatientRecord = this.populateNewPatientReport(oldPatient,req);
		
		this.dataAccessObject.updatePatientPersonalRecord(newPatientRecord);
		// TODO insert newpatientrecord in DB and return boolean and if boolean returns true.(updatePatientPersonalRecord)
		
		resp.sendRedirect("Nurse_Login.html");
	}

	private Patient populateNewPatientReport(Patient oldPatient,HttpServletRequest req) {
		
		final String firstName = req.getParameter("First_Name");
		if(!firstName.equals("")){
			oldPatient.setFirstName(firstName);
		}
		
		final String lastName = req.getParameter("Last_Name");
		if(!lastName.equals("")){
			oldPatient.setLastName(lastName);
		}
		
		final String address = req.getParameter("Address");
		if(!address.equals("")){
			oldPatient.setAddress(address);
		}
		final String city = req.getParameter("City");
		if(!city.equals("")){
			oldPatient.setCity(city);
		}
		final String province = req.getParameter("Province");
		if(!province.equals("")){
			oldPatient.setProvince(province);
		}
		
		final String country = req.getParameter("Country");
		if(!country.equals("")){
			oldPatient.setCountry(country);
		}
		
		final String postalCode = req.getParameter("Postal_Code");
		if(!postalCode.equals("")){
			oldPatient.setPostalCode(postalCode);
		}
		
		
		final String familyDoctorName = req.getParameter("Family_Doctor_Name");
		if(!familyDoctorName.equals("")){
			oldPatient.setFamilyDoctorName(familyDoctorName);
		}
		
		final String familyDoctorContactNumber = req.getParameter("Family_Doctor_Number");
		if(!familyDoctorContactNumber.equals("")){
			oldPatient.setFamilyDoctorNumber(familyDoctorContactNumber);
		}
		
		final String emergencyContactName = req.getParameter("Emergency_Contact_Person");
		if(!emergencyContactName.equals("")){
			oldPatient.setEmergencyContactName(emergencyContactName);
		}
		final String emergencyContactNumber = req.getParameter("Contact_Number");
		if(!emergencyContactNumber.equals("")){
			oldPatient.setEmergencyContactNumber(emergencyContactNumber);
		}
		
		return oldPatient;
	}
	
	private String getCurrentDate(){

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
