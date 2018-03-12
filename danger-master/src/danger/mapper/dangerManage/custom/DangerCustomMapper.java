package danger.mapper.dangerManage.custom;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.dangerManage.Danger;

public interface DangerCustomMapper {

	/**
	 * 组合条件查询隐患
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Danger> findDangerByCondition(Map<String, Object> map) throws SQLException;

	/**
	 * 根据条件查询满足条件的总数
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer getDangerCountByCondition(Map<String, Object> map) throws SQLException;

	/**
	 * 统计信息的时候根据开始时间和结束时间，单位和级别，类型查询满足条件的总数
	 * 
	 * @param map
	 *            开始时间，结束时间，单位，级别，类型查询
	 * @return
	 * @throws SQLException
	 */
	public Integer getDangerCountByCondition2(Map<String, Object> map) throws SQLException;

	/**
	 * 统计信息的时候根据开始时间和结束时间，单位和级别，类型查询满足条件的记录
	 * 
	 * @param map
	 *            开始时间，结束时间，单位，级别，类型查询
	 * @return
	 * @throws Exception
	 */
	public List<Danger> findDangerByCondition2(Map<String, Object> map) throws SQLException;

	/***************************
	 * xianyuan start
	 **********************************/
	/**
	 * 查询所有班次
	 * 
	 * @return
	 */
	public List<Danger> findAllDangerclassType();

	/**
	 * 查询所有检查单位
	 * 
	 * @return
	 */
	public List<Danger> findAllDangercheckUnit();

	/**
	 * 查询所有隐患类型
	 * 
	 * @return
	 */
	public List<Danger> findAllDangertype();

	/**
	 * 查询所有责任单位
	 * 
	 * @return
	 */
	public List<Danger> findAllDangerunit();
	
	/**
	 * 根据机构名称获取机构的负责人  也就是根据责任单位名称获取责任单位的负责人 
	 */
	String getManagerByDepartmentName(String departmentname);

	/***************************
	 * xianyuan end
	 **********************************/
}
