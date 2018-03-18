package danger.mapper.riIdentify.custom;

import java.util.List;
import java.util.Map;

import danger.bean.riIdentify.RiAssessment;

public interface RiAssessmentCustomMapper {
	
	/**
	 * 组合条件查询风险评估信息 根据评估时间降序排序 分页查询
	 * @param map  组合查询条件
	 * @return  风险评估信息
	 * @throws Exception
	 */
	public List<RiAssessment> findRiAssessmentByCondition(Map<String,Object> map)throws Exception;
	

	/**
	 * 组合条件查询风险评估信息的总条数 
	 * @param map  组合查询条件
	 * @return 符合条件的风险评估信息的总条数
	 * @throws Exception
	 */
	public int getRiAssessmentCountByCondition(Map<String,Object> map)throws Exception;
	
	
	/**
	 * 组合条件查询 风险辨识主表的名称name+辨识风险信息表+风险评估表信息
	 * @param condition 组合条件
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> findIdentifyMsgAndAssessmentByCondition(Map<String,Object> condition)throws Exception;
	
	
	/**
	 * 组合条件查询 风险辨识主表的名称name+辨识风险信息表+风险评估表信息 的总记录数 
	 * @param condition 组合条件
	 * @return 符合组合条件的 总记录数
	 * @throws Exception
	 */
	public Integer findIdentifyMsgAndAssessmentCountByCondition(Map<String,Object>condition)throws Exception;
	
	
}
