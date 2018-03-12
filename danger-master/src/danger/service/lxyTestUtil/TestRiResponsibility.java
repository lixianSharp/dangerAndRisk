package danger.service.lxyTestUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//岗位职责分工

import danger.bean.riIdentify.RiResponsibility;
import danger.service.riResponsibility.RiResponsibilityService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestRiResponsibility {
	
	@Resource
	private RiResponsibilityService riResponsibilityService; 
	
	@Test
	public void add()throws Exception{
		RiResponsibility riResponsibility = new RiResponsibility();
		riResponsibility.setRespid(UUIDUtil.getUUID2());
		riResponsibility.setQuarters("技术岗位");
		riResponsibility.setDuty("技术更新");
		riResponsibility.setCtrlfrequency("一月一次");
		riResponsibility.setCtrlcontent("技术和理性");
		riResponsibility.setAnalysisfrequency("一月一次");
		
		boolean result = riResponsibilityService.addRiResponsibility(riResponsibility);
		System.out.println("是否添加成功?"+result);
	}
	
	
	@Test
	public void update()throws Exception{
		RiResponsibility riResponsibility = new RiResponsibility();
		riResponsibility.setRespid("72c02c53eebb4da1bbc0a680ba56c59a");
		riResponsibility.setQuarters("技术岗位1");
		riResponsibility.setDuty("技术更新1");
		riResponsibility.setCtrlfrequency("一月一次1");
		riResponsibility.setCtrlcontent("技术和理性1");
		riResponsibility.setAnalysisfrequency("一月一次1");
		
		boolean result = riResponsibilityService.updateRiResponsibility(riResponsibility);
		System.out.println("是否修改成功?"+result);
	}
	
	@Test
	public void find()throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		PageBean<RiResponsibility> RiResponsibilityList = riResponsibilityService.findRiResponsibilityByCondition(1, 10, condition);
		List<RiResponsibility> riResponsibilityList = RiResponsibilityList.getProductList();
		System.out.println("条数"+riResponsibilityList.size());
		System.out.println("数据："+riResponsibilityList.get(0).getCtrlcontent());
		
	}
	
	@Test
	public void delete()throws Exception{
		boolean result = riResponsibilityService.deleteRiResponsibility("72c02c53eebb4da1bbc0a680ba56c59a");
		System.out.println("删除成功了吗?"+result);
	}
}
