package danger.mapper.shiro.custom;

import java.util.List;
import java.util.Map;

import danger.bean.shiro.SysPermission;

/**
 * 权限mapper
 * @author 贤元
 *
 */
public interface SysPermissionMapperCustom {
	
	//根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
	//根据用户id查询权限url
	public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;

	/**
	 * 按组合条件查询从权限表sys_permission中的权限信息
	 * @param map 封装查询条件
	 * @return 符合查询条件的所有权限信息
	 * @throws Exceptoin
	 */
	//public List<SysPermission> findSysPermissionByCondition(Map<String,Object> map)throws Exception;


	/**
	 * 按组合条件从权限表sys_permission中查询符合条件的总记录数
	 * @param map 封装查询条件
	 * @return 符合查询条件的总记录数
	 * @throws Exception
	 */
	//public Integer findSysPermissionCountByCondition(Map<String,Object> map)throws Exception;
	
	/**
	 * 根据登陆帐户名usercode 查询该账户未分配的权限
	 * @param map 封装查询条件
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findNotPermissionByUsercode(Map<String,Object> map)throws Exception;
	
	 /**
	  * 根据登陆帐户名usercode 查询该账户未分配的权限的总记录数
	  * @param map 封装查询条件
	  * @return
	  * @throws Exception
	  */
	public Integer findNotPermissionCountByUsercode(Map<String,Object> map)throws Exception;


	
	
		
	
	
	/**
	 * 根据账户的主键id在sys_permission中获取该权限主键id对应的权限名称 
	 * @param map 封装usercode 当前页页号：index 每页显示的记录数：currentCount
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findSysUserPermissionbyUsercode(Map<String,Object> map)throws Exception;
	

	/**
	 * 根据账户的的主键id在sys_permission中获取该权限的总记录数 
	 * @param usercode 登陆的帐户名
	 * @return
	 * @throws Exception
	 */
	public Integer findSysUserPermissionCountbyUsercode(Map<String,Object> map)throws Exception;
	  
	  
}
