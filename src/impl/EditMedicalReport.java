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

import model.AuditTrail;
import model.Patient;
import model.Report;
import dao.DataAccessObject;

/**
 * This class is responsible for editing report and inserting new diagnosis and prescription.
 * @author Owner
 *
 */
public class EditMedicalReport extends HttpServlet{

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
		String newDiagnosis = req.getParameter("diagnosis");
		String newPrescription = req.getParameter("prescription");
		
		Report patientReport = this.dataAccessObject.getPatientMedicalReport(patient.getHealthInsuranceNumber());
		// insert in Db and change old report so that nurse/doctor view updated reports. get audit trail id from DB
		this.dataAccessObject.createAuditTrail(patientReport.getDiagnosis(), newDiagnosis, patientReport.getPrescription(), newPrescription, patient.getHealthInsuranceNumber());
		
		//insert audit trail in DB for lawyer
		
		resp.sendRedirect("Doctor.html");
	}
	

	public String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
