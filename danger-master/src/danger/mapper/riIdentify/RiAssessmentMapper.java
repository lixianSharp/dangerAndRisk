package danger.mapper.riIdentify;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riIdentify.RiAssessment;
import danger.bean.riIdentify.RiAssessmentExample;

public interface RiAssessmentMapper {
    long countByExample(RiAssessmentExample example);

    int deleteByExample(RiAssessmentExample example);

    int deleteByPrimaryKey(String assessmentid);

    int insert(RiAssessment record);

    int insertSelective(RiAssessment record);

    List<RiAssessment> selectByExample(RiAssessmentExample example);

    RiAssessment selectByPrimaryKey(String assessmentid);

    int updateByExampleSelective(@Param("record") RiAssessment record, @Param("example") RiAssessmentExample example);

    int updateByExample(@Param("record") RiAssessment record, @Param("example") RiAssessmentExample example);

    int updateByPrimaryKeySelective(RiAssessment record);

    int updateByPrimaryKey(RiAssessment record);
}