package danger.service.impl.riResponsibility;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.riIdentify.RiIdentificationRange;
import danger.bean.riIdentify.RiResponsibility;
import danger.mapper.riIdentify.RiResponsibilityMapper;
import danger.mapper.riIdentify.custom.RiResponsibilityCustomMapper;
import danger.service.riResponsibility.RiResponsibilityService;
import danger.utils.PageBean;

@Service
public class RiResponsibilityServiceImpl implements RiResponsibilityService {

	@Resource
	private RiResponsibilityMapper riResponsibilityMapper;
	
	@Resource
	private RiResponsibilityCustomMapper riResponsibilityCustomMapper;

	@Override
	public boolean addRiResponsibility(RiResponsibility riResponsibility) throws Exception {
		int result = riResponsibilityMapper.insert(riResponsibility);
		return (result == 1 ? true : false);
	}

	@Override
	public boolean deleteRiResponsibility(String respid) throws Exception {
		int result = riResponsibilityMapper.deleteByPrimaryKey(respid);
		return (result == 1 ? true : false);
	}

	// 修改岗位职责
	@Override
	public boolean updateRiResponsibility(RiResponsibility riResponsibility) throws Exception {
		int result = riResponsibilityMapper.updateByPrimaryKeySelective(riResponsibility);
		return (result == 1 ? true : false);
	}

	
	/**
	 * 根据组合条件查询职责分工信息
	 */
	@Override
	public PageBean<RiResponsibility> findRiResponsibilityByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiResponsibility> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = riResponsibilityCustomMapper.getRiRiesponsibilityCountByCondition(condition);
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
		condition.put("index", index);// 当前页页号
		condition.put("currentCount", currentCount);// 每页显示的记录数
		List<RiResponsibility> riResponsibilityRangeList = riResponsibilityCustomMapper.findRiResponsibilityByCondition(condition);
		pageBean.setProductList(riResponsibilityRangeList);

		return pageBean;
	}

	/**
	 * 根据岗位职责id获取岗位职责信息
	 */
	@Override
	public RiResponsibility findRiResponsibilityById(String respid) throws Exception {
		RiResponsibility riResponsibility = riResponsibilityMapper.selectByPrimaryKey(respid);
		return (riResponsibility==null?null:riResponsibility);
	}

}
