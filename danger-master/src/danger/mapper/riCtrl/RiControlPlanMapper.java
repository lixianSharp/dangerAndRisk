package danger.mapper.riCtrl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riCtrl.RiControlPlan;
import danger.bean.riCtrl.RiControlPlanExample;

public interface RiControlPlanMapper {
    long countByExample(RiControlPlanExample example);

    int deleteByExample(RiControlPlanExample example);

    int deleteByPrimaryKey(String rictrlplanid);

    int insert(RiControlPlan record);

    int insertSelective(RiControlPlan record);

    List<RiControlPlan> selectByExample(RiControlPlanExample example);

    RiControlPlan selectByPrimaryKey(String rictrlplanid);

    int updateByExampleSelective(@Param("record") RiControlPlan record, @Param("example") RiControlPlanExample example);

    int updateByExample(@Param("record") RiControlPlan record, @Param("example") RiControlPlanExample example);

    int updateByPrimaryKeySelective(RiControlPlan record);

    int updateByPrimaryKey(RiControlPlan record);
}