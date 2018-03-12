package danger.service.queryView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.dangerManage.Danger;

/**
 * 统计点击每个数字的时候
 * 
 * @author QizoLiQiang
 * @time 2017年9月7日下午12:11:52
 */
public interface TongjiDangerService {

	/**
	 * 根据条件查询总数
	 * 
	 * @param condition
	 *            条件
	 * @return 总数
	 * @throws SQLException
	 */
	public int getCountByCondition(Map<String, Object> condition) throws SQLException;

	/**
	 * 获取满足条件的集合
	 * 
	 * @param currentPage
	 *            当前页
	 * @param currentCount
	 *            每页多少数据
	 * @param condition
	 *            条件
	 * @return
	 * @throws SQLException
	 */
	public List<Danger> findDangersByCondition(int currentPage, int currentCount, Map<String, Object> condition)
			throws SQLException;

	/**
	 * 统计一个隐患信息，一个map包含当前的页号，总数与数据集合
	 * 
	 * @param condition
	 *            查询条件:页号，页大小
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> findDangerCountPageByCondition(int currentPage, int currentCount,Map<String, Object> condition) throws SQLException;
}
