package danger.mapper.dangerHandle;

import danger.bean.dangerHandle.Delay;
import danger.bean.dangerHandle.DelayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DelayMapper {
    int countByExample(DelayExample example);

    int deleteByExample(DelayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Delay record);

    int insertSelective(Delay record);

    List<Delay> selectByExample(DelayExample example);

    Delay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Delay record, @Param("example") DelayExample example);

    int updateByExample(@Param("record") Delay record, @Param("example") DelayExample example);

    int updateByPrimaryKeySelective(Delay record);

    int updateByPrimaryKey(Delay record);
}