package danger.mapper.dangerHandle;

import danger.bean.dangerHandle.Spotdispose;
import danger.bean.dangerHandle.SpotdisposeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpotdisposeMapper {
    int countByExample(SpotdisposeExample example);

    int deleteByExample(SpotdisposeExample example);

    int deleteByPrimaryKey(Integer disposeid);

    int insert(Spotdispose record);

    int insertSelective(Spotdispose record);

    List<Spotdispose> selectByExample(SpotdisposeExample example);

    Spotdispose selectByPrimaryKey(Integer disposeid);

    int updateByExampleSelective(@Param("record") Spotdispose record, @Param("example") SpotdisposeExample example);

    int updateByExample(@Param("record") Spotdispose record, @Param("example") SpotdisposeExample example);

    int updateByPrimaryKeySelective(Spotdispose record);

    int updateByPrimaryKey(Spotdispose record);
}