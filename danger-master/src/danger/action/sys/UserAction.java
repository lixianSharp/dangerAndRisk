package danger.action.sys;

import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.sys.Permission;
import danger.bean.sys.User;
import danger.service.sys.UserService;
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session = ServletActionContext.getRequest().getSession();
	@Resource
	private UserService userService;
	
	public String userLogin(){
		try {
			if (userService.login(user.getId().toString(), user.getPassword())) {
				List<Permission> permission=userService.getPermissionObjectfromUserByUserId(user.getId());
				session.setAttribute("permissionInfo", permission);
				return "login_success";	
			}else {
				return "login_error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "login_error";
		}				
	}
	
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
