package danger.action.queryView;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class LogoutAction extends ActionSupport {

	/*@Override
	public String execute() throws Exception {
		// 获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 清空session中的用户
		session.removeAttribute("user");
		return super.execute();
	}*/
}
