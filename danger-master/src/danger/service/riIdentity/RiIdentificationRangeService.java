package danger.service.riIdentity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.queryView.DangerSiding;
import danger.bean.riIdentify.RiIdentificationRange;
import danger.utils.PageBean;
//风险辨识范围
public interface RiIdentificationRangeService {
	
	/**
	 * 添加风险辨识范围
	 * @param riIdentificationRange
	 * @return
	 * @throws Exception
	 */
	public boolean addRiIdentificationRange(RiIdentificationRange riIdentificationRange)throws Exception;
	
	
	/**
	 * 根据风险辨识范围的id 删除风险辨识范围信息
	 * @param idenranid
	 * @return
	 * @throws Exception
	 */
	public boolean delRiIdentificationRange(String  idenranid)throws Exception;
	
	
	/**
	 * 修改风险辨识范围信息
	 * @param riIdentificationRange
	 * @return
	 * @throws Exception
	 */
	public boolean updateRiIdentificationRange(RiIdentificationRange riIdentificationRange)throws Exception;
	
	
	/**
	 * 组合条件查询 风险辨识范围信息
	 * @param currentPage 当前页页号
	 * @param currentCount 每页显示的记录数
	 * @param condition  组合查询条件
	 * @return
	 * @throws SQLException
	 */
	public PageBean<RiIdentificationRange> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception;
	
	
	/**
	 * 查询所有风险辨识范围信息
	 * @return
	 * @throws Exception
	 */
	public List<RiIdentificationRange> findAllRiIdentificationRange()throws Exception;
	
}
