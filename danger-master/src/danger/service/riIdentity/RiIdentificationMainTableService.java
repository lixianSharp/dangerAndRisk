package danger.service.riIdentity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.utils.PageBean;
//风险辨识主表
public interface RiIdentificationMainTableService {

	/**
	 * 添加风险辨识主表信息
	 * @param riIdentificationMainTable
	 * @return
	 * @throws Exception
	 */
	public boolean addRiIdentificationMainTable(RiIdentificationMainTable riIdentificationMainTable)throws Exception;
	
	/**
	 * 修改风险辨识主表信息
	 * @param riIdentificationMainTable
	 * @return
	 * @throws Exception
	 */
	public boolean updateRiIdentificationMainTable(RiIdentificationMainTable riIdentificationMainTable)throws Exception;
	
	
	/**
	 * 根据风险辨识主表id删除风险辨识主表信息 (级联删除，要先删除辨识风险信息表信息(直接调用删除辨识风险信息表的service方法)，最后再删除风险辨识主表信息)
	 * @param identiryid
	 * @return
	 * @throws Exception
	 */
	public boolean delRiIdentificationMainTable(String identiryid)throws Exception;
	
	
	
	
	/**
	 * 组合条件查询 风险辨识主表信息
	 * @param currentPage 当前页页号
	 * @param currentCount 每页显示的记录数
	 * @param condition  组合查询条件
	 * @return
	 * @throws SQLException
	 */
	public PageBean<RiIdentificationMainTable> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception;
	
	
	/**
	 * 根据组合条件查询风险辨识主表信息及其对应的辨识风险信息
	 * @param condition 组合查询条件
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> findIdentifyMainAndRiskMsgByCondition(Map<String,Object> condition)throws Exception;
	
	
	/**
	 * 根据组合条件查询风险辨识主表信息及其对应的辨识风险信息 的总记录数
	 * @param condition  组合查询条件     index ， currentCount  identiryid
	 * @return 
	 * @throws Exception
	 */
	public Integer getIdentifyMainAndRiskMsgCountByCondition(Map<String,Object> condition) throws Exception;
	
	/**
	 * 根据主键id获取辨识主表信息
	 * @param identiryid
	 * @return  辨识主表信息的javabean
	 * @throws Exception
	 */
	public RiIdentificationMainTable findIdentifyMainByIdentifyId(String identiryid) throws Exception;
	
	
	/**
	 * 根据风险辨识主表年份 查询该是否有该年度的年度辨识主表信息 
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public List<RiIdentificationMainTable> selIdentifyMainByYear(Map<String,Object>	condition)throws Exception;
	
}
