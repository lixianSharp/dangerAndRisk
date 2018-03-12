package danger.action.queryView;

/**
 * 登陆Action
 */
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.sys.User;
import danger.utils.ValidateCheck;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {
	private Map<String, Object> result;
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
	}
}
