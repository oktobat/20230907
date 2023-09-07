package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/book_store";
	private static final String user = "root";
	private static final String pwd = "1234";
	private Connection con;
	private PreparedStatement pstmt;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from t_member";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addMember(MemberVO memberVO) {
		try { 
			connDB();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member";
			query += " (id, pwd, name, email)";
			query += " values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	
	public void delMember(String id) {
		try {
			connDB();
			String query = "delete from t_member where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	public void modMember(String id) {
		try {
			connDB();
			String query = "UPDATE t_member SET name='김순신' where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("MySQL 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
//			stmt = con.createStatement();
//			System.out.println("Statement 생성 성공");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
