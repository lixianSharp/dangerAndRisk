package danger.service.riResponsibility;

import java.sql.SQLException;
import java.util.Map;

import danger.bean.riIdentify.RiIdentificationRange;
import danger.bean.riIdentify.RiResponsibility;
import danger.utils.PageBean;

//岗位职责分工矩阵
public interface RiResponsibilityService {
	
	/**
	 * 添加岗位职责
	 * @param riResponsibility
	 * @return 是否成功
	 * @throws Exception
	 */
	public boolean addRiResponsibility(RiResponsibility riResponsibility)throws Exception;
	
	/**
	 * 根据岗位职责id删除岗位职责
	 * @param respid
	 * @return
	 * @throws Exception
	 */
	public boolean deleteRiResponsibility(String respid)throws Exception;
	
	
	/**
	 * 修改岗位职责 
	 * @param riResponsibility 修改后的岗位职责bean
	 * @return
	 * @throws Exception
	 */
	public boolean updateRiResponsibility(RiResponsibility riResponsibility) throws Exception;
	
	/**
	 * 根据岗位职责id获取岗位职责信息
	 * @param respid 岗位职责id
	 * @return 岗位职责信息
	 * @throws Exception
	 */
	public RiResponsibility findRiResponsibilityById(String respid)throws Exception;
	
	/**
	 * 组合条件查询 岗位职责分工信息
	 * @param currentPage 当前页页号
	 * @param currentCount 每页显示的记录数
	 * @param condition  组合查询条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<RiResponsibility> findRiResponsibilityByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception;
	
	
}
