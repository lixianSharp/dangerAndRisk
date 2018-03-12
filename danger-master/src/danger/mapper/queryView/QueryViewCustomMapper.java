package danger.mapper.queryView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.queryView.DangerSiding;
import danger.bean.queryView.DangerSidingFollow;
import danger.bean.queryView.DangerSidingFollowRecheck;
import danger.bean.queryView.DangerSpot;

/**
 * 分页查询视图
 * 
 * @author QizoLiQiang
 * @time 2017年9月4日下午1:53:09
 */
public interface QueryViewCustomMapper {
	/************************* 隐患现场处理 *****************************************/

	/**
	 * 根据隐患id查询隐患现场处理
	 * 
	 * @param dangerId
	 *            隐患id
	 * @return
	 * @throws SQLException
	 */
	public DangerSpot getDangerSpotByDangerId(Integer dangerId) throws SQLException;

	/********************************** 查询隐患五定 *******************************************/
	/**
	 * 根据条件查询满足条件的总数
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer getDangerSidingCountByCondition(Map<String, Object> map) throws SQLException;

	/**
	 * 组合条件查询隐患现场处理
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DangerSiding> findDangerSidingByCondition(Map<String, Object> map) throws SQLException;

	/**
	 * 根据五定Id查询单个隐患五定信息
	 * 
	 * @param sidingId
	 * @return
	 * @throws SQLException
	 */
	public DangerSiding getDangerSidingBySidingId(int sidingId) throws SQLException;

	/********************************** 查询隐患五定跟踪 *******************************************/
	/**
	 * 组合条件查询隐患五定跟踪
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DangerSidingFollow> findDangerSidingFollowByCondition(Map<String, Object> map) throws SQLException;

	/**
	 * 根据条件查询满足条件的总数
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer getDangerSidingFollowCountByCondition(Map<String, Object> map) throws SQLException;

	/**
	 * 根据五定Id查询单个隐患四跟踪息
	 * 
	 * @param sidingId
	 * @return
	 * @throws SQLException
	 */
	public DangerSidingFollow getDangerSidingFollowBySidingId(int sidingId) throws SQLException;

	/********************************** 查询隐患五定跟踪复查 *******************************************/

	/**
	 * 根据条件查询满足条件的总数
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer getDangerSidingFollowRecheckCountByCondition(Map<String, Object> map) throws SQLException;

	/**
	 * 组合条件查询隐患五定跟踪复查
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DangerSidingFollowRecheck> findDangerSidingFollowRecheckByCondition(Map<String, Object> map)
			throws SQLException;

	/**
	 * 根据五定Id查询隐患五定跟踪复查视图
	 * 
	 * @param sidingId
	 * @return
	 * @throws SQLException
	 */
	public DangerSidingFollowRecheck getDangerSidingFollowRecheckBySidingId(int sidingId) throws SQLException;
}
