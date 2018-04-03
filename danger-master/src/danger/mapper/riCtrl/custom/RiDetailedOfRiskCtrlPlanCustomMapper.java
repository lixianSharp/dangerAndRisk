package danger.mapper.riCtrl.custom;

import java.util.List;
import java.util.Map;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riIdentify.RiIdentificationRriskMsg;

public interface RiDetailedOfRiskCtrlPlanCustomMapper {

	//得到该管控计划下的风险信息数量
	int getAllRiskMsgCountByControlPlanId(Map<String, Object> condition);

	//得到该管控计划下的所有风险信息
	List<RiIdentificationRriskMsg> getAllRiskMsgByControlPlanId(Map<String, Object> condition);

	//通过风险id得到分析信息
	RiDetailedOfRiskCtrlPlan getAnalysisPlanByRiskId(String riskMsgId);

	List<Map<String, Object>> getAllRiskMsgAndAnalysisPlanByControlPlanId(Map<String, Object> condition);

	//添加风险分析信息
	int addControlPlanAnalysis(RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan);

	//得到月风险管控计划有效性数量
	int getAllVaildPlanCount(Map<String, Object> condition);

	//得到月风险管控计划有效性信息
	List<Map<String, Object>> getAllVaildPlanInfo(Map<String, Object> condition);

	//得到月管控计划的措施无效的数量
	int getValidCount(String rictrlplanid);
	//得到月管控计划的措施无效的信息
	List<RiIdentificationRriskMsg> getRiskMsgList(String riCtrlPlanId);

	//得到该管控记录的所有责任部门及其个数
	List<Map<String, Object>> getDutyDepartmentList(String riCtrlPlanId);

	
	
	
	
	
	
	
	
	
	
	
	
	//得到该管控记录的所有失效风险地点及其个数
	List<Map<String, Object>> getAddressList(String riCtrlPlanId);

	//得到专业类型下拉列表
	List<String> getProfessionalTypesList();

	/*
	 * 通过传入的管控计划id得到该管控计划的风险信息
	 */
	List<RiIdentificationRriskMsg> findRiskInfoByRictrlplanId(String rictrlplanid);

	
	
	
	

}
