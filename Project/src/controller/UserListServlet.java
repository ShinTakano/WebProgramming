package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる

		HttpSession session = request.getSession();

		if(session.getAttribute("userInfo") == null){//ログイン情報がセッションされているかの条件文(資料:3-4-17)

			response.sendRedirect("LoginServlet");//情報がない場合はログイン画面へリダイレクト
			return;
		}


		// ユーザ一覧情報を取得
		UserDao userDao = new UserDao();
		List<User> userList = userDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("UserList", userList);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO  未実装：検索処理全般
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginid");
		String name = request.getParameter("name");
		String birthdate1 = request.getParameter("birthdate1");
		String birthdate2 = request.getParameter("birthdate2");

		UserDao userDao = new UserDao();
		List<User> userList = userDao.finduser(loginId, name, birthdate1, birthdate2);

		request.setAttribute("UserList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);

	}


}
