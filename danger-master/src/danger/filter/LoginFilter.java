package danger.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import danger.bean.sys.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		// 如果包含login.jsp证明是登陆就放行
		if (path.contains("login") || path.contains("/js/") || path.contains("/image/") || path.contains("/css/")
				|| path.contains("message.jsp")|| path.contains("404.jsp")|| path.contains("/images/")) {
			chain.doFilter(request, response); // 放行
			return;
		}
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user =  (User) session.getAttribute("user");
		// 如果session中存在user证明用户登录，可以放行。否则认为未登陆重定向到login.jsp
		if (user == null) {
			res.sendRedirect(req.getContextPath() + "/login/login.jsp");
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
