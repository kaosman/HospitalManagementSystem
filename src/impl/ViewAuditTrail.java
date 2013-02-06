package impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;

import dao.DataAccessObject;

/**
 * this class retreives audit trail information based on dates of a patient to the lawyer. 
 * @author Owner
 *
 */
public class ViewAuditTrail extends HttpServlet{

	private DataAccessObject dataAccessObject;
	private Patient patient;
	
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			HttpSession httpSession = req.getSession(false);
			String healthInsuranceNumber = req.getParameter("Health_Insurance_Number");
			
			ArrayList<String> dates = this.dataAccessObject.getAuditTrailDates(healthInsuranceNumber);
			this.patient = this.dataAccessObject.getPatientRecord(healthInsuranceNumber);
				
			httpSession.setAttribute("patientObject", this.patient);
			httpSession.setAttribute("dates", dates);
			resp.sendRedirect("Lawyer_View_Report.jsp");
				
	}
}
