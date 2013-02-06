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

/**
 * this class retreives patient record and the dates list of the date of creation of all reports.
 * @author
 *
 */
public class DoctorPatientSearch extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		String healthInsuranceNumber = req.getParameter("Health_Insurance_Number");
		
		Patient patient = this.dataAccessObject.getPatientRecord(healthInsuranceNumber);
		
		if(patient == null){
			// redirect to error page
		}else{
			
			ArrayList<String> dates = new ArrayList<String>();
			//get from data base the dates of report creation
			dates = this.dataAccessObject.getCreatedReportDates(healthInsuranceNumber);
			httpSession.setAttribute("dates", dates);
			httpSession.setAttribute("patient", patient);
			resp.sendRedirect("Doctor_View_All_Report.jsp");
		}
	}
}
