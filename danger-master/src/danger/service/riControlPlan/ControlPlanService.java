package danger.service.riControlPlan;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiRiskPlanAudit;
import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.utils.PageBean;

public interface ControlPlanService {

	//得到所有的管控计划信息
	PageBean<RiControlPlan> getAllControlPlan(Map<String, Object> condition);

	//添加管控计划记录
	String addControlPlan(RiControlPlan ricontrolPlan);

	//修改管控计划
	boolean updateControlPlan(RiControlPlan ricontrolPlan);

	//通过风险管控计划id得到风险管控计划
	RiControlPlan getRiControlPlanById(String riCtrlPlanId);

	//得到该管控计划所拥有的风险数量
	int getRiskCount(String rictrlplanid);

	//得到其中一条管控计划的所有审核备注信息
	LinkedList<RiRiskPlanAudit> getShenHe(String rictrlplanid);

	/*
	 * 得到灾害类型的风险数量
	 */
	List<Map<String, Object>> getRiskCountByDisasterTypes();

	/*
	 * 得到失效的风险的地点
	 */
	List<Map<String, Object>> getAddressList();

	/*
	 * 得到该管控计划下的所有风险信息的风险地点
	 */
	List<String> getRiskAddress(String rictrlplanid);

	/*
	 * 得到风险信息（分页）
	 */
	PageBean<RiIdentificationRriskMsg> getAllRiskInfo(Map<String, Object> condition);

	/*
	 * 导入风险信息到管控计划中
	 */
	boolean importRiskInfo(String rictrlplanid, String riskmsgid);

	/*
	 * 删除该管控计划中的一条风险信息
	 */
	boolean deleteRiskInfo(String rictrlplanid, String riskmsgid);

	/*
	 * 得到上月的管控计划的id
	 */
	String getPrecedingMonthId(String myrictrlplanid, String myspecialty);
	String getPrecedingMonthId(Map<String, Object> condition);

	/*
	 * 得到上月的风险信息的id
	 */
	List<String> getPrecedingMonthRiskInfoIdList(String precedingMonthId);
	
	

	/*
	 * 计划上报
	 */
	boolean reportPlan(String controlPlansid);

	/*
	 * 计划审核
	 */
	boolean auditPlan(RiRiskPlanAudit riRiskPlanAudit);

	/*
	 * 添加旬管控计划
	 */
	String addWeekControlPlan(RiControlPlan ricontrolPlan);

	/*
	 * 得到周管控计划的所有记录
	 */
	PageBean<RiControlPlan> getAllWeekControlPlan(Map<String, Object> condition);

	boolean updateWeekControlPlan(RiControlPlan ricontrolPlan);
	
	//得到风险来源
	RiIdentificationMainTable getRiIdentificationMainTableName(String str);

	//通过时间查找年度辨识id
	String getYearIdByTime(String year);


	

	


}
