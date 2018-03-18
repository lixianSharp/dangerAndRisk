package danger.service.riIdentity;

import java.sql.SQLException;
import java.util.Map;

import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.utils.PageBean;

//辨识风险信息
public interface RiIdentificationRriskMsgService {

	/**
	 * 添加辨识风险信息
	 * @param riIdentificationRriskMsg 辨识风险信息
	 * @return
	 * @throws Exception
	 */
	public boolean addRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) throws Exception;
	
	/**
	 * 修改辨识风险信息
	 * @param riIdentificationRriskMsg
	 * @return
	 * @throws Exception
	 */
	public boolean updateRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) throws Exception;
	
	/**
	 * 根据 辨识风险信息id 辨识风险信息 (级联删除，要先删除对应风险评估表、风险管控计划详细表的信息之后，最后删除辨识风险信息)
	 * @param riskMsgId 辨识风险信息id
	 * @return
	 * @throws Exception
	 */
	public boolean delRiIdentificationRriskMsg(String riskMsgId) throws Exception;
	
	
	
	
	/**
	 * 组合条件查询 风险辨识信息
	 * @param currentPage 当前页页号
	 * @param currentCount 每页显示的记录数
	 * @param condition  组合查询条件
	 * @return
	 * @throws SQLException
	 */
	public PageBean<RiIdentificationRriskMsg> findRiIdentificationRriskMsgByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception;
	
	
	/**
	 * 根据辨识风险信息id删除风险管控计划详细表信息
	 * @param riskMsgId  风险信息id
	 * @return
	 * @throws Exception
	 */
	public boolean delRiCtrlPlanByRiskMsgId(String riskMsgId)throws Exception;
	
	/**根据风险信息id查找辨识风险信息
	 * @param riskMsgId
	 * @return
	 * @throws Exception
	 */
	public RiIdentificationRriskMsg selRiIdentifyRriskMsgByRiskMsgId(String riskMsgId) throws Exception;
}
