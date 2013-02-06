package impl;

import model.Patient;
import dao.DataAccessObject;

/**
 * this class is responsible for displaying available beds of the selected room.
 * @author Owner
 *
 */
public class AdmitPatient extends HttpServlet{

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
		
		String roomNumber = req.getParameter("Room");
		
		patient.setRoomNumber(roomNumber);
		httpSession.setAttribute("room", roomNumber);
		ArrayList<String> beds = this.dataAccessObject.getAvailableBed(roomNumber);
		httpSession.setAttribute("beds", beds);
		resp.sendRedirect("Admit_Patient_Bed.jsp");
	}
}
