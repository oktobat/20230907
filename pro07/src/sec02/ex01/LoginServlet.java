package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  
		MemberDAO dao = new MemberDAO();
		String id_ = request.getParameter("id");
		String pwd_ = request.getParameter("pwd");
		String info = dao.okMember(id_, pwd_);
//		System.out.println(info);
		request.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		if (info.equals("회원입니다.") && session.isNew()) {
			session.setAttribute("user_id", id_);
			response.sendRedirect("show");
		} else if (info.equals("회원입니다.")==false){
			out.println("<html><body>");
			out.println("<p>");
			out.println(info);
			out.println("<a href='loginForm.html'>");
			out.println("로그인하러 가기");
			out.println("</a>");
			out.println("</p>");
			out.println("</body></html>");
			session.invalidate();
		} else {
			response.sendRedirect("show");
		}
		
			
	    
	}

}
