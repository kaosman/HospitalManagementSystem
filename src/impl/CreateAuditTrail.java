package impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;
import model.Report;

import dao.DataAccessObject;

/**
 * This class will request edited report from browser and will create audit trail.
 * @author Owner
 *
 */
public class CreateAuditTrail extends HttpServlet{

	private DataAccessObject dataAccessObject;
	
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String newPrescription = req.getParameter("New_Prescription");
		String newDiagosis = req.getParameter("New_Diagnosis");
		String date = req.getParameter("date");
		HttpSession httpSession = req.getSession(false);
		Patient patient = (Patient) httpSession.getAttribute("patient");
		//ArrayList<Report> auditTrail = this.dataAccessObject.getAuditTrail(patient.getHealthInsuranceNumber(),date);
	}
}
