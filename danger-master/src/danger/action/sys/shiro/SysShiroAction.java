package danger.action.sys.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.shiro.ActiveUser;
import danger.bean.shiro.SysPermission;
import danger.bean.shiro.SysRolePermission;
import danger.bean.shiro.SysUser;
import danger.bean.shiro.SysUserRole;
import danger.service.shiro.AuthManagerService;
import danger.shiro.CustomRealm;
import danger.utils.PageBean;

/**
 * 权限操作
 * 
 * @author 贤元
 *
 */
@Controller
@Scope("prototype")
public class SysShiroAction extends ActionSupport {

	// 要转换成json的map集合
	Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	// javabean
	private SysUser sysUser;

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	// javabean
	private SysUserRole sysUserRole;

	public SysUserRole getSysUserRole() {
		return sysUserRole;
	}

	public void setSysUserRole(SysUserRole sysUserRole) {
		this.sysUserRole = sysUserRole;
	}

	// javabean
	private SysRolePermission sysRolePermission;

	public SysRolePermission getSysRolePermission() {
		return sysRolePermission;
	}

	public void setSysRolePermission(SysRolePermission sysRolePermission) {
		this.sysRolePermission = sysRolePermission;
	}

	@Autowired
	private AuthManagerService authManagerService;

	@Autowired
	private CustomRealm customRealm;
	
	/**
	 * 注册用户，添加用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertSysUser() throws Exception {
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		// 添加用户
		boolean result = authManagerService.insertSysUser(sysUser);

		if (result) {
			map.put("result", "添加成功");
		} else {
			map.put("result", "添加失败，请重新添加");
		}
		return "ok";
	}
	
	/**
	 * 查询登陆账户名是否存在
	 * @return
	 */
	public String findUsercode()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		String usercode = ServletActionContext.getRequest().getParameter("usercode");
		boolean result = authManagerService.findSysUserusercode(usercode);
		if(result){
			map.put("result", "true");//说明该登陆账户名在数据库中存在，不能添加相同登陆账户名
		}else{
			map.put("result", "false");//说明该帐户名在数据库中不存在，可以进行添加
		}
		return "ok";
	}

	/**
	 * 为用户分配权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String permissionToUser() throws Exception {
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String usercode = request.getParameter("usercode");
		String sysPermissionIdsArray = request.getParameter("sysPermissionIds");
		String[] sysPermissionIds = sysPermissionIdsArray.split(",");// 将字符串以","分割成数组
		boolean result = authManagerService.permissionToUser(usercode, sysPermissionIds);
		if (result) {
			map.put("result", "分配成功");
		} else {
			map.put("result", "分配失败，请重新分配");
		}
		return "ok";
	}
	
	
	
	/**
	 * 根据用户账户usercode修改账户密码
	 * @param usercode用户登录的帐户名
	 * @param password 密码
	 * @param username 登陆成功之后显示在右上角的名字(可以理解为职称)
	 * @return 是否修改成功，修改成功返回true,否则返回false
	 * @throws Exception
	 */
	//public boolean updateSysUser(String usercode,String password,String username)throws Exception;
	
	/**
	 * 修改账户密码
	 * 根据用户账户usercode修改账户密码  
	 * @return
	 * @throws Exception
	 */
	public String updateSysUser()throws Exception{
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		boolean result = authManagerService.updateSysUser(sysUser.getUsercode(), sysUser.getPassword(), sysUser.getUsername());
		if (result) {
			map.put("result", "修改成功");
		} else {
			map.put("result", "修改失败，请重新修改");
		}
		
		return "ok";
	}
	
	
	
	/**
	 * 删除账户
	 * 参数：只需要一个用户账户的 usercode,也就是登陆需要用的账户名
	 * @param usercode 用户登录的帐户名 usercode
	 * @return
	 * @throws Exception
	 */
	//public boolean delUser(String usercode)throws Exception;
	/**
	 * 删除账户
	 * 	参数：只需要一个用户账户的 usercode,也就是登陆需要用的账户
	 * @return
	 * @throws Exception
	 */
	public String delUser()throws Exception{
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		String usercode = ServletActionContext.getRequest().getParameter("usercode");
		boolean result = authManagerService.delUser(usercode);
		if (result) {
			map.put("result", "删除成功");
		} else {
			map.put("result", "删除失败，请重新删除");
		}
		return "ok";
	}
	
	
	
	/**
	 * 组合条件查询查询所有用户账户信息  按组合条件查询
	 * @param currentPage 当前页页号(不需要进行处理的)
	 * @param currentCount 每页显示的记录数
	 * @param map 查询条件
	 * @return
	 * @throws Exception
	 */
	//public PageBean<SysUser> findAllUser(int currentPage, int currentCount,Map<String,Object> map)throws Exception;
	
	public String findAllUserByCondition()throws Exception{
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");
		String currentCount = request.getParameter("currentCount");
		String usercode = request.getParameter("usercode");
		String username = request.getParameter("username");
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		//进行封装一些查询条件.......
		condition.put("usercode", usercode);
		condition.put("username", username);
		PageBean<SysUser> pageBean = authManagerService.findAllUser(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		
		map.put("currentPage", currentPage);//当前页页号
		map.put("currentCount", currentCount);//每页显示的记录数
		map.put("pageBean", pageBean);
		
		return "ok";
	}
	
	
	
	/**
	 * 组合条件查询符合条件的权限信息
	 * @return
	 * @throws Exception
	 */
	public String findPermissionByCondition()throws Exception{
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");
		String currentCount = request.getParameter("currentCount");
		String usercode = request.getParameter("usercode");//登陆的帐户名
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		//进行封装一些查询条件.......
		condition.put("usercode", usercode);
		PageBean<SysPermission> pageBean = authManagerService.findPermissionByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		
		map.put("currentPage", currentPage);//当前页页号
		map.put("currentCount", currentCount);//每页显示的记录数
		map.put("pageBean", pageBean);
		
		return "ok";
	}
	
	
	
	/**
	 * 根据帐户名查询该账户下已分配的所有权限
	 * @return
	 * @throws Exception
	 */
	public String selectSysUserPermissions()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//接收从jsp页面传过来的数据
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");//当前页页号
		String currentCount = request.getParameter("currentCount");//每页显示的记录数
		String usercode = request.getParameter("usercode");//登陆帐户名
		
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("usercode", usercode);//封装usercode 登陆帐户名
		PageBean<SysPermission> pageBean = authManagerService.findSysUserAllPermission(Integer.parseInt(currentPage),Integer.parseInt(currentCount), condition);
		
		map.put("currentPage", currentPage);//当前页页号
		map.put("currentCount", currentCount);//每页显示的记录数
		map.put("pageBean", pageBean);
		
		return "ok";
	}
	

	/**
	 * 根据权限id(sys_permission_id)从sys_role_permission表中删除对应用户的数据
	 * @return
	 * @throws Exception
	 */
	public String delPermission()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String sysPermissionId = request.getParameter("sysPermissionId");
		boolean result = authManagerService.delPermissionById(sysPermissionId);
		if(result){
			map.put("result", "删除成功");
		}else{
			map.put("result", "删除失败");
		}
		return "ok";
	}
	
	//清除缓存
	/*public String clearShiroCache()throws Exception{
		//清除缓存
		customRealm.clearCached();
		return "clearShiroCache";
	}*/
	
	
	
}
