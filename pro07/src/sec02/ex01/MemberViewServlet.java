package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/memberView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
//		List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	    
	    ServletContext context = getServletContext();
	    List<MemberVO> list =(List<MemberVO>) context.getAttribute("memberList");
		
	      out.print("<html><body>");
	      out.print("<table border=1><tr>");
	      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>취미</td><td>가입일</td></tr>");
	      
	      for (int i=0; i<list.size(); i++) {
	    	  MemberVO memberVO = (MemberVO) list.get(i);
	    	  String id = memberVO.getId();
	  		  String pwd = memberVO.getPwd();
	  		  String name = memberVO.getName();
	  		  String email = memberVO.getEmail();
	  		  Date joinDate = memberVO.getJoinDate();
	  		  String hobby = memberVO.getHobby();
	  		  out.print("<tr><td>"+id+
	  				  "</td><td>"+pwd+
	  				  "</td><td>"+name+
	  				  "</td><td>"+email+
	  				  "</td><td>"+hobby+
	  				  "</td><td>"+joinDate+
	  				  "<a href='/pro07/member3?command=delMember&id="+id+"'>삭제</a></td></tr>");
	      }
	      out.print("</table><a href='/pro07/memberForm.html'>새회원 등록하기</a></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
