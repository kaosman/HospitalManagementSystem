package impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appointment;
import dao.DataAccessObject;

/**
 * this class dislays the appointments of the doctor for the selected date.
 * @author JM
 *
 */
public class ViewPatientAppointment extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		
		String doctor = (String)httpSession.getAttribute("doctor");
		String year = req.getParameter("Year");
		String month = req.getParameter("Month");
		String day = req.getParameter("date");
		String date = year+"-"+month+"-"+day;
		
		ArrayList<Appointment> schedule = this.dataAccessObject.getDoctorSchedule(doctor, date);
		httpSession.setAttribute("schedule", schedule);
		httpSession.setAttribute("date", date);
		resp.sendRedirect("View_Patient_Appointment.jsp");
		//-----------------END--------------------
		
	}
	
	public String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
