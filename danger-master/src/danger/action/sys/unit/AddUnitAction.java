package danger.action.sys.unit;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import danger.bean.sys.Department;
import danger.service.sys.DepartmentService;

/**
 * 添加机构action
 * @author yuanyr
 *
 */
@SuppressWarnings("serial")
@Component
public class AddUnitAction extends ActionSupport implements ModelDriven<Department> {
	
	private Department department = new Department();
	private boolean addResult;

	@Resource
	private DepartmentService departmentService;
	

	public boolean isAddResult() {
		return addResult;
	}

	public void setAddResult(boolean addResult) {
		this.addResult = addResult;
	}

	
	/**
	 * 添加机构方法
	 * @return
	 */
	public String addUnit(){
		boolean addResult = false;
		try {
			String currentUnitId = departmentService.getNextUnitId(department.getUpDepartmentId());
			department.setDepartmentId(currentUnitId);
			addResult = departmentService.addUnit(department);
			this.addResult = addResult;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Logger logger = Logger.getLogger(AddUnitAction.class);
			logger.info(logger);
		}
		if (addResult) {
			return SUCCESS;
		} 
		return ERROR;
	}

	
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

}