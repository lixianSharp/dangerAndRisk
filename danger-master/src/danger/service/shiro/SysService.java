package danger.service.shiro;

import java.util.List;

import danger.bean.shiro.ActiveUser;
import danger.bean.shiro.SysPermission;
import danger.bean.shiro.SysUser;

/**
 * 认证授权服务接口
 * @author 贤元
 *
 */
public interface SysService {
	
	/**
	 * 根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
	 * @param userCode
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public ActiveUser authenticat(String userCode,String password) throws Exception;
	
	/**
	 * 根据用户账号查询用户信息
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public SysUser findSysUserByUserCode(String userCode)throws Exception;
	
	/**
	 * 根据用户id查询权限范围的菜单
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	/**
	 * 根据用户id查询权限范围的url
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
