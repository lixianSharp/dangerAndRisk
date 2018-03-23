package danger.service.impl.riControlPlan;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riCtrl.RiRiskPlanAudit;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.mapper.riCtrl.RiControlPlanMapper;
import danger.mapper.riCtrl.RiDetailedOfRiskCtrlPlanMapper;
import danger.mapper.riCtrl.RiRiskPlanAuditMapper;
import danger.mapper.riCtrl.custom.RiControlPlanCustomMapper;
import danger.service.riControlPlan.ControlPlanService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;


@Service
public class ControlPlanServiceImpl implements ControlPlanService {
	

	@Resource
	private RiControlPlanCustomMapper riControlPlanCustomMapper;
	public RiControlPlanCustomMapper getRiControlPlanCustomMapper() {
		return riControlPlanCustomMapper;
	}
	public void setRiControlPlanCustomMapper(RiControlPlanCustomMapper riControlPlanCustomMapper) {
		this.riControlPlanCustomMapper = riControlPlanCustomMapper;
	}
	
	@Resource
	private RiControlPlanMapper riControlPlanMapper;
	
	public RiControlPlanMapper getRiControlPlanMapper() {
		return riControlPlanMapper;
	}
	public void setRiControlPlanMapper(RiControlPlanMapper riControlPlanMapper) {
		this.riControlPlanMapper = riControlPlanMapper;
	}
	
	@Resource
	private RiRiskPlanAuditMapper riRiskPlanAuditMapper;
	
	
	public RiRiskPlanAuditMapper getRiRiskPlanAuditMapper() {
		return riRiskPlanAuditMapper;
	}
	public void setRiRiskPlanAuditMapper(RiRiskPlanAuditMapper riRiskPlanAuditMapper) {
		this.riRiskPlanAuditMapper = riRiskPlanAuditMapper;
	}
	
	@Resource
	private RiDetailedOfRiskCtrlPlanMapper riDetailedOfRiskCtrlPlanMapper;
	public RiDetailedOfRiskCtrlPlanMapper getRiDetailedOfRiskCtrlPlanMapper() {
		return riDetailedOfRiskCtrlPlanMapper;
	}
	public void setRiDetailedOfRiskCtrlPlanMapper(RiDetailedOfRiskCtrlPlanMapper riDetailedOfRiskCtrlPlanMapper) {
		this.riDetailedOfRiskCtrlPlanMapper = riDetailedOfRiskCtrlPlanMapper;
	}
	//添加一条管控计划记录
	@Override
	public boolean addControlPlan(RiControlPlan ricontrolPlan) {
		int flag=0;

		System.out.println("ricontrolPlan" + ricontrolPlan);
		if (ricontrolPlan != null) {

			//设置管控id
			String rictrlplanid = UUIDUtil.getUUID2();
			ricontrolPlan.setRictrlplanid(rictrlplanid);
			
			// 设置当前时间
			
			ricontrolPlan.setCreatetime(new Date());
			
			String month = ricontrolPlan.getMonthorweek();
			//年
			String str1 = month.substring(0, 4);
			
			//月
			String str2 = month.substring(month.length()-2, month.length());
			int number = Integer.parseInt(str2);
			
			ricontrolPlan.setYear(str1);
			ricontrolPlan.setMonthorweek(String.valueOf(number));
			
			//将该管控记录标识为月管控计划
			ricontrolPlan.setRiskctrlplanmark("0");
			
			//状态设置为未上报
			ricontrolPlan.setReportstatus("0");
			
			flag = riControlPlanMapper.insertSelective(ricontrolPlan);
			

		} 
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	/*
	 * 修改管控计划
	 */
	@Override
	public boolean updateControlPlan(RiControlPlan ricontrolPlan) {
		int flag=0;

		System.out.println("ricontrolPlan" + ricontrolPlan);
		
		
		if (ricontrolPlan != null) {
			
			// 设置当前时间
			
			ricontrolPlan.setCreatetime(new Date());
			
			String month = ricontrolPlan.getMonthorweek();
			//年
			String str1 = month.substring(0, 4);
			
			//月
			String str2 = month.substring(month.length()-2, month.length());
			int number = Integer.parseInt(str2);
			
			ricontrolPlan.setYear(str1);
			ricontrolPlan.setMonthorweek(String.valueOf(number));
			
			
			flag = riControlPlanMapper.updateByPrimaryKeySelective(ricontrolPlan);
			
		} 
		System.out.println("ricontrolPlan" + ricontrolPlan);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
	
	/*
	 * 通过管控计划id得到管控计划
	 */
	@Override
	public RiControlPlan getRiControlPlanById(String riCtrlPlanId) {
		
		RiControlPlan riControlPlan=null;
		System.out.println("riCtrlPlanId" + riCtrlPlanId);
		if (riCtrlPlanId != null) {
			
			riControlPlan = riControlPlanMapper.selectByPrimaryKey(riCtrlPlanId);
		} 
		System.out.println("riControlPlan" + riControlPlan);
		return riControlPlan;
	}
	
	
	//得到该管控计划所拥有的风险数量
	@Override
	public int getRiskCount(String rictrlplanid) {
		int a=0;
		if (rictrlplanid != null) {
			
			a = riControlPlanCustomMapper.getRiskCount(rictrlplanid);
		} 
		
		return a;
		
	}
	
	//得到其中一条管控计划的所有审核备注信息
	@Override
	public LinkedList<RiRiskPlanAudit> getShenHe(String rictrlplanid) {
		LinkedList<RiRiskPlanAudit> riRiskPlanAudit = null;
		if (rictrlplanid != null) {
			
			riRiskPlanAudit = riControlPlanCustomMapper.getShenHe(rictrlplanid);
		} 
		
		return riRiskPlanAudit;
	}
	
	//分页得到所有的管控信息
	@Override
	public PageBean<RiControlPlan> getAllControlPlan(Map<String, Object> condition) {
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
		
		List<RiControlPlan> controlPlanmap = riControlPlanCustomMapper.getControlPlanByCondition(condition);
		pageBean.setProductList(controlPlanmap);

		return pageBean;
	}
	
	/*
	 * 得到灾害类型的风险数量
	 */
	@Override
	public List<Map<String, Object>> getRiskCountByDisasterTypes() {
		List<Map<String, Object>> riskCountList=null;
		riskCountList = riControlPlanCustomMapper.getRiskCountByDisasterTypes();
		return riskCountList;
	}
	
	/*
	 * 得到失效的风险的地点
	 */
	@Override
	public List<Map<String, Object>> getAddressList() {
		List<Map<String,Object>> addressList=null;
		addressList =riControlPlanCustomMapper.getAddressList();
		return addressList;
	}
	
	/*
	 * 得到该管控计划下的所有风险信息的风险地点
	 */
	@Override
	public List<String> getRiskAddress(String rictrlplanid) {
		List<String> s =null;
		if(rictrlplanid!=null){
			s = riControlPlanCustomMapper.getRiskAddress(rictrlplanid);
		}
		return s;
	}
	
	/*
	 * 得到风险信息（分页）
	 */
	@Override
	public PageBean<RiIdentificationRriskMsg> getAllRiskInfo(Map<String, Object> condition) {
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

		totalCount = riControlPlanCustomMapper.getAllRiskInfoCount(condition);
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
		
		List<RiIdentificationRriskMsg> controlPlanmap = riControlPlanCustomMapper.getAllRiskInfo(condition);
		pageBean.setProductList(controlPlanmap);

		return pageBean;
	}
	
	/*
	 * 导入风险信息到管控计划中
	 */
	@Override
	public boolean importRiskInfo(String rictrlplanid, String riskmsgid) {
		 int flag=0;
		 
		 //通过rictrlplanid查询riskmsgid，如果存在，就把之前的去掉
		 List<RiDetailedOfRiskCtrlPlan> riDetailedOfRiskCtrlPlanList = riControlPlanCustomMapper.getMyRiskmsgid(rictrlplanid);
		for(RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan:riDetailedOfRiskCtrlPlanList){
			if(riDetailedOfRiskCtrlPlan.getRiskmsgid().equals(riskmsgid)){
				 
				 riDetailedOfRiskCtrlPlanMapper.deleteByPrimaryKey(riDetailedOfRiskCtrlPlan.getDetailedofriskctrlplanid());
			 }
		}
		 
		 
		 
		if (rictrlplanid != null&&riskmsgid!=null) {
			
			RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan =new RiDetailedOfRiskCtrlPlan();
			
			//设置管控计划详情id
			String detailedOfRiskCtrlPlanId = UUIDUtil.getUUID2();
			riDetailedOfRiskCtrlPlan.setDetailedofriskctrlplanid(detailedOfRiskCtrlPlanId);
			
			//设置管控计划和风险信息的关联
			riDetailedOfRiskCtrlPlan.setRictrlplanid(rictrlplanid);
			riDetailedOfRiskCtrlPlan.setRiskmsgid(riskmsgid);
			
			
			flag = riControlPlanCustomMapper.importRiskInfo(riDetailedOfRiskCtrlPlan);
		} 
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
	
	/*
	 * 删除该管控计划中的一条风险信息
	 */
	@Override
	public boolean deleteRiskInfo(String riCtrlPlanId, String riskMsgId) {
		 int flag=0;
			if (riCtrlPlanId != null&&riskMsgId!=null) {
				
				RiDetailedOfRiskCtrlPlan riDetailedOfRiskCtrlPlan =new RiDetailedOfRiskCtrlPlan();
			
				//设置管控计划和风险信息的关联
				riDetailedOfRiskCtrlPlan.setRictrlplanid(riCtrlPlanId);
				riDetailedOfRiskCtrlPlan.setRiskmsgid(riskMsgId);
				
				
				//flag = riControlPlanCustomMapper.deleteRiskInfo(riCtrlPlanId,riskMsgId);
				flag = riControlPlanCustomMapper.deleteRiskInfo(riDetailedOfRiskCtrlPlan);
			} 
			if(flag==0){
				return false;
			}else{
				return true;
			}
	}
	
	
	/*
	 * 得到上月的管控计划的id
	 */
	@Override
	public String getPrecedingMonthId(String myrictrlplanid) {
		String str = null;
		if(myrictrlplanid!=null){
			str = riControlPlanCustomMapper.getPrecedingMonthId(myrictrlplanid);
		}
		return str;
	}
	
	/*
	 * 得到上月的风险信息的id
	 */
	@Override
	public List<String> getPrecedingMonthRiskInfoIdList(String precedingMonthId) {
		List<String> strList =null;
		if(precedingMonthId!=null){
			strList = riControlPlanCustomMapper.getPrecedingMonthRiskInfoIdList(precedingMonthId);
		}
		return strList;
	}
	
	/*
	 * 计划上报
	 */
	@Override
	public boolean reportPlan(String controlPlansid) {
		int flag=0;
		if(controlPlansid!=null){
			flag = riControlPlanCustomMapper.reportPlan(controlPlansid);
		}
		if(flag!=0){
			return true;
		}else{
			return false;
		}
	
	}
	
	/*
	 * 计划审核
	 */
	@Override
	public boolean auditPlan(RiRiskPlanAudit riRiskPlanAudit) {
		int flag=0;
		if(riRiskPlanAudit!=null){
			
			
			//给管控计划添加审核状态
			String auditStatus =riRiskPlanAudit.getAuditstatus();
			String id=riRiskPlanAudit.getRictrlplanid();
			RiControlPlan riControlPlan = riControlPlanMapper.selectByPrimaryKey(id);
			if(auditStatus.equals("未通过审核")){
				riControlPlan.setCheckstatus("0");
				riControlPlanMapper.updateByPrimaryKey(riControlPlan);
			}else if(auditStatus.equals("通过审核")){
				riControlPlan.setCheckstatus("1");
				riControlPlanMapper.updateByPrimaryKey(riControlPlan);
			}
			
			
			//设置管控id
			String riskplanauditid = UUIDUtil.getUUID2();
			riRiskPlanAudit.setRiskplanauditid(riskplanauditid);
			
			// 设置当前时间
			
			riRiskPlanAudit.setAudittime(new Date());
			
			
			flag = riRiskPlanAuditMapper.insertSelective(riRiskPlanAudit);
		}
		if(flag!=0){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * 添加旬管控计划
	 */
	@Override
	public boolean addWeekControlPlan(RiControlPlan ricontrolPlan) {
		int flag=0;

		System.out.println("ricontrolPlan" + ricontrolPlan);
		if (ricontrolPlan != null) {

			//设置管控id
			String rictrlplanid = UUIDUtil.getUUID2();
			ricontrolPlan.setRictrlplanid(rictrlplanid);
			
			// 设置当前时间
			
			ricontrolPlan.setCreatetime(new Date());
			
			//将该管控记录标识为旬管控计划
			ricontrolPlan.setRiskctrlplanmark("0");
			//状态设置为未上报
			ricontrolPlan.setReportstatus("0");
			
			flag = riControlPlanMapper.insertSelective(ricontrolPlan);
			

		} 
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	
	
	
	

	
}
