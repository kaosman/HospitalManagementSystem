package impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.TODO;

import model.Patient;
import model.Schedule;
import model.Staff;

import dao.DataAccessObject;

/** This class is responsible for selecting doctor, patient and date of appointment. 
 * It forwards the request to select available time slot for that doctor and on the selected date
 * 
 * @author Owner
 *
 */
public class SelectAppointment extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		String doctorName = req.getParameter("doctor");
		String day = req.getParameter("date");
		String month = req.getParameter("Month");
		String year = req.getParameter("year");
		String date = year+"-"+month+"-"+day;
		
		String healthInsuranceNumber = req.getParameter("HealthInsuranceNumber");
		boolean checkBeforeDate = this.checkBeforeDate(date);
		
		Patient patient = this.dataAccessObject.getPatientRecord(healthInsuranceNumber);
		
		if(checkBeforeDate || patient == null){
			
			resp.sendRedirect("Error_Book_appointment.jsp");
		}else{
			
			httpSession.setAttribute("healthInsuranceNumber", healthInsuranceNumber);
			httpSession.setAttribute("patient", patient.getFirstName()+" "+patient.getLastName());
			httpSession.setAttribute("doctor", doctorName);
			httpSession.setAttribute("date", date);
		
			
			ArrayList<String> availableTimeSlots = this.dataAccessObject.getAvailableTimeSlots(doctorName, date);
			
			httpSession.setAttribute("availableTimeSlots", availableTimeSlots);
			httpSession.setAttribute("date", date);
			
			
			resp.sendRedirect("Select_Time.jsp");
		}
		
	}
	
	/*
	 * Returns true if input date is before current date.
	 */
	private boolean checkBeforeDate(String date) {
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date inputDate;
			inputDate = (Date) dateFormat.parse(date);
			Date currentDate = new Date();

			Calendar current = Calendar.getInstance();
			current.setTime(currentDate);

			Calendar input = Calendar.getInstance();
			input.setTime(inputDate);

			return input.before(current);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
