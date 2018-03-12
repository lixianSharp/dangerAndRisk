package danger.action.sys.unit;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import danger.bean.sys.Department;
import danger.service.sys.DepartmentService;

/**
 * 更新机构action
 * @author yuanyr
 *
 */
@SuppressWarnings("serial")
@Component
public class UpdateUnitAction extends ActionSupport implements ModelDriven<Department> {
	
	private Department department = new Department();
	private Department result;
	private boolean updateResult;
   
	@Resource
	private DepartmentService departmentService;
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getResult() {
		return result;
	}

	public void setResult(Department result) {
		this.result = result;
	}

	public boolean isUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(boolean updateResult) {
		this.updateResult = updateResult;
	}


	/**
	 * 更新机构信息
	 * @return
	 */
	public String updateUnit() {
		boolean updateResult = false;
		try {
			updateResult = departmentService.updateUnit(department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(updateResult){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	/**
	 * 查找要更新的机构
	 * @return
	 */
	public String getUpdateUnit(){
		try {
			result = departmentService.getUnitByUnitId(department.getDepartmentId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

}