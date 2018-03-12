package danger.service.lxyTestUtil;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//风险评估

import danger.bean.riIdentify.RiAssessment;
import danger.bean.riIdentify.RiResponsibility;
import danger.service.riIdentity.RiAssessmentService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestRiAssesmentUtil {
	
	@Resource
	private RiAssessmentService riAssessmentService; 
	
	@Test
	public void add()throws Exception{
		RiAssessment riAssessment = new RiAssessment();
		riAssessment.setAssessmentid(UUIDUtil.getUUID2());
		riAssessment.setRiskmsgid("e5b5e542b326494ebcd52101c5886b0a");
		riAssessment.setEvaluatetime(new Date());
		riAssessment.setLossofcconsequences("人员暴露频繁程度");
		riAssessment.setPersondegreeofexposure("损失后果");
		riAssessment.setPossibility("可能性");
		riAssessment.setRiskgrade("风险等级");
		riAssessment.setRiskvalue(2.3);
		
		
		boolean result = riAssessmentService.addRiAssessment(riAssessment);
		System.out.println("是否添加成功?"+result);
	}
	
	
	@Test
	public void update()throws Exception{
		RiAssessment riAssessment = new RiAssessment();
		riAssessment.setAssessmentid("2fbee4fbdb6c43108fd8429fb46f4e64");
		riAssessment.setRiskmsgid("3c31649c7263457da71acebda585dd8b");
		riAssessment.setEvaluatetime(new Date());
		riAssessment.setLossofcconsequences("人员暴露频繁程度1");
		riAssessment.setPersondegreeofexposure("损失后果1");
		riAssessment.setPossibility("可能性1");
		riAssessment.setRiskgrade("风险等级1");
		riAssessment.setRiskvalue(2.31);
		
		boolean result = riAssessmentService.updateRiAssessment(riAssessment);
		System.out.println("是否修改成功?"+result);
	}
	
	@Test
	public void find()throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		PageBean<RiAssessment> RiResponsibilityList = riAssessmentService.findDangerSidingByCondition(1, 4, condition);
		List<RiAssessment> riResponsibilityList = RiResponsibilityList.getProductList();
		System.out.println("条数"+riResponsibilityList.size());
		System.out.println("数据："+riResponsibilityList.get(0).getPersondegreeofexposure());
		
	}
	
	@Test
	public void delete()throws Exception{
		boolean result = riAssessmentService.deleteRiAssessment("d8f4fd1406db4fb08b934333e451ea39");
		System.out.println("删除成功了吗?"+result);
	}
}
