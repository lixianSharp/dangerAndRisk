package danger.mapper.sys;

import danger.bean.sys.Role;
import danger.bean.sys.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String roleid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String roleid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}