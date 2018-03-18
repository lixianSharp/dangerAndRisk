package danger.service.impl.riIdentity;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.riIdentify.RiAssessment;
import danger.bean.riIdentify.RiResponsibility;
import danger.mapper.riIdentify.RiAssessmentMapper;
import danger.mapper.riIdentify.custom.RiAssessmentCustomMapper;
import danger.service.riIdentity.RiAssessmentService;
import danger.utils.PageBean;
@Service
public class RiAssessmentServiceImpl implements RiAssessmentService{
	
	@Resource
	private RiAssessmentMapper riAssessmentMapper;
	
	@Resource 
	private RiAssessmentCustomMapper riAssessmentCustomMapper;
	
	/**
	 * 添加风险评估信息
	 */
	@Override
	public boolean addRiAssessment(RiAssessment riAssessment) throws Exception {
		int result = riAssessmentMapper.insert(riAssessment);
		return (result>0?true:false);
	}

	/**
	 * 修改风险评估信息
	 */
	@Override
	public boolean updateRiAssessment(RiAssessment riAssessment) throws Exception {
		int result = riAssessmentMapper.updateByPrimaryKeySelective(riAssessment);
		return (result>0?true:false);
	}

	/**
	 * 删除风险评估信息
	 */
	@Override
	public boolean deleteRiAssessment(String assessmentid) throws Exception {
		int result = riAssessmentMapper.deleteByPrimaryKey(assessmentid);
		return (result>0?true:false);
	}

	
	/**
	 * 组合条件查询 风险辨识主表信息
	 */
	@Override
	public PageBean<RiAssessment> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiAssessment> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = riAssessmentCustomMapper.getRiAssessmentCountByCondition(condition);
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
		List<RiAssessment> riAssessmentList = riAssessmentCustomMapper.findRiAssessmentByCondition(condition);
		pageBean.setProductList(riAssessmentList);

		return pageBean;
	}

	/**
	 * 组合条件查询 风险辨识主表的名称name+辨识风险信息表+风险评估表信息
	 */
	@Override
	public List<Map<String, Object>> findIdentifyMsgAndAssessmentByCondition(Map<String, Object> condition)	throws Exception {
		List<Map<String, Object>> resultMapList= riAssessmentCustomMapper.findIdentifyMsgAndAssessmentByCondition(condition);
		return resultMapList;
	}

	/**
	 * 组合条件查询 风险辨识主表的名称name+辨识风险信息表+风险评估表信息 的总记录数
	 */
	@Override
	public Integer findIdentifyMsgAndAssessmentCountByCondition(Map<String, Object> condition) throws Exception {
		Integer count = riAssessmentCustomMapper.findIdentifyMsgAndAssessmentCountByCondition(condition);
		return count;
	}

	
	/**
	 * 组合条件查询 风险辨识主表的名称name+辨识风险信息表+风险评估表信息
	 * @param currentPage
	 * @param currentCount
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<Map<String, Object>> findRiskMsgAndAssessmentByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<Map<String, Object>> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount =  riAssessmentCustomMapper.findIdentifyMsgAndAssessmentCountByCondition(condition);//总条数
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
		//结果集==》风险辨识主表的名称name+辨识风险信息表+风险评估表信息
		List<Map<String, Object>> resultMapList = riAssessmentCustomMapper.findIdentifyMsgAndAssessmentByCondition(condition);
		pageBean.setProductList(resultMapList);

		return pageBean;
	}
}
