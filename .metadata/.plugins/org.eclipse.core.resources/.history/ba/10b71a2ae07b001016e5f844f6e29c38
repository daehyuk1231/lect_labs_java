package app.labs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/SessionEx")
public class SessionEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionEx() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = Optional.ofNullable(request.getParameter("user_name"))
				.orElse("");
		HttpSession session = request.getSession();
		session.setAttribute("user_name", userName);
		
		response.sendRedirect(request.getContextPath() + "/session.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
