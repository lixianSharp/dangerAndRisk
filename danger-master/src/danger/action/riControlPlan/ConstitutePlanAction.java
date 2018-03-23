package danger.action.riControlPlan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.service.riControlPlan.ControlPlanService;
import danger.service.riIdentity.RiIdentificationRriskMsgService;

@Controller
@Scope("prototype")
public class ConstitutePlanAction extends ActionSupport {

	@Resource
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService;
	public RiIdentificationRriskMsgService getRiIdentificationRriskMsgService() {
		return riIdentificationRriskMsgService;
	}

	public void setRiIdentificationRriskMsgService(RiIdentificationRriskMsgService riIdentificationRriskMsgService) {
		this.riIdentificationRriskMsgService = riIdentificationRriskMsgService;
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
	
	/*
	 * 得到灾害类型的风险数量和失效地点
	 */
	public String getRiskCountByDisasterTypes(){
		result = new HashMap<String,Object>();
		//得到灾害类型的风险数量
		List<Map<String,Object>> RiskCountList = controlPlanService.getRiskCountByDisasterTypes();
		//得到失效地点
		List<Map<String,Object>> addressList = controlPlanService.getAddressList();
		
		result.put("RiskCountList",RiskCountList);
		
		result.put("addressList", addressList);
		
		List<String> address = new LinkedList<String>();
		List<Long> counts = new LinkedList<Long>();
		for(Map<String,Object> map : addressList){
			Set<String> set = map.keySet();
			
			address.add( (String) map.get("riskAddress"));
			counts.add((Long)map.get("count"));
		
		}
		result.put("address",address);
		result.put("counts", counts);
		
		return SUCCESS;
	}
	
	
}
