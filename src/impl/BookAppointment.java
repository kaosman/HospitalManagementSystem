package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appointment;

import dao.DataAccessObject;

/** this class is responsible for booking appointment from the selected date and time
 * 
 * @author Owner
 *
 */
public class BookAppointment extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {

		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			HttpSession httpSession = req.getSession(false);
			String availableTimeSlot = req.getParameter("timeslot");
			String healthInsuranceNumber = (String) httpSession.getAttribute("healthInsuranceNumber");
			String patientName = (String) httpSession.getAttribute("patient");
			String doctorName = (String) httpSession.getAttribute("doctor");
			String date = (String) httpSession.getAttribute("date");
			
			if(availableTimeSlot != null){
				
				Appointment appointment = new Appointment(doctorName, patientName,date, availableTimeSlot,healthInsuranceNumber);
				boolean bookedAppointment = this.dataAccessObject.bookAppointment(appointment);
				httpSession.setAttribute("appointment", appointment);
				if(bookedAppointment){
					resp.sendRedirect("Appointment_Booked_Successfully.jsp");
				}else{
					resp.sendRedirect("Error_Book_appointment.jsp");
				}
			}else{
				resp.sendRedirect("Error_Book_appointment.jsp");
			}
	}
}
