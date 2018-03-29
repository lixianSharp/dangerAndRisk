package danger.service.impl.export2Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import danger.bean.dangerManage.Danger;
import danger.bean.queryView.DangerSidingFollowRecheck;
import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.mapper.dangerManage.custom.DangerCustomMapper;
import danger.mapper.queryView.QueryViewCustomMapper;
import danger.mapper.riIdentify.RiIdentificationMainTableMapper;
import danger.mapper.riIdentify.custom.RiAssessmentCustomMapper;
import danger.mapper.riIdentify.custom.RiIdentificationRriskMsgCustomMapper;
import danger.service.export.ExportExcelService;
import danger.service.queryView.QueryViewService;
import danger.service.riIdentity.RiAssessmentService;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.PageBean;
//导出相应信息到excel表格
@Service
public class ExportExcelImpl implements ExportExcelService{
	
	//^^^^^^^导出风险辨识主表及其对应的所有风险辨识信息表数据^^^^^^^^
	//^^^^^^^导出风险辨识主表及其对应的所有风险辨识信息表数据^^^^^^^^
	//^^^^^^^导出风险辨识主表及其对应的所有风险辨识信息表数据^^^^^^^^
	
	//风险辨识主表
	@Resource
	private RiIdentificationMainTableMapper riIdentificationMainTableMapper;
	
	//辨识风险信息表
	@Resource 
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService;
	
	@Resource
	private RiIdentificationRriskMsgCustomMapper riIdentificationRriskMsgCustomMapper;
	
	/**
	 * 导出年度辨识主表及其对应的所有辨识风险信息表数据
	 * 		这个方法将查询出来的数据保存在当前项目下的一个excel文件中
	 * @param identiryid 风险辨识主表id
	 * @return 文件名带有后缀的 例如 a.xls
	 * @throws Exception
	 */
	@Override
	public String exportIdentifyMainYS(String identiryid)throws Exception{
		//1.根据年度辨识主表id获查询该年度辨识主表信息
		RiIdentificationMainTable identifyMainTable = riIdentificationMainTableMapper.selectByPrimaryKey(identiryid);
		List<RiIdentificationMainTable> list1 = new LinkedList<RiIdentificationMainTable>();
		list1.add(identifyMainTable);
		
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("identiryid", identiryid);
		//2.根据年度辨识主表id查询该年度辨识主表对应的所有辨识风险信息表数据
		int sumMsgCount = riIdentificationRriskMsgCustomMapper.getRiIdentificationRriskMsgCountByCondition(condition);
		PageBean<RiIdentificationRriskMsg> pageBean = riIdentificationRriskMsgService.findRiIdentificationRriskMsgByCondition(1,sumMsgCount, condition);
		
		List<RiIdentificationRriskMsg> list2 = pageBean.getProductList();
		
		String fileName = UUID.randomUUID().toString()+".xls";//用uuid生成一个文件名
		
		exportExcelPaper2Javabean(list1,list2,fileName,6,11,new String[]{"年份","地点","主持人","记录人","参会人员","会议内容"},new String[]{"风险地点","风险描述","风险类型","专业类型","灾害类型","可能导致事故","管控措施","负责人","监管人","监管周期","评估状态"});
		//将生成在项目目录下的excel文件复制到D盘下的exportExcel文件夹下，复制成功之后，并删除生成在项目目录下的excel文件
		copyExcelToDirectory(fileName);
		return fileName;
	}
	
	
	/**
	 * 一个RiIdentificationMainTable对应多个RiIdentificationRriskMsg
	 * @param list1 第一个list集合 
	 * @param list2 第二个list集合
	 * @param fileName 导出文件名字  实际情况还需要加上路径(使用虚拟路径)
	 * @param columnCount1 第一个集合的列的个数
	 * @param columnCount2 第二个集合的列的个数
	 * @param title1 第一个集合的标题
	 * @param title2 第二个集合的标题
	 */
	public void exportExcelPaper2Javabean(List<RiIdentificationMainTable>list1,List<RiIdentificationRriskMsg> list2,String fileName,int columnCount1,int columnCount2,String[] title1,String[] title2) {
		// 创建一个工作簿
		Workbook workbook = new XSSFWorkbook();
		// 创建一个工作表sheet
		Sheet sheet = workbook.createSheet();
		// 设置列宽
		//sheet.setColumnWidth();
		//setColumnWidth();//setColumnWidth(sheet, 8);
		// 创建第一行
		Row row = sheet.createRow(0);
		// 创建一个单元格
		Cell cell = null;
		// 创建表头
		for (int i = 0; i < title1.length; i++) {
			cell = row.createCell(i);
			// 设置样式
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置字体居中
			// 设置字体
			Font font = workbook.createFont();
			font.setFontName("宋体");
			font.setBold(true);// 字体加粗
			// font.setFontHeight((short)12);
			font.setFontHeightInPoints((short) 13);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);

			cell.setCellValue(title1[i]);
		}

		// 从第二行开始追加数据
		for (int i = 1; i < (list1.size() + 1); i++) {//行  list集合中的每一个javabean当作一行
			// 创建第i行
			Row nextRow = sheet.createRow(i);
			for (int j = 0; j <=columnCount1-1; j++) {//列
				RiIdentificationMainTable identifyMainTable = list1.get(i-1);
				Cell cell2 = nextRow.createCell(j);
				
				if (j == 0) {
					cell2.setCellValue(identifyMainTable.getYear().toString().substring(24, 28));//年份
				}
				if (j == 1) {
					cell2.setCellValue(identifyMainTable.getMeetingaddress());//地点
				}
				if (j == 2) {
					cell2.setCellValue(identifyMainTable.getCompere());//主持人
				}
				if (j == 3) {
					cell2.setCellValue(identifyMainTable.getRecorder());//记录人
				}
				if (j == 4) {
					cell2.setCellValue(identifyMainTable.getParticipants());//参会人员
				}
				if (j == 5) {
					cell2.setCellValue(identifyMainTable.getMeetingcontent());//会议内容
				}
				
			}
		}
		
		
		//开始写入第二个list2
		// 创建第一行
		Row rowlist2 = sheet.createRow(list1.size()+1);
		// 创建一个单元格
		Cell celllist2 = null;
		// 创建表头
		for (int i = 0; i < title2.length; i++) {
			celllist2 = rowlist2.createCell(i);
			// 设置样式
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置字体居中
			// 设置字体
			Font font = workbook.createFont();
			font.setFontName("宋体");
			font.setBold(true);// 字体加粗
			// font.setFontHeight((short)12);
			font.setFontHeightInPoints((short) 13);
			cellStyle.setFont(font);
			celllist2.setCellStyle(cellStyle);

			celllist2.setCellValue(title2[i]);
		}
		
		// 从第四行开始追加数据
		for (int i = list1.size()+2; i <=(list2.size()+list1.size()+1); i++) {//行  list集合中的每一个javabean当作一行
			// 创建第i行
			Row nextRow = sheet.createRow(i);
			for (int j = 0; j <columnCount2; j++) {//列
				RiIdentificationRriskMsg identifyRiskMsg = list2.get(i-(list1.size()+2));
				Cell cell22 = nextRow.createCell(j);
				
				//向第i行中的第0到j列种写入数据
				if (j == 0) {
					cell22.setCellValue(identifyRiskMsg.getRiskaddress());//风险地点
				}
				if (j == 1) {
					cell22.setCellValue(identifyRiskMsg.getRiskdescribe());//风险描述
				}
				if (j == 2) {
					cell22.setCellValue(identifyRiskMsg.getRisktype());//风险类型
				}
				if (j == 3) {
					cell22.setCellValue(identifyRiskMsg.getProfessionaltypes());//专业类型
				}   
				if (j == 4) {
					cell22.setCellValue(identifyRiskMsg.getDisastertypes());//灾害类型
				}
				if (j == 5) {
					cell22.setCellValue(identifyRiskMsg.getCancauseaccidents());//可能导致事故
				}
				if (j == 6) {
					cell22.setCellValue(identifyRiskMsg.getCtrlmeasure());//管控措施
				}
				if (j == 7) {
					cell22.setCellValue(identifyRiskMsg.getPrincipal());//负责人
				}
				if (j == 8) {
					cell22.setCellValue(identifyRiskMsg.getSuperintendent());//监管人
				}
				if (j == 9) {
					cell22.setCellValue(identifyRiskMsg.getMonitoringperiod());//监管周期
				}
				if (j == 10) {
					if("Y".equals(identifyRiskMsg.getEvaluationstatus())){
						cell22.setCellValue("已评估");//评估状态
					}else if("N".equals(identifyRiskMsg.getEvaluationstatus())){
						cell22.setCellValue("未评估");//评估状态
					}
					
				}
			}//小for的括号
		}//大for的括号

		File file = new File(fileName);
		try {
			
			// 打开文件流
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭工作簿
			if(workbook!=null){
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	
	
	//^^^^^^^^^^^^^^导出风险清单^^^^^^^^^^^^^
	//^^^^^^^^^^^^^^导出风险清单^^^^^^^^^^^^^
	//^^^^^^^^^^^^^^导出风险清单^^^^^^^^^^^^^
	
	@Resource 
	private RiAssessmentCustomMapper riAssessmentCustomMapper;
	
	@Resource
	private RiAssessmentService riAssessmentService;
	
	/**
	 * 导出风险清单 
	 * @param condition 查询条件  condition中不需要当前页页号和每页显示的记录数
	 * @return
	 * @throws Exception
	 */
	@Override
	public String exportRiskList(Map<String,Object>condition)throws Exception{
		//当前页页号就设置为1
		String currentPage = "1";
		//查询结果的总记录数	
		Integer currentCount = riAssessmentCustomMapper.findIdentifyMsgAndAssessmentCountByCondition(condition);//总条数
		PageBean<Map<String, Object>> pageBean = riAssessmentService.findRiskMsgAndAssessmentByCondition(Integer.parseInt(currentPage), currentCount, condition);
		
		List<Map<String,Object>> list = new LinkedList<Map<String,Object>>();
		list = pageBean.getProductList();
		String fileName = UUID.randomUUID().toString()+".xls";
		
		//标题
		String[] title=new String[]{"风险来源","风险地点","风险描述","风险类型","专业类型","灾害类型","可能导致事故","管控措施","负责人","监管人","监管周期","可能性(L)","人员暴露频繁程度(E)","损失后果(C)","风险值(D)","风险等级"};
		
		exportExcelRiskList(list,fileName,16,title);
		//将生成在项目目录下的excel文件复制到D盘下的exportExcel文件夹下，复制成功之后，并删除生成在项目目录下的excel文件
		copyExcelToDirectory(fileName);
		return fileName;
	}
	
	/**
	 * 将List<Map<String,Object>>导出到Excel
	 *@param list  数据
	 *@param fileName   导出文件名字  实际情况还需要加上路径(使用虚拟路径)
	 *@param columnCount 导出到excel中一共有几行 = List集合中的javabean中的属性个数
	 *@param rowCount 导出到excel中一共有几列 = List集合中元素的个数
	 *@param title 标题
	 */
	public static void exportExcelRiskList(List<Map<String,Object>> list,String fileName,int columnCount,String[] title) {
		// 创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		// 设置列宽
		setColumnWidth(sheet, columnCount);//setColumnWidth(sheet, 8);
		// 创建第一行
		HSSFRow row = sheet.createRow(0);
		// 创建一个单元格
		HSSFCell cell = null;
		// 创建表头
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			// 设置样式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置字体居中
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setBold(true);// 字体加粗
			// font.setFontHeight((short)12);
			font.setFontHeightInPoints((short) 13);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);

			cell.setCellValue(title[i]);
		}

		// 从第二行开始追加数据
		for (int i = 1; i < (list.size() + 1); i++) {//行  list集合中的每一个javabean当作一行
			// 创建第i行
			HSSFRow nextRow = sheet.createRow(i);
			for (int j = 0; j <=columnCount-1; j++) {//列
				Map<String, Object> map = list.get(i-1);
				HSSFCell cell2 = nextRow.createCell(j);
				
				if (j == 0) {
					System.out.println((String.valueOf(map.get("identifyMainMsg"))));
					cell2.setCellValue((String.valueOf(map.get("identifyMainMsg"))));//风险来源
				}
				if (j == 1) {
					cell2.setCellValue((String)map.get("riskAddress"));//风险地点
				}
				if (j == 2) {
					cell2.setCellValue((String)map.get("riskDescribe"));//风险描述
				}
				if (j == 3) {
					cell2.setCellValue((String)map.get("riskType"));//风险类型
				}
				if (j == 4) {
					cell2.setCellValue((String)map.get("professionalTypes"));//专业类型
				}
				if (j == 5) {
					cell2.setCellValue((String)map.get("disasterTypes"));//灾害类型
				}
				if (j == 6) {
					cell2.setCellValue((String)map.get("canCauseAccidents"));//可能导致事故
				}
				if (j == 7) {
					cell2.setCellValue((String)map.get("ctrlMeasure"));//管控措施
				}
				
				if (j == 8) {
					cell2.setCellValue((String)map.get("principal"));//负责人
				}
				if (j == 9) {
					cell2.setCellValue((String)map.get("superintendent"));//监管人
				}
				if (j == 10) {
					cell2.setCellValue((String)map.get("monitoringPeriod"));//监管周期
				}
				if (j == 11) {
					cell2.setCellValue((String)map.get("possibility"));//可能性(L)
				}
				if (j == 12) {
					cell2.setCellValue((String)map.get("personDegreeOfExposure"));//人员暴露频繁程度(E)
				}
				if (j == 13) {
					cell2.setCellValue((String)map.get("lossOfCconsequences"));//损失后果(C)
				}
				if (j == 14){
					cell2.setCellValue((String.valueOf(map.get("riskValue"))));//风险值(D)
				}
				if (j == 15) {
					cell2.setCellValue((String)map.get("riskGrade"));//风险等级
				}
				
			}
		}
		File file = new File(fileName);
		try {
			// 打开文件流
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(workbook!=null){
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// 设置列宽()
	private static void setColumnWidth(HSSFSheet sheet, int colNum) {
		for (int i = 0; i < colNum; i++) {
			int v = 0;
			v = Math.round(Float.parseFloat("15.0") * 37F);
			v = Math.round(Float.parseFloat("20.0") * 267.5F);
			sheet.setColumnWidth(i, v);
		}
	}
	
	
	
	//^^^^^^^^将隐患查询中界面的数据导入到excel^^^^^^^^^
	//^^^^^^^^将隐患查询中界面的数据导入到excel^^^^^^^^^
	//^^^^^^^^将隐患查询中界面的数据导入到excel^^^^^^^^^
	@Resource
	private DangerCustomMapper dangerCustomMapper;
	
	@Resource 
	private QueryViewService queryViewService;
	
	@Resource
	private QueryViewCustomMapper queryViewCustomMapper;
	
	/**
	 * 导出隐患查询界面中符合查询条件的数据
	 * @param condition 封装查询条件，但是不需要封装当前页页号和每页显示的记录数
	 * @return 带后缀的文件名
	 * @throws Exception
	 */
	@Override
	public String exportDangerFind(Map<String,Object>condition)throws Exception{
		//设置当前页页号就为1
		String currentPage = "1";
		//查询符合当前条件的总记录数
		Integer  currentCount = dangerCustomMapper.getDangerCountByCondition(condition);
		PageBean<Danger> pageBean = queryViewService.findDangerByCondition(Integer.valueOf(currentPage),currentCount, condition);
		
		String[] title = {"级别","类型","责任单位","隐患内容","地点","检查日期","检查单位","检查人","状态"};
		List<Danger> list = pageBean.getProductList();
		String fileName = UUID.randomUUID().toString()+".xls";
		exportExcelPaper(list,fileName,9,title);
		//将生成在项目目录下的excel文件复制到D盘下的exportExcel文件夹下，复制成功之后，并删除生成在项目目录下的excel文件
		copyExcelToDirectory(fileName);
		return fileName;
	}
	
	
	
	/**
	 * 将List<Danger>导出到Excel
	 *@param list  数据
	 *@param fileName   导出文件名字  实际情况还需要加上路径(使用虚拟路径)
	 *@param columnCount 导出到excel中一共有几行 = List集合中的javabean中的属性个数
	 *@param rowCount 导出到excel中一共有几列 = List集合中元素的个数
	 *@param title 标题
	 */
	public static void exportExcelPaper(List<Danger> list,String fileName,int columnCount,String[] title) {
		// 标题
		//String[] title = { "考试名称","考试级别","员工姓名","员工成绩","职工类型","考试方式","单位/部门名称"};
		
		// 创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		// 设置列宽
		setColumnWidth(sheet, columnCount);//setColumnWidth(sheet, 8);
		// 创建第一行
		HSSFRow row = sheet.createRow(0);
		// 创建一个单元格
		HSSFCell cell = null;
		// 创建表头
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			// 设置样式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置字体居中
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setBold(true);// 字体加粗
			// font.setFontHeight((short)12);
			font.setFontHeightInPoints((short) 13);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);

			cell.setCellValue(title[i]);
		}

		// 从第二行开始追加数据
		for (int i = 1; i < (list.size() + 1); i++) {//行  list集合中的每一个javabean当作一行
			// 创建第i行
			HSSFRow nextRow = sheet.createRow(i);
			for (int j = 0; j <=columnCount-1; j++) {//列
				Danger danger = list.get(i-1);
				HSSFCell cell2 = nextRow.createCell(j);
				
				//向第i行中的第0到j列种写入数据
				if (j == 0) {
					cell2.setCellValue(danger.getDangergrade());//隐患级别
				}
				if (j == 1) {
					cell2.setCellValue(danger.getType());//隐患类型
				}
				if (j == 2) {
					cell2.setCellValue(danger.getUnit());//责任单位
				}
				if (j == 3) {
					cell2.setCellValue(danger.getContent());//隐患内容
				}
				if (j == 4) {
					cell2.setCellValue(danger.getAddress());//地点
				}
				if (j == 5) {
					cell2.setCellValue(danger.getFindtime());//检查日期
				}
				if (j == 6) {
					cell2.setCellValue(danger.getCheckunit());//检查单位
				}
				if (j == 7) {
					cell2.setCellValue(danger.getFindperson());//检查人(发现人)
				}
				if (j == 8) {
					cell2.setCellValue(danger.getDangerstatus());//状态
				}
				
			}
		}
		File file = new File(fileName);
		try {
			// 打开文件流
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(workbook!=null){
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	
	
	/**
	 * 导出隐患月报
	 * @param condition 封装查询的条件，但是不封装当前页页号和每页显示的记录数
	 * @return 文件名
	 * @throws Exception
	 */
	@Override
	public String exportDangerMonthReport(Map<String,Object> condition)throws Exception{
			
		//当前页页号就设置为1
		String currentPage = "1";
		//总记录数  每页显示的记录数的值设置为显示全部(总记录数)
		Integer currentCount = queryViewCustomMapper.getDangerSidingFollowRecheckCountByCondition(condition);
		
		PageBean<DangerSidingFollowRecheck> pageBean  = queryViewService.findDangerSidingFollowRecheckByCondition(Integer.valueOf(currentPage),currentCount, condition);
		String[] title = new String[]{"检查日期","检查单位","地点","类别","级别","状态","隐患内容","责任单位","整改措施","五定时间","责任单位负责人","复查时间","复查人","复查结果"};
		
		List<DangerSidingFollowRecheck> list = pageBean.getProductList();
		String fileName = UUID.randomUUID().toString()+".xls";//文件名
		exportExcelDangerMonthReport(list,fileName,title.length,title);
		
		//将生成在项目目录下的excel文件复制到D盘下的exportExcel文件夹下，复制成功之后，并删除生成在项目目录下的excel文件
		copyExcelToDirectory(fileName);
		
		return fileName;
	}
	
	
	
	/**
	 * 导出隐患月报
	 * 将List<DangerSidingFollowRecheck>导出到Excel
	 *@param list  数据
	 *@param fileName   导出文件名字  实际情况还需要加上路径(使用虚拟路径)
	 *@param columnCount 导出到excel中一共有几行 = List集合中的javabean中的属性个数
	 *@param rowCount 导出到excel中一共有几列 = List集合中元素的个数
	 *@param title 标题
	 */
	public static void exportExcelDangerMonthReport(List<DangerSidingFollowRecheck> list,String fileName,int columnCount,String[] title) {
		// 创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		// 设置列宽
		setColumnWidth(sheet, columnCount);//setColumnWidth(sheet, 8);
		// 创建第一行
		HSSFRow row = sheet.createRow(0);
		// 创建一个单元格
		HSSFCell cell = null;
		// 创建表头
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			// 设置样式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置字体居中
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setBold(true);// 字体加粗
			// font.setFontHeight((short)12);
			font.setFontHeightInPoints((short) 13);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);

			cell.setCellValue(title[i]);
		}

		// 从第二行开始追加数据
		for (int i = 1; i < (list.size() + 1); i++) {//行  list集合中的每一个javabean当作一行
			// 创建第i行
			HSSFRow nextRow = sheet.createRow(i);
			for (int j = 0; j <=columnCount-1; j++) {//列
				DangerSidingFollowRecheck dangerSidingFollowRecheck = list.get(i-1);
				HSSFCell cell2 = nextRow.createCell(j);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				//向第i行中的第0到j列种写入数据
				if (j == 0) {
					cell2.setCellValue(sdf.format(dangerSidingFollowRecheck.getFindtime()).toString());//检查日期
				}
				if (j == 1) {
					cell2.setCellValue(dangerSidingFollowRecheck.getCheckunit());//检查单位
				}
				if (j == 2) {
					cell2.setCellValue(dangerSidingFollowRecheck.getAddress());//地点
				}
				if (j == 3) {
					cell2.setCellValue(dangerSidingFollowRecheck.getType());//类别
				} 
				if (j == 4) {
					cell2.setCellValue(dangerSidingFollowRecheck.getDangergrade());//级别
				}
				if (j == 5) {
					cell2.setCellValue(dangerSidingFollowRecheck.getDangerstatusnum());//状态
				}
				if (j == 6) {
					cell2.setCellValue(dangerSidingFollowRecheck.getContent());//隐患内容
				}
				if (j == 7) {
					cell2.setCellValue(dangerSidingFollowRecheck.getUnit());//责任单位
				}
				if (j == 8) {
					cell2.setCellValue(dangerSidingFollowRecheck.getRectificationmeasure());//整改措施
				}
				if (j == 9) {
					cell2.setCellValue(sdf.format(dangerSidingFollowRecheck.getSidingtime()).toString());//五定时间
				}
				if (j == 10) {
					cell2.setCellValue(dangerSidingFollowRecheck.getManager());//责任单位负责人
				}
				if (j == 11) {
					cell2.setCellValue(sdf.format(dangerSidingFollowRecheck.getRectificationtime()).toString());//复查时间
				}
				if (j == 12) {
					cell2.setCellValue(dangerSidingFollowRecheck.getRecheckman());//复查人
				}
				if (j == 13) {
					if("0".equals(dangerSidingFollowRecheck.getRecheckresult())){
						cell2.setCellValue("合格");//复查结果
					}else{
						cell2.setCellValue("不合格");//复查结果
					}
					
				}
				
			}
		}
		File file = new File(fileName);
		try {
			// 打开文件流
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(workbook!=null){
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	
	
	
	
	/**
	 * 导出隐患日报
	 * @param condition 封装查询条件 但是不封装当前页页号和每页显示的记录数
	 * @return 文件名
	 * @throws Exception
	 */
	@Override
	public String exportDangerDayReport(Map<String,Object> condition)throws Exception{
		//当前页页号就设置为1
		String currentPage = "1";
		//每页显示的记录数就设置为 查询出来的总记录数
		Integer  currentCount = queryViewCustomMapper.getDangerSidingFollowRecheckCountByCondition(condition);
		PageBean<DangerSidingFollowRecheck> pageBean= queryViewService.findDangerSidingFollowRecheckByCondition(Integer.valueOf(currentPage),currentCount, condition);
		List<DangerSidingFollowRecheck> list = pageBean.getProductList();
		String[] title = new String[]{"责任单位","存在的隐患问题","隐患类型","级别","隐患发现人","解决时间","负责人","督办人","复查时间","复查人","是否消号"};
		String fileName = UUID.randomUUID().toString()+".xls";
		exportExcelDangerDayReport(list,fileName,title.length,title);
		
		//将生成在项目目录下的excel文件复制到D盘下的exportExcel文件夹下，复制成功之后，并删除生成在项目目录下的excel文件
		copyExcelToDirectory(fileName);
		
		return fileName;
	}

	//将生成在项目目录下的excel文件复制到D盘下的exportExcel文件夹下
	private void copyExcelToDirectory(String fileName) throws IOException {
		//将生成在项目目录下的excel文件复制到D盘下的exportExcel文件夹下
		FileUtils.copyFileToDirectory(new File(fileName), new File("D:/exportExcel/"));
		
		//删除生成在项目目录下的excel文件删除
		File file = new File(fileName);
		if(file.exists()){//如果该excel文件存在，则删除
			file.delete();
		}
	}
	
	
	/**
	 * 导出隐患日报
	 * 将List<DangerSidingFollowRecheck>导出到Excel
	 *@param list  数据
	 *@param fileName   导出文件名字  实际情况还需要加上路径(使用虚拟路径)
	 *@param columnCount 导出到excel中一共有几行 = List集合中的javabean中的属性个数
	 *@param rowCount 导出到excel中一共有几列 = List集合中元素的个数
	 *@param title 标题
	 */
	public static void exportExcelDangerDayReport(List<DangerSidingFollowRecheck> list,String fileName,int columnCount,String[] title) {
		// 创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		// 设置列宽
		setColumnWidth(sheet, columnCount);//setColumnWidth(sheet, 8);
		// 创建第一行
		HSSFRow row = sheet.createRow(0);
		// 创建一个单元格
		HSSFCell cell = null;
		// 创建表头
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			// 设置样式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置字体居中
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setBold(true);// 字体加粗
			// font.setFontHeight((short)12);
			font.setFontHeightInPoints((short) 13);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);

			cell.setCellValue(title[i]);
		}

		// 从第二行开始追加数据
		for (int i = 1; i < (list.size() + 1); i++) {//行  list集合中的每一个javabean当作一行
			// 创建第i行
			HSSFRow nextRow = sheet.createRow(i);
			for (int j = 0; j <=columnCount-1; j++) {//列
				DangerSidingFollowRecheck dangerSidingFollowRecheck = list.get(i-1);
				HSSFCell cell2 = nextRow.createCell(j);
				
				
				if (j == 0) {
					cell2.setCellValue(dangerSidingFollowRecheck.getUnit());//责任单位
				}
				if (j == 1) {
					cell2.setCellValue(dangerSidingFollowRecheck.getContent());//存在的隐患问题
				}
				if (j == 2) {
					cell2.setCellValue(dangerSidingFollowRecheck.getType());//隐患类型
				}
				if (j == 3) {
					cell2.setCellValue(dangerSidingFollowRecheck.getDangergrade());//级别
				}
				if (j == 4) {
					cell2.setCellValue(dangerSidingFollowRecheck.getFindperson());//隐患发现人
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (j == 5) {
					cell2.setCellValue(sdf.format(dangerSidingFollowRecheck.getRechecktime()).toString());//解决时间
				}
				if (j == 6) {
					cell2.setCellValue(dangerSidingFollowRecheck.getDutyperson());//负责人
				}
				if (j == 7) {
					cell2.setCellValue(dangerSidingFollowRecheck.getSupervisor());//督办人
				}
				if (j == 8) {
					cell2.setCellValue(sdf.format(dangerSidingFollowRecheck.getRecheckdate()).toString());//复查时间
				}
				if (j == 9) {
					cell2.setCellValue(dangerSidingFollowRecheck.getRecheckman());//复查人
				}
				if (j == 10) {
					if("0".equals(dangerSidingFollowRecheck.getRecheckresult())){
						cell2.setCellValue("否");//是否销号
					}else if("1".equals(dangerSidingFollowRecheck.getRecheckresult())){
						cell2.setCellValue("是");//是否销号
					}
					
				}
				
				
			}
		}
		File file = new File(fileName);
		try {
			// 打开文件流
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(workbook!=null){
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	
	
	
	
	
	
	
}
