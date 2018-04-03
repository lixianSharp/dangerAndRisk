package danger.service.impl.riControlPlan;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.mapper.riCtrl.RiDetailedOfRiskCtrlPlanMapper;
import danger.mapper.riCtrl.custom.RiControlPlanCustomMapper;
import danger.mapper.riCtrl.custom.RiDetailedOfRiskCtrlPlanCustomMapper;
import danger.service.riControlPlan.ControlPlanDetailService;
import danger.utils.PageBean;

@Service
public class ControlPlanDetailServiceImpl implements ControlPlanDetailService {
	
	@Resource
	private RiDetailedOfRiskCtrlPlanMapper riDetailedOfRiskCtrlPlanMapper;

	public RiDetailedOfRiskCtrlPlanMapper getRiDetailedOfRiskCtrlPlanMapper() {
		return riDetailedOfRiskCtrlPlanMapper;
	}

	public void setRiDetailedOfRiskCtrlPlanMapper(RiDetailedOfRiskCtrlPlanMapper riDetailedOfRiskCtrlPlanMapper) {
		this.riDetailedOfRiskCtrlPlanMapper = riDetailedOfRiskCtrlPlanMapper;
	}
	
	@Resource
	private RiDetailedOfRiskCtrlPlanCustomMapper RiDetailedOfRiskCtrlPlanCustomMapper;

	public RiDetailedOfRiskCtrlPlanCustomMapper getRiDetailedOfRiskCtrlPlanCustomMapper() {
		return RiDetailedOfRiskCtrlPlanCustomMapper;
	}

	public void setRiDetailedOfRiskCtrlPlanCustomMapper(
			RiDetailedOfRiskCtrlPlanCustomMapper riDetailedOfRiskCtrlPlanCustomMapper) {
		RiDetailedOfRiskCtrlPlanCustomMapper = riDetailedOfRiskCtrlPlanCustomMapper;
	}
	
	@Resource
	private RiControlPlanCustomMapper riControlPlanCustomMapper;
	public RiControlPlanCustomMapper getRiControlPlanCustomMapper() {
		return riControlPlanCustomMapper;
	}

	public void setRiControlPlanCustomMapper(RiControlPlanCustomMapper riControlPlanCustomMapper) {
		this.riControlPlanCustomMapper = riControlPlanCustomMapper;
	}

	/*
	 * 通过风险id得到分析信息
	 */
	@Override
	public RiDetailedOfRiskCtrlPlan getAnalysisPlanByRiskId(String riskMsgId) {
		RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan=null;
		if (riskMsgId != null) {
			riDetailedOfRiskCtrlPlan = RiDetailedOfRiskCtrlPlanCustomMapper.getAnalysisPlanByRiskId(riskMsgId);
			
		} 
		System.out.println("riskMsgId" + riskMsgId);
		
		return riDetailedOfRiskCtrlPlan;
		
	}
	
	
	
	/*
	 * 得到该管控的所有风险信息
	 */
	@Override
	public PageBean<RiIdentificationRriskMsg> getAllRiskMsgByControlPlanId(Map<String, Object> condition) {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiIdentificationRriskMsg> pageBean = new PageBean<RiIdentificationRriskMsg>();

		// 1、当前页private int currentPage;
		String strcurrentPage = (String) condition.get("currentPage");
		int currentPage = Integer.valueOf(strcurrentPage);

		pageBean.setCurrentPage(currentPage);

		// 2、当前页显示的条数private int currentCount;
		String strcurrentCount = (String) condition.get("currentCount");
		int currentCount = Integer.valueOf(strcurrentCount);

		pageBean.setCurrentCount(currentCount);

		// 3、总条数private int totalCount;
		int totalCount = 0;
		// 调用dao层的方法

		totalCount = RiDetailedOfRiskCtrlPlanCustomMapper.getAllRiskMsgCountByControlPlanId(condition);
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
		 * * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		
		List<RiIdentificationRriskMsg> riskMsgmap = RiDetailedOfRiskCtrlPlanCustomMapper.getAllRiskMsgByControlPlanId(condition);
		pageBean.setProductList(riskMsgmap);

		return pageBean;
	}

	/*
	 *添加管控计划分析
	 */
	@Override
	public boolean addControlPlanAnalysis(RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan) {
		int flag=0;
		System.out.println("riDetailedOfRiskCtrlPlan" + riDetailedOfRiskCtrlPlan);
		System.out.println(riDetailedOfRiskCtrlPlan.getRiskmsgid());
		if (riDetailedOfRiskCtrlPlan != null) {

			riDetailedOfRiskCtrlPlan.setAnalysistime(new Date());
			
			//flag = riDetailedOfRiskCtrlPlanMapper.insertSelective(riDetailedOfRiskCtrlPlan);
			flag = RiDetailedOfRiskCtrlPlanCustomMapper.addControlPlanAnalysis(riDetailedOfRiskCtrlPlan);

		} 
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public PageBean<Map<String, Object>> getAllRiskMsgAndAnalysisPlanByControlPlanId(Map<String, Object> condition) {
		// 目的：就是想办法封装一个PageBean 并返回
				PageBean<Map<String, Object>> pageBean = new PageBean<Map<String, Object>>();

				// 1、当前页private int currentPage;
				String strcurrentPage = (String) condition.get("currentPage");
				int currentPage = Integer.valueOf(strcurrentPage);

				pageBean.setCurrentPage(currentPage);

				// 2、当前页显示的条数private int currentCount;
				String strcurrentCount = (String) condition.get("currentCount");
				int currentCount = Integer.valueOf(strcurrentCount);

				pageBean.setCurrentCount(currentCount);

				// 3、总条数private int totalCount;
				int totalCount = 0;
				// 调用dao层的方法

				totalCount = RiDetailedOfRiskCtrlPlanCustomMapper.getAllRiskMsgCountByControlPlanId(condition);
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
				 * * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
				 * 
				 * 索引index = (当前页数-1)*每页显示的条数
				 * 
				 */
				int index = (currentPage - 1) * currentCount;
				condition.put("index", index);
				condition.put("currentCount", currentCount);
				
				List<Map<String, Object>> riskMsgmap = RiDetailedOfRiskCtrlPlanCustomMapper.getAllRiskMsgAndAnalysisPlanByControlPlanId(condition);
				pageBean.setProductList(riskMsgmap);

				return pageBean;
	}

	//得到月风险管控计划有效性
	@Override
	public PageBean<RiControlPlan> getAllVaildPlanInfo(Map<String, Object> condition) {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiControlPlan> pageBean = new PageBean<RiControlPlan>();

		// 1、当前页private int currentPage;
		String strcurrentPage = (String) condition.get("currentPage");
		int currentPage = Integer.valueOf(strcurrentPage);

		pageBean.setCurrentPage(currentPage);

		// 2、当前页显示的条数private int currentCount;
		String strcurrentCount = (String) condition.get("currentCount");
		int currentCount = Integer.valueOf(strcurrentCount);

		pageBean.setCurrentCount(currentCount);

		// 3、总条数private int totalCount;
		int totalCount = 0;
		// 调用dao层的方法

		//totalCount = RiDetailedOfRiskCtrlPlanCustomMapper.getAllVaildPlanCount(condition);
		totalCount = riControlPlanCustomMapper.getControlPlanCountById(condition);
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
		 * * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		
		
			/*
			 * 年份
			 */
			if(condition.get("monthOrWeek")!=null){
				String str = condition.get("monthOrWeek").toString();
				
				String str1 = str.substring(0, 4);
				
				condition.put("year", str1);
				
			}
			
			/*
			 * 月份
			 */
			if(condition.get("monthOrWeek")!=null){
				String str = condition.get("monthOrWeek").toString();
				System.out.println(str);
				String str1 = str.substring(str.length()-2, str.length());
				int number = Integer.parseInt(str1);
				condition.put("monthOrWeek", String.valueOf(number));
				
			}
		
		
		
		
		List<RiControlPlan> validList = riControlPlanCustomMapper.getControlPlanByCondition(condition);
		pageBean.setProductList(validList);

		return pageBean;
	}

	//得到月管控计划的措施无效的数量
	@Override
	public int getValidCount(String rictrlplanid) {
		int flag=0;
		if (rictrlplanid != null) {

			
			flag = RiDetailedOfRiskCtrlPlanCustomMapper.getValidCount(rictrlplanid);

		} 
		return flag;
	}
	
	
	@Override
	public List<RiIdentificationRriskMsg> getRiskMsgList(String riCtrlPlanId) {
		List<RiIdentificationRriskMsg> riskMsgList=null;
		if (riCtrlPlanId != null) {

			
			riskMsgList = RiDetailedOfRiskCtrlPlanCustomMapper.getRiskMsgList(riCtrlPlanId);

		} 
		return riskMsgList;
	}

	//得到该管控记录的所有责任部门及其个数
	@Override
	public List<Map<String, Object>> getDutyDepartmentList(String riCtrlPlanId) {
		List<Map<String, Object>> dutyDepartmentMap =null;
		if (riCtrlPlanId != null) {

			
			dutyDepartmentMap = RiDetailedOfRiskCtrlPlanCustomMapper.getDutyDepartmentList(riCtrlPlanId);
			System.out.println(dutyDepartmentMap);
		} 
		return dutyDepartmentMap;
	}
	
	
	//得到该管控记录的所有失效风险地点及其个数
	@Override
	public List<Map<String, Object>> getAddressList(String riCtrlPlanId) {
		List<Map<String, Object>> addressMap =null;
		if (riCtrlPlanId != null) {

			
			addressMap = RiDetailedOfRiskCtrlPlanCustomMapper.getAddressList(riCtrlPlanId);
			System.out.println(addressMap);
		} 
		return addressMap;
	}

	
	//得到专业类型下拉列表
	@Override
	public List<String> getProfessionalTypesList() {
		List<String> ptList = RiDetailedOfRiskCtrlPlanCustomMapper.getProfessionalTypesList();
		return ptList;
	}

	/*
	 * 通过传入的管控计划id得到该管控计划的风险信息
	 */
	@Override
	public List<RiIdentificationRriskMsg> findRiskInfoByRictrlplanId(String rictrlplanid) {
		List<RiIdentificationRriskMsg> RiskInfo =null;
		if (rictrlplanid != null) {

			
			RiskInfo = RiDetailedOfRiskCtrlPlanCustomMapper.findRiskInfoByRictrlplanId(rictrlplanid);
			
		} 
		return RiskInfo;
	}

	/*
	 * 得到旬风险管控计划有效性
	 */
	@Override
	public PageBean<RiControlPlan> getWeekAllVaildPlanInfo(Map<String, Object> condition) {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiControlPlan> pageBean = new PageBean<RiControlPlan>();

		// 1、当前页private int currentPage;
		String strcurrentPage = (String) condition.get("currentPage");
		int currentPage = Integer.valueOf(strcurrentPage);

		pageBean.setCurrentPage(currentPage);

		// 2、当前页显示的条数private int currentCount;
		String strcurrentCount = (String) condition.get("currentCount");
		int currentCount = Integer.valueOf(strcurrentCount);

		pageBean.setCurrentCount(currentCount);

		// 3、总条数private int totalCount;
		int totalCount = 0;
		// 调用dao层的方法

		totalCount = riControlPlanCustomMapper.getControlPlanCountById(condition);
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
		 * * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		
		List<RiControlPlan> controlPlanmap = riControlPlanCustomMapper.getControlPlanByCondition(condition);
		pageBean.setProductList(controlPlanmap);

		return pageBean;
	}

	

	
	

}
