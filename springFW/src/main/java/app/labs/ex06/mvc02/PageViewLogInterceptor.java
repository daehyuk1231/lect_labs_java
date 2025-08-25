package app.labs.ex06.mvc02;

import java.sql.Date;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PageViewLogInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("컨트롤러가 실행 되기 전입니다.");

		request.setCharacterEncoding("utf-8");

		System.out.println("URI:" + request.getRequestURI());
		System.out.println("현재시간: " + (new java.util.Date()).toString());

		/*
		 * // 로그인 처리 HttpSession session = request.getSession(); String id =
		 * session.getAttribute("userid").toString();
		 * 
		 * if(id.equals("")||id==null) { response.sendRedirect("/login"); return false;
		 * }
		 */
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("컨트롤러가 실행된 후 입니다.(뷰가 실행되기 전)");
		System.out.println(modelAndView.getViewName());

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("뷰가 실행된 후 입니다.");

	}
}
