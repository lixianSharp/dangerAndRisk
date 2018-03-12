package danger.mapper.riCtrl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import danger.bean.riCtrl.RiRiskPlanAudit;
import danger.bean.riCtrl.RiRiskPlanAuditExample;

public interface RiRiskPlanAuditMapper {
    long countByExample(RiRiskPlanAuditExample example);

    int deleteByExample(RiRiskPlanAuditExample example);

    int deleteByPrimaryKey(String riskplanauditid);

    int insert(RiRiskPlanAudit record);

    int insertSelective(RiRiskPlanAudit record);

    List<RiRiskPlanAudit> selectByExample(RiRiskPlanAuditExample example);

    RiRiskPlanAudit selectByPrimaryKey(String riskplanauditid);

    int updateByExampleSelective(@Param("record") RiRiskPlanAudit record, @Param("example") RiRiskPlanAuditExample example);

    int updateByExample(@Param("record") RiRiskPlanAudit record, @Param("example") RiRiskPlanAuditExample example);

    int updateByPrimaryKeySelective(RiRiskPlanAudit record);

    int updateByPrimaryKey(RiRiskPlanAudit record);
}