package danger.action.queryView.shiro;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import danger.bean.shiro.ActiveUser;

@Controller
@Scope("prototype")
public class FirstAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 获取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过request传到页面
		/*HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("activeUser", activeUser);*/
		
		//通过session传到页面
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("activeUser", activeUser);
		return SUCCESS;
	}
}
