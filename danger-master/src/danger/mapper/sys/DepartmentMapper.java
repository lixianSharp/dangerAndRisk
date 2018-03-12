package danger.mapper.sys;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import danger.bean.sys.Department;
import danger.bean.sys.DepartmentExample;

public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(String departmentid);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String departmentid);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    
    /*2017.9.3 by yuanyr*/
    
    /**
	 * 查询机构树信息
	 * @return
	 */
	public List<Map<String,Object>> getUnitTree();
	
	
	/**
	 * 添加机构
	 * @param department
	 * @return
	 * @throws SQLException
	 */
	public boolean addUnit(Department department) throws SQLException;
	
	
	/**
	 * 根据机构id删除机构
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteUnit(String departmentId) throws SQLException;
	
	
	/**
	 * 修改机构信息 
	 * @param department
	 * @return
	 * @throws SQLException
	 */
	public boolean updateUnit(Department department) throws SQLException;
	
	
	/**
	 * 根据departmentId查询机构信息
	 * @param departmentId
	 * @return
	 * @throws SQLException
	 */
	public Department getUnitByUnitId(String departmentId) throws SQLException;
	
	
	/**
	 * 根据upDepartmentId查询机构信息
	 * @param upDepartmentId
	 * @return
	 * @throws SQLException
	 */
	public List<Department> getUnitByUpUnitId(String upDepartmentId) throws SQLException;
	
	
	/**
	 * 按条件查询机构 
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<Department> getUnitByConditon(Map<String,Object> condition) throws SQLException;
	
	
	/**
	 * 根据上级机构Id查询下一个要插入的下一级机构Id
	 * @param upDepartmentId
	 * @return
	 * @throws SQLException
	 */
	public String getNextUnitId(String upDepartmentId) throws SQLException;
	
	//lxy
	/**
	 *  根据上级机构id查询其最大的下一级机构编号 
	 */
    public String getMaxUnitIdByUpUnitId(String updepartmentid)throws SQLException;
}