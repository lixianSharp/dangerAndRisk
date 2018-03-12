package danger.mapper.dangerManage;

import danger.bean.dangerManage.Danger;
import danger.bean.dangerManage.DangerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DangerMapper {
    int countByExample(DangerExample example);

    int deleteByExample(DangerExample example);

    int deleteByPrimaryKey(Integer dangerid);

    int insert(Danger record);

    int insertSelective(Danger record);

    List<Danger> selectByExample(DangerExample example);

    Danger selectByPrimaryKey(Integer dangerid);

    int updateByExampleSelective(@Param("record") Danger record, @Param("example") DangerExample example);

    int updateByExample(@Param("record") Danger record, @Param("example") DangerExample example);

    int updateByPrimaryKeySelective(Danger record);

    int updateByPrimaryKey(Danger record);
}