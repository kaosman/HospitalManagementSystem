package impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccessObject;

import model.Patient;
import model.Report;

/**
 * This class is used to select the audit trail report from available dates.
 * @author Owner
 *
 */
public class SelectAuditTrail extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		Patient patient = (Patient) httpSession.getAttribute("patientObject");
		
		String date = req.getParameter("dates");
		
		ArrayList<Report> reportlist = this.dataAccessObject.getAuditTrail(patient.getHealthInsuranceNumber(), date);
		
		httpSession.setAttribute("patientObject",patient);
		httpSession.setAttribute("reports", reportlist);
		httpSession.setAttribute("dates", date);
		
		resp.sendRedirect("Lawyer_View_Audit.jsp");
		//------------------END------------------
		
	}
}
