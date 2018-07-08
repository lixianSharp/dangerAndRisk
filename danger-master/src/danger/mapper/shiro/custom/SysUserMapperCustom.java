package danger.mapper.shiro.custom;

import java.util.List;
import java.util.Map;

import danger.bean.shiro.SysUser;

public interface SysUserMapperCustom {
	/**
	 * 按组合条件查询所有账户信息 
	 * @param map 封装组合条件的map集合
	 * @return
	 * @throws Exception
	 */
	public List<SysUser> findUserByCondition(Map<String,Object> map)throws Exception;
	
	/**
	 * 按组合条件查询所有账户信息的总条数 
	 * @param map 封装组合条件的map集合
	 * @return
	 * @throws Exception
	 */
	public Integer findUserCountByCondition(Map<String,Object> map)throws Exception;

}