package danger.action.queryView;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.dangerManage.Danger;
import danger.bean.queryView.DangerSiding;
import danger.bean.queryView.DangerSidingFollow;
import danger.bean.queryView.DangerSidingFollowRecheck;
import danger.bean.queryView.DangerSpot;
import danger.bean.queryView.Tongji;
import danger.service.queryView.QueryViewService;
import danger.service.queryView.TongjiService;
import danger.utils.PageBean;
import danger.utils.ValidateCheck;

@Controller
@Scope("prototype")
// 控制层，多例模式
public class TongjiAction extends ActionSupport {
	Logger log = Logger.getLogger(TongjiAction.class);

	@Autowired
	private TongjiService tongjiService;

	private String startTime;
	private String endTime;

	private Map<String, Object> result;// 用于回显结果

	@Override
	public String execute() throws Exception {
		result = new HashMap<>();
		Map<String, Object> condition = new HashMap<>();
		condition = this.generateCondition(condition);
		List<Tongji> tongjiInfoList = tongjiService.getTongjiInfo(condition);
		Tongji totalInfo = tongjiService.getTotalInfo(condition);
		result.put("tongjiInfoList", tongjiInfoList);
		result.put("totalInfo", totalInfo);
		return super.execute();
	}

	private Map generateCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		if (ValidateCheck.isNotNull(startTime)) {
			condition.put("startTime", startTime + " 00:00:00");
			result.put("startTime", startTime);
		}
		if (ValidateCheck.isNotNull(endTime)) {
			condition.put("endTime", endTime + " 23:59:59");
			result.put("endTime", endTime);
		}
		return condition;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public TongjiService getTongjiService() {
		return tongjiService;
	}

	public void setTongjiService(TongjiService tongjiService) {
		this.tongjiService = tongjiService;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}
