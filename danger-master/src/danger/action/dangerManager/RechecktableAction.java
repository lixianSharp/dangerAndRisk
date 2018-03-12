package danger.action.dangerManager;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.dangerManage.Rechecktable;
import danger.service.dangerManage.RechecktableService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
// 控制层，多例模式
public class RechecktableAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Rechecktable rechecktable;
	private Map<String, Object> result;
	private Integer recheckid;
	private Integer followid;
	Logger logger = Logger.getLogger(RechecktableAction.class);
	@Resource
	private RechecktableService rechecktableService;

	// 新增复查信息
	public String addRecheck() {
		// Integer dangerId = Integer.parseInt(request.getParameter("隐患编号"));
		// Integer followId = Integer.parseInt(request.getParameter("跟踪编号"));
		boolean b = false;
		try {
			result = new HashMap<>();
			b = rechecktableService.addRechecktable(rechecktable);
			String recheckresult = rechecktable.getRecheckresult();
			
			if (b = true) {
				result.put("result", 1);
			} else {
				result.put("result", 0);
			}
			
			/*if("0".equals(recheckresult)){
				//合格
				result.put("res", 0);
			}else if("1".equals(recheckresult)){
				//不合格
				result.put("res", 1);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", 0);
		}
		return SUCCESS;
	}

	// 根据复查编号删除复查信息
	public String deleteRecheck() {
		boolean b = false;
		try {
			result = new HashMap<>();
			b = rechecktableService.deleteRechecktableById(rechecktable.getRecheckid());
			if (b = true) {
				result.put("result", "添加成功！");
			} else {
				result.put("result", "添加失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "添加失败！");
		}
		return SUCCESS;
	}

	public String getRecheck() {
		Rechecktable rechecktableinfo;
		result = new HashMap<>();
		try {
			rechecktableinfo = rechecktableService.getRechecktableByFollowId(followid);
			logger.info(rechecktableinfo);
			// ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			result.put("result", rechecktableinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Integer getRecheckid() {
		return recheckid;
	}

	public void setRecheckid(Integer recheckid) {
		this.recheckid = recheckid;
	}

	public Rechecktable getRechecktable() {
		return rechecktable;
	}

	public void setRechecktable(Rechecktable rechecktable) {
		this.rechecktable = rechecktable;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Integer getFollowid() {
		return followid;
	}

	public void setFollowid(Integer followid) {
		this.followid = followid;
	}

}
