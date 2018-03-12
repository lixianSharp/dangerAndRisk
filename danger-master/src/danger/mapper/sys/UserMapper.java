package danger.mapper.sys;

import danger.bean.sys.Permission;
import danger.bean.sys.User;
import danger.bean.sys.UserExample;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<Permission> getPermissionObjectfromUserByUserId(Integer userId);
    
    Set<String> getPermissionStringfromUserByUserId(Integer userId);
}