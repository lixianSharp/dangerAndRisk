package danger.service.dangerHandle;

import java.util.Map;

import danger.bean.dangerHandle.Spotdispose;

/**
 * 现场处理的service
 * 
 * @author QizoLiQiang
 * @time 2017年9月2日下午6:52:05
 */
public interface SpotDisposeService {

	/**
	 * 增加现场处理 。1. 先增加现场处理记录 2.修改隐患状态为已现场处理
	 * 
	 * @param spotDispose
	 * @return
	 * @throws Exception
	 */
	public boolean addSpotDispose(Spotdispose spotDispose) throws Exception;

	/**
	 * 根据id删除现场处理(级联删除)
	 * 
	 * @param spotDisposeId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteSpotDisposeById(Integer spotDisposeId) throws Exception;

	/**
	 * 修改单个现场出理
	 * 
	 * @param spotDispose
	 * @return
	 * @throws Exception
	 */
	public boolean updateSpotDisposeById(Spotdispose spotDispose) throws Exception;

	/**
	 * 根据隐患id查询现场处理信息
	 * 
	 * @param dangerId
	 *            隐患编号
	 * @return 一个map包含隐患基本信息与现场处理基本信息
	 * @throws Exception
	 */
	public Map<String, Object> getSpotDisposeByDangerId(Integer dangerId) throws Exception;
	
	/**
	 * 
	 * @param dangerId
	 * @return
	 * @throws Exception
	 */
	public Spotdispose selectByDangerId(Integer dangerId)throws Exception;

}
