package danger.service.queryView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.dangerManage.Danger;
import danger.bean.queryView.DangerSiding;
import danger.bean.queryView.DangerSidingFollow;
import danger.bean.queryView.DangerSidingFollowRecheck;
import danger.bean.queryView.DangerSpot;
import danger.utils.PageBean;

public interface QueryViewService {

	/**
	 * 分页组合条件查询隐患
	 * 
	 * @param currentPage
	 *            当前页
	 * @param currentCount
	 *            每页大小
	 * @param condition
	 *            查询条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<Danger> findDangerByCondition(int currentPage, int currentCount, Map<String, Object> condition)
			throws SQLException;

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
	 * 组合条件查询隐患五定
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public PageBean<DangerSiding> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws SQLException;

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
	public PageBean<DangerSidingFollow> findDangerSidingFollowByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws SQLException;

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
	 * 组合条件查询隐患五定跟踪复查
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public PageBean<DangerSidingFollowRecheck> findDangerSidingFollowRecheckByCondition(int currentPage,
			int currentCount, Map<String, Object> condition) throws SQLException;

	/**
	 * 根据五定Id查询隐患五定跟踪复查视图
	 * 
	 * @param sidingId
	 * @return
	 * @throws SQLException
	 */
	public DangerSidingFollowRecheck getDangerSidingFollowRecheckBySidingId(int sidingId) throws SQLException;

}
