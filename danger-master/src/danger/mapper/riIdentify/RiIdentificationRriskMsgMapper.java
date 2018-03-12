package danger.mapper.riIdentify;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.bean.riIdentify.RiIdentificationRriskMsgExample;

public interface RiIdentificationRriskMsgMapper {
    long countByExample(RiIdentificationRriskMsgExample example);

    int deleteByExample(RiIdentificationRriskMsgExample example);

    int deleteByPrimaryKey(String riskmsgid);

    int insert(RiIdentificationRriskMsg record);

    int insertSelective(RiIdentificationRriskMsg record);

    List<RiIdentificationRriskMsg> selectByExample(RiIdentificationRriskMsgExample example);

    RiIdentificationRriskMsg selectByPrimaryKey(String riskmsgid);

    int updateByExampleSelective(@Param("record") RiIdentificationRriskMsg record, @Param("example") RiIdentificationRriskMsgExample example);

    int updateByExample(@Param("record") RiIdentificationRriskMsg record, @Param("example") RiIdentificationRriskMsgExample example);

    int updateByPrimaryKeySelective(RiIdentificationRriskMsg record);

    int updateByPrimaryKey(RiIdentificationRriskMsg record);
}