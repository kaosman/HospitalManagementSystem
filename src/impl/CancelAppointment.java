package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccessObject;

import model.Appointment;

/**
 * this class deletes appointment from the DB
 * @author Owner
 *
 */
public class CancelAppointment extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession(false);
		
		Appointment cancelAppointment = (Appointment) httpSession.getAttribute("cancelApp");

		boolean result = this.dataAccessObject.cancelAppointment(cancelAppointment);
		
		if(result){
			resp.sendRedirect("Success_Cancel_appointment.jsp");
		}
		
		//-------------------------END-------------------------
	}
}
