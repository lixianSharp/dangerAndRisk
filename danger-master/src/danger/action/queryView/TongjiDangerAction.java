package danger.action.queryView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.service.queryView.TongjiDangerService;
import danger.utils.ValidateCheck;

/**
 * 统计之后点击每个数字的时候用
 * 
 * @author QizoLiQiang
 * @time 2017年9月7日下午12:09:31
 */
@SuppressWarnings({ "rawtypes", "unchecked", "serial", "unused" })

@Controller

@Scope("prototype")

public class TongjiDangerAction extends ActionSupport {
	Logger logger = Logger.getLogger(TongjiDangerAction.class);
	private Map<String, Object> result;
	private String currentPage;
	private String currentCount;
	private String checkunit;// 检查单位
	private String dangergrade;// 隐患级别
	private String startTime; // 月表查询的开始时间
	private String endTime; // 月表查询的结束时间
	private String type;// 隐患类型

	@Autowired
	private TongjiDangerService tongjiDangerService;

	@Override
	public String execute() {
		Map<String, Object> condition = new HashMap();
		result = new HashMap();
		// 封装条件
		condition = generateCondition(condition);
		try {// 获取总数与数据
			Map<String, Object> dangerTongji = tongjiDangerService.findDangerCountPageByCondition(
					Integer.valueOf(currentPage), Integer.valueOf(currentCount), condition);
			// 将总数与数据加入map中返回
			result.put("productList", dangerTongji.get("productList"));
			result.put("totalCount", dangerTongji.get("totalCount"));
			result.put("currentPage", dangerTongji.get("currentPage"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
		}
		return "success";
	}

	private Map<String, Object> generateCondition(Map<String, Object> condition) {
		if (currentPage == null || "".equals(currentPage.trim())) {
			currentPage = "1";
			// 当前页号写回到页面
			result.put("currentPage", Integer.valueOf(currentPage));
		}
		if (currentCount == null || "".equals(currentCount.trim())) {
			currentCount = "6";
		}
		if (ValidateCheck.isNotNull(checkunit)) {
			if (!"0".equals(checkunit)) {
				condition.put("checkunit", checkunit);
				result.put("checkunit", checkunit);
			}
		}
		if (ValidateCheck.isNotNull(startTime)) {
			condition.put("startTime", startTime + " 00:00:00");
			result.put("startTime", startTime);
		}
		if (ValidateCheck.isNotNull(endTime)) {
			condition.put("endTime", endTime + " 23:59:59");
			result.put("endTime", endTime);
		}
		if (ValidateCheck.isNotNull(dangergrade)) {
			condition.put("dangergrade", dangergrade);
			result.put("dangergrade", dangergrade);
		}
		if (ValidateCheck.isNotNull(type)) {
			condition.put("type", type);
			result.put("type", type);
		}
		return condition;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(String currentCount) {
		this.currentCount = currentCount;
	}

	public String getCheckunit() {
		return checkunit;
	}

	public void setCheckunit(String checkunit) {
		this.checkunit = checkunit;
	}

	public String getDangergrade() {
		return dangergrade;
	}

	public void setDangergrade(String dangergrade) {
		this.dangergrade = dangergrade;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TongjiDangerService getTongjiDangerService() {
		return tongjiDangerService;
	}

	public void setTongjiDangerService(TongjiDangerService tongjiDangerService) {
		this.tongjiDangerService = tongjiDangerService;
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
