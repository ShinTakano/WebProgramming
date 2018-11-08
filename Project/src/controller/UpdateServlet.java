package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ユーザ情報の取得

		HttpSession session = request.getSession();

		if(session.getAttribute("userInfo") == null){//ログイン情報がセッションされているかの条件文(資料:3-4-17)

			response.sendRedirect("LoginServlet");//情報がない場合はログイン画面へリダイレクト
			return;
		}


		String id = request.getParameter("id");

		System.out.println(id);

		UserDao userDao = new UserDao();
		User user = userDao.UserId(id);

		request.setAttribute("UserId", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthDate");
		String id = request.getParameter("id");
		UserDao userdao = new UserDao();
		if(!password1.equals(password2) || "".equals(name) || "".equals(birthdate)) {
			request.setAttribute("errMsg2", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}else if("".equals(password1) && "".equals(password2)) {
			userdao.UserUpdate2(id, name, birthdate);
			response.sendRedirect("UserListServlet");
			return;
		}
		//暗号化(処理が正常にされる前に、暗号化処理を行う。
				String source = password1;
				Charset charset = StandardCharsets.UTF_8;
				String algorithm = "MD5";
				byte[] bytes = null;
				try {
					bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
				} catch (NoSuchAlgorithmException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				String result = DatatypeConverter.printHexBinary(bytes);

		userdao.UserUpdate(id, name, result, birthdate);
		response.sendRedirect("UserListServlet");
	}

}
