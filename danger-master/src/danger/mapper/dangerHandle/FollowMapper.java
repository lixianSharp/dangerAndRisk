package danger.mapper.dangerHandle;

import danger.bean.dangerHandle.Follow;
import danger.bean.dangerHandle.FollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FollowMapper {
    int countByExample(FollowExample example);

    int deleteByExample(FollowExample example);

    int deleteByPrimaryKey(Integer followid);

    int insert(Follow record);

    int insertSelective(Follow record);

    List<Follow> selectByExample(FollowExample example);

    Follow selectByPrimaryKey(Integer followid);

    int updateByExampleSelective(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByExample(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);
}