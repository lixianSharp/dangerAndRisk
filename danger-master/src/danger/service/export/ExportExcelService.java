package danger.service.export;

import java.util.Map;

//导出excel的接口
public interface ExportExcelService {

	/**
	 * 导出年度辨识主表及其对应的所有辨识风险信息表数据
	 * 		这个方法将查询出来的数据保存在当前项目下的一个excel文件中
	 * @param identiryid 风险辨识主表id
	 * @return 文件名带有后缀的 例如 a.xls
	 * @throws Exception
	 */
	public String exportIdentifyMainYS(String identiryid)throws Exception;
	
	/**
	 * 导出风险清单 
	 * @param condition 查询条件  condition中不需要当前页页号和每页显示的记录数
	 * @return
	 * @throws Exception
	 */
	public String exportRiskList(Map<String,Object>condition)throws Exception;
	
	/**
	 * 导出隐患查询界面中符合查询条件的数据
	 * @param condition 封装查询条件，但是不需要封装当前页页号和每页显示的记录数
	 * @return 带后缀的文件名
	 * @throws Exception
	 */
	public String exportDangerFind(Map<String,Object>condition)throws Exception;
	
	/**
	 * 导出隐患月报
	 * @param condition 封装查询的条件，但是不封装当前页页号和每页显示的记录数
	 * @return 文件名
	 * @throws Exception
	 */
	public String exportDangerMonthReport(Map<String,Object> condition)throws Exception;
	
	/**
	 * 导出隐患日报
	 * @param condition 封装查询条件 但是不封装当前页页号和每页显示的记录数
	 * @return 文件名
	 * @throws Exception
	 */
	public String exportDangerDayReport(Map<String,Object> condition)throws Exception;
}
