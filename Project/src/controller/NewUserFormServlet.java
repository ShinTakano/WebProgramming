package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class NewUserFormServlet
 */
@WebServlet("/NewUserFormServlet")
public class NewUserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUserForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginid = request.getParameter("loginId");//jspから取る値（"nameの値"）
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		UserDao userDao = new UserDao();
		 boolean b = userDao.finduserinfo(loginid);
		if(!password1 .equals(password2) || "".equals(loginid) || "" .equals(password1) || "".equals(password2) ||
				"".equals(name)|| "".equals(birthDate)|| b == true){
			request.setAttribute("errMsg2", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUserForm.jsp");
			dispatcher.forward(request, response);
			return;
		}


		userDao.NewUser(loginid, password1, name, birthDate);

		response.sendRedirect("UserListServlet");


	}
}
