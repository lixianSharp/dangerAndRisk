package danger.mapper.riCtrl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlan;
import danger.bean.riCtrl.RiDetailedOfRiskCtrlPlanExample;

public interface RiDetailedOfRiskCtrlPlanMapper {
    long countByExample(RiDetailedOfRiskCtrlPlanExample example);

    int deleteByExample(RiDetailedOfRiskCtrlPlanExample example);

    int deleteByPrimaryKey(String detailedofriskctrlplanid);

    int insert(RiDetailedOfRiskCtrlPlan record);

    int insertSelective(RiDetailedOfRiskCtrlPlan record);

    List<RiDetailedOfRiskCtrlPlan> selectByExample(RiDetailedOfRiskCtrlPlanExample example);

    RiDetailedOfRiskCtrlPlan selectByPrimaryKey(String detailedofriskctrlplanid);

    int updateByExampleSelective(@Param("record") RiDetailedOfRiskCtrlPlan record, @Param("example") RiDetailedOfRiskCtrlPlanExample example);

    int updateByExample(@Param("record") RiDetailedOfRiskCtrlPlan record, @Param("example") RiDetailedOfRiskCtrlPlanExample example);

    int updateByPrimaryKeySelective(RiDetailedOfRiskCtrlPlan record);

    int updateByPrimaryKey(RiDetailedOfRiskCtrlPlan record);
}