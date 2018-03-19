package danger.action.riIdentify;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.bean.riIdentify.RiIdentificationRange;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.mapper.riIdentify.RiIdentificationRriskMsgMapper;
import danger.service.riIdentity.RiIdentificationMainTableService;
import danger.service.riIdentity.RiIdentificationRangeService;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;

//年度辨识和专项辨识 -》对应  风险辨识主表
@Controller
@Scope("prototype")
public class RiIdentificationAction extends ActionSupport{
	
	@Resource
	private RiIdentificationMainTableService riIdentificationMainTableService;
	
	@Resource
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService;
	
	@Resource
	private RiIdentificationRangeService riIdentificationRangeService;
	
	@Resource
	private RiIdentificationRriskMsgMapper riIdentificationRriskMsgMapper;
	
	// 实例化要转成json的文本集合
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	//javabean 风险辨识主表
	private RiIdentificationMainTable identify;
	public RiIdentificationMainTable getIdentify() {
		return identify;
	}

	public void setIdentify(RiIdentificationMainTable identify) {
		this.identify = identify;
	}

	
	//javabean 辨识风险信息
	private RiIdentificationRriskMsg riIdentificationRriskMsg;
	public RiIdentificationRriskMsg getRiIdentificationRriskMsg() {
		return riIdentificationRriskMsg;
	}

	public void setRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) {
		this.riIdentificationRriskMsg = riIdentificationRriskMsg;
	}
	
	//年度  添加用的
	private String identifyNTime;
	public String getIdentifyNTime() {
		return identifyNTime;
	}
	public void setIdentifyNTime(String identifyNTime) {
		this.identifyNTime = identifyNTime;
	}
	
	//年度 修改用的
	private String updateYearDate;
	public String getUpdateYearDate() {
		return updateYearDate;
	}

	public void setUpdateYearDate(String updateYearDate) {
		this.updateYearDate = updateYearDate;
	}

	//======以下是各种操作====》
	/**
	 * 字符串转日期  String->Date
	 * @throws Exception
	 */
	public Date string2Data(String strData)throws Exception{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		Date parse = simpleDateFormat.parse(strData);
		return parse;
	}
	
	
	/**
	 * 添加年度的辨识主表信息的时候判断该年份是否存在
	 */
	public String theYearIsExist()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收年份
		String strDate = ServletActionContext.getRequest().getParameter("identifyNTime");
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("year", strDate);
		//以"该年份"为条件在年度辨识主表中查询是否有信息
		List<RiIdentificationMainTable> selIdentifyMainByYear = riIdentificationMainTableService.selIdentifyMainByYear(condition);
		if(selIdentifyMainByYear.size()>0){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return "ok";
	}
	
	/**
	 * 添加辨识主表信息(年度Y)
	 * @return
	 * @throws Exception
	 */
	public String addRiIdentificationMainTable()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收年份
		String strDate = ServletActionContext.getRequest().getParameter("identifyNTime");
		Date yearDate = string2Data(strDate);//字符串转日期
		
		//添加主键
		identify.setIdentiryid(UUIDUtil.getUUID2());
		//添加年份
		identify.setYear(yearDate);
		//添加创建时间
		identify.setCreatetime(new Date());
		//添加年度辨识的名字
		identify.setName("年度辨识风险");
		
		boolean result = riIdentificationMainTableService.addRiIdentificationMainTable(identify);
		if(result){
			map.put("result", "添加成功");
		}else{
			map.put("result", "添加失败");
		}
		
		return "ok";
	}
	
	
	
	
	/**
	 * 修改辨识主表信息(年度Y)(不修改创建时间)
	 * @return
	 * @throws Exception
	 */
	public String updateRiIdentificationMainTable() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收年份
		String strDate = ServletActionContext.getRequest().getParameter("updateYearDate");
		Date yearDate = string2Data(strDate);//字符串转日期
		//添加年份
		identify.setYear(yearDate);		
		
		boolean result = riIdentificationMainTableService.updateRiIdentificationMainTable(identify);
		if(result){
			map.put("result", "修改成功");
		}else{
			map.put("result", "修改失败，请重新修改");
		}
		
		return "ok";
	}
	
	/**
	 * 根据主键id删除辨识信息(年度Y)
	 * @return
	 * @throws Exception
	 */
	public String delRiIdentificationMainTable() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收从jsp页面传过来的辨识信息id
		String identiryid = ServletActionContext.getRequest().getParameter("identiryid");
		boolean result = riIdentificationMainTableService.delRiIdentificationMainTable(identiryid);
		if(result){
			map.put("result", "删除成功");
		}else{
			map.put("result", "删除失败，请重新删除");
		}
		return "ok";
	}
	
	/**
	 * 组合条件查询年度辨识信息(年度Y)
	 * @return
	 * @throws Exception
	 */
	public String findRiIdentificationMainTableByConditionY()throws Exception{
		//实例化要转换成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收从jsp传过来的数据
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");//当前页页号
		String currentCount = request.getParameter("currentCount");//每页显示的记录数
		
		Integer currpage = Integer.parseInt(currentPage);//当前页页号
		Integer currCount = Integer.parseInt(currentCount);//每页显示的记录数
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("index", (currpage-1)*currCount);//（当前页页号-1）*每页显示的记录数
		condition.put("currentCount", currCount);
		condition.put("identifymark", "Y");//表示年度的辨识
		List<Map<String, Object>> resultMapList = riIdentificationMainTableService.findIdentifyMainAndRiskMsgByCondition(condition);
		//总记录数
		Integer resultCount = riIdentificationMainTableService.getIdentifyMainAndRiskMsgCountByCondition(condition);
		resultCount = resultCount;
		
		//封装结果集
		map.put("resultMapList", resultMapList);
		//封装当前页页号
		map.put("currentPage", currpage);
		//每页显示的记录数
		map.put("currentCount", currCount);
		//总记录数
		map.put("totalCount", resultCount);
		
		return "ok";
	}
	
	
	/**
	 * 跳转到详情
	 * @return
	 * @throws Exception
	 */
	public String detailOpY()throws Exception{
		//1.接收从jsp传过来的年度辨识id
		HttpServletRequest request = ServletActionContext.getRequest();
		String idenranid = request.getParameter("idenranid");//风险辨识主表的id
		
		//2.根据年度id获取年度辨识信息
		RiIdentificationMainTable identifyMainTableY = riIdentificationMainTableService.findIdentifyMainByIdentifyId(idenranid);
		
		//3.根据年度id获取其对应的所有年度辨识风险信息
		String currentPage = request.getParameter("currentPage");//接收当前页页号
		String currentCount = request.getParameter("currentCount");//接收每页显示的记录数
		if(currentPage==null){
			currentPage = "1";
		}
		if(currentCount==null){
			currentCount = "10";
		}
		//封装组合条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("identiryid", idenranid);
		PageBean<RiIdentificationRriskMsg> pageBean = riIdentificationRriskMsgService.findRiIdentificationRriskMsgByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		
		//通过request域对象将数据转发到对应的详情页面
		request.setAttribute("identifyMainTableY", identifyMainTableY);//年度辨识信息
		request.setAttribute("pageBean", pageBean);//年度辨识风险信息
		
		return "detailOpY";
	}
	
	/**
	 * 初始化工作面地点
	 * @return
	 * @throws Exception
	 */
	public String initWorkFace()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//查询所有风险辨识范围信息
		List<RiIdentificationRange> riIdentificationRangeList = riIdentificationRangeService.findAllRiIdentificationRange();
		map.put("riIdentificationRangeList", riIdentificationRangeList);
		return "ok";
	}
	
	//*****************
	//>>>>>>>>>>>>>>>>>年度辨识风险信息(副表)
	//****************
	/**
	 * 添加辨识风险信息
	 */
	public String addIdentifyRiskMsg()throws Exception{
		map = new LinkedHashMap<String,Object>();
		//添加辨识风险信息的id
		riIdentificationRriskMsg.setRiskmsgid(UUIDUtil.getUUID2());
		//添加评估状态，默认为 "未评估N"
		riIdentificationRriskMsg.setEvaluationstatus("N");
		boolean result = riIdentificationRriskMsgService.addRiIdentificationRriskMsg(riIdentificationRriskMsg);
		if(result){
			map.put("result", "添加成功");
		}else{
			map.put("result", "添加失败,请重新添加");
		}
		return "ok";
	}
	
	
	/**
	 * 修改辨识风险信息
	 */
	public String updateIdentifyRiskMsg()throws Exception{
		map = new LinkedHashMap<String,Object>();
		boolean result = riIdentificationRriskMsgService.updateRiIdentificationRriskMsg(riIdentificationRriskMsg);
		if(result){
			map.put("result", "修改成功");
		}else{
			map.put("result", "修改失败，请重新修改");
		}
		return "ok";
	}
	
	
	/**
	 * 删除辨识风险信息
	 */
	public String delIdentifyRiskMsg()throws Exception{
		map = new LinkedHashMap<String,Object>();
		//获取从jsp传过来的riskMsgId辨识风险信息id
		String riskMsgId = ServletActionContext.getRequest().getParameter("riskMsgId");
		boolean result = riIdentificationRriskMsgService.delRiIdentificationRriskMsg(riskMsgId);
		if(result){
			map.put("result", "删除成功");
		}else{
			map.put("result", "删除失败，请重新删除");
		}
		return "ok";
	}
	
	/**
	 * 组合条件查询辨识风险信息 查询出符合条件的 辨识风险信息表中中identiryid=identiryid的
	 * @return
	 * @throws Exception
	 */
	public String findIdentifyByCondition()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//获取从jsp传过来的当前页页号，每页显示的记录数，风险辨识主表id
		String currentPage = ServletActionContext.getRequest().getParameter("currentPage");//当前页页号
		String currentCount = ServletActionContext.getRequest().getParameter("currentCount");//每页显示的记录数
		String identiryid = ServletActionContext.getRequest().getParameter("identiryid");//风险辨识主表id
		
		//封装条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("identiryid", identiryid);//
		PageBean<RiIdentificationRriskMsg> pageBean = riIdentificationRriskMsgService.findRiIdentificationRriskMsgByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		map.put("pageBean", pageBean);
		return "ok";
	}
	
	
	
	
	
	
	
	
	
	//================以上是年度辨识的
	//************************************************************************************************************
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//************************************************************************************************************
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//************************************************************************************************************
	//===============以下是专项辨识的
	
	/**
	 * 添加辨识主表信息(专项S)
	 * @return
	 * @throws Exception
	 */
	public String addRiIdentificationMainTableS()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收年份
		String strDate = ServletActionContext.getRequest().getParameter("identifyNTime");
		Date yearDate = string2Data(strDate);//字符串转日期
		
		//添加主键
		identify.setIdentiryid(UUIDUtil.getUUID2());
		//添加年份
		identify.setYear(yearDate);
		//添加创建时间
		identify.setCreatetime(new Date());
		//添加专项辨识的名字
		identify.setName("专项辨识风险");
		
		boolean result = riIdentificationMainTableService.addRiIdentificationMainTable(identify);
		if(result){
			map.put("result", "添加成功");
		}else{
			map.put("result", "添加失败");
		}
		
		return "ok";
	}
	
	

	
	
	/**
	 * 修改辨识主表信息(专项S)(不修改创建时间)
	 * @return
	 * @throws Exception
	 */
	public String updateRiIdentificationMainTableS() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收年份
		String strDate = ServletActionContext.getRequest().getParameter("updateYearDate");
		Date yearDate = string2Data(strDate);//字符串转日期
		//添加年份
		identify.setYear(yearDate);		
		
		boolean result = riIdentificationMainTableService.updateRiIdentificationMainTable(identify);
		if(result){
			map.put("result", "修改成功");
		}else{
			map.put("result", "修改失败，请重新修改");
		}
		
		return "ok";
	}
	
	/**
	 * 根据主键id删除辨识信息(专项S)
	 * @return
	 * @throws Exception
	 */
	public String delRiIdentificationMainTableS() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收从jsp页面传过来的辨识信息id
		String identiryid = ServletActionContext.getRequest().getParameter("identiryid");
		boolean result = riIdentificationMainTableService.delRiIdentificationMainTable(identiryid);
		if(result){
			map.put("result", "删除成功");
		}else{
			map.put("result", "删除失败，请重新删除");
		}
		return "ok";
	}
	
	/**
	 * 组合条件查询年度辨识信息(专项S)
	 * @return
	 * @throws Exception
	 */
	public String findRiIdentificationMainTableByConditionS()throws Exception{
		//实例化要转换成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收从jsp传过来的数据
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");//当前页页号
		String currentCount = request.getParameter("currentCount");//每页显示的记录数
		
		Integer currpage = Integer.parseInt(currentPage);//当前页页号
		Integer currCount = Integer.parseInt(currentCount);//每页显示的记录数
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("index", (currpage-1)*currCount);//（当前页页号-1）*每页显示的记录数
		condition.put("currentCount", currCount);
		condition.put("identifymark", "S");//表示专项的辨识
		List<Map<String, Object>> resultMapList = riIdentificationMainTableService.findIdentifyMainAndRiskMsgByCondition(condition);
		//总记录数
		Integer resultCount = riIdentificationMainTableService.getIdentifyMainAndRiskMsgCountByCondition(condition);
		resultCount = resultCount;
		
		//封装结果集
		map.put("resultMapList", resultMapList);
		//封装当前页页号
		map.put("currentPage", currpage);
		//每页显示的记录数
		map.put("currentCount", currCount);
		//总记录数
		map.put("totalCount", resultCount);
		
		return "ok";
	}
	
	
	/**
	 * 跳转到详情
	 * @return
	 * @throws Exception
	 */
	public String detailOpS()throws Exception{
		//1.接收从jsp传过来的年度辨识id
		HttpServletRequest request = ServletActionContext.getRequest();
		String idenranid = request.getParameter("idenranid");//风险辨识主表的id
		
		//2.根据专项id获取年度辨识信息
		RiIdentificationMainTable identifyMainTableY = riIdentificationMainTableService.findIdentifyMainByIdentifyId(idenranid);
		
		//3.根据专项id获取其对应的所有年度辨识风险信息
		String currentPage = request.getParameter("currentPage");//接收当前页页号
		String currentCount = request.getParameter("currentCount");//接收每页显示的记录数
		if(currentPage==null){
			currentPage = "1";
		}
		if(currentCount==null){
			currentCount = "10";
		}
		//封装组合条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("identiryid", idenranid);
		PageBean<RiIdentificationRriskMsg> pageBean = riIdentificationRriskMsgService.findRiIdentificationRriskMsgByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		
		//通过request域对象将数据转发到对应的详情页面
		request.setAttribute("identifyMainTableY", identifyMainTableY);//专项辨识信息
		request.setAttribute("pageBean", pageBean);//专项辨识风险信息
		
		return "detailOpS";
	}
	
	
	
	//*****************
	//>>>>>>>>>>>>>>>>>以下是专项辨识风险信息(副表)
	//****************
	//<<<<<<<<<<<<<<<<
	/**
	 * 添加辨识风险信息
	 */
	public String addIdentifyRiskMsgS()throws Exception{
		map = new LinkedHashMap<String,Object>();
		//添加辨识风险信息的id
		riIdentificationRriskMsg.setRiskmsgid(UUIDUtil.getUUID2());
		//添加评估状态，默认为 "未评估N"
		riIdentificationRriskMsg.setEvaluationstatus("N");
		boolean result = riIdentificationRriskMsgService.addRiIdentificationRriskMsg(riIdentificationRriskMsg);
		if(result){
			map.put("result", "添加成功");
		}else{
			map.put("result", "添加失败,请重新添加");
		}
		return "ok";
	}
	
	
	/**
	 * 修改辨识风险信息
	 */
	public String updateIdentifyRiskMsgS()throws Exception{
		map = new LinkedHashMap<String,Object>();
		boolean result = riIdentificationRriskMsgService.updateRiIdentificationRriskMsg(riIdentificationRriskMsg);
		if(result){
			map.put("result", "修改成功");
		}else{
			map.put("result", "修改失败，请重新修改");
		}
		return "ok";
	}
	
	
	/**
	 * 删除辨识风险信息
	 */
	public String delIdentifyRiskMsgS()throws Exception{
		map = new LinkedHashMap<String,Object>();
		//获取从jsp传过来的riskMsgId辨识风险信息id
		String riskMsgId = ServletActionContext.getRequest().getParameter("riskMsgId");
		boolean result = riIdentificationRriskMsgService.delRiIdentificationRriskMsg(riskMsgId);
		if(result){
			map.put("result", "删除成功");
		}else{
			map.put("result", "删除失败，请重新删除");
		}
		return "ok";
	}
	
	/**
	 * 组合条件查询辨识风险信息 查询出符合条件的 辨识风险信息表中中identiryid=identiryid的
	 * @return
	 * @throws Exception
	 */
	public String findIdentifyByConditionS()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//获取从jsp传过来的当前页页号，每页显示的记录数，风险辨识主表id
		String currentPage = ServletActionContext.getRequest().getParameter("currentPage");//当前页页号
		String currentCount = ServletActionContext.getRequest().getParameter("currentCount");//每页显示的记录数
		String identiryid = ServletActionContext.getRequest().getParameter("identiryid");//风险辨识主表id
		
		//封装条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("identiryid", identiryid);//
		PageBean<RiIdentificationRriskMsg> pageBean = riIdentificationRriskMsgService.findRiIdentificationRriskMsgByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		map.put("pageBean", pageBean);
		return "ok";
	}
	

	
}
