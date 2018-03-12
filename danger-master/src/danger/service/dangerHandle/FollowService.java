package danger.service.dangerHandle;

import java.util.List;

import danger.bean.dangerHandle.Follow;

/**
 * 跟踪service
 * 
 * @author QizoLiQiang
 * @time 2017年9月2日下午6:22:42
 */
public interface FollowService {

	/**
	 * 增加跟踪信息。1.增加一条跟踪记录。2.修改隐患状态为已整改
	 * 
	 * @param follow
	 * @return
	 * @throws Exception
	 */
	public boolean addFollow(Follow follow) throws Exception;

	/**
	 * 根据跟踪id删除跟踪信息(级联删除)
	 * 
	 * @param sidingId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFollowById(Integer sidingId) throws Exception;

	/**
	 * 修改跟踪信息
	 * 
	 * @param follow
	 *            修改后的跟踪信息
	 * @return
	 * @throws Exception
	 */
	public boolean updateFollowById(Follow follow) throws Exception;

	/**
	 * 根据隐患编号查询跟踪信息
	 * 
	 * @param dangerId
	 * @return
	 * @throws Exception
	 */
	public List<Follow> getFollowsByDangerId(Integer dangerId) throws Exception;

}
