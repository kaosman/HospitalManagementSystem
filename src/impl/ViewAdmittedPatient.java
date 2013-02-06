package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccessObject;

import model.Patient;

/**
 * this class is responsible for searching admitted patient and displaying room,bed number on the next page
 * @author Owner
 *
 */
public class ViewAdmittedPatient extends HttpServlet{

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
		
		Patient patient = this.dataAccessObject.getAdmittedPatients(healthInsuranceNumber);
		// get only the admitted patient , bed,room based ion HIN from DB and display on next page.
		
		httpSession.setAttribute("patient", patient);
		resp.sendRedirect("Admitted_Patients.jsp");
		
		//-----------END------------------
	}
}
