package danger.action.riControlPlan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.service.riControlPlan.ControlPlanDetailService;
import danger.service.riControlPlan.ControlPlanService;
import danger.utils.ResourcesUtil;

@Controller
@Scope("prototype")
public class ExportRiskInfoExcelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//通过传入的管控计划id得到该管控计划的风险信息
	private String rictrlplanid;
	public String getRictrlplanid() {
		return rictrlplanid;
	}
	public void setRictrlplanid(String rictrlplanid) {
		this.rictrlplanid = rictrlplanid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// 导出的Excel名称
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	private String year;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	@Autowired
	private ControlPlanDetailService controlPlanDetailService;
	public ControlPlanDetailService getControlPlanDetailService() {
		return controlPlanDetailService;
	}
	public void setControlPlanDetailService(ControlPlanDetailService controlPlanDetailService) {
		this.controlPlanDetailService = controlPlanDetailService;
	}
	@Autowired
	private ControlPlanService controlPlanService;
	
	public ControlPlanService getControlPlanService() {
		return controlPlanService;
	}
	public void setControlPlanService(ControlPlanService controlPlanService) {
		this.controlPlanService = controlPlanService;
	}
	// 获取数据
	public List<RiIdentificationRriskMsg> findRiskInfoByRictrlplanId() throws Exception {

		List<RiIdentificationRriskMsg> myRiskInfoList = controlPlanDetailService.findRiskInfoByRictrlplanId(rictrlplanid);

		return myRiskInfoList;
	}
	
	
	
	
	// 2.写入Excel
		public boolean writeExamEmployees2Excel(List<RiIdentificationRriskMsg> myRiskInfoList, String fileName) throws Exception {

			RiControlPlan riControlPlan = controlPlanService.getRiControlPlanById(rictrlplanid);
			if(riControlPlan.getYear().length()==4){
				this.year=riControlPlan.getYear()+"年"+riControlPlan.getMonthorweek()+"月";
			}else{
				String xun =null;
				if(Integer.parseInt(riControlPlan.getMonthorweek())==1){
					xun="上旬";
				}else if(Integer.parseInt(riControlPlan.getMonthorweek())==2){
					xun="中旬";
				}else if(Integer.parseInt(riControlPlan.getMonthorweek())==3){
					xun="下旬";
				}
				this.year=riControlPlan.getYear().substring(0, 4)+"年"+Integer.parseInt(riControlPlan.getYear().substring(riControlPlan.getYear().length()-2, riControlPlan.getYear().length()))+"月"+riControlPlan.getMonthorweek();
			}
			
			/*
			 * 月管控计划信息
			 */
			// 标题

			String[] title1 = { "年份", "月份","专业", "专业负责人" };

			// 创建一个工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建一个工作表sheet
			HSSFSheet sheet = workbook.createSheet();
			// 设置列宽
			setColumnWidth(sheet, 8);

			// 创建第一行
			HSSFRow row0 = sheet.createRow(0);
			// 创建一个单元格
			HSSFCell cell0 = row0.createCell(5);
			if (cell0 != null) {

				// 设置样式
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION); // 设置字体居中
				// 设置字体
				HSSFFont font = workbook.createFont();
				font.setFontName("宋体");
				font.setFontHeight((short)3);// 字体加粗
				// font.setFontHeight((short)12);
				font.setFontHeightInPoints((short) 20);
				cellStyle.setFont(font);
				cell0.setCellStyle(cellStyle);

				// 写入数据
				cell0.setCellValue("月管控计划信息");

			}
			// 创建第二行
			HSSFRow row1 = sheet.createRow(1);
			// 创建一个单元格
			HSSFCell cell1 = null;

			for (int j = 0 ; j < 10; j ++) {
				cell1 = row1.createCell(j);
				// 设置样式
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION); // 设置字体居中
				// 设置字体
				HSSFFont font = workbook.createFont();
				font.setFontName("宋体");
				font.setFontHeight((short)3);// 字体加粗
				// font.setFontHeight((short)12);
				font.setFontHeightInPoints((short) 13);
				cellStyle.setFont(font);
				cell1.setCellStyle(cellStyle);

				// 写入数据
				if(j==1){
					cell1.setCellValue(title1[0]);
				}
				if(j==3){
					cell1.setCellValue(title1[1]);
				}
				if(j==5){
					cell1.setCellValue(title1[2]);
				}
				if(j==7){
					cell1.setCellValue(title1[3]);
				}
				
				System.out.println("cell1" + cell1);

			}

			// 创建第三行
			HSSFRow row2 = sheet.createRow(2);
			for (int j = 0; j < 8; j = j + 1) {
				cell1 = row2.createCell(j);
				// 设置数据
				if (j == 1) {
					cell1.setCellValue(riControlPlan.getYear());

				}
				if (j == 3) {
					cell1.setCellValue(riControlPlan.getMonthorweek());
					
				}
				if (j == 5) {
					cell1.setCellValue(riControlPlan.getSpecialty());
					

				}
				if (j == 7) {
					cell1.setCellValue(riControlPlan.getLeader());
				}

			}

			/*
			 * 月管控计划风险信息
			 */
			
			
			
			// 创建第五行
			HSSFRow row5 = sheet.createRow(5);
			// 创建一个单元格
			HSSFCell cell5 = row5.createCell(5);
			if (cell5 != null) {

				// 设置样式
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION); // 设置字体居中
				// 设置字体
				HSSFFont font = workbook.createFont();
				font.setFontName("宋体");
				font.setFontHeight((short)3);// 字体加粗
				// font.setFontHeight((short)12);
				font.setFontHeightInPoints((short) 20);
				cellStyle.setFont(font);
				cell5.setCellStyle(cellStyle);

				// 写入数据
				cell5.setCellValue("月管控计划风险信息");
				System.out.println("cell5" + cell5);
			}
			/*
			 * 培训信息
			 */
			// 标题

			String[] title = { "风险地点", "风险描述", "风险类型", "专业类型", "灾害类型", "可能导致事故", "管控措施","负责人","监管人","监管周期" };
			// 创建第六行
			HSSFRow row = sheet.createRow(6);
			// 创建一个单元格
			HSSFCell cell = null;
			// 创建表头
			for (int i = 0; i < title.length; i++) {
				cell = row.createCell(i);
				// 设置样式
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION); // 设置字体居中
				// 设置字体
				HSSFFont font = workbook.createFont();
				font.setFontName("宋体");
				font.setFontHeight((short)3);// 字体加粗

				font.setFontHeightInPoints((short) 13);
				cellStyle.setFont(font);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(title[i]);

			}

			// 写入数据
			// 从第六行开始追加数据
			for (int i = 7; i < (myRiskInfoList.size() + 7); i++) {
				// 创建第i行
				HSSFRow nextRow = sheet.createRow(i);
				// 获取数据
				RiIdentificationRriskMsg riIdentificationRriskMsg = myRiskInfoList.get(i - 7);

				for (int j = 0; j < 10; j++) {
					
					HSSFCell cell2 = nextRow.createCell(j);
					if (j == 0) {
						cell2.setCellValue(riIdentificationRriskMsg.getRiskaddress());
					}
					if (j == 1) {
						cell2.setCellValue(riIdentificationRriskMsg.getRiskdescribe());
					}
					if (j == 2) {
						cell2.setCellValue(riIdentificationRriskMsg.getRisktype());
					}
					if (j == 3) {
						cell2.setCellValue(riIdentificationRriskMsg.getProfessionaltypes());
					}
					if (j == 4) {
						cell2.setCellValue(riIdentificationRriskMsg.getDisastertypes());
					}
					if (j == 5) {
						cell2.setCellValue(riIdentificationRriskMsg.getCancauseaccidents());
					}
					if (j == 6) {
						cell2.setCellValue(riIdentificationRriskMsg.getCtrlmeasure());
					}
					if (j == 7) {
						cell2.setCellValue(riIdentificationRriskMsg.getPrincipal());
					}
					if (j == 8) {
						cell2.setCellValue(riIdentificationRriskMsg.getSuperintendent());
					}
					if (j == 9) {
						cell2.setCellValue(riIdentificationRriskMsg.getMonitoringperiod());
					}

				}
			}

			// 创建一个文件
			File file = new File(fileName);
			// 如果存在就删除
			if (file.exists()) {
				file.delete();
			}
			try {
				file.createNewFile();
				// 打开文件流
				FileOutputStream outputStream = FileUtils.openOutputStream(file);

				workbook.write(outputStream);
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
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

		// 3.打开文件的流提供下载
		public InputStream getInputStream() throws Exception {
			this.create();// 创建文件到指定目录下
			// String path =
			// ServletActionContext.getServletContext().getRealPath("/files/examEmployeesExcel");
			String filepath = ResourcesUtil.getValue("path", "excel") + fileName + ".xls";

			File file = new File(filepath);
			// 只用返回一个输入流

			return FileUtils.openInputStream(file);// 打开文件
		}

		// 产生Excel到文件夹下面
		public void create() throws Exception {
			// 获取工程下的路径
			// String path =
			// ServletActionContext.getServletContext().getRealPath("/files/examEmployeesExcel");
			String filepath = ResourcesUtil.getValue("path", "excel") + fileName + ".xls";
			// 获取文件
			List<RiIdentificationRriskMsg> examEmployees = this.findRiskInfoByRictrlplanId();
			this.writeExamEmployees2Excel(examEmployees, filepath);
		}

		// 文件下载名
		public String getDownloadFileName() {
			String downloadFileName = "";
			String filename = year+"管控计划" + ".xls";

			try {
				downloadFileName = URLEncoder.encode(filename, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return downloadFileName;
		}

		@Override
		public String execute() throws Exception {
			// 先将名字设为秒数产生唯一的名字
			// this.setFileName(String.valueOf(System.currentTimeMillis()));
			this.setFileName(rictrlplanid);
			return super.execute();
		}

}
