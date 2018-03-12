package danger.service.dangerManage;

import java.util.List;

import danger.bean.dangerManage.Rechecktable;

/**
 * Service
 * 
 * @author QizoLiQiang
 * @time 2017年9月2日下午6:29:18
 */
public interface RechecktableService {

	/**
	 * 增加复查记录1.增加一条复查信息。2.修改隐患表状态为已复查
	 * 
	 * @param recheckTable
	 * @return
	 * @throws Exception
	 */
	public boolean addRechecktable(Rechecktable recheckTable) throws Exception;

	/**
	 * 根据复查id删除复查信息。(级联删除)
	 * 
	 * @param recheeckTableId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteRechecktableById(Integer recheckTableId) throws Exception;

	/**
	 * 根据隐患编号查询信息集合
	 * 
	 * @param dangerId
	 * @return
	 * @throws Exception
	 */
	public List<Rechecktable> getRechecktableByDangerId(Integer dangerId) throws Exception;
	
	/**
	 * 根据复查编号查询复查信息
	 * @param recheckId
	 * @return
	 * @throws Exception
	 */
	public Rechecktable getRechecktableByRecheckId(Integer recheckId) throws Exception;
	/**
	 * 根据跟踪id查询复查信息
	 * @param followid
	 * @return
	 * @throws Exception
	 */
	public Rechecktable getRechecktableByFollowId(Integer followid) throws Exception;
}
