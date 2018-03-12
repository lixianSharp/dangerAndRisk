package danger.service.sys;

import java.util.List;
import java.util.Set;

import danger.bean.sys.Permission;
import danger.bean.sys.User;

public interface UserService {

	/**
	 * 根据用户id获取用户信息
	 * @param userName
	 * @return
	 */
	public User getUserById(Integer userId) throws Exception;
	
	/**
	 * 传入用户名 username、密码 password
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public boolean login(String username,String password) throws Exception;
	
	/**
	 * 根据用户Id获取用户所拥有的权限对象集合
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Permission> getPermissionObjectfromUserByUserId(Integer userId) throws Exception;
	
	/**
	 * 根据用户Id获取用户所拥有的权限编号集合
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Set<String> getPermissionStringfromUserByUserId(Integer userId) throws Exception;
}
