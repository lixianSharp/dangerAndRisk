package danger.action.queryView;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.dangerManage.Danger;
import danger.bean.queryView.DangerSiding;
import danger.bean.queryView.DangerSidingFollow;
import danger.bean.queryView.DangerSidingFollowRecheck;
import danger.bean.queryView.DangerSpot;
import danger.service.queryView.QueryViewService;
import danger.utils.PageBean;
import danger.utils.ValidateCheck;

@Controller
@Scope("prototype")
// 控制层，多例模式
public class QueryViewAction extends ActionSupport {
	Logger log = Logger.getLogger(QueryViewAction.class);
	private Map<String, Object> result;
	private String getType; // 标记是现场处理还是隐患
	private String first;
	private String currentPage;
	private String currentCount;
	private String findtime;// 发现日期
	private String manager;// 负责人
	private String checkunit;// 检查单位
	private String unit;// 责任单位
	private int dangerId;// 隐患id
	private int sidingId;// 五定id

	private String address;// 地点

	private String content;// 隐患内容

	private String dangergrade;// 隐患级别

	private String type;// 隐患类型

	private String dangerstatusnum;// 隐患状态编号

	private String dangerstatus; // 隐患状态
	private String startTime; // 月表查询的开始时间
	private String endTime; // 月表查询的结束时间

	@Autowired
	private QueryViewService queryViewService;

	/**
	 * 分页查询隐患信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDanger() {
		@SuppressWarnings("rawtypes")
		Map condition = new HashMap();
		result = new HashMap();
		condition = generateCondition(condition);//组装查询条件
		if (first != null && "spotDispose".equals(first)) {
			result.put("dangergrade", "无");
			condition.put("dangergrade", "无");
			result.put("dangerstatus", "未五定");
			condition.put("dangerstatus", "未五定");
		}
		PageBean<Danger> pageBean = null;
		try {
			pageBean = queryViewService.findDangerByCondition(Integer.valueOf(currentPage),
					Integer.valueOf(currentCount), condition);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
	
		result.put("pageBean", pageBean);
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.setAttribute("unitvalue", unit);
		
		
		return "pageDanger";
	}

	/**
	 * 查询隐患
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDanger2() {
		@SuppressWarnings("rawtypes")
		Map condition = new HashMap();
		result = new HashMap();
		condition = generateCondition(condition);
		PageBean<Danger> pageBean = null;
		try {
			pageBean = queryViewService.findDangerByCondition(Integer.valueOf(currentPage),
					Integer.valueOf(currentCount), condition);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		result.put("pageBean", pageBean);
		return "pageDangerQuery";
	}

	/**
	 * 五定的查询
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findSiding() {
		@SuppressWarnings("rawtypes")
		Map condition = new HashMap();
		result = new HashMap();
		condition = generateCondition(condition);
		if (first != null && "siding".equals(first)) {
			result.put("dangerstatus", "未五定");
			condition.put("dangerstatus", "未五定");
		}
		// 如果是查看已经复查的就去查询视图
		if (ValidateCheck.isNotNull(dangerstatus) && "已复查".equals(dangerstatus)) {
			PageBean<DangerSidingFollowRecheck> pageBean = null;
			try {
				pageBean = queryViewService.findDangerSidingFollowRecheckByCondition(Integer.valueOf(currentPage),
						Integer.valueOf(currentCount), condition);
			} catch (SQLException e) {
				log.error(e.getMessage(), e);
			}
			result.put("tag", "checkedSiding");
			result.put("pageBean", pageBean);
			return "pageSiding";
		}
		PageBean<Danger> pageBean = null;
		try {
			pageBean = queryViewService.findDangerByCondition(Integer.valueOf(currentPage),
					Integer.valueOf(currentCount), condition);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		result.put("tag", "formalSiding");
		result.put("pageBean", pageBean);
		return "pageSiding";
	}

	/**
	 * 查询单个隐患现场处理信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDangerSpot() {
		DangerSpot dangerSpot;
		try {
			dangerSpot = queryViewService.getDangerSpotByDangerId(dangerId);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		result = new HashMap<String, Object>();
		result.put("dangerSpot", "dangerSpot");
		return SUCCESS;
	}

	/**
	 * 查询隐患跟踪
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDangerS() {
		@SuppressWarnings("rawtypes")
		Map condition = new HashMap();
		result = new HashMap();
		condition = generateCondition(condition);
		PageBean<DangerSiding> pageBean = null;

		if (first != null && "follow".equals(first)) {
			result.put("dangerstatus", "已五定");
			condition.put("dangerstatus", "已五定");
		}

		try {
			pageBean = queryViewService.findDangerSidingByCondition(Integer.valueOf(currentPage),
					Integer.valueOf(currentCount), condition);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		result.put("pageBean", pageBean);
		return "pageDangerS";
	}

	/**
	 * 查询隐患五定跟踪
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDangerSF() {
		@SuppressWarnings("rawtypes")
		Map condition = new HashMap();
		result = new HashMap();
		condition = generateCondition(condition);
		PageBean<DangerSidingFollow> pageBean = null;
		if (first != null && "review".equals(first)) {
			result.put("dangerstatus", "已整改");
			condition.put("dangerstatus", "已整改");
		}
		try {
			pageBean = queryViewService.findDangerSidingFollowByCondition(Integer.valueOf(currentPage),
					Integer.valueOf(currentCount), condition);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		result.put("pageBean", pageBean);
		return "pageDangerSF";
	}

	/**
	 * 查询隐患五定跟踪复查(日报统计)
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDangerSFR() {
		@SuppressWarnings("rawtypes")
		Map condition = new HashMap();
		result = new HashMap();
		condition = generateCondition(condition);
		PageBean<DangerSidingFollowRecheck> pageBean = null;
		try {
			pageBean = queryViewService.findDangerSidingFollowRecheckByCondition(Integer.valueOf(currentPage),
					Integer.valueOf(currentCount), condition);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		result.put("pageBean", pageBean);
		return "pageDangerSFR";
	}

	/**
	 * 查询隐患五定跟踪复查(月报统计)
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDangerSFR1() {
		@SuppressWarnings("rawtypes")
		Map condition = new HashMap();
		result = new HashMap();
		condition = generateCondition(condition);
		PageBean<DangerSidingFollowRecheck> pageBean = null;
		try {
			pageBean = queryViewService.findDangerSidingFollowRecheckByCondition(Integer.valueOf(currentPage),
					Integer.valueOf(currentCount), condition);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		result.put("pageBean", pageBean);
		return "pageDangerSFR1";
	}

	/**
	 * 组装查询条件
	 * 
	 * @param condition
	 */
	private Map generateCondition(Map<String, Object> condition) {
		if (currentPage == null || "".equals(currentPage.trim())) {
			currentPage = "1";
		}
		if (currentCount == null || "".equals(currentCount.trim())) {
			currentCount = "10";
		}
		if (ValidateCheck.isNotNull(checkunit)) {
			if (!"0".equals(checkunit)) {
				condition.put("checkunit", checkunit);
				result.put("checkunit", checkunit);
			}
		}
		if (ValidateCheck.isNotNull(findtime)) {
			condition.put("startTime", findtime + " 00:00:00");
			condition.put("endTime", findtime + " 23:59:59");
			result.put("findtime", findtime);
		}
		if (ValidateCheck.isNotNull(startTime)) {
			condition.put("startTime", startTime + " 00:00:00");
			result.put("startTime", startTime);
		}
		if (ValidateCheck.isNotNull(endTime)) {
			condition.put("endTime", endTime + " 23:59:59");
			result.put("endTime", endTime);
		}
		if (ValidateCheck.isNotNull(findtime)) {
			condition.put("startTime", findtime + " 00:00:00");
			condition.put("endTime", findtime + " 23:59:59");
			result.put("findtime", findtime);
		}
		if (ValidateCheck.isNotNull(address)) {
			condition.put("address", address);
			result.put("address", address);
		}
		if (ValidateCheck.isNotNull(content)) {
			condition.put("content", content);
			result.put("content", content);
		}
		if (ValidateCheck.isNotNull(dangergrade)) {
			condition.put("dangergrade", dangergrade);
			result.put("dangergrade", dangergrade);
		}
		if (ValidateCheck.isNotNull(type)) {
			condition.put("type", type);
			result.put("type", type);
		}
		if (ValidateCheck.isNotNull(unit)) {
			condition.put("unit", unit);
			result.put("unit", unit);
		}
		if (ValidateCheck.isNotNull(dangerstatusnum)) {
			condition.put("dangerstatusnum", dangerstatusnum);
			result.put("dangerstatusnum", dangerstatusnum);
		}
		if (ValidateCheck.isNotNull(dangerstatus)) {
			condition.put("dangerstatus", dangerstatus);
			result.put("dangerstatus", dangerstatus);
		}
		if (ValidateCheck.isNotNull(manager)) {
			condition.put("manager", manager);
			result.put("manager", manager);
		}
		return condition;
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

	public QueryViewService getQueryViewService() {
		return queryViewService;
	}

	public void setQueryViewService(QueryViewService queryViewService) {
		this.queryViewService = queryViewService;
	}

	public String getFindtime() {
		return findtime;
	}

	public void setFindtime(String findtime) {
		this.findtime = findtime;
	}

	public String getCheckunit() {
		return checkunit;
	}

	public void setCheckunit(String checkunit) {
		this.checkunit = checkunit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getDangerstatusnum() {
		return dangerstatusnum;
	}

	public void setDangerstatusnum(String dangerstatusnum) {
		this.dangerstatusnum = dangerstatusnum;
	}

	public String getDangerstatus() {
		return dangerstatus;
	}

	public void setDangerstatus(String dangerstatus) {
		this.dangerstatus = dangerstatus;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public int getDangerId() {
		return dangerId;
	}

	public void setDangerId(int dangerId) {
		this.dangerId = dangerId;
	}

	public int getSidingId() {
		return sidingId;
	}

	public void setSidingId(int sidingId) {
		this.sidingId = sidingId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getGetType() {
		return getType;
	}

	public void setGetType(String getType) {
		this.getType = getType;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

}
