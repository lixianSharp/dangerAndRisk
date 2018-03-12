package danger.mapper.riIdentify;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riIdentify.RiResponsibility;
import danger.bean.riIdentify.RiResponsibilityExample;

public interface RiResponsibilityMapper {
    long countByExample(RiResponsibilityExample example);

    int deleteByExample(RiResponsibilityExample example);

    int deleteByPrimaryKey(String respid);

    int insert(RiResponsibility record);

    int insertSelective(RiResponsibility record);

    List<RiResponsibility> selectByExample(RiResponsibilityExample example);

    RiResponsibility selectByPrimaryKey(String respid);

    int updateByExampleSelective(@Param("record") RiResponsibility record, @Param("example") RiResponsibilityExample example);

    int updateByExample(@Param("record") RiResponsibility record, @Param("example") RiResponsibilityExample example);

    int updateByPrimaryKeySelective(RiResponsibility record);

    int updateByPrimaryKey(RiResponsibility record);
}