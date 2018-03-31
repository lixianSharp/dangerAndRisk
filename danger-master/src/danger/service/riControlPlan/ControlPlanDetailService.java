package danger.service.riControlPlan;

import java.util.List;
import java.util.Map;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.utils.PageBean;

public interface ControlPlanDetailService {

	//按分页条件得到该管控计划下的所有风险信息
	PageBean<RiIdentificationRriskMsg> getAllRiskMsgByControlPlanId(Map<String, Object> condition);

	//添加管控计划分析
	boolean addControlPlanAnalysis(RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan);

	//通过风险id得到分析信息
	RiDetailedOfRiskCtrlPlan getAnalysisPlanByRiskId(String riskMsgId);

	//通过id得到风险分析信息
	PageBean<Map<String, Object>> getAllRiskMsgAndAnalysisPlanByControlPlanId(Map<String, Object> condition);

	//得到月风险管控计划有效性
	PageBean<RiControlPlan> getAllVaildPlanInfo(Map<String, Object> condition);

	//得到月管控计划的措施无效的数量
	int getValidCount(String rictrlplanid);
	
	//得到月管控计划的措施无效的风险信息
	List<RiIdentificationRriskMsg> getRiskMsgList(String riCtrlPlanId);

	//得到该管控记录的所有责任部门及其个数
	List<Map<String, Object>> getDutyDepartmentList(String riCtrlPlanId);

	//得到该管控记录的所有失效风险地点及其个数
	List<Map<String, Object>> getAddressList(String riCtrlPlanId);

	//得到专业类型下拉列表
	List<String> getProfessionalTypesList();

	


	
	

}
