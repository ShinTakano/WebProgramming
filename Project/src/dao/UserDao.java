package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

	/**
	 * ログインIDとパスワードに紐づくユーザ情報を返す
	 * @param loginId
	 * @param password
	 * @return
	 */
	public User findByLoginInfo(String loginId, String password) {//ログイン時の情報メソッド
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}





	public boolean finduserinfo(String loginId) {//IDがログイン状態かログアウト状態かメソッド
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			ResultSet rs = pStmt.executeQuery();

			if (loginId == null) {
				return false;
			}
			String loginIdData = rs.getString("login_id");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}

	}

	/**
	 * 全てのユーザ情報を取得する
	 * @return
	 */
	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user WHERE login_id<>'admin'";
			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

				userList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public void NewUser(String loginId, String password, String name, String birhDate) {//新規登録のメソッド
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO user(login_id,password,name,birth_date,create_date, update_date) VALUES (?,?,?,?,now(),now())";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			pStmt.setString(3, name);
			pStmt.setString(4, birhDate);
			int rs = pStmt.executeUpdate();//データの追加

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}
	//一つのユーザ情報を取得するメソッド
	public User UserId(String id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * from user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {//主キーに紐づいているのは1件のみなので、あるかないかの結果。
				return null;//結果がない場合
			}
			//結果がある場合
			int idData = Integer.parseInt(id);
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			Date birthdateData = rs.getDate("birth_date");
			String createdateData = rs.getString("create_date");
			String updateData = rs.getString("update_date");
			return new User(idData, loginIdData, nameData,birthdateData,createdateData,updateData, updateData);


		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
	//一つのユーザ情報を編集するメソッド
	public void UserUpdate(String id,String name,String password,String birthdate) {//更新メソッド戻り値なし
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE user SET name = ?,password = ?,birth_date = ? WHERE id = ?";//「?」は左から昇順になっている
					//SET・・変えたいカラム名 WHERE・・・特定するカラム名（主キーかユニークを使うのが一般）
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, password);
			pStmt.setString(3, birthdate);
			pStmt.setString(4, id);
			int rs = pStmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}
	//パスワード以外を更新するメソッド
	public void UserUpdate2(String id,String name,String birthdate) {//更新メソッド戻り値なし
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE user SET name = ?,birth_date = ? WHERE id = ?";//「?」は左から昇順になっている
					//SET・・変えたいカラム名 WHERE・・・特定するカラム名（主キーかユニークを使うのが一般）
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birthdate);
			pStmt.setString(3, id);
			int rs = pStmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}
}
