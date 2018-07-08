package danger.service.lxyTestUtil.sysShiro;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestSysPermission {
	
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
	
	@Autowired
	private AuthManagerService authManagerService;
	
	//根据用户id(sys_user表中的用户id)查询查询该用户所拥有的权限
	@Test
	public void findPermissionListByUserId() throws Exception{
		List<SysPermission> permissionList = sysPermissionMapperCustom.findPermissionListByUserId("rootid");
		System.out.println(permissionList.size()+"条数");
		for(SysPermission per:permissionList){
			System.out.println(per);
		}
	}
	
	//步骤一：
	//注册用户(增加用户)往sys_user中添加（id用uuid）  1
	@Test
	public void insertSysUser()throws Exception{
		SysUser sysUser = new SysUser();
		sysUser.setId(UUIDUtil.getUUID2());
		sysUser.setUsercode("lixianyuan");//登陆用的账户usercode
		sysUser.setPassword("1520");//登陆用的密码
		sysUser.setUsername("李贤元");//登陆成功之后显示在右上角的名字
		sysUser.setLocked("0");
		int result = sysUserMapper.insert(sysUser);
		System.out.println("结果:"+result);//1
	}
	
	//步骤二：
	//将sys_user中新增加的用户添加到sys_user_role中(sys_user_role中的id用uuid生成，sys_user_id就是sys_user中那个账户对应的主键id，sys_role_id用uuid生成一个)
	@Test
	public void insertSysUserRole()throws Exception{
		
		
		/**
		 * 根据帐户名从sys_user中获取账户信息
		 */
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo("lixianyuan");//这里面的参数是需要从其他地方获取的
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		if(sysUserList.size()>0){
			SysUser sysUser = sysUserList.get(0);
			
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setId(UUIDUtil.getUUID2());//用uuid生成
			sysUserRole.setSysUserId(sysUser.getId());//该用户在sys_user中对应的主键id
			sysUserRole.setSysRoleId(UUIDUtil.getUUID2());//用uuid生成一个
			sysUserRoleMapper.insert(sysUserRole);
		}
		System.out.println(sysUserList.get(0));
		
		/*sysUserRole.setSysUserId(sysUserId);//该用户在sys_user中对应的主键id
		sysUserRole.setSysRoleId(UUIDUtil.getUUID2());//用uuid生成一个
		sysUserRoleMapper.insert(sysUserRole);*/
	}
	
	//步骤三
	//给用户分配权限sys_role_permission(id用uuid生成，sys_role_id 从sys_user_role表中的user_role_id获取，sys_permission_id就是对应的权限的id)
	@Test
	public void permissionToUser()throws Exception{
		//这个方法的参数：账户名也就是usercode,参数二：权限表sys_permission的主键id
		
		//根据账户名usercode去sys_user中查询该账户的信息
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo("lixianyuan");//这里面的参数是需要从其他地方获取的
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
				authorToUser(sysRoleId,new String[]{"31","32"});
			}
			
		}
		
		System.out.println("ok");
		
		
	}

	/**
	 * 给用户分配权限,一次可以分配多个权限
	 * @param sysRoleId
	 * @param auths 需要添加的所有权限的标识(主键id)
	 */
	private void authorToUser(String sysRoleId,String[] auths) {
		for(int i=0;i<auths.length;i++){
			//进行授权操作，将信息添加到sys_role_permission表中
			//(主键id用uuid生成，sys_role_id就是sysRoleId的值，sys_permission_id就是sys_permission表中对应的权限的主键id)
			SysRolePermission sysRolePermission = new SysRolePermission();
			sysRolePermission.setId(UUIDUtil.getUUID2());//用uuid生成
			sysRolePermission.setSysRoleId(sysRoleId);
			sysRolePermission.setSysPermissionId(auths[i]);//权限表sys_role_permission中对应权限的的主键id
			sysRolePermissionMapper.insert(sysRolePermission);
		}
		
	}
	
	
	
	//根据用户账户usercode修改账户密码
	@Test
	public void updateSysUser()throws Exception{
		//参数一：用户的帐户名：usercode;  参数二：密码
		
		//根据帐户名usercode获取账户信息
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo("lixianyuan");//帐户名：usercode
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		if(sysUserList.size()>0){
			SysUser sysUser = sysUserList.get(0);
			sysUser.setPassword("1521");//密码
			int result = sysUserMapper.updateByPrimaryKeySelective(sysUser);
			System.out.println("结果:"+result);//1
		}
		
		/*SysUser sysUser = new SysUser();
		sysUser.setId(UUIDUtil.getUUID2());
		sysUser.setUsercode("lixianyuan");//登陆用的账户usercode
		sysUser.setPassword("1521");//登陆用的密码
		sysUser.setUsername("李贤元");//登陆成功之后显示在右上角的名字
		sysUser.setLocked("0");*/
		
	}
	
	
	/**
	 * 删除账户
	 * 参数：只需要一个用户账户的 usercode,也就是登陆需要用的账户
	 * @throws Exception
	 */
	@Test
	public void delUser()throws Exception{
		
		
		//步骤：
		//先根据账户名usercode获取账户信息
		//根据帐户名usercode获取账户信息
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo("lxyusercode");//帐户名：usercode
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
		//String sysRolePermissionId = sysRolePermission.getId();
		
		//System.out.println(sysUserId+":"+sysRoleId+":"+permissionIds);
		
		//根据sysUserId从sys_user_role中获取sys_user_role中的sys_role_id的值
		
		
		
		//1 先删除sys_role_permission中对应的数据 
		//根据sys_role_id从sys_role_permission表中删除所有
		for(String permissionId:permissionIds){
			sysRolePermissionMapper.deleteByPrimaryKey(permissionId);
		}
		
		
		//2 删除sys_user_role中的对应的数据 
		sysUserRoleMapper.deleteByPrimaryKey(sysUserRoleId);
		
		//3 删除sys_user中对应的数据
		sysUserMapper.deleteByPrimaryKey(sysUserId);
		
		System.out.println("ok");
		
	}
	
	
	
	
	
	
	//查询所有用户账户信息  按组合条件查询
	@Test
	public void findAllUser()throws Exception{
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("usercode", "li");
		map.put("username", "李");
		//map.put("username", "李");

		PageBean<SysUser> sysUserCondition = findAllUserCondition(1, 10, map);
		List<SysUser> productList = sysUserCondition.getProductList();
		for(SysUser sysUser:productList){
			System.out.println("信息："+sysUser);
		}
		
		int currentCount = sysUserCondition.getCurrentCount();//10 每页显示的记录数
		int currentPage = sysUserCondition.getCurrentPage();//1  当前页页号
		int totalCount = sysUserCondition.getTotalCount();//4  总记录数
		int totalPage = sysUserCondition.getTotalPage();//1  总页数
		System.out.println(currentCount+":"+currentPage+":"+totalCount+":"+totalPage);//10:1:4:1
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
	 * 查询符合条件的权限信息
	 * @throws Exception
	 */
	@Test
	public void testPermission()throws Exception{
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("usercode", "");

		PageBean<SysPermission> sysPermissionCondition = findAllSysPermissionCondition(1, 10, map);
		List<SysPermission> productList = sysPermissionCondition.getProductList();
		for(SysPermission sysPermission:productList){
			System.out.println(sysPermission);
		}
		
		int currentCount = sysPermissionCondition.getCurrentCount();//10 每页显示的记录数
		int currentPage = sysPermissionCondition.getCurrentPage();//1  当前页页号
		int totalCount = sysPermissionCondition.getTotalCount();//39 总记录数
		int totalPage = sysPermissionCondition.getTotalPage();//4  总页数
		System.out.println(currentCount+":"+currentPage+":"+totalCount+":"+totalPage);//10:1:39:4
	}
	
	
	/**
	 * 查询符合查询条件的 权限信息
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
	
	
	
	//根据账户名usercode查询该账户下的已经分配的所有权限
	@Test
	public void findPermissionBySysUserUsercode()throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("usercode", "root");
		PageBean<SysPermission> pageBean = authManagerService.findSysUserAllPermission(2, 10, condition);
		List<SysPermission> productList = pageBean.getProductList();
		for(SysPermission sysPermission:productList){
			System.out.println(sysPermission);
		}
		
		int currentCount = pageBean.getCurrentCount();//10 每页显示的记录数
		int currentPage = pageBean.getCurrentPage();//1  当前页页号
		int totalCount = pageBean.getTotalCount();//39 总记录数
		int totalPage = pageBean.getTotalPage();//4  总页数
		System.out.println(currentCount+":"+currentPage+":"+totalCount+":"+totalPage);//10:1:39:4
		
	}
	
	
	//分割字符串
	@Test
	public void splitStr()throws Exception{
		String str = "31,32,33,34,35";
		
		String[] permissionIds = str.split(",");
		System.out.println("长度:"+permissionIds.length);
		for(String s:permissionIds){
			System.out.print(s+" ");
		}
	}
	
	/**
	 * 查询登陆账户名是否存在
	 * @throws Exception
	 */
	@Test
	public void findSysUserusercode()throws Exception{
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo("lixianyuan");
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		if(sysUserList.size()>0){
			SysUser sysUser = sysUserList.get(0);
			System.out.println(sysUser);
			System.out.println("存在");
		}else{
			System.out.println("不存在");
		}
	}
	
	
	
	
	
}

