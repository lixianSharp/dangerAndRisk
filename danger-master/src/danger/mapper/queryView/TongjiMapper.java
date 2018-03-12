package danger.mapper.queryView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.queryView.Tongji;

public interface TongjiMapper {

	/**
	 * 获取统计信息
	 * 
	 * @param condition
	 *            开始日期到结束日期
	 * @return
	 * @throws SQLException
	 */
	public List<Tongji> getTongjiInfo(Map<String, Object> condition) throws SQLException;

	/**
	 * 获取最后的合计信息
	 * 
	 * @param condition
	 *            开始日期到结束日期
	 * @return
	 * @throws SQLException
	 */
	public Tongji getTotalInfo(Map<String, Object> condition) throws SQLException;
	
	
	
	
	
	

}
