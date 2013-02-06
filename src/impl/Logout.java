package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * this class logs out the user.
 * @author Owner
 *
 */
public class Logout extends HttpServlet{

	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession httpSession = req.getSession(false);
		
		if(httpSession != null){
			synchronized (httpSession) {

				httpSession.invalidate();
			}

		}
		
		resp.sendRedirect("loginPage.html");
	}
}
