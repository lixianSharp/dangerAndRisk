package danger.service.impl.queryView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import danger.bean.dangerManage.Danger;
import danger.mapper.dangerManage.custom.DangerCustomMapper;
import danger.service.queryView.TongjiDangerService;

@Service
public class TongjiDangerServiceImpl implements TongjiDangerService {

	@Autowired
	private DangerCustomMapper dangerCustomMapper;

	@Override
	public int getCountByCondition(Map<String, Object> condition) throws SQLException {
		// TODO Auto-generated method stub
		return dangerCustomMapper.getDangerCountByCondition(condition);
	}

	@Override
	public List<Danger> findDangersByCondition(int currentPage,int currentCount,Map<String, Object> condition) throws SQLException {
		//获取到总数
		int totalCount = 0;
		totalCount = this.getCountByCondition(condition);
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		return dangerCustomMapper.findDangerByCondition(condition);
	}

	/**
	 * 返回页号，总数，数据集合
	 */
	@Override
	public Map<String, Object> findDangerCountPageByCondition(int currentPage,int currentCount,Map<String, Object> condition) throws SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("totalCount", this.getCountByCondition(condition));
		result.put("productList", this.findDangersByCondition(currentPage,currentCount,condition));
		result.put("currentPage", currentPage);
		return result;
	}

}
