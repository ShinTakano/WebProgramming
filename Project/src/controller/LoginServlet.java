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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		if(session.getAttribute("userInfo") != null){//ログイン情報がセッションされているかの条件文(資料:3-4-17)

			response.sendRedirect("UserListServlet");//情報がある場合はユーザ一覧画面へリダイレクト
			return;
		}

		// TODO 未実装：ログインセッションがある場合、ユーザ一覧画面にリダイレクトさせる

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		UserDao userDao = new UserDao();
		String source = password;
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

		User user = userDao.findByLoginInfo(loginId, result);

		/** テーブルに該当のデータが見つからなかった場合 **/
		if (user == null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります。");

			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		/** テーブルに該当のデータが見つかった場合 **/


		// セッションにユーザの情報をセット
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", user);//ログイン情報を保存

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");

	}

}
