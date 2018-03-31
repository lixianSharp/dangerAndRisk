package danger.mapper.riCtrl.custom;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riCtrl.RiRiskPlanAudit;
import danger.bean.riIdentify.RiIdentificationRriskMsg;

public interface RiControlPlanCustomMapper {

	//得到该条件下的所有管控计划的个数
	int getControlPlanCountById(Map<String, Object> condition);

	//得到该条件下的所有的管控计划
	List<RiControlPlan> getControlPlanByCondition(Map<String, Object> condition);

	//得到该管控计划的风险数量
	int getRiskCount(String rictrlplanid);

	//得到其中一条管控计划的所有审核备注信息
	LinkedList<RiRiskPlanAudit> getShenHe(String rictrlplanid);

	/*
	 * 得到灾害类型的风险数量
	 */
	List<Map<String, Object>> getRiskCountByDisasterTypes(String year);

	/*
	 * 得到失效的风险的地点
	 */
	List<Map<String, Object>> getAddressList(String year);

	/*
	 * 得到该管控计划下的所有风险信息的风险地点
	 */
	List<String> getRiskAddress(String rictrlplanid);

	/*
	 * 得到该条件下的风险信息数量
	 */
	int getAllRiskInfoCount(Map<String, Object> condition);

	/*
	 * 得到该条件下的风险信息
	 */
	List<RiIdentificationRriskMsg> getAllRiskInfo(Map<String, Object> condition);

	/*
	 * 导入风险信息到管控计划中
	 */
	//int importRiskInfo(String rictrlplanid, String riskmsgid);

	int importRiskInfo(RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan);

	/*
	 * 删除该管控计划中的一条风险信息
	 */
	int deleteRiskInfo(RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan);

	int deleteRiskInfo(String riCtrlPlanId, String riskMsgId);

	/*
	 * 得到上月的管控计划的id
	 */
	String getPrecedingMonthId(String myrictrlplanid, String myspecialty);
	
	String getPrecedingMonthIdByCondition(Map<String, Object> condition);

	/*
	 * 得到上月的风险信息的id
	 */
	List<String> getPrecedingMonthRiskInfoIdList(String precedingMonthId);

	/*
	 * 计划上报,审核未通过
	 */
	int reportPlan(String controlPlansid);
	/*
	 * 还未进行审核
	 */
	int reportPlan2(String controlPlansid);

	/*
	 * 计划审核
	 */
	int auditPlan(RiRiskPlanAudit riRiskPlanAudit);

	//通过管控计划id得到管控计划详情
	List<RiDetailedOfRiskCtrlPlan> getMyRiskmsgid(String rictrlplanid);

	//得到周管控计划的数量
	int getWeekControlPlanCountById(Map<String, Object> condition);

	//得到周管控计划的记录
	List<RiControlPlan> getWeekControlPlanByCondition(Map<String, Object> condition);

	//得到所有的月管控计划
	List<RiControlPlan> getAllControlPlan(String string);

	List<Map<String, Object>> getAddressList2(String year);

	List<RiControlPlan> getAllControlPlan2(String string);

	//通过时间查找年度辨识id
	String getYearIdByTime(String year);

	

	

	
	

}
