package danger.mapper.dangerHandle;

import danger.bean.dangerHandle.Sidingbiao;
import danger.bean.dangerHandle.SidingbiaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SidingbiaoMapper {
    int countByExample(SidingbiaoExample example);

    int deleteByExample(SidingbiaoExample example);

    int deleteByPrimaryKey(Integer sidingid);

    int insert(Sidingbiao record);

    int insertSelective(Sidingbiao record);

    List<Sidingbiao> selectByExample(SidingbiaoExample example);

    Sidingbiao selectByPrimaryKey(Integer sidingid);

    int updateByExampleSelective(@Param("record") Sidingbiao record, @Param("example") SidingbiaoExample example);

    int updateByExample(@Param("record") Sidingbiao record, @Param("example") SidingbiaoExample example);

    int updateByPrimaryKeySelective(Sidingbiao record);

    int updateByPrimaryKey(Sidingbiao record);
}