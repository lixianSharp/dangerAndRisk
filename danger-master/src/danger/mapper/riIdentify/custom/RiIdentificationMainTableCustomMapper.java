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
}
