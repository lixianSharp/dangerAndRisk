package danger.service.dangerManage;

import java.util.Map;

import danger.bean.dangerManage.Danger;
import danger.utils.PageBean;

/**
 * 隐患服务
 * 
 * @author QizoLiQiang
 */
public interface DangerService {

	/**
	 * 隐患添加
	 * 
	 * @param danger
	 *            隐患记录
	 * @return 是否成功
	 * @throws Exception
	 */
	public boolean addDanger(Danger danger) throws Exception;

	/**
	 * 删除记录(级联删除)
	 * 
	 * @param id
	 *            隐患id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteDangerById(Integer id) throws Exception;

	/**
	 * 修改一条隐患
	 * 
	 * @param danger
	 *            修改后的记录
	 * @return
	 * @throws Exception
	 */
	public boolean updateDangerById(Danger danger) throws Exception;

	/**
	 * 根据隐患编号修改隐患状态
	 * 
	 * @param dangerId
	 *            隐患编号
	 * @param status
	 *            新的隐患状态
	 * @return
	 * @throws Exception
	 */
	public boolean updateDangerStatus(Integer dangerId, String status) throws Exception;

	/**
	 * 根据id查询单个
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Danger getDangerById(Integer id) throws Exception;


	/**
	 * 根据机构名称获取机构的负责人  也就是根据责任单位名称获取责任单位的负责人 
	 */
	String getManagerByDepartmentName(String departmentname);
}
