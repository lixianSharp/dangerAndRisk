package danger.mapper.riIdentify.custom;

import java.util.List;
import java.util.Map;

import danger.bean.riIdentify.RiIdentificationMainTable;

//风险辨识主表
public interface RiIdentificationMainTableCustomMapper {
	
	/**
	 * 组合条件查询风险辨识主表信息
	 * @param map 组合条件
	 * @return 符合条件的风险辨识主表信息
	 * @throws Exception
	 */
	public List<RiIdentificationMainTable> findRiIdentificationMainTableByCondition(Map<String,Object> map)throws Exception;
	
	
	/**
	 * 组合条件查询风险辨识主表信息的总条数
	 * @param map 组合条件
	 * @return 符合条件的 风险辨识主表信息的总记录数
	 * @throws Exception
	 */
	public int getRiIdentificationMainTableCountByCondition(Map<String,Object> map) throws Exception;
	
	
	
	
	/**
	 * 根据组合条件查询风险辨识主表信息及其对应的辨识风险信息
	 * 			如果没有输入 identiryid，则说明是只需要显示所有风险辨识主表信息及其对应的(辨识风险信息及数量)
	 * 			输入identiryid，则说明是查询当前风险辨识主表信息及其对应的所有辨识风险信息
	 * @param condition 组合查询条件     index ， currentCount  identiryid
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> findIdentifyMainAndRiskMsgByCondition(Map<String,Object> condition)throws Exception;
	
	
	/**
	 * 根据组合条件查询风险辨识主表信息及其对应的辨识风险信息 的总记录数
	 * @param condition  组合查询条件     index ， currentCount  identiryid
	 * @return 
	 * @throws Exception
	 */
	public Integer getIdentifyMainAndRiskMsgCountByCondition(Map<String,Object> condition) throws Exception;
	
	
}
