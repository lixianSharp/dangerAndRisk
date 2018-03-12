package danger.mapper.sys.custom;

import java.util.List;
import java.util.Map;

import danger.bean.sys.Department;

public interface DepartmentCustomMapper {

	int getDepartmentCountByDepartmentId(Map<String, Object> condition);

	List<Department> findDepartmentByCondition(Map<String, Object> condition);

}
