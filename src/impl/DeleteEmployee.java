package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Staff;

import dao.DataAccessObject;

/**
 * this class is responsible for deleting employee(changing status to NOT EMPLOYED). NOT IN USE
 * @author Owner
 *
 */
public class DeleteEmployee extends HttpServlet{

	private DataAccessObject dataAccessObject;
	@Override
	public void init() throws ServletException {
		
		System.out.println("init of delete emp");
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String staffId = req.getParameter("Staff_Id");
		Staff staff = this.dataAccessObject.getStaffRecord(staffId);
		if(staff != null){
		
			this.dataAccessObject.changeEmployeeStatus(staffId);
			resp.sendRedirect("ItAdmin.html");
		}
	}
}
