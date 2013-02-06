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

import dao.DataAccessObject;
import model.Doctor;
import model.Staff;

/**
 * This class is responsible for logging in user and passing control to other components.
 * 
 *
 */
public class Controller extends HttpServlet{

	private DataAccessObject dataAccessObject;
	private UserType userType;
	private Doctor doctor;
	
	public Controller() {
		
	}
	
	@Override
	public void init() throws ServletException {

		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.login(req, resp);
	}
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		
		final String userType = this.dataAccessObject.checkCredentials(username,password);
		

		if (userType != null) {

			HttpSession httpSession = req.getSession(true);
			if (httpSession.isNew() == false) {
				httpSession.invalidate();
				httpSession = req.getSession(true);
			}
			
			if (userType.equals("Doctor")) {

				httpSession.setAttribute("doctor", this.populateDoctor(username));
				resp.sendRedirect("Doctor.html");

			} else if (userType.equals("Nurse")) {
				httpSession.setAttribute("nurse", this.populateStaff(username));
				resp.sendRedirect("Nurse_Login.html");
			} else if (userType.equals("Lawyer")) {
				resp.sendRedirect("lawyer.html");
			} else if (userType.equals("IT administrator")) {
				resp.sendRedirect("ITAdministrator.html");
			}
		} else {
			resp.sendRedirect("loginFailed.html");
		}
	}
	
	private String populateDoctor(String username){
		
		Staff doctor = this.dataAccessObject.getStaffRecord(username);
		return doctor.getLastname();
		
	}
	 private Staff populateStaff(String username){
		 Staff staff = this.dataAccessObject.getStaffRecord(username);
		return staff; 
	 }
	
	
}
