package danger.service.impl.queryView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import danger.bean.dangerManage.Danger;
import danger.bean.queryView.DangerSiding;
import danger.bean.queryView.DangerSidingFollow;
import danger.bean.queryView.DangerSidingFollowRecheck;
import danger.bean.queryView.DangerSpot;
import danger.mapper.dangerManage.custom.DangerCustomMapper;
import danger.mapper.queryView.QueryViewCustomMapper;
import danger.service.queryView.QueryViewService;
import danger.utils.PageBean;

@Service
public class QueryViewServiceImpl implements QueryViewService {

	@Autowired
	private DangerCustomMapper dangerCustomMapper;
	@Autowired
	private QueryViewCustomMapper queryViewCustomMapper;

	/**
	 * @param currentPage 当前页页号  
	 * @param currentCount 每页显示的记录数 
	 * @param condition 查询条件
	 */
	@Override
	public PageBean<Danger> findDangerByCondition(int currentPage, int currentCount, Map<String, Object> condition)
			throws SQLException {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<Danger> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = dangerCustomMapper.getDangerCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);//当前页页号
		condition.put("currentCount", currentCount);//每页显示的记录数
		List<Danger> dangerList = dangerCustomMapper.findDangerByCondition(condition);
		pageBean.setProductList(dangerList);

		return pageBean;
	}

	@Override
	public DangerSpot getDangerSpotByDangerId(Integer dangerId) throws SQLException {
		return queryViewCustomMapper.getDangerSpotByDangerId(dangerId);
	}

	@Override
	public PageBean<DangerSiding> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws SQLException {

		PageBean<DangerSiding> pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;
		totalCount = queryViewCustomMapper.getDangerSidingCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		pageBean.setProductList(queryViewCustomMapper.findDangerSidingByCondition(condition));
		return pageBean;
	}

	@Override
	public DangerSiding getDangerSidingBySidingId(int sidingId) throws SQLException {
		// TODO Auto-generated method stub
		return queryViewCustomMapper.getDangerSidingBySidingId(sidingId);
	}

	@Override
	public PageBean<DangerSidingFollow> findDangerSidingFollowByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws SQLException {

		PageBean<DangerSidingFollow> pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;
		totalCount = queryViewCustomMapper.getDangerSidingFollowCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		pageBean.setProductList(queryViewCustomMapper.findDangerSidingFollowByCondition(condition));
		return pageBean;
	}

	@Override
	public DangerSidingFollow getDangerSidingFollowBySidingId(int sidingId) throws SQLException {
		return queryViewCustomMapper.getDangerSidingFollowBySidingId(sidingId);
	}

	@Override
	public PageBean<DangerSidingFollowRecheck> findDangerSidingFollowRecheckByCondition(int currentPage,
			int currentCount, Map<String, Object> condition) throws SQLException {

		PageBean<DangerSidingFollowRecheck> pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;
		totalCount = queryViewCustomMapper.getDangerSidingFollowRecheckCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		pageBean.setProductList(queryViewCustomMapper.findDangerSidingFollowRecheckByCondition(condition));
		return pageBean;
	}

	@Override
	public DangerSidingFollowRecheck getDangerSidingFollowRecheckBySidingId(int sidingId) throws SQLException {
		// TODO Auto-generated method stub
		return queryViewCustomMapper.getDangerSidingFollowRecheckBySidingId(sidingId);
	}

	
}
