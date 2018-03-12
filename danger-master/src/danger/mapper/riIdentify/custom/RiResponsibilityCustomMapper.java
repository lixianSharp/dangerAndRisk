package danger.mapper.riIdentify.custom;

import java.util.List;
import java.util.Map;

import danger.bean.riIdentify.RiResponsibility;
//岗位职责分工
public interface RiResponsibilityCustomMapper {
	
	/**
	 *  查询职责分工 按照岗位降序排序  分页查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RiResponsibility> findRiResponsibilityByCondition(Map<String,Object> map)throws Exception;
	
	
	/**
	 * 根据条件查询满足条件的总数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getRiRiesponsibilityCountByCondition(Map<String,Object> map)throws Exception;
}
