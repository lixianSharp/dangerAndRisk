package danger.service.riIdentity;

import java.sql.SQLException;
import java.util.Map;

import danger.bean.riIdentify.RiAssessment;
import danger.utils.PageBean;
//风险评估
public interface RiAssessmentService {
	/**
	 * 添加风险评估信息
	 * @param riAssessment
	 * @return
	 * @throws Exception
	 */
	public boolean addRiAssessment(RiAssessment riAssessment) throws Exception;
	
	/**
	 * 修改风险评估信息
	 * @param riAssessment
	 * @return
	 * @throws Exception
	 */
	public boolean updateRiAssessment(RiAssessment riAssessment) throws Exception;
	
	/**
	 * 根据风险评估id 删除风险评估信息
	 * @param assessmentid
	 * @return
	 * @throws Exception
	 */
	public boolean deleteRiAssessment(String assessmentid) throws Exception;
	
	
	/**
	 * 组合条件查询 风险辨识主表信息
	 * @param currentPage 当前页页号
	 * @param currentCount 每页显示的记录数
	 * @param condition  组合查询条件
	 * @return
	 * @throws SQLException
	 */
	public PageBean<RiAssessment> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception;
}
