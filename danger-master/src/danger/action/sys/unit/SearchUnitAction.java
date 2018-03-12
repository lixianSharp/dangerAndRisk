package danger.action.sys.unit;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.sys.Department;
import danger.service.sys.DepartmentService;
import danger.utils.PageBean;
import danger.utils.ValidateCheck;

/**
 * 查询机构action
 * @author yuanyr
 *
 */
@SuppressWarnings("serial")
@Component
public class SearchUnitAction extends ActionSupport {

	private String upDepartmentId; //上级部门编号 
//	private String result;         //返回的结果
	private String nextId;         //下级中下一个部门的编号 
	private String departmentId;   //部门的编号--查询条件
	private String name;           //部门的名称 --查询条件
	
	@Resource
	private DepartmentService departmentService;
	
	
	public String getUpDepartmentId() {
		return upDepartmentId;
	}

	public void setUpDepartmentId(String upDepartmentId) {
		this.upDepartmentId = upDepartmentId;
	}

/*	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}*/

	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
/**
 * 分页相关的
 */
		private String currentPage;
		private String currentCount;
		public String getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(String currentPage) {
			this.currentPage = currentPage;
		}

		public String getCurrentCount() {
			return currentCount;
		}

		public void setCurrentCount(String currentCount) {
			this.currentCount = currentCount;
		}
		
		// 将action中得到的值返回到jsp中
		private Map<String, Object> result;
		public Map<String, Object> getResult() {
			return result;
		}

		public void setResult(Map<String, Object> result) {
			this.result = result;
		}
	
	/**
	 * 通过上级id查询
	 * @return
	 */
	public String searchUnitByUpId(){
		
		try {
			//返回自己的子节点
			//department = departmentService.getUnitByUpUnitId(upDepartmentId);
			//Department unit=departmentService.getUnitByUnitId(upDepartmentId);
			//返回自己本身
			//department.add(unit);
			//将java对象转化为json对象
			/*JSONArray jsonArray = JSONArray.fromObject(department);
			//返回给Ajax
			this.result = jsonArray.toString();*/
			
			PageBean<Department> department;
			result = new HashMap<String,Object>();
			Map<String,Object> condition = new HashMap<String,Object>();
			condition = generateCondition(condition);
			
		/*	condition.put("departmentId", departmentId);
			condition.put("name", name);*/
			
			department = departmentService.getUnitByConditon(condition);
			System.out.println("department"+department);
			
			result.put("pageBean", department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	/**
	 * 通过条件查询机构
	 * @return
	 */
	public String searchUnitByCondition(){
		//List<Department> department;
		PageBean<Department> department;
		try {
			
			result = new HashMap<String,Object>();
			Map<String,Object> condition = new HashMap<String,Object>();
			condition = generateCondition(condition);
			
		/*	condition.put("departmentId", departmentId);
			condition.put("name", name);*/
			
			department = departmentService.getUnitByConditon(condition);
			System.out.println("department"+department);
			//将java对象转化为json对象
			/*JSONArray jsonArray = JSONArray.fromObject(department);
			//返回给Ajax
			this.result = jsonArray.toString();*/
			
			result.put("pageBean", department);
		} catch (SQLException e) {
		}
		return SUCCESS;
	}
	
	
	/*
	 * 将条件判断之后放到一个集合中
	 */
	private Map<String, Object> generateCondition(Map<String, Object> condition) {
		if (currentPage == null || "".equals(currentPage.trim())) {
			currentPage = "1";
			condition.put("currentPage", currentPage);
		}
		if (currentCount == null || "".equals(currentCount.trim())) {
			currentCount = "10";
			condition.put("currentCount", currentCount);
		}
		if (ValidateCheck.isNotNull(currentCount)) {
			
			condition.put("currentCount", currentCount);
		}
		if (ValidateCheck.isNotNull(currentPage)) {
			
			condition.put("currentPage", currentPage);
		}
		if (ValidateCheck.isNotNull(departmentId)) {
			condition.put("departmentId", departmentId);
			
		}
		if (ValidateCheck.isNotNull(name)) {
			condition.put("name", name);
			
		}
		if(ValidateCheck.isNotNull(upDepartmentId)){
			condition.put("upDepartmentId", upDepartmentId);
		}

		return condition;
	}


	/**
	 * 查询即将新增机构的id
	 * @return
	 */
	public String searchNextUnitId(){
		try {
			nextId =departmentService.getNextUnitId(upDepartmentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}