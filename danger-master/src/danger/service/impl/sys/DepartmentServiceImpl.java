package danger.service.impl.sys;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.sys.Department;
import danger.bean.sys.Dictionary;
import danger.mapper.sys.DepartmentMapper;
import danger.mapper.sys.custom.DepartmentCustomMapper;
import danger.service.sys.DepartmentService;
import danger.utils.PageBean;

/**
 * 机构service实现类
 * 
 * @author yuanyr
 *
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentMapper departmentMapper;

	@Override
	public List<Map<String, Object>> getUnitTree() {
		// TODO Auto-generated method stub
		return departmentMapper.getUnitTree();
	}
	
	
	@Resource
	private DepartmentCustomMapper departmentCustomMapper;

	public DepartmentMapper getDepartmentMapper() {
		return departmentMapper;
	}

	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}

	public DepartmentCustomMapper getDepartmentCustomMapper() {
		return departmentCustomMapper;
	}

	public void setDepartmentCustomMapper(DepartmentCustomMapper departmentCustomMapper) {
		this.departmentCustomMapper = departmentCustomMapper;
	}

	@Override
	public boolean addUnit(Department department) throws SQLException {
		// TODO Auto-generated method stub
		return departmentMapper.addUnit(department);
	}

	@Override
	public boolean deleteUnit(String departmentId) throws SQLException {
		// TODO Auto-generated method stub
		return departmentMapper.deleteUnit(departmentId);
	}

	@Override
	public boolean updateUnit(Department department) throws SQLException {
		// TODO Auto-generated method stub
		return departmentMapper.updateUnit(department);
	}

	@Override
	public Department getUnitByUnitId(String departmentId) throws SQLException {
		// TODO Auto-generated method stub
		return departmentMapper.getUnitByUnitId(departmentId);
	}

	@Override
	public List<Department> getUnitByUpUnitId(String upDepartmentId) throws SQLException {
		// TODO Auto-generated method stub
		return departmentMapper.getUnitByUpUnitId(upDepartmentId);
	}

	//按条件查询
	/*@Override
	public List<Department> getUnitByConditon(Map<String, Object> condition) throws SQLException {
		// TODO Auto-generated method stub
		return departmentMapper.getUnitByConditon(condition);
	}*/

	//按条件查询分页
	@Override
	public PageBean<Department> getUnitByConditon(Map<String, Object> condition) throws SQLException {

		PageBean<Department> pageBean = new PageBean<Department>();
	
		
		/*pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);*/
		
		// 1、当前页private int currentPage;
		String strcurrentPage = (String) condition.get("currentPage");
		int currentPage = Integer.valueOf(strcurrentPage);

		pageBean.setCurrentPage(currentPage);
		
		System.out.println("当前页currentPage"+currentPage);

		// 2、当前页显示的条数private int currentCount;
		String strcurrentCount = (String) condition.get("currentCount");
		int currentCount = Integer.valueOf(strcurrentCount);

		pageBean.setCurrentCount(currentCount);
		
		System.out.println("当前页显示的条数currentCount"+currentCount);
		
		// 3、总条数private int totalCount;
		int totalCount = 0;
		//调用dao方法
		totalCount = departmentCustomMapper.getDepartmentCountByDepartmentId(condition);
		
		pageBean.setTotalCount(totalCount);
		
		System.out.println("总记录数totalCount"+totalCount);
		
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		
		System.out.println("总页数totalPage"+totalPage);
		
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();

		/*
		 * * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		
		System.out.println("index"+index);
		System.out.println("currentCount"+currentCount);
		
		
		pageBean.setProductList(departmentCustomMapper.findDepartmentByCondition(condition));
		System.out.println("pageBean.getProductList()"+pageBean.getProductList());
		return pageBean;
	}

	/*@Override
	public String getNextUnitId(String upDepartmentId) throws SQLException {
		// TODO Auto-generated method stub
		return departmentMapper.getNextUnitId(upDepartmentId);
	}*/

	// lxy
	/**
	 * 查询即将新增机构的id(根据上级机构编号查询插入的下级机构的编号)
	 * 
	 * @param updepartmentid
	 *            上级机构id
	 * @return 新增机构的id
	 * @throws SQLException
	 */
	@Override
	public String getNextUnitId(String updepartmentid) throws SQLException {
		// 新增机构的id
		String newUnitId = "";

		String maxUnitId = departmentMapper.getMaxUnitIdByUpUnitId(updepartmentid);
		if ("10".equals(updepartmentid)) {
			// 1如果是最顶层的机构
			// 1.1判断其是否有下一级机构，如果没有的话添加的机构的id为=100
			// 1.2如果有下一级机构，则根据查询其下一级机构的最大编号，则添加的机构的id=（下一级机构的最大编号+100）

			// 1.1
			if (maxUnitId == null) {
				newUnitId = "100";
			} else {
				// 1.2
				newUnitId = String.valueOf((Integer.parseInt(maxUnitId) + 100));
			}
		} else {
			// 2不是最顶层的机构的情况
			// 2.1判断其是否有下一级机构，如果没有的话添加的机构的id为=上级机构的id+"001"
			// 2.2如果有下一级机构，则根据查询其下一级机构的最大编号，则添加的机构的id=（下一级机构的最大编号+1）+"001"

			// 2.1
			if (maxUnitId == null) {

				// 2.1
				newUnitId = updepartmentid + "001";
			} else {
				// 2.2
				newUnitId = String.valueOf(Integer.parseInt(maxUnitId) + 1);
			}
		}
		return newUnitId;
	}

}