package danger.action.sys.unit;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import danger.service.sys.DepartmentService;

/**
 * 删除机构action
 * @author yuanyr
 *
 */
@SuppressWarnings("serial")
@Component
public class DeleteUnitAction extends ActionSupport {

	private String departmentId;  //Ajax传过来的值（机构编号）
	private boolean deleteResult;
	
	@Resource
	private DepartmentService departmentService;
	
	
	public boolean isDeleteResult() {
		return deleteResult;
	}

	public void setDeleteResult(boolean deleteResult) {
		this.deleteResult = deleteResult;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	
	/**
	 * 删除机构方法
	 * @return
	 */
	public String deleteUnit() {
		boolean deleteResult = false;
		try {
			deleteResult = departmentService.deleteUnit(departmentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(deleteResult) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
}