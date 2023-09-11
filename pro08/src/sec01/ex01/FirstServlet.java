package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
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

//		서블릿의 여러 가지 포워드(다른 서블릿으로 이동) 방법		
//		1. redirect 방법	
//		response.sendRedirect("second?name=kim");
//		1-1. redirect 포워딩시 바인딩 : 값이 전달되지 않음
//		request.setAttribute("address", "서울시 성북구");
//		response.sendRedirect("second");
		
//		2. Refresh 방법
//		2-1. refresh 포워딩시 바인딩 : 값이 전달되지 않음
//		request.setAttribute("address", "서울시 성북구");
//		response.addHeader("Refresh", "1; url=second");

//		3. location 방법
//		3-1. location 포워딩시 바인딩 : 값이 전달되지 않음
//		out.print("<script type='text/javascript'>");
//		out.print("location.href='second?name=choi'");
//		out.print("</script>");

//		4. dispatch 방법 : request가 브라우저를 거치지 않고 바로 전달됨
//		4-1. 바인딩 데이터는 dispatch 방식으로만 전달됨
		request.setAttribute("address", "서울시 성북구");
		RequestDispatcher dispatch = request.getRequestDispatcher("second");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
