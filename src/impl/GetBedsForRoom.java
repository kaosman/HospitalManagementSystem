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
 * this class will set room number and bed number to the patient in the DB
 * @author Owner
 *
 */
public class GetBedsForRoom extends HttpServlet{

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
		String bed = req.getParameter("Bed");
		patient.setBedNumber(bed);
		this.dataAccessObject.setRoomBed(patient.getRoomNumber(),bed,patient.getHealthInsuranceNumber());
		resp.sendRedirect("Nurse_Login.html");
		//-----------------END----------------------
	}
}
