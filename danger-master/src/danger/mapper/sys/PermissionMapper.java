package danger.mapper.sys;

import danger.bean.sys.Permission;
import danger.bean.sys.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(String permissionid);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(String permissionid);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}