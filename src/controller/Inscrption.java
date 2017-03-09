package controller;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atelier_2.db.DBinteraction;
import atelier_2.model.User;
import dao.SendMail;
import dao.UserDAO;

/**
 * Servlet implementation class Inscrption
 */
@WebServlet("/Inscrption")
public class Inscrption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscrption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		userDao = new UserDAO();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("nom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Date date = new Date();
		String token = DBinteraction.md5(date+email);
		User user = new User(username, email, password,0,token);
		//response.getOutputStream().println(user.toString());
		int n = userDao.addUser(user);
		//send Email
		try {
			SendMail.generateAndSendEmail(email, token, username);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (n!=0) {
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
			response.sendRedirect("login.jsp");
		} else {
			response.getOutputStream().println("user not saved");
		}
	}

}
