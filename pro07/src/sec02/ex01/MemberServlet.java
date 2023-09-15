package sec02.ex01;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Date;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/member3")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  
		MemberDAO dao = new MemberDAO();
		  
		  String command = request.getParameter("command");
		  if (command != null && command.equals("addMember")) {
			  String _id = request.getParameter("id");
		      String _pwd = request.getParameter("pwd");
		      String _name = request.getParameter("name");
		      String _email = request.getParameter("email");
		      String _edomain = request.getParameter("edomain");
		      String email = _email + "@" + _edomain;
		      String[] arrhobby = request.getParameterValues("hobby");
		      String hobby = "";
		      if (arrhobby != null) {
		    	  for (int i=0; i<arrhobby.length; i++) {
		    		  if (i==arrhobby.length-1) {
		    			  hobby += arrhobby[i];
		    		  } else {
		    			  hobby += arrhobby[i]+"/";
		    		  }
				  }
		      }
		      
		      MemberVO vo = new MemberVO();
		      vo.setId(_id);
		      vo.setPwd(_pwd);
		      vo.setName(_name);
		      vo.setEmail(email);
		      vo.setHobby(hobby);
		      dao.addMember(vo);

		  } else if (command != null && command.equals("delMember")) {
			  String id = request.getParameter("id");
			  dao.delMember(id);
		  } 
	      
		  List<MemberVO> list = dao.listMembers();
		  
//		  request.setAttribute("memberList", list);
//		  RequestDispatcher dispatch = request.getRequestDispatcher("memberView");
//		  dispatch.forward(request, response);

		  ServletContext context = getServletContext();
		  context.setAttribute("memberList", list);
		  
		  response.sendRedirect("memberView");
		  
	}

}
