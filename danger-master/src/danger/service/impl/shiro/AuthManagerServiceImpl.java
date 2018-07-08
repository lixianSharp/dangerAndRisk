package danger.service.impl.shiro;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import danger.bean.shiro.SysPermission;
import danger.bean.shiro.SysRolePermission;
import danger.bean.shiro.SysRolePermissionExample;
import danger.bean.shiro.SysUser;
import danger.bean.shiro.SysUserExample;
import danger.bean.shiro.SysUserExample.Criteria;
import danger.bean.shiro.SysUserRole;
import danger.bean.shiro.SysUserRoleExample;
import danger.mapper.shiro.SysRolePermissionMapper;
import danger.mapper.shiro.SysUserMapper;
import danger.mapper.shiro.SysUserRoleMapper;
import danger.mapper.shiro.custom.SysPermissionMapperCustom;
import danger.mapper.shiro.custom.SysUserMapperCustom;
import danger.service.shiro.AuthManagerService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;

/**
 * 权限管理接口的实现类
 * @author 贤元
 *
 */
@Service
public class AuthManagerServiceImpl implements AuthManagerService{
	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserMapperCustom sysUserMapperCustom;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;
	
	//这个先不弄
	//根据用户id(sys_user表中的用户id)查询查询该用户所拥有的权限
	@Test
	public void findPermissionListByUserId(String sysUserId) throws Exception{
		List<SysPermission> permissionList = sysPermissionMapperCustom.findPermissionListByUserId(sysUserId);
		//System.out.println(permissionList.size()+"条数");
		/*for(SysPermission per:permissionList){
			System.out.println(per);
		}*/
		
	}
	
	
	//步骤一和步骤二是连贯的，执行完步骤一之后就执行步骤二
	/**
	 * 步骤一：
	 * 注册用户(增加用户)往sys_user中添加（id用uuid）  1    帐户名usercode不能重复
	 * @param sysUser 用户的javabean
	 * @return
	 * @throws Exception
	 */
	public boolean insertSysUser(SysUser sysUser)throws Exception{
		//设置主键，用uuid生成
		sysUser.setId(UUIDUtil.getUUID2());
		//sysUser.setUsercode("lixianyuan");//登陆用的账户usercode
		//sysUser.setPassword("1520");//登陆用的密码
		//sysUser.setUsername("李贤元");//登陆成功之后显示在右上角的名字
		sysUser.setLocked("0");
		int result = sysUserMapper.insert(sysUser);
		if(result>0){//说明添加成功
			boolean insertSysUserRole = insertSysUserRole(sysUser.getUsercode());//添加成功返回true，否则返回false
			return insertSysUserRole;
		}
		return false;
	}
	
	
	/**
	 * 步骤二：
	 * 将sys_user中新增加的用户添加到sys_user_role中(sys_user_role中的id用uuid生成，sys_user_id就是sys_user中那个账户对应的主键id，sys_role_id用uuid生成一个)
	 * @param usercode用户登陆的帐户名
	 * @return 是否操作成功,成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean insertSysUserRole(String usercode)throws Exception{
		/**
		 * 根据帐户名从sys_user中获取账户信息
		 */
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);//这里面的参数是需要从其他地方获取的，用户登录的帐户名usercode
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		if(sysUserList.size()>0){
			SysUser sysUser = sysUserList.get(0);
			
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setId(UUIDUtil.getUUID2());//用uuid生成
			sysUserRole.setSysUserId(sysUser.getId());//该用户在sys_user中对应的主键id
			sysUserRole.setSysRoleId(UUIDUtil.getUUID2());//用uuid生成一个
			int insertResult = sysUserRoleMapper.insert(sysUserRole);//执行添加
			return insertResult>0?true:false;
		}
		return false;
	}
	
	//步骤三
	//给用户分配权限sys_role_permission(id用uuid生成，sys_role_id 从sys_user_role表中的user_role_id获取，sys_permission_id就是对应的权限的id)
	/**
	 * 给用户分配权限
	 * @param usercode 用户的登陆帐户名
	 * @param sysPermissionIds 权限的主键id 是一个数组，表示可以同时进行多个权限的分配
	 * @return 返回是否分配成功的标志
	 * @throws Exception
	 */
	public boolean permissionToUser(String usercode,String[] sysPermissionIds)throws Exception{
		boolean flag = false;
		//这个方法的参数：账户名也就是usercode,参数二：权限表sys_permission的主键id，他是一个数组，可以同时进行多个权限的分配
		
		//根据账户名usercode去sys_user中查询该账户的信息
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);//这里面的参数是需要从其他地方获取的,登陆帐户名usercode
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		if(sysUserList.size()>0){
			SysUser sysUser = sysUserList.get(0);
			System.out.println(sysUser);
			//根据账户主键id获取sysUserRole信息
			//根据该账户信息获取该账户的主键id，然后根据该主键id=sys_user_role表中的sys_user_id，获取该用户对应的sys_user_role中的javabean，之后获取sys_role_id
			SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
			danger.bean.shiro.SysUserRoleExample.Criteria createCriteria = sysUserRoleExample.createCriteria();
			createCriteria.andSysUserIdEqualTo(sysUser.getId());
			
			List<SysUserRole> sysUserRoleList = sysUserRoleMapper.selectByExample(sysUserRoleExample);
			if(sysUserRoleList.size()>0){
				SysUserRole sysUserRole = sysUserRoleList.get(0);
				System.out.println(sysUserRole);
				//获取sysRoleid,之后进行授权操作
				String sysRoleId = sysUserRole.getSysRoleId();//授权操作需要用的
				//参数一：该用户在sys_user_role表中对应的sysRoleId
				flag = authorToUser(sysRoleId,sysPermissionIds);//如果全部执行成功就返回true
			}
			
		}
		
		return flag;
		
	}

	/**
	 * 给用户分配权限,一次可以分配多个权限
	 * @param sysRoleId
	 * @param auths 需要添加的所有权限的标识(主键id)
	 */
	private boolean authorToUser(String sysRoleId,String[] auths) {
		boolean flag = true;
		for(int i=0;i<auths.length;i++){
			//进行授权操作，将信息添加到sys_role_permission表中
			//(主键id用uuid生成，sys_role_id就是sysRoleId的值，sys_permission_id就是sys_permission表中对应的权限的主键id)
			SysRolePermission sysRolePermission = new SysRolePermission();
			sysRolePermission.setId(UUIDUtil.getUUID2());//用uuid生成
			sysRolePermission.setSysRoleId(sysRoleId);
			sysRolePermission.setSysPermissionId(auths[i]);//权限表sys_role_permission中对应权限的的主键id
			int result = sysRolePermissionMapper.insert(sysRolePermission);
			if(result<1){
				flag=false;
			}
		}
		return flag;
	}
	
	
	
	
	/**
	 * 根据用户账户usercode修改账户密码
	 * @param usercode用户登录的帐户名
	 * @param password 密码
	 * @param username 登陆成功之后显示在右上角的名字(可以理解为职称)
	 * @return 是否修改成功，修改成功返回true,否则返回false
	 * @throws Exception
	 */
	public boolean updateSysUser(String usercode,String password,String username)throws Exception{
		//参数一：用户的帐户名：usercode;  参数二：密码,参数三：username:登陆成功之后显示在右上角的名字
		
		//根据帐户名usercode获取账户信息
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);//帐户名：usercode
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		if(sysUserList.size()>0){
			SysUser sysUser = sysUserList.get(0);
			sysUser.setPassword(password);//密码
			sysUser.setUsername(username);//登陆成功之后显示在右上角的名字
			int result = sysUserMapper.updateByPrimaryKeySelective(sysUser);
			return result>0?true:false;
		}
		return false;
	}
	
	
	
	/**
	 * 删除账户
	 * 参数：只需要一个用户账户的 usercode,也就是登陆需要用的账户
	 * @param usercode 用户登录的帐户名 usercode
	 * @return
	 * @throws Exception
	 */
	public boolean delUser(String usercode)throws Exception{
		//步骤：
		//先根据账户名usercode获取账户信息
		//根据帐户名usercode获取账户信息
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);//帐户名：usercode
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		SysUser sysUser = null;
		if(sysUserList.size()>0){
			 sysUser = sysUserList.get(0);
		}
		
		//one
		String sysUserId = sysUser.getId();//3 中用于删除数据需要用的
		
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		danger.bean.shiro.SysUserRoleExample.Criteria createCriteria = sysUserRoleExample.createCriteria();
		createCriteria.andSysUserIdEqualTo(sysUser.getId());
		
		List<SysUserRole> sysUserRoleList = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		SysUserRole sysUserRole = null;
		if(sysUserRoleList.size()>0){
			 sysUserRole = sysUserRoleList.get(0);
		}
		
		//two
		String sysUserRoleId = sysUserRole.getId();//2 中用于删除数据需要的
		String sysRoleId = sysUserRole.getSysRoleId();
		
		
		SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
		danger.bean.shiro.SysRolePermissionExample.Criteria createCriteria2 = sysRolePermissionExample.createCriteria();
		createCriteria2.andSysRoleIdEqualTo(sysRoleId);
		List<SysRolePermission> sysRolePermissionList = sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
		//存储该用户在sys_user_role表中所对应的所有权限信息的id
		List<String> permissionIds = new ArrayList<String>();//1 中删除需要的主键id
		if(sysRolePermissionList.size()>0){
			for(SysRolePermission sysrolepermission:sysRolePermissionList){
				permissionIds.add(sysrolepermission.getId());
			}
		}
		
		//three
		
		boolean flag = true;

		//1 先删除sys_role_permission中对应的数据 
		//根据sys_role_id从sys_role_permission表中删除所有
		for(String permissionId:permissionIds){
			int deleteResult = sysRolePermissionMapper.deleteByPrimaryKey(permissionId);
			if(deleteResult<1){
				flag = false;
			}
		}
		
		//2 删除sys_user_role中的对应的数据 
		int result2 = sysUserRoleMapper.deleteByPrimaryKey(sysUserRoleId);
		
		//3 删除sys_user中对应的数据
		int result3 = sysUserMapper.deleteByPrimaryKey(sysUserId);
		
		return flag&&(result2>0?true:false)&&(result3>0?true:false);
	}
	
	
	
	/**
	 * 查询所有用户账户信息  按组合条件查询
	 * @param currentPage 当前页页号(不需要进行处理的)
	 * @param currentCount 每页显示的记录数
	 * @param map 查询条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<SysUser> findAllUser(int currentPage, int currentCount,Map<String,Object> map)throws Exception{
		PageBean<SysUser> sysUserCondition = findAllUserCondition(currentPage, currentCount, map);
		
		return sysUserCondition;
	}
	
	
	/**
	 * 组合条件查询
	 * @param currentPage 当前页页号
	 * @param currentCount 每页显示的记录数
	 * @param condition 封装查询条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<SysUser> findAllUserCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<SysUser> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = sysUserMapperCustom.findUserCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);// 当前页页号
		condition.put("currentCount", currentCount);// 每页显示的记录数
		List<SysUser> sysUserList = sysUserMapperCustom.findUserByCondition(condition);
		pageBean.setProductList(sysUserList);

		return pageBean;
	}
	
	
	
	/**
	 * 根据登陆帐户名usercode 查询该账户未分配的所有权限的信息
	 * @param currentPage  当前页页号(不需要处理的)
	 * @param currentCount 每页显示的记录数
	 * @param map 封装查询的组合条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<SysPermission> findPermissionByCondition(int currentPage, int currentCount,
			Map<String, Object> map)throws Exception{
		
		PageBean<SysPermission> sysPermissionCondition = findAllSysPermissionCondition(currentPage, currentCount, map);
		List<SysPermission> productList = sysPermissionCondition.getProductList();

		return sysPermissionCondition;
	}
	
	
	/**
	 * 根据登陆帐户名usercode 查询该账户未分配的所有权限的信息
	 * @param currentPage 当前页页号
	 * @param currentCount 每页显示的记录数
	 * @param condition 查询条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<SysPermission> findAllSysPermissionCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<SysPermission> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = sysPermissionMapperCustom.findNotPermissionCountByUsercode(condition);
		pageBean.setTotalCount(totalCount);
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);// 当前页页号
		condition.put("currentCount", currentCount);// 每页显示的记录数
		List<SysPermission> sysUserList = sysPermissionMapperCustom.findNotPermissionByUsercode(condition);
		pageBean.setProductList(sysUserList);

		return pageBean;
	}


	
	//根据账户的主键id在sys_permission中获取该权限主键id对应的权限名称
	public PageBean<SysPermission> findSysUserAllPermission(int currentPage,int currentCount,Map<String,Object> condition) throws Exception{
		PageBean<SysPermission> pageBean = findSysUserPermissionByusercode(currentPage, currentCount, condition);
		return pageBean;
	}
	
	/**
	 *根据账户的主键id在sys_permission中获取该权限主键id对应的权限名称
	 * @param currentPage 当前页页号(不需要处理的)
	 * @param currentCount 每页显示的记录数
	 * @param condition 条件
	 * @return
	 * @throws Exception
	 */
	public PageBean<SysPermission> findSysUserPermissionByusercode(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<SysPermission> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = sysPermissionMapperCustom.findSysUserPermissionCountbyUsercode(condition);
		pageBean.setTotalCount(totalCount);
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);// 当前页页号
		condition.put("currentCount", currentCount);// 每页显示的记录数
		List<SysPermission> sysUserList = sysPermissionMapperCustom.findSysUserPermissionbyUsercode(condition);
		pageBean.setProductList(sysUserList);

		return pageBean;
	}
	
		
	
	/**
	 * 根据权限id(sys_permission_id)从sys_role_permission表中删除对应用户的数据
	 * @param sysPermissionId
	 * @return
	 * @throws Exception
	 */
	public boolean delPermissionById(String sysPermissionId)throws Exception{
		//根据sys_permission_id获取sys_role_permission表中对应的主键
		SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
		danger.bean.shiro.SysRolePermissionExample.Criteria criteria = sysRolePermissionExample.createCriteria();
		criteria.andSysPermissionIdEqualTo(sysPermissionId);
		List<SysRolePermission> sysRolePermissionList = sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
		if(sysRolePermissionList!=null&&sysRolePermissionList.size()>0){
			SysRolePermission sysRolePermission = sysRolePermissionList.get(0);
			//根据sys_role_permission的主键id删除对应的数据
			int result = sysRolePermissionMapper.deleteByPrimaryKey(sysRolePermission.getId());
			return result>0?true:false;
		}
		
		return false;
	}
	
	
	
	/**
	 * 查询登陆账户名是否存在
	 * @param usercode 帐户名
	 * @return 存在返回true，不存在返回false
	 * @throws Exception
	 */
	public boolean findSysUserusercode(String usercode)throws Exception{
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		if(sysUserList.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	
	//根据登陆帐户名查询该账户所未分配的权限
	
}
