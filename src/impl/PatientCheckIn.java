package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;

import dao.DataAccessObject;

/**
 * This class is responsible for searching patient and selecting room for admitting
 * @author Owner
 *
 */
public class PatientCheckIn extends HttpServlet{

	private String healthInsuranceNumber;
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

		this.healthInsuranceNumber = req.getParameter("Health_Insurance_Number");

		this.patient = this.dataAccessObject.getPatientRecord(this.healthInsuranceNumber);

		if (this.patient == null) {
			
			resp.sendRedirect("Nurse_Error_patient_search.html");
		} else {
			
			httpSession.setAttribute("patient", this.patient);
			resp.sendRedirect("Admit_Patient.jsp");
		}
	}
	}

