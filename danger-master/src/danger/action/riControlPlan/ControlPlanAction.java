package danger.action.riControlPlan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiRiskPlanAudit;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.service.riControlPlan.ControlPlanService;
import danger.utils.PageBean;
import danger.utils.ValidateCheck;

@Controller
@Scope("prototype")
public class ControlPlanAction extends ActionSupport {


	
	//添加月管控计划
	public String addControlPlan(){
		result = new HashMap<String,Object>();
		boolean flag = controlPlanService.addControlPlan(ricontrolPlan);

		if (flag) {
			result.put("message", "添加成功");
		} else {
			result.put("message", "添加失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	//添加旬管控计划
	public String addWeekControlPlan(){
		result = new HashMap<String,Object>();
		boolean flag = controlPlanService.addWeekControlPlan(ricontrolPlan);

		if (flag) {
			result.put("message", "添加成功");
		} else {
			result.put("message", "添加失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	
	//修改管控计划
	public String updateControlPlan(){
		result = new HashMap<String,Object>();
		
		boolean flag = controlPlanService.updateControlPlan(ricontrolPlan);
		if (flag) {
			result.put("message", "修改成功");
		} else {
			result.put("message", "修改失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	
	
	//得到所有的管控计划的信息（分页）
	public String getAllControlPlan(){
		result = new HashMap<String, Object>();
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition(condition);
		
		PageBean<RiControlPlan> pageBean = controlPlanService.getAllControlPlan(condition);
		
		List<RiControlPlan> ricontrolPlanList = pageBean.getProductList();
		//得到管控计划的风险数量
		List<Integer> riskCountList = new LinkedList<Integer>();
		
		//得到该管控计划的审核备注信息
		List<LinkedList<RiRiskPlanAudit>> shenheList = new LinkedList<LinkedList<RiRiskPlanAudit>>();
		
		//得到该管控计划下的所有风险信息的风险地点
		List<List<String>> addressList = new LinkedList<List<String>>();
		
		for(int i=0;i<ricontrolPlanList.size();i++){
			System.out.println(ricontrolPlanList.get(i).getRictrlplanid());
			int a=controlPlanService.getRiskCount(ricontrolPlanList.get(i).getRictrlplanid());
			riskCountList.add(a);
			//得到其中一条管控计划的所有审核备注信息
			LinkedList<RiRiskPlanAudit> strList=controlPlanService.getShenHe(ricontrolPlanList.get(i).getRictrlplanid());
			shenheList.add(strList);
			
			List<String> s2=  controlPlanService.getRiskAddress(ricontrolPlanList.get(i).getRictrlplanid());
			addressList.add(s2);
		}
		
		
		
		
		
		result.put("riskCountList", riskCountList);
		
		result.put("shenheList", shenheList);
		
		result.put("addressList", addressList);
		
		result.put("pageBean", pageBean);
		System.out.println(result);
		return SUCCESS;
	}

	//分页查询条件
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
		return condition;
	}
	
	/*
	 * 得到风险信息（分页）
	 */
	public String getAllRiskInfo(){
		result = new HashMap<String, Object>();
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition = generateCondition2(condition);
		
		PageBean<RiIdentificationRriskMsg> pageBean = controlPlanService.getAllRiskInfo(condition);
		result.put("pageBean", pageBean);
		return SUCCESS;
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
		if (ValidateCheck.isNotNull(riskDescribe)) {
			condition.put("riskDescribe", riskDescribe);
			result.put("riskDescribe", riskDescribe);
		}
		if (ValidateCheck.isNotNull(riskType)) {
			condition.put("riskType", riskType);
			result.put("riskType", riskType);
		}
		return condition;
	}
	
	
	
	/*
	 * 导入风险信息到管控计划中
	 */
	public String importRiskInfo(){
		result = new HashMap<String, Object>();
		//System.out.println(shuzu);
		/*for(int i=0;i<shuzu.length;i++){
			System.out.println(shuzu[i]);
			boolean flag = controlPlanService.importRiskInfo(rictrlplanid,shuzu[i]);
		}
		*/
		boolean flag = controlPlanService.importRiskInfo(rictrlplanid,riskmsgid);
		//boolean flag = controlPlanService.importRiskInfo(rictrlplanid,rictrlplanid);
		if (flag) {
			result.put("message", "导入成功");
		} else {
			result.put("message", "导入失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	
	/*
	 * 删除该管控计划中的一条风险信息
	 */
	public String deleteRiskInfo(){
		result = new HashMap<String, Object>();
		boolean flag = controlPlanService.deleteRiskInfo(riCtrlPlanId,riskMsgId);
		if (flag) {
			result.put("message", "删除成功");
		} else {
			result.put("message", "删除失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	
	/*
	 * 复制上月的管控计划风险数据
	 */
	public String iconpyPrecedingMonthRiskInfo(){
		result = new HashMap<String, Object>();
		boolean flag=false;
		/*
		 * 得到上月管控计划的id
		 */
		String precedingMonthId = controlPlanService.getPrecedingMonthId(Myrictrlplanid);
		
		/*
		 * 得到上月的风险信息的id
		 */
		List<String> precedingMonthRiskInfoIdList = new LinkedList<String>();
		precedingMonthRiskInfoIdList = controlPlanService.getPrecedingMonthRiskInfoIdList(precedingMonthId);
		
		/*
		 * 将上月的风险信息的id添加到本月中
		 */
		if(precedingMonthId!=null){
			
			for(String str :precedingMonthRiskInfoIdList){
				 flag= controlPlanService.importRiskInfo(Myrictrlplanid,str);
				 if(!flag){
					 break;
				 }
			}
			if (flag) {
				result.put("message", "复制成功");
			} else {
				result.put("message", "复制失败");
			}
		}else{
			result.put("message", "没有上月的管控计划");
		}
		
		
		
		
		System.out.println(result);
		
		return SUCCESS;
	}
	
	/*
	 * 计划上报
	 */
	public String reportPlan(){
		result = new HashMap<String, Object>();
		boolean flag = controlPlanService.reportPlan(controlPlansid);
		if (flag) {
			result.put("message", "上报成功");
		} else {
			result.put("message", "上报失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}
	
	/*
	 * 计划审核
	 */
	public String auditPlan(){
		result = new HashMap<String, Object>();
		
		//添加审核信息
		boolean flag = controlPlanService.auditPlan(riRiskPlanAudit);
		if (flag) {
			result.put("message", "审核成功");
		} else {
			result.put("message", "审核失败");
		}
		System.out.println(result);
		
		return SUCCESS;
	}

	@Resource
	private ControlPlanService controlPlanService;
	
	public ControlPlanService getControlPlanService() {
		return controlPlanService;
	}

	public void setControlPlanService(ControlPlanService controlPlanService) {
		this.controlPlanService = controlPlanService;
	}
	
	
	//管控计划
	private RiControlPlan ricontrolPlan;
	public RiControlPlan getRicontrolPlan() {
		return ricontrolPlan;
	}

	public void setRicontrolPlan(RiControlPlan ricontrolPlan) {
		this.ricontrolPlan = ricontrolPlan;
	}
	
	//风险信息
	private RiIdentificationRriskMsg riIdentificationRriskMsg;
	public RiIdentificationRriskMsg getRiIdentificationRriskMsg() {
		return riIdentificationRriskMsg;
	}

	public void setRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) {
		this.riIdentificationRriskMsg = riIdentificationRriskMsg;
	}


	//分页查询条件
	private String monthOrWeek;
	private String currentPage;
	private String currentCount;
	

	public String getMonthOrWeek() {
		return monthOrWeek;
	}

	public void setMonthOrWeek(String monthOrWeek) {
		this.monthOrWeek = monthOrWeek;
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
	
	//分页查询风险信息
	private String riskDescribe;
	private String riskType;
	public String getRiskDescribe() {
		return riskDescribe;
	}

	public void setRiskDescribe(String riskDescribe) {
		this.riskDescribe = riskDescribe;
	}

	
	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	//导入风险信息到管控计划中
	private String rictrlplanid;
	private String riskmsgid;

	public String getRictrlplanid() {
		return rictrlplanid;
	}

	public void setRictrlplanid(String rictrlplanid) {
		this.rictrlplanid = rictrlplanid;
	}

	public String getRiskmsgid() {
		return riskmsgid;
	}

	public void setRiskmsgid(String riskmsgid) {
		this.riskmsgid = riskmsgid;
	}
/*	private String rictrlplanid;
	private String[] shuzu;

	public String getRictrlplanid() {
		return rictrlplanid;
	}

	public void setRictrlplanid(String rictrlplanid) {
		this.rictrlplanid = rictrlplanid;
	}

	public String[] getShuzu() {
		return shuzu;
	}

	public void setShuzu(String[] shuzu) {
		this.shuzu = shuzu;
	}
*/

	//将action中得到的值返回到jsp中
	private Map<String, Object> result;

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	
	//删除该管控计划中的一条风险信息的id
	private String riCtrlPlanId;
	private String riskMsgId;

	public String getRiCtrlPlanId() {
		return riCtrlPlanId;
	}
	public void setRiCtrlPlanId(String riCtrlPlanId) {
		this.riCtrlPlanId = riCtrlPlanId;
	}

	public String getRiskMsgId() {
		return riskMsgId;
	}

	public void setRiskMsgId(String riskMsgId) {
		this.riskMsgId = riskMsgId;
	}
	
	//得到本月的管控计划id以得到上月的风险数据
	private String Myrictrlplanid;

	public String getMyrictrlplanid() {
		return Myrictrlplanid;
	}

	public void setMyrictrlplanid(String myrictrlplanid) {
		Myrictrlplanid = myrictrlplanid;
	}
	
	//对该管控计划进行上报
	private String controlPlansid;

	public String getControlPlansid() {
		return controlPlansid;
	}

	public void setControlPlansid(String controlPlansid) {
		this.controlPlansid = controlPlansid;
	}
	
	//审核
	private RiRiskPlanAudit riRiskPlanAudit;

	public RiRiskPlanAudit getRiRiskPlanAudit() {
		return riRiskPlanAudit;
	}

	public void setRiRiskPlanAudit(RiRiskPlanAudit riRiskPlanAudit) {
		this.riRiskPlanAudit = riRiskPlanAudit;
	}
	
	
}
