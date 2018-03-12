//package danger.service.impl.sys;
//
//import java.util.List;
//import java.util.Set;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//import org.apache.struts2.ServletActionContext;
//import org.springframework.stereotype.Service;
//
//import danger.bean.sys.Permission;
//import danger.bean.sys.User;
//import danger.mapper.sys.UserMapper;
//import danger.service.sys.UserService;
//
//@Service
//public class UserServiceImpl implements UserService {
//	
//	@Resource
//	private UserMapper userMapper;
//	
//	/**
//	 * 根据用户id获取用户信息
//	 * @param userName
//	 * @return
//	 */
//	@Override
//	public User getUserById(Integer userId) throws Exception {
//		return userMapper.selectByPrimaryKey(userId);
//	}
//
//	/**
//	 * 传入用户名 username、密码 password
//	 * @param username 用户名
//	 * @param password 密码
//	 * @return
//	 */
//	@Override
//	public boolean login(String username, String password) {
//		HttpServletRequest request=ServletActionContext.getRequest();
//		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
//		Subject currentUser=SecurityUtils.getSubject();
//		User user=null;		
//		try {
//			currentUser.login(token);
//			user=(User) currentUser.getPrincipal();
//			Session session=currentUser.getSession();
//			session.setAttribute("userInfo", user);
//			return true;
//		} catch (Exception e) {
//			 request.setAttribute("errorinfo", "用户名或密码错误");
//			 return false;
//		}
//	}
//	
//	/**
//	 * 根据用户Id获取用户所拥有的权限
//	 * @param userId
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public List<Permission> getPermissionObjectfromUserByUserId(Integer userId) throws Exception {
//		List<Permission> permissions=userMapper.getPermissionObjectfromUserByUserId(userId);
//		return permissions;
//	}
//
//
//	@Override
//	public Set<String> getPermissionStringfromUserByUserId(Integer userId) throws Exception {
//		Set<String> permissionids=userMapper.getPermissionStringfromUserByUserId(userId);
//		return permissionids;
//	}
//
//}
