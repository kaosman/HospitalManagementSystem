package impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccessObject;

/**
 * this class populates doctor names to cancel appointment
 * @author Owner
 *
 */
public class CancelAppointmentData extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {

		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		ArrayList<String> doctors = this.dataAccessObject.getDoctorsbyAppointment();
		httpSession.setAttribute("doctors", doctors);
		
		resp.sendRedirect("Cancel_Appointment.jsp");
	}
}
