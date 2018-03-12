package danger.mapper.dangerManage;

import danger.bean.dangerManage.Rechecktable;
import danger.bean.dangerManage.RechecktableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechecktableMapper {
    int countByExample(RechecktableExample example);
    
    int deleteByExample(RechecktableExample example);
    
    int deleteByPrimaryKey(Integer recheckid);

    int insert(Rechecktable record);

    int insertSelective(Rechecktable record);

    List<Rechecktable> selectByExample(RechecktableExample example);

    Rechecktable selectByPrimaryKey(Integer recheckid);

    int updateByExampleSelective(@Param("record") Rechecktable record, @Param("example") RechecktableExample example);

    int updateByExample(@Param("record") Rechecktable record, @Param("example") RechecktableExample example);

    int updateByPrimaryKeySelective(Rechecktable record);

    int updateByPrimaryKey(Rechecktable record);
}