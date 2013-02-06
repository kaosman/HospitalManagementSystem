package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccessObject;

import model.Appointment;
import model.Patient;

/**
 * this class gets the HIN, date and time from the page and checks for validity of appointment.
 * @author Owner
 *
 */
public class CancelAppointmentConfirmation extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		String healthInsuranceNumber = req.getParameter("HealthInsuranceNumber");
		String doctorName = req.getParameter("doctor");
		String day = req.getParameter("date");
		String month = req.getParameter("Month");
		String year = req.getParameter("Year");
		String date = year+"-"+month+"-"+day;
		
		String hour = req.getParameter("hour");
		String time = hour+":"+"00"+":00";
		
		Patient patient = this.dataAccessObject.getPatientRecord(healthInsuranceNumber);
		boolean check = this.dataAccessObject.checkAppointment(healthInsuranceNumber, doctorName, date, time);
		
		if(patient == null|| !check){
			resp.sendRedirect("Error_Cancel_appointment.html");
		} else {

			Appointment cancelAppointment = new Appointment(doctorName, patient.getFirstName()+" "+patient.getLastName(),date, time, healthInsuranceNumber);
			httpSession.setAttribute("cancelApp", cancelAppointment);
			resp.sendRedirect("Cancel_Appointment_Confirmation.jsp");
		}
	}
}
