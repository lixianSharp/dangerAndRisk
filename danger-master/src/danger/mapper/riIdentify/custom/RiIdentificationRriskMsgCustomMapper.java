package danger.mapper.riIdentify.custom;

import java.util.List;
import java.util.Map;

import danger.bean.riIdentify.RiIdentificationRriskMsg;
//辨识风险信息
public interface RiIdentificationRriskMsgCustomMapper {

	
	/**
	 * 组合条件查询辨识风险信息 分页查询
	 * @param map 组合条件
	 * @return 辨识风险信息
	 * @throws Exception
	 */
	public List<RiIdentificationRriskMsg> findRiIdentificationRriskMsgByCondition(Map<String,Object> map)throws Exception;
	
	/**
	 * 组合条件查询辨识风险信息的总记录数
	 * @param map 组合条件
	 * @return 符合条件的便是风险信息的总记录数
	 * @throws Exception
	 */
	public int getRiIdentificationRriskMsgCountByCondition(Map<String,Object> map)throws Exception;
	
	/**
	 * 根据辨识风险信息id删除风险管控计划详细表信息
	 * @param riskMsgId  风险信息id
	 * @return
	 * @throws Exception
	 */
	public Integer delRiCtrlPlanByRiskMsgId(String riskMsgId)throws Exception;
	
	
	
}
