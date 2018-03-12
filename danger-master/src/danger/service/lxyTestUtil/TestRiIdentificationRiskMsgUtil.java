package danger.service.lxyTestUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.bean.riIdentify.RiResponsibility;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;
//辨识风险信息
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestRiIdentificationRiskMsgUtil {
	
	@Resource
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService; 
	
	@Test
	public void add()throws Exception{
		RiIdentificationRriskMsg riIdentificationRriskMsg = new RiIdentificationRriskMsg();
		riIdentificationRriskMsg.setRiskmsgid(UUIDUtil.getUUID2());
		riIdentificationRriskMsg.setIdentiryid("b345d7c5b84c410cb9dacf7cd7db8ae3");
		riIdentificationRriskMsg.setCancauseaccidents("可能导致事故");
		riIdentificationRriskMsg.setCtrlmeasure("管控措施");
		riIdentificationRriskMsg.setDisastertypes("灾害类型");
		riIdentificationRriskMsg.setEvaluationstatus("Y");
		riIdentificationRriskMsg.setMonitoringperiod("监控周期");
		riIdentificationRriskMsg.setPrincipal("负责人");
		riIdentificationRriskMsg.setProfessionaltypes("专业类型");
		riIdentificationRriskMsg.setRiskaddress("风险地点");
		riIdentificationRriskMsg.setRiskdescribe("风险描述");
		riIdentificationRriskMsg.setRisktype("风险类型");
		riIdentificationRriskMsg.setSuperintendent("监督人");
		boolean result = riIdentificationRriskMsgService.addRiIdentificationRriskMsg(riIdentificationRriskMsg);
		System.out.println("是否添加成功?"+result);
	}
	
	
	@Test
	public void update()throws Exception{
		RiIdentificationRriskMsg riIdentificationRriskMsg = new RiIdentificationRriskMsg();
		riIdentificationRriskMsg.setRiskmsgid("3c31649c7263457da71acebda585dd8b");
		riIdentificationRriskMsg.setIdentiryid("19f39acadc8d45b19a788e798b17b028");
		riIdentificationRriskMsg.setCancauseaccidents("可能导致事故1");
		riIdentificationRriskMsg.setCtrlmeasure("管控措施1");
		riIdentificationRriskMsg.setDisastertypes("灾害类型1");
		riIdentificationRriskMsg.setEvaluationstatus("Y");
		riIdentificationRriskMsg.setMonitoringperiod("监控周期1");
		riIdentificationRriskMsg.setPrincipal("负责人1");
		riIdentificationRriskMsg.setProfessionaltypes("专业类型1");
		riIdentificationRriskMsg.setRiskaddress("风险地点1");
		riIdentificationRriskMsg.setRiskdescribe("风险描述1");
		riIdentificationRriskMsg.setRisktype("风险类型1");
		riIdentificationRriskMsg.setSuperintendent("监督人1");
		boolean result = riIdentificationRriskMsgService.updateRiIdentificationRriskMsg(riIdentificationRriskMsg);
		System.out.println("是否修改成功?"+result);
	}
	
	@Test
	public void find()throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		PageBean<RiIdentificationRriskMsg> RiResponsibilityList = riIdentificationRriskMsgService.findDangerSidingByCondition(1, 4, condition);
		List<RiIdentificationRriskMsg> riResponsibilityList = RiResponsibilityList.getProductList();
		System.out.println("条数"+riResponsibilityList.size());
		System.out.println("数据："+riResponsibilityList.get(0).getCtrlmeasure());
		
	}
	
	@Test
	public void delete()throws Exception{
		boolean result = riIdentificationRriskMsgService.delRiIdentificationRriskMsg("5387f57187454b0088ef842c9085af69");
		System.out.println("删除成功了吗?"+result);
	}
}
