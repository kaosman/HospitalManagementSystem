package impl;

import model.Staff;
import dao.DataAccessObject;

/**
 * This class is responsible for adding employee to DB.
 * @author Owner
 *
 */
public class AddEmployee extends HttpServlet{

	private DataAccessObject dataAccessObject;
	private Staff staff;
	@Override
	public void init() throws ServletException {
		
		this.dataAccessObject = new DataAccessObject();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String firstname = req.getParameter("First_Name");
		String lastname = req.getParameter("Last_Name");
		
		String day = req.getParameter("date");
		String month = req.getParameter("Month");
		String year = req.getParameter("Year");
		String dob = year+"-"+month+"-"+day;
		String designation = req.getParameter("type");
		String address = req.getParameter("Address");
		String city = req.getParameter("City");
		String province = req.getParameter("Province");
		String country = req.getParameter("Country");
		String homephone = req.getParameter("Contact_Number");
		String hiredDate = this.getCurrentDate();
		
		this.staff = new Staff(firstname, lastname, homephone, address+city+province+country, "employed", designation, "1", hiredDate);
		
		boolean result = this.dataAccessObject.createStaffRecord(this.staff);
		
		if(result){
			resp.sendRedirect("ITAdministrator.html");
		}
	}
	
	private String getCurrentDate(){

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
