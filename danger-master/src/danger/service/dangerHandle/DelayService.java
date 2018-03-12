package danger.service.dangerHandle;

import danger.bean.dangerHandle.Delay;

/**
 * 五定延期Service
 * 
 * @author QizoLiQiang
 * @time 2017年9月2日下午6:15:35
 */
public interface DelayService {

	/**
	 * 增加延期记录。1.增加一条延迟记录。2.修改五定表的整改时间为最新的时间
	 * 
	 * @param delay
	 * @return
	 * @throws Exception
	 */
	public boolean addDelay(Delay delay) throws Exception;

	/**
	 * 根据延期id删除记录(级联删除)
	 * 
	 * @param delayId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteDelayById(Integer delayId) throws Exception;

	/**
	 * 修改延期记录
	 * 
	 * @param delay
	 *            修改后的记录
	 * @return
	 * @throws Exception
	 */
	public boolean updateDelayById(Delay delay) throws Exception;

}
