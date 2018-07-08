package danger.action.queryView.shiro;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

import danger.exception.CustomException;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {
	/*private Map<String, Object> result;
	private String username;
	private String password;
	private User user;

	@Override
	public String execute() throws Exception {
		result = new HashMap();
		// 获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 用户名与密码不为空进行登陆验证
		if (ValidateCheck.isNotNull(username) && ValidateCheck.isNotNull(password)) {
			// 模拟登陆成功后session中添加user
			if ("root".equals(username) && "123456".equals(password)) {
				user = new User();
				user.setUsername(username);
				user.setRole(2);
				session.setAttribute("user", user);
				return SUCCESS;
			}
			if ("信息录入员".equals(username) && "123456".equals(password)) {
				user = new User();
				user.setRole(1);
				user.setUsername(username);
				session.setAttribute("user", user);
				return SUCCESS;
			}
		}
		// 来到这里证明登陆未成功
		result.put("msg", "账户或者密码错误");
		return ERROR;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map getResult() {
		return result;
	}

	public void setResult(Map result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/
	
	
	
	
	//以下是使用shiro之后重新写的*********///
	
	//登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				throw new CustomException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				throw new CustomException("用户名/密码错误");
			} else if("randomCodeError".equals(exceptionClassName)){
				throw new CustomException("验证码错误 ");
			}else{
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
