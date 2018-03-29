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
import danger.bean.riCtrl.RiRiskPlanAudit;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.service.riControlPlan.ControlPlanDetailService;
import danger.service.riControlPlan.ControlPlanService;
import danger.utils.PageBean;
import danger.utils.ValidateCheck;

@Controller
@Scope("prototype")
public class ValidPlanAction extends ActionSupport {

	//管控详细信息
	@Resource
	private ControlPlanDetailService controlPlanDetailService;

	public ControlPlanDetailService getControlPlanDetailService() {
		return controlPlanDetailService;
	}

	public void setControlPlanDetailService(ControlPlanDetailService controlPlanDetailService) {
		this.controlPlanDetailService = controlPlanDetailService;
	}
	
	@Resource
	private ControlPlanService controlPlanService;
	public ControlPlanService getControlPlanService() {
		return controlPlanService;
	}

	public void setControlPlanService(ControlPlanService controlPlanService) {
		this.controlPlanService = controlPlanService;
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
	private String monthOrWeek;
	private String specialty;
    private String riskCtrlPlanMark;
	private String currentPage;
	private String currentCount;
	
	
	public String getMonthOrWeek() {
		return monthOrWeek;
	}

	public void setMonthOrWeek(String monthOrWeek) {
		this.monthOrWeek = monthOrWeek;
	}
	
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
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
	public String getRiskCtrlPlanMark() {
		return riskCtrlPlanMark;
	}

	public void setRiskCtrlPlanMark(String riskCtrlPlanMark) {
		this.riskCtrlPlanMark = riskCtrlPlanMark;
	}

	//跳转到losePlanDis页面
	public String toLosePlanDis(){
		result = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String riCtrlPlanId = request.getParameter("method");
		
		//得到该管控记录的所有失效责任部门及其个数
		List<Map<String,Object>> dutyDepartmentList = new LinkedList<Map<String,Object>>();
		dutyDepartmentList = controlPlanDetailService.getDutyDepartmentList(riCtrlPlanId);
		
		//得到该管控记录的所有失效风险地点及其个数
		List<Map<String,Object>> addressList = new LinkedList<Map<String,Object>>();
		addressList = controlPlanDetailService.getAddressList(riCtrlPlanId);
		
		result.put("addressList", addressList);
		result.put("dutyDepartmentList", dutyDepartmentList);
		return "losePlanDis";
	}
	
	
	
	//得到所有的有效性数据
	public String getAllVaildPlanInfo(){
		result = new HashMap<String,Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition(condition);
		
		PageBean<RiControlPlan> pageBean = controlPlanDetailService.getAllVaildPlanInfo(condition);

		List<RiControlPlan> ricontrolPlanList = pageBean.getProductList();
		
		//风险总数
		List<Integer> riskCountList = new LinkedList<Integer>();
		
		List<Integer> validCountList = new LinkedList<Integer>();
		
		//得到该管控计划下的所有风险信息的风险地点
		List<List<String>> addressList = new LinkedList<List<String>>();
				
		
		for(int i=0;i<ricontrolPlanList.size();i++){
			
			int a=controlPlanService.getRiskCount(ricontrolPlanList.get(i).getRictrlplanid());
			riskCountList.add(a);
			
			int b = controlPlanDetailService.getValidCount(ricontrolPlanList.get(i).getRictrlplanid());
			validCountList.add(b);
			
			List<String> s2=  controlPlanService.getRiskAddress(ricontrolPlanList.get(i).getRictrlplanid());
			addressList.add(s2);
			
		}
		
		result.put("riskCountList", riskCountList);
		
		result.put("validCountList", validCountList);
		
		result.put("addressList", addressList);
		
		result.put("pageBean", pageBean);
		
		return SUCCESS;
	}

	private Map<String, Object> generateCondition(Map<String, Object> condition) {
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
		if (ValidateCheck.isNotNull(monthOrWeek)) {
			condition.put("monthOrWeek", monthOrWeek);
			result.put("monthOrWeek", monthOrWeek);
		}
		if (ValidateCheck.isNotNull(specialty)) {
			condition.put("specialty", specialty);
			result.put("specialty", specialty);
		}
		if (ValidateCheck.isNotNull(riskCtrlPlanMark)) {
			condition.put("riskCtrlPlanMark", riskCtrlPlanMark);
			result.put("riskCtrlPlanMark", riskCtrlPlanMark);
		}
		
		return condition;
	}
	
	
	/*
	 * 得到专业类型下拉列表
	 */

	public String getProfessionalTypesList(){
		result = new HashMap<String,Object>();
		List<String> ptList = controlPlanDetailService.getProfessionalTypesList();
		result.put("ptList", ptList);
		return SUCCESS;
	}
}
