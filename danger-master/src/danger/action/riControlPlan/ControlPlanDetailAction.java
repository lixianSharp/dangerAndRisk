package danger.action.riControlPlan;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.service.riControlPlan.ControlPlanDetailService;
import danger.service.riControlPlan.ControlPlanService;
import danger.service.riIdentity.RiAssessmentService;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.PageBean;
import danger.utils.ValidateCheck;

@Controller
@Scope("prototype")
public class ControlPlanDetailAction extends ActionSupport {
	
	//管控详细信息
	@Resource
	private ControlPlanDetailService controlPlanDetailService;

	public ControlPlanDetailService getControlPlanDetailService() {
		return controlPlanDetailService;
	}

	public void setControlPlanDetailService(ControlPlanDetailService controlPlanDetailService) {
		this.controlPlanDetailService = controlPlanDetailService;
	}
	
	//管控
	@Resource
	private ControlPlanService controlPlanService;
	public ControlPlanService getControlPlanService() {
		return controlPlanService;
	}

	public void setControlPlanService(ControlPlanService controlPlanService) {
		this.controlPlanService = controlPlanService;
	}
	
	//辨识风险信息
	@Resource
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService;
	public RiIdentificationRriskMsgService getRiIdentificationRriskMsgService() {
		return riIdentificationRriskMsgService;
	}

	public void setRiIdentificationRriskMsgService(RiIdentificationRriskMsgService riIdentificationRriskMsgService) {
		this.riIdentificationRriskMsgService = riIdentificationRriskMsgService;
	}
	
	//风险评估
	@Resource
	private RiAssessmentService riAssessmentService;
	public RiAssessmentService getRiAssessmentService() {
		return riAssessmentService;
	}

	public void setRiAssessmentService(RiAssessmentService riAssessmentService) {
		this.riAssessmentService = riAssessmentService;
	}

	//返回结果
	private Map<String, Object> result;
	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	//分页条件
	
	private String currentPage;
	private String currentCount;

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
	
	//风险信息详情
	private RiIdentificationRriskMsg riIdentificationRriskMsg;
	public RiIdentificationRriskMsg getRiIdentificationRriskMsg() {
		return riIdentificationRriskMsg;
	}

	public void setRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) {
		this.riIdentificationRriskMsg = riIdentificationRriskMsg;
	}

	/*
	 * 跳转到月管控详情界面
	 */
	public String toMonthControlPlanDetail(){
		result = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String riCtrlPlanId = request.getParameter("method");
	
		//得到该管控记录
		RiControlPlan riControlPlan = controlPlanService.getRiControlPlanById(riCtrlPlanId);
		result.put("riControlPlan", riControlPlan);
	
		
		//得到该管控记录的所有风险信息
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition(condition,riCtrlPlanId);
		PageBean<RiIdentificationRriskMsg> pageBean=controlPlanDetailService.getAllRiskMsgByControlPlanId(condition);
		System.out.println("pageBean"+pageBean);
		result.put("pageBean", pageBean);
		return "monthRiskControlPlanRisk";
	}
	/*
	 * 跳转到周管控详情界面
	 */
	public String toWeekControlPlanDetail(){
		result = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String riCtrlPlanId = request.getParameter("method");
	
		//得到该管控记录
		RiControlPlan riControlPlan = controlPlanService.getRiControlPlanById(riCtrlPlanId);
		result.put("riControlPlan", riControlPlan);
	
		
		//得到该管控记录的所有风险信息
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition(condition,riCtrlPlanId);
		PageBean<RiIdentificationRriskMsg> pageBean=controlPlanDetailService.getAllRiskMsgByControlPlanId(condition);
		System.out.println("pageBean"+pageBean);
		result.put("pageBean", pageBean);
		return "weekRiskControlPlanRisk";
	}
	
	
	/*
	 * 点击页码得到风险信息
	 */
	public String getRiskInfoByPage(){
		
		
		//得到该管控记录的所有风险信息
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition2(condition);
		PageBean<RiIdentificationRriskMsg> pageBean=controlPlanDetailService.getAllRiskMsgByControlPlanId(condition);
		System.out.println("pageBean"+pageBean);
		result.put("pageBean", pageBean);
		return SUCCESS;
	}

	

	/*
	 * 添加一条新的风险信息并添加到管控计划中
	 */
	public String addRiskInfoToControlPlan() throws Exception{
		result = new HashMap<String,Object>();
		
		//新增一条风险信息

		boolean flag1 = riIdentificationRriskMsgService.addRiIdentificationRriskMsg(riIdentificationRriskMsg);
		
		//将该风险进行评估
		//boolean flag2 = riAssessmentService.addRiAssessment(riIdentificationRriskMsg);
		
		//得到该风险信息的id添加到风险管控计划详细表中
		
		
		return SUCCESS;
	}
	
	/*
	 * 修改一条新的风险信息并添加到管控计划中
	 */
	public String updateRiskInfoToControlPlan(){
		result = new HashMap<String,Object>();
		
		//修改这条风险信息
		
		//得到该风险信息的id添加到风险管控计划详细表中
		
		return SUCCESS;
	}
	
	/*
	 * 删除该管控计划的一条风险信息
	 */
	public String deleteRiskFormControlPlan(){
		result = new HashMap<String,Object>();
		
		//得到该风险信息的id并且从风险管控计划详细表中去掉
		
		
		return SUCCESS;
	}
	
	/*
	 * 复制上月的管控计划的所有风险信息
	 */
	public String copyPrecedingMonthToControlPlan(){
		result = new HashMap<String,Object>();
		
		//得到该管控计划的年份和月份
		
		//得到上月的年份和月份
		
		//得到上月的风险信息
		
		//将风险信息添加到该管控计划中
		
		return SUCCESS;
	}
	
	
	//分页查询条件
	private Map<String, Object> generateCondition(Map<String, Object> condition,String riCtrlPlanId) {
		if (currentPage == null || "".equals(currentPage.trim())) {
			currentPage = "1";
			condition.put("currentPage", currentPage);
			result.put("currentPage", currentPage);
		}
		if (currentCount == null || "".equals(currentCount.trim())) {
			currentCount ="10";
			condition.put("currentCount", currentCount);
			result.put("currentCount", currentCount);
		}

		if (ValidateCheck.isNotNull(currentPage)) {
			condition.put("currentPage", currentPage);
			result.put("currentPage", currentPage);
		}
		if (ValidateCheck.isNotNull(currentCount)) {
			condition.put("currentCount", currentCount);
			result.put("currentCount", currentCount);
		}
		if (ValidateCheck.isNotNull(riCtrlPlanId)) {
			condition.put("riCtrlPlanId", riCtrlPlanId);
			result.put("riCtrlPlanId", riCtrlPlanId);
		}
		return condition;
	}
	
	private Map<String, Object> generateCondition2(Map<String, Object> condition) {
		if (currentPage == null || "".equals(currentPage.trim())) {
			currentPage = "1";
			condition.put("currentPage", currentPage);
			result.put("currentPage", currentPage);
		}
		if (currentCount == null || "".equals(currentCount.trim())) {
			currentCount ="10";
			condition.put("currentCount", currentCount);
			result.put("currentCount", currentCount);
		}

		if (ValidateCheck.isNotNull(currentPage)) {
			condition.put("currentPage", currentPage);
			result.put("currentPage", currentPage);
		}
		if (ValidateCheck.isNotNull(currentCount)) {
			condition.put("currentCount", currentCount);
			result.put("currentCount", currentCount);
		}
		return condition;
	}

}
