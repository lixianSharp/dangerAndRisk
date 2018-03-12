package danger.action.dangerHandle;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import danger.bean.dangerHandle.Sidingbiao;
import danger.service.dangerHandle.SidingService;



/**   
*    
* 项目名称：danger   
* 类名称：SidingAction   
* 类描述：隐患五定的action
* 创建人：Leilong      
* 修改人：     
* 修改备注：   
* @version    
*    
*/
@Controller
@Scope("prototype")
// 控制层，多例模式
public class SidingAction extends ActionSupport implements ModelDriven<Sidingbiao> {

	private static final long serialVersionUID = 1L;

	private Sidingbiao siDingBiao = new Sidingbiao();
	@Resource
	private SidingService sidingService;
	private Map<String, Object> result;

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	// 实现模型驱动中的方法
	public Sidingbiao getModel() {
		return siDingBiao;
	}

	

	// 添加五定信息
	public String addSiding() {
		try {
			boolean isAdd = sidingService.addSiding(siDingBiao);
			result = new HashMap<String, Object>();
			if (isAdd) {
				result.put("result", "添加成功！");
			} else {
				result.put("result", "添加失败！");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(siDingBiao);
		return SUCCESS;
	}

	// 查询五定显示详情信息，调用SidingService中的getSidingById(Integer dangerId)的方法
	public String getSidingById() {

		try {
			// 获取request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			String dangerIdStr = request.getParameter("dangerId");
			int dangerId = Integer.valueOf(dangerIdStr);
			result = sidingService.getSidingById(dangerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	// 修改五定信息
	// 封装包括sidingID在内的所有信息
	public String updateSidingInfo() {

		try {
			boolean isUpdate = sidingService.updateSiding(siDingBiao);
			result = new HashMap<String, Object>();
			if (isUpdate) {
				result.put("result", "修改成功！");
			} else {
				result.put("result", "修改失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 根据五定ID查询五定信息
	public String getSidingInfoBySidingId() {

		try {
			result = new HashMap<String, Object>();
			HttpServletRequest request = ServletActionContext.getRequest();
			String sidingIdStr = request.getParameter("sidingId");
			int sidingId = Integer.valueOf(sidingIdStr);
			Sidingbiao sidingInfo = sidingService.getSidingInfoBySidingId(sidingId);
			result.put("sidingInfo", sidingInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 根据五定ID删除五定信息
	public String deleteSidingInfoBySidingId() {

		try {

			// 获取request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			String sidingIdStr = request.getParameter("sidingId");
			int sidingId = Integer.valueOf(sidingIdStr);
			boolean isDelete = sidingService.deleteSidingById(sidingId);
			result = new HashMap<String, Object>();
			if (isDelete) {
				result.put("result", "删除成功！");
			} else {
				result.put("result", "删除失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

}
