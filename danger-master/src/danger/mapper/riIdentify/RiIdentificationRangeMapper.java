package danger.mapper.riIdentify;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riIdentify.RiIdentificationRange;
import danger.bean.riIdentify.RiIdentificationRangeExample;

public interface RiIdentificationRangeMapper {
    long countByExample(RiIdentificationRangeExample example);

    int deleteByExample(RiIdentificationRangeExample example);

    int deleteByPrimaryKey(String idenranid);

    int insert(RiIdentificationRange record);

    int insertSelective(RiIdentificationRange record);

    List<RiIdentificationRange> selectByExample(RiIdentificationRangeExample example);

    RiIdentificationRange selectByPrimaryKey(String idenranid);

    int updateByExampleSelective(@Param("record") RiIdentificationRange record, @Param("example") RiIdentificationRangeExample example);

    int updateByExample(@Param("record") RiIdentificationRange record, @Param("example") RiIdentificationRangeExample example);

    int updateByPrimaryKeySelective(RiIdentificationRange record);

    int updateByPrimaryKey(RiIdentificationRange record);
}