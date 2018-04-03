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
		
		
		
		//封装所有的工作面到一个List中
		List<String> addressList2 = new LinkedList<String>();
	
		for(Map<String,Object> map:addressList){
			//得到每一个风险数据的所有工作面
			//Set<String> addressSet = map.keySet();
			String str1 = (String)map.get("riskAddress");
			Long count =(Long) map.get("count");
			
			String[] str2 =str1.trim().split(",");
			for(int i=0;i<str2.length*count;i++){
				addressList2.add(str2[i]);
			}
			
		}
		System.out.println(addressList2);
		
		//将这些工作面一次放入map中
		List<Map<String,Object>> addressList3 = new LinkedList<Map<String,Object>>();
		
		for(int i=0;i<addressList2.size();i++){
			int count=1;
			Map<String,Object> map = new HashMap<String,Object>();
			for(int j=i+1;j<addressList2.size();j++){
				if(addressList2.get(i).equals(addressList2.get(j))){
					count++;
					addressList2.remove(j);
					j--;
				}
				
			}
			map.put("riskAddress", addressList2.get(i));
			map.put("count",count);
			addressList3.add(map);
			
			
		}
		
		
		
		
		result.put("addressList", addressList3);
		
	
		
		return SUCCESS;
	}
	
	
}
