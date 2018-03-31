package danger.action.riControlPlan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.service.riControlPlan.ControlPlanDetailService;
import danger.service.riControlPlan.ControlPlanService;
import danger.utils.PageBean;
import danger.utils.ValidateCheck;

@Controller
@Scope("prototype")
public class AnalysisPlanAction extends ActionSupport {

	@Resource
	private ControlPlanService controlPlanService;
	public ControlPlanService getControlPlanService() {
		return controlPlanService;
	}

	public void setControlPlanService(ControlPlanService controlPlanService) {
		this.controlPlanService = controlPlanService;
	}
	
	
	@Resource
	private ControlPlanDetailService controlPlanDetailService;
	public ControlPlanDetailService getControlPlanDetailService() {
		return controlPlanDetailService;
	}

	public void setControlPlanDetailService(ControlPlanDetailService controlPlanDetailService) {
		this.controlPlanDetailService = controlPlanDetailService;
	}
	
	//管控计划分析
	private RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan;
	

	public RiDetailedOfRiskCtrlPlan getRiDetailedOfRiskCtrlPlan() {
		return riDetailedOfRiskCtrlPlan;
	}

	public void setRiDetailedOfRiskCtrlPlan(RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan) {
		this.riDetailedOfRiskCtrlPlan = riDetailedOfRiskCtrlPlan;
	}


	//返回结果到界面中
	private Map<String,Object> result;
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

	/*
	 * 跳转到月管控计划分析详情界面
	 */
	public String toMonthRiskControlPlanAnalyzeInfo(){
		
		result = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String riCtrlPlanId = request.getParameter("method");
	
		//得到该管控记录
		RiControlPlan riControlPlan = controlPlanService.getRiControlPlanById(riCtrlPlanId);
		result.put("riControlPlan", riControlPlan);
	
		
		//得到该管控记录的所有风险信息
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition(condition,riCtrlPlanId);
		PageBean<Map<String, Object>> pageBean=controlPlanDetailService.getAllRiskMsgAndAnalysisPlanByControlPlanId(condition);
		System.out.println("pageBean"+pageBean);
		

		result.put("pageBean", pageBean);
		return "monthRiskControlPlanAnalyzeInfo";
	}
	
	
	/*
	 * 跳转到周管控计划分析详情界面
	 */
	public String toWeekRiskControlPlanAnalyzeInfo(){
		
		result = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String riCtrlPlanId = request.getParameter("method");
	
		//得到该管控记录
		RiControlPlan riControlPlan = controlPlanService.getRiControlPlanById(riCtrlPlanId);
		result.put("riControlPlan", riControlPlan);
	
		
		//得到该管控记录的所有风险信息
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition(condition,riCtrlPlanId);
		PageBean<Map<String, Object>> pageBean=controlPlanDetailService.getAllRiskMsgAndAnalysisPlanByControlPlanId(condition);
		System.out.println("pageBean"+pageBean);
		

		result.put("pageBean", pageBean);
		return "weekRiskControlPlanAnalyzeInfo";
	}

	

	private Map<String, Object> generateCondition(Map<String, Object> condition, String riCtrlPlanId) {
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
		if (ValidateCheck.isNotNull(riCtrlPlanId)) {
			condition.put("riCtrlPlanId", riCtrlPlanId);
			result.put("riCtrlPlanId", riCtrlPlanId);
		}
		return condition;
	}
	
	//添加单条管控计划分析
	public String addControlPlanAnalysis(){
		result = new HashMap<String,Object>();
		System.out.println("riDetailedOfRiskCtrlPlan"+riDetailedOfRiskCtrlPlan);
		boolean flag = controlPlanDetailService.addControlPlanAnalysis(riDetailedOfRiskCtrlPlan);

		if (flag) {
			result.put("message", "添加成功");
		} else {
			result.put("message", "添加失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	
	
	private String addRiskmsgid2;
	private String addIdentiryid2;
	public String getAddRiskmsgid2() {
		return addRiskmsgid2;
	}

	public void setAddRiskmsgid2(String addRiskmsgid2) {
		this.addRiskmsgid2 = addRiskmsgid2;
	}

	public String getAddIdentiryid2() {
		return addIdentiryid2;
	}

	public void setAddIdentiryid2(String addIdentiryid2) {
		this.addIdentiryid2 = addIdentiryid2;
	}

	//添加多条管控计划分析
	public String addControlPlanAnalysis2(){
		result = new HashMap<String,Object>();
		
		String[] str = null;
		if(addRiskmsgid2 != null){
			addRiskmsgid2 = addRiskmsgid2.replace("\"", "");
			addRiskmsgid2=addRiskmsgid2.substring(1, addRiskmsgid2.length()-1);
			str = addRiskmsgid2.split(",");
		}
		System.out.println(str);
		
		String[] str2 = null;
		if(addIdentiryid2 != null){
			addIdentiryid2 = addIdentiryid2.replace("\"", "");
			addIdentiryid2=addIdentiryid2.substring(1, addIdentiryid2.length()-1);
			str2 = addIdentiryid2.split(",");
		}
		System.out.println(str2);
		boolean flag=true;
		for(int i=0;i<str.length;i++){
			riDetailedOfRiskCtrlPlan.setRictrlplanid(str2[i]);
			riDetailedOfRiskCtrlPlan.setRiskmsgid(str[i]);
			flag = controlPlanDetailService.addControlPlanAnalysis(riDetailedOfRiskCtrlPlan);
		}
		
		
		
		//boolean flag = controlPlanDetailService.addControlPlanAnalysis(riDetailedOfRiskCtrlPlan);

		if (flag) {
			result.put("message", "添加成功");
		} else {
			result.put("message", "添加失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	
}
