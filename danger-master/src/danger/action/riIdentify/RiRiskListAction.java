package danger.action.riIdentify;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

//风险清单
@Controller
@Scope("prototype")
public class RiRiskListAction extends ActionSupport{

	// 实例化要转成json的文本集合
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
