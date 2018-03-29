package danger.action.export2Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.mapper.riIdentify.custom.RiAssessmentCustomMapper;
import danger.service.export.ExportExcelService;
import danger.service.riIdentity.RiAssessmentService;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.ValidateCheck;

/**
 * 将数据导出到excel表格中 思路：点击导出按钮的时候，将excel文件生成在指定文件夹下，然后弹出一个是否要下载该excel文件的提示，
 * 如果选择是则进行下载，下载之后将指定文件夹下的excel文件进行删除
 * 
 * @author 贤元
 *
 */
@Controller
@Scope("prototype")
public class ExportToExcelAction extends ActionSupport {

	// 辨识风险信息表
	@Resource
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService;
	
	//风险评估
	@Resource
	private RiAssessmentService riAssessmentService;
	
	@Resource 
	private RiAssessmentCustomMapper riAssessmentCustomMapper;
	
	@Resource
	private ExportExcelService exportExcelService;

	//要转成json的map集合
	private Map<String,Object> map;
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	// 注入服务器目录地址
	private String serverPath;// 注入要下载的文件的地址
	// 接收文件名
	private String name;// 这次是从jsp中的那个a标签中来的

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	public String getServerPath() {
		return serverPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 需要提供给struts写出数据的输入流
	public InputStream getInputStream() {
		try {
			// 转码：解决中文乱码问题
			// 先用ISO8859-1编码 再使用UTF-8解码
			String filename = new String(name.getBytes("ISO8859-1"), "UTF-8");// 中名名称.后缀名
			FileInputStream fis = new FileInputStream(new File(serverPath + filename));// 服务器目录地址+文件名
			return fis;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	// 下载方法
	public String down() throws Exception {
		// System.out.println(this.name);
		return "down";
	}
	
	//辨识主表id
	private String identiryid;
	public String getIdentiryid() {
		return identiryid;
	}

	public void setIdentiryid(String identiryid) {
		this.identiryid = identiryid;
	}

	/**
	 * 导出年度/专项辨识及其对一个的所有辨识风险信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportIdentifyYS() throws Exception {
		//1.获取从jsp传过来的风险辨识主表id
		//2.调用后台的方法，返回一个文件名
		String fileNameExcel = exportExcelService.exportIdentifyMainYS(identiryid);
		
		//3.根据文件名进行文件下载(下载excel文件) 在该文件夹下根据文件名进行下载D:\exportExcel
		this.name = fileNameExcel; //给this.name赋值赋为 当前返回的文件名(带后缀的 例如 a.xls)
		
		return "down";
	}
	
	/**
	 * 导出风险清单
	 * @throws Exception
	 */
	public String exportRiskList()throws Exception{
		//实例化要转成json的map集合
		map  = new LinkedHashMap<String,Object>();
		
		//1接收从jsp传过来的 当前页页号 每页显示的记录数
		HttpServletRequest request = ServletActionContext.getRequest();
		//String currentPage = request.getParameter("currentPage");//当前页页号
		String risktype = request.getParameter("risktype");//风险类型
		String professionaltypes = request.getParameter("professionaltypes");//专业类型
		String disastertypes = request.getParameter("disastertypes");//灾害类型
		String riskgrade = request.getParameter("riskgrade");//风险等级
		
		//2封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("riskgrade", riskgrade);//风险等级
		condition.put("risktype",risktype );//风险类型
		condition.put("professionaltypes", professionaltypes);//专业类型
		condition.put("disastertypes", disastertypes);//灾害类型
		condition.put("evaluationstatus", "Y");//评估状态 查询状态=已评估的 "Y" 
		
		//3调用后台的方法，返回一个文件名
		String fileNameExcel = exportExcelService.exportRiskList(condition);
		//4.根据文件名进行文件下载(下载excel文件)
		this.name = fileNameExcel; //给this.name赋值赋为 当前返回的文件名(带后缀的 例如 a.xls)
		map.put("fileNameExcel", fileNameExcel);
		return "ok";
	}

	//=========================================================以上是导出风险的，以下是导出隐患的
	//=========================================================以上是导出风险的，以下是导出隐患的
	//=========================================================以上是导出风险的，以下是导出隐患的
	private String checkunit;// 检查单位
	private String findtime;// 发现日期
	private String unit;// 责任单位
	private String address;// 地点
	private String content;// 隐患内容
	private String dangergrade;// 隐患级别
	private String type;// 隐患类型
	private String dangerstatus; // 隐患状态
	
	private String startTime; // 月表查询的开始时间
	private String endTime; // 月表查询的结束时间
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
	public String getCheckunit() {
		return checkunit;
	}
	public void setCheckunit(String checkunit) {
		this.checkunit = checkunit;
	}

	public String getFindtime() {
		return findtime;
	}
	public void setFindtime(String findtime) {
		this.findtime = findtime;
	}

	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDangergrade() {
		return dangergrade;
	}
	public void setDangergrade(String dangergrade) {
		this.dangergrade = dangergrade;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDangerstatus() {
		return dangerstatus;
	}
	public void setDangerstatus(String dangerstatus) {
		this.dangerstatus = dangerstatus;
	}
	
	/**
	 * 导出隐患查询界面中符合查询条件的数据
	 * @return
	 * @throws Exception
	 */
	public String exportDangerFind()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		
		//1.封装查询条件
		Map<String,Object> condition = new HashMap();
		
		if(ValidateCheck.isNotNull(checkunit)) {
			if (!"0".equals(checkunit)) {
				condition.put("checkunit", checkunit);
			}
		}
		if (ValidateCheck.isNotNull(findtime)) {
			condition.put("startTime", findtime + " 00:00:00");
			condition.put("endTime", findtime + " 23:59:59");
		}
		if (ValidateCheck.isNotNull(address)) {
			condition.put("address", address);
		}
		if (ValidateCheck.isNotNull(content)) {
			condition.put("content", content);
		}
		if (ValidateCheck.isNotNull(dangergrade)) {
			condition.put("dangergrade", dangergrade);
		}
		if (ValidateCheck.isNotNull(type)) {
			condition.put("type", type);
		}
		if (ValidateCheck.isNotNull(unit)) {
			condition.put("unit", unit);
		}
		if (ValidateCheck.isNotNull(dangerstatus)) {
			condition.put("dangerstatus", dangerstatus);
		}
		
		//2调用后台的方法，返回一个文件名
		String fileNameExcel = exportExcelService.exportDangerFind(condition);
		
		//4.根据文件名进行文件下载(下载excel文件)
		this.name = fileNameExcel; //给this.name赋值赋为 当前返回的文件名(带后缀的 例如 a.xls)
		map.put("fileNameExcel", fileNameExcel);
		return "ok";
	}
	
	/**
	 * 导出隐患月报
	 * @return
	 * @throws Exception
	 */
	public String exportDangerMonthReport()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//1.封装条件
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		if (ValidateCheck.isNotNull(startTime)) {//开始时间
			condition.put("startTime", startTime + " 00:00:00");
		}
		if (ValidateCheck.isNotNull(endTime)) {//结束时间
			condition.put("endTime", endTime + " 23:59:59");
		}
		if("0".equals(checkunit)){
			checkunit = "";
		}
		condition.put("checkunit", checkunit);
		condition.put("unit",unit);
		//2.调用后台的方法 返回一个文件名
		String fileNameExcel = exportExcelService.exportDangerMonthReport(condition);
		
		//4.根据文件名进行文件下载(下载excel文件)
		this.name = fileNameExcel; //给this.name赋值赋为 当前返回的文件名(带后缀的 例如 a.xls)
		map.put("fileNameExcel", fileNameExcel);
		return "ok";
	}
	
	/**
	 * 导出隐患日报
	 * @return
	 * @throws Exception
	 */
	public String exportDangerDayReport()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//1。封装查询条件
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		
		//String findtime = "2018-01-15";
		//封装发现日期
		if (ValidateCheck.isNotNull(findtime)) {
			condition.put("startTime", findtime + " 00:00:00");
			condition.put("endTime", findtime + " 23:59:59");
		}
		//2.调用后台的方法
		String fileNameExcel = exportExcelService.exportDangerDayReport(condition);
		
		//4.根据文件名进行文件下载(下载excel文件)
		this.name = fileNameExcel; //给this.name赋值赋为 当前返回的文件名(带后缀的 例如 a.xls)
		map.put("fileNameExcel", fileNameExcel);
		return "ok";
	}
	
}
