package danger.service.shiro;

import java.util.List;
import java.util.Map;

import danger.bean.shiro.SysPermission;
import danger.bean.shiro.SysUser;
import danger.utils.PageBean;

/**
 * 权限管理的接口
 * @author 贤元
 *
 */
public interface AuthManagerService {
	
	/**
	 * 步骤一：
	 * 注册用户(增加用户)往sys_user中添加（id用uuid）  1    帐户名usercode不能重复
	 * 
	 * 步骤一和步骤二是连贯的，执行完步骤一之后就执行步骤二
	 * @param sysUser 用户的javabean
	 * @return
	 * @throws Exception
	 */
	public boolean insertSysUser(SysUser sysUser)throws Exception;
	
	//步骤三
	//给用户分配权限sys_role_permission(id用uuid生成，sys_role_id 从sys_user_role表中的user_role_id获取，sys_permission_id就是对应的权限的id)
	/**
	 * 给用户分配权限
	 * @param usercode 用户的登陆帐户名
	 * @param sysPermissionIds 权限的主键id 是一个数组，表示可以同时进行多个权限的分配
	 * @return 返回是否分配成功的标志
	 * @throws Exception
	 */
	public boolean permissionToUser(String usercode,String[] sysPermissionIds)throws Exception;
		
		
	/**
	 * 根据用户账户usercode修改账户密码
	 * @param usercode用户登录的帐户名
	 * @param password 密码
	 * @param username 登陆成功之后显示在右上角的名字(可以理解为职称)
	 * @return 是否修改成功，修改成功返回true,否则返回false
	 * @throws Exception
	 */
	public boolean updateSysUser(String usercode,String password,String username)throws Exception;
	
	/**
	 * 删除账户
	 * 参数：只需要一个用户账户的 usercode,也就是登陆需要用的账户
	 * @param usercode 用户登录的帐户名 usercode
	 * @return
	 * @throws Exception
	 */
	public boolean delUser(String usercode)throws Exception;
	
	
	/**
	 * 组合体条件查询查询所有用户账户信息  按组合条件查询
	 * @param currentPage 当前页页号(不需要进行处理的)
	 * @param currentCount 每页显示的记录数
	 * @param map 查询条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<SysUser> findAllUser(int currentPage, int currentCount,Map<String,Object> map)throws Exception;
	
	
	/**
	 * 组合条件查询符合条件的权限信息
	 * @param currentPage  当前页页号(不需要处理的)
	 * @param currentCount 每页显示的记录数
	 * @param map 封装查询的组合条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<SysPermission> findPermissionByCondition(int currentPage, int currentCount,
			Map<String, Object> map)throws Exception;
	
	
	/**
	 * 查询账户所拥有的所有权限
	 * 根据账户的主键id在sys_permission中获取该权限主键id对应的权限名称
	 * @param currentPage
	 * @param currentCount
	 * @param condition
	 * @throws Exception
	 */
	public PageBean<SysPermission>   findSysUserAllPermission(int currentPage,int currentCount,Map<String,Object> condition) throws Exception;
	  
	
	/**
	 * 根据权限id(sys_permission_id)从sys_role_permission表中删除对应用户的数据
	 * @param sysPermissionId
	 * @return
	 * @throws Exception
	 */
	public boolean delPermissionById(String sysPermissionId)throws Exception;
	
	/**
	 * 查询登陆账户名是否存在
	 * @param usercode 帐户名
	 * @return 存在返回true，不存在返回false
	 * @throws Exception
	 */
	public boolean findSysUserusercode(String usercode)throws Exception;
}
