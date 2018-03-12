package danger.mapper.dangerHandle.custom;

import danger.bean.dangerHandle.Spotdispose;
/**
 * xianyuan的现场处理
 * @author QizoLiQiang
 * @time 2017年9月8日下午3:05:58
 */
public interface SpotdisposeCustomMapper {
	
	public Spotdispose selectByDangerId(Integer dangerId);
	
}
