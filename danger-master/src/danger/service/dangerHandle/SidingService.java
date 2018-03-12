package danger.service.dangerHandle;

import java.util.List;
import java.util.Map;

import danger.bean.dangerHandle.Delay;
import danger.bean.dangerHandle.Follow;
import danger.bean.dangerHandle.Sidingbiao;

/**
 * 五定service
 * 
 * @author QizoLiQiang
 * @time 2017年9月2日下午5:55:24
 */
public interface SidingService {

	/**
	 * 增加五定记录。1.增加五定记录2.修改隐患状态为已五定3.往延迟表中增加一条记录
	 * 
	 * @param siding
	 * @return
	 * @throws Exception
	 */
	public boolean addSiding(Sidingbiao siding) throws Exception;

	/**
	 * 通过id删除(级联删除)
	 * 
	 * @param id
	 *            五定编号
	 * @return
	 * @throws Exception
	 */
	public boolean deleteSidingById(Integer id) throws Exception;

	/**
	 * 修改五定
	 * 
	 * @param siding
	 * @return
	 * @throws Exception
	 */
	public boolean updateSiding(Sidingbiao siding) throws Exception;

	/**
	 * 根据id查询五定以及隐患信息
	 * 
	 * @param id
	 *            隐患编号
	 * @return 第一个是隐患基本信息，第二个是五定集合
	 * @throws Exception
	 */
	public Map<String, Object> getSidingById(Integer dangerId) throws Exception;

	/**
	 * 根据五定编号查询五定延期记录
	 * 
	 * @param id
	 *            五定编号
	 * @return
	 * @throws Exception
	 */
	public List<Delay> getDelaysBySidingId(Integer sidingId) throws Exception;

	/**
	 * 根据五定编号查询跟踪信息
	 * 
	 * @param sidingId
	 * @return
	 * @throws Exception
	 */
	public Follow getFollowBySidingId(Integer sidingId) throws Exception;

	/******* leilong *******/
	/**
	 * 根据五定编号查询五定信息
	 * 
	 * @param sidingId
	 *            五定编号
	 * 
	 * @return
	 * @throws Exception
	 */
	public Sidingbiao getSidingInfoBySidingId(Integer sidingId) throws Exception;

}
