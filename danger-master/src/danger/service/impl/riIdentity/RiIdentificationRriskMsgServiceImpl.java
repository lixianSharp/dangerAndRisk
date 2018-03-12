package danger.service.impl.riIdentity;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlanExample;
import danger.bean.riIdentify.RiAssessment;
import danger.bean.riIdentify.RiAssessmentExample;
import danger.bean.riIdentify.RiAssessmentExample.Criteria;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.mapper.riCtrl.RiDetailedOfRiskCtrlPlanMapper;
import danger.mapper.riIdentify.RiAssessmentMapper;
import danger.mapper.riIdentify.RiIdentificationRriskMsgMapper;
import danger.mapper.riIdentify.custom.RiIdentificationRriskMsgCustomMapper;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.PageBean;

//辨识风险信息
@Service
public class RiIdentificationRriskMsgServiceImpl implements RiIdentificationRriskMsgService {

	@Resource
	private RiIdentificationRriskMsgMapper riIdentificationRriskMsgMapper;

	@Resource
	private RiIdentificationRriskMsgCustomMapper riIdentificationRriskMsgCustomMapper;

	// 风险评估信息
	@Resource
	private RiAssessmentMapper riAssessmentMapper;

	// 风险管控计划详细表信息
	private RiDetailedOfRiskCtrlPlanMapper riDetailedOfRiskCtrlPlanMapper;

	/**
	 * 添加辨识风险信息
	 */
	@Override
	public boolean addRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) throws Exception {
		int result = riIdentificationRriskMsgMapper.insert(riIdentificationRriskMsg);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) throws Exception {
		int result = riIdentificationRriskMsgMapper.updateByPrimaryKeySelective(riIdentificationRriskMsg);
		return (result > 0 ? true : false);
	}

	/**
	 * 根据 辨识风险信息id 辨识风险信息 (级联删除，要先删除对应风险评估表、风险管控计划详细表的信息之后，最后删除辨识风险信息) 级联删除
	 */
	@Override
	public boolean delRiIdentificationRriskMsg(String riskMsgId) throws Exception {
		// 1.根据辨识风险信息id删除风险评估信息
		RiAssessmentExample riAssessmentExample = new RiAssessmentExample();
		Criteria criteria = riAssessmentExample.createCriteria();
		// 1.1封装条件
		criteria.andRiskmsgidEqualTo(riskMsgId);
		List<RiAssessment> riAssessmentList = riAssessmentMapper.selectByExample(riAssessmentExample);
		if (riAssessmentList.size() > 0) {
			RiAssessment riAssessment = riAssessmentList.get(0);
			// 获取风险评估信息id
			String assessmentid = riAssessment.getAssessmentid();
			// 根据风险评估信息id删除风险评估信息
			int result = riAssessmentMapper.deleteByPrimaryKey(assessmentid);
		}

		// 2.根据辨识风险信息id删除风险管控计划详细表信息
		Integer result2 = riIdentificationRriskMsgCustomMapper.delRiCtrlPlanByRiskMsgId(riskMsgId);
		
		
		// 3.根据辨识风险信息id删除辨识风险信息
		int result3 = riIdentificationRriskMsgMapper.deleteByPrimaryKey(riskMsgId);

		return (result3 > 0 ? true : false);
	}

	@Override
	public PageBean<RiIdentificationRriskMsg> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiIdentificationRriskMsg> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = riIdentificationRriskMsgCustomMapper.getRiIdentificationRriskMsgCountByCondition(condition);
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
		List<RiIdentificationRriskMsg> riIdentificationRriskMsgList = riIdentificationRriskMsgCustomMapper
				.findRiIdentificationRriskMsgByCondition(condition);
		pageBean.setProductList(riIdentificationRriskMsgList);

		return pageBean;
	}

	/**
	 * 根据辨识风险信息id删除风险管控计划详细表信息
	 */
	@Override
	public boolean delRiCtrlPlanByRiskMsgId(String riskMsgId) throws Exception {
		int result = riIdentificationRriskMsgCustomMapper.delRiCtrlPlanByRiskMsgId(riskMsgId);
		return (result>0?true:false);
	}

}