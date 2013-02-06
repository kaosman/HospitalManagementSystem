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
import model.Report;

/**
 * this class gets the report data and inserts in the Database.
 * @author Owner
 *
 */
public class CreateMedicalReport extends HttpServlet{

	private DataAccessObject dataAccessObject;
	
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		Patient patient = (Patient) httpSession.getAttribute("patient");
		
		String diagnosis = req.getParameter("diagnosis");
		String prescription = req.getParameter("prescription");
		
		this.dataAccessObject.createPatientMedicalReport(patient.getHealthInsuranceNumber(), prescription, diagnosis);
		resp.sendRedirect("Doctor.html");
	}
}
