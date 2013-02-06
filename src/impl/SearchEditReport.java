package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;
import model.Report;

import dao.DataAccessObject;

/**
 * This class is responsible for selecting which report is to be edited based on date.
 * @author Owner
 *
 */
public class SearchEditReport extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		
		Patient patient = (Patient) httpSession.getAttribute("patient");
		String date = req.getParameter("date");
		
		//query DB for report of this hin and date and save it in report object.
		
		
		Report patientReport = this.dataAccessObject.getPatientMedicalReport(patient.getHealthInsuranceNumber(), date);
		httpSession.setAttribute("patient", patient);
		httpSession.setAttribute("report", patientReport);
		resp.sendRedirect("Doctor_View-Edit_Report.jsp");
		
	}
}
