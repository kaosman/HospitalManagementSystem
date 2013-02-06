package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccessObject;

import model.Doctor;
import model.Patient;

/**
 * this class gets medical report data and saves it to DB.
 * @author Owner
 *
 */
public class CreateMedicalReportForm extends HttpServlet{

	private DataAccessObject dataAccessObject;
	
	@Override
	public void init() throws ServletException {
		System.out.println("init of create medical report form");
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		Doctor doctor = (Doctor) httpSession.getAttribute("doctorInfo");
		Patient patient = (Patient)httpSession.getAttribute("patientObject");
		String prescription = req.getParameter("prescription");
		String diagnosis = req.getParameter("diagnosis");
		
		boolean result = this.dataAccessObject.createPatientMedicalReport(patient.getHealthInsuranceNumber(),prescription,diagnosis);
		if(!result){
			resp.sendRedirect("errorCreateMedicalReport.html");
		}
		resp.sendRedirect("doctorHomePage.html");
		
		
	}
}
