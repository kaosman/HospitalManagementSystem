package impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;
import model.Staff;
import dao.DataAccessObject;

/**
 * this class is responsible for searching patient whose report is to be created.
 * @author Owner
 *
 */
public class DoctorPatientSearch_CreateReport extends HttpServlet{

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
		String doctor = (String) httpSession.getAttribute("doctor");
		
		
		if(patient != null){
	
			httpSession.setAttribute("patient", patient);
			httpSession.setAttribute("currentdate", getCurrentDate());
			httpSession.setAttribute("doctor", doctor);
			resp.sendRedirect("Create_Patient_report.jsp");
		}else{
			resp.sendRedirect("Doctor_Error_Patient_Search.html");
		}
	}
	
	public String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
