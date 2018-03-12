package danger.mapper.riIdentify;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.bean.riIdentify.RiIdentificationMainTableExample;

public interface RiIdentificationMainTableMapper {
    long countByExample(RiIdentificationMainTableExample example);

    int deleteByExample(RiIdentificationMainTableExample example);

    int deleteByPrimaryKey(String identiryid);

    int insert(RiIdentificationMainTable record);

    int insertSelective(RiIdentificationMainTable record);

    List<RiIdentificationMainTable> selectByExample(RiIdentificationMainTableExample example);

    RiIdentificationMainTable selectByPrimaryKey(String identiryid);

    int updateByExampleSelective(@Param("record") RiIdentificationMainTable record, @Param("example") RiIdentificationMainTableExample example);

    int updateByExample(@Param("record") RiIdentificationMainTable record, @Param("example") RiIdentificationMainTableExample example);

    int updateByPrimaryKeySelective(RiIdentificationMainTable record);

    int updateByPrimaryKey(RiIdentificationMainTable record);
}