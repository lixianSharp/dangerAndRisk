package danger.bean.sys;

/**
 * 机构实体
 * @author yuanyr
 *
 */
public class Department {
	
    private String departmentId;   
    private String upDepartmentId;
    private String name;
    private String manager;
    private String phone;
    
    
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getUpDepartmentId() {
		return upDepartmentId;
	}
	public void setUpDepartmentId(String upDepartmentId) {
		this.upDepartmentId = upDepartmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}