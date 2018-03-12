package danger.action.sys.unit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
// 控制层，多例模式
public class DepartmentAction extends ActionSupport{

}
