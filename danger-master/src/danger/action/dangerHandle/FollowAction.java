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

import danger.bean.dangerHandle.Follow;
import danger.service.dangerHandle.FollowService;
import danger.service.dangerHandle.SidingService;


/**   
*    
* 项目名称：danger   
* 类名称：FollowAction   
* 类描述： 五定跟踪的action  
* 创建人：Leilong      
* 修改人：     
* 修改备注：   
* @version    
*    
*/
@Controller
@Scope("prototype")
// 控制层，多例模式
public class FollowAction extends ActionSupport implements ModelDriven<Follow> {

	private static final long serialVersionUID = 1L;

	private Follow follow = new Follow();
	@Resource
	private FollowService followService;
	@Resource
	private SidingService siDingService;
	private Map<String, Object> result;

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	// 实现模型驱动
	public Follow getModel() {
		return follow;
	}

	// 添加跟踪信息
	public String addFollow() {

		try {
			boolean isAdd = followService.addFollow(follow);
			result = new HashMap<String, Object>();
			if (isAdd) {

				result.put("result", "添加成功！");
			} else {
				result.put("result", "添加失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// 查询详细信息
	public String getDetailInfo() {

		try {
			// 获取request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			String sidingIdStr = request.getParameter("sidingId");
			// 创建一个map存放信息
			result = new HashMap<String, Object>();
			int sidingId = Integer.valueOf(sidingIdStr);
			result.put("followInfo", siDingService.getFollowBySidingId(sidingId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//删除跟踪信息
	public String deleteFollowInfoBySidingId(){
		
		try {
			// 获取request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			String sidingIdStr = request.getParameter("sidingId_followInfo");
			// 创建一个map存放信息
			result = new HashMap<String, Object>();
			int sidingId = Integer.valueOf(sidingIdStr);
			boolean isDelete = followService.deleteFollowById(sidingId);
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
	
	//修改跟踪信息
	public String updateFollowInfo(){
		
		try {
			boolean isAdd = followService.updateFollowById(follow);
			result = new HashMap<String, Object>();
			if (isAdd) {

				result.put("result", "修改成功！");
			} else {
				result.put("result", "修改失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
}
