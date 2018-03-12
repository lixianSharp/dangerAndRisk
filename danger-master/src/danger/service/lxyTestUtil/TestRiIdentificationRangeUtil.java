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

import danger.bean.riIdentify.RiIdentificationRange;
import danger.bean.riIdentify.RiResponsibility;
import danger.service.riIdentity.RiIdentificationRangeService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;
//风险辨识范围
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestRiIdentificationRangeUtil {
	
	@Resource
	private RiIdentificationRangeService riIdentificationRangeService; 
	
	@Test
	public void add()throws Exception{
		RiIdentificationRange riIdentificationRange = new RiIdentificationRange();
		riIdentificationRange.setIdenranid(UUIDUtil.getUUID2());
		riIdentificationRange.setStarttime(new Date());
		riIdentificationRange.setEndtime(new Date());
		riIdentificationRange.setFacename("工作面名称");
		riIdentificationRange.setRirtype("风险辨识范围类型");
		riIdentificationRange.setSurvey("概况");
		
		boolean result = riIdentificationRangeService.addRiIdentificationRange(riIdentificationRange);
		System.out.println("是否添加成功?"+result);
	}
	
	
	@Test
	public void update()throws Exception{
		RiIdentificationRange riIdentificationRange = new RiIdentificationRange();
		riIdentificationRange.setIdenranid("31b9c8ad50f04050bb2f59e0bd93bb60");
		riIdentificationRange.setStarttime(new Date());
		riIdentificationRange.setEndtime(new Date());
		riIdentificationRange.setFacename("工作面名称1");
		riIdentificationRange.setRirtype("风险辨识范围类型1");
		riIdentificationRange.setSurvey("概况1");
		
		boolean result = riIdentificationRangeService.updateRiIdentificationRange(riIdentificationRange);
		System.out.println("是否修改成功?"+result);
	}
	
	@Test
	public void find()throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		PageBean<RiIdentificationRange> RiResponsibilityList =riIdentificationRangeService.findDangerSidingByCondition(1, 4, condition);
		List<RiIdentificationRange> riResponsibilityList = RiResponsibilityList.getProductList();
		System.out.println("条数"+riResponsibilityList.size());
		System.out.println("数据："+riResponsibilityList.get(0).getFacename());
		
	}
	
	@Test
	public void delete()throws Exception{
		boolean result =riIdentificationRangeService.delRiIdentificationRange("31b9c8ad50f04050bb2f59e0bd93bb60");
		System.out.println("删除成功了吗?"+result);
	}
}
