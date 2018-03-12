package danger.action.dangerHandle;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import danger.bean.dangerHandle.Delay;
import danger.service.dangerHandle.DelayService;


/**   
*    
* 项目名称：danger   
* 类名称：DelayAction   
* 类描述：五定延期的action   
* 创建人：Leilong      
* 修改人：      
* 修改备注：   
* @version    
*    
*/
@Controller
@Scope("prototype")
// 控制层，多例模式
public class DelayAction extends ActionSupport implements ModelDriven<Delay> {

	private static final long serialVersionUID = 1L;

	@Resource
	private DelayService delayService;
	private Delay delay = new Delay();
	private Map<String, Object> result;

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	// 实现模型驱动
	public Delay getModel() {

		return delay;
	}

	// 添加延迟信息
	public String addDelay() {

		try {
			boolean isAdd = delayService.addDelay(delay);
			if (isAdd) {
				result = new HashMap<String, Object>();
				result.put("result", "添加成功！");
			} else {
				result.put("result", "添加失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
