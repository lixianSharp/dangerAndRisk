package danger.mapper.riIdentify.custom;

import java.util.List;
import java.util.Map;

import danger.bean.riIdentify.RiIdentificationRange;

//风险辨识范围
public interface RiIdentificationRangeCustomMapper {
	/**
	 *  查询风险辨识范围信息 按照开始时间降序排序  分页查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RiIdentificationRange> findRiIdentificationRangeByCondition(Map<String,Object> map)throws Exception;
	
	
	/**
	 * 根据条件查询满足条件的总数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getRiIdentificationRangeCountByCondition(Map<String,Object> map)throws Exception;
	
	/**
	 * 查询所有风险辨识范围信息
	 * @return
	 * @throws Exception
	 */
	public List<RiIdentificationRange> findAllRiIdentificationRange()throws Exception;
}
