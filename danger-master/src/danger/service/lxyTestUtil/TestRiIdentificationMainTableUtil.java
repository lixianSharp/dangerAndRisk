package danger.service.lxyTestUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.service.riIdentity.RiIdentificationMainTableService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;
//风险辨识主表
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestRiIdentificationMainTableUtil {
	@Resource
	private RiIdentificationMainTableService identifyService; 
	
	@Test
	public void add()throws Exception{
		RiIdentificationMainTable identify = new RiIdentificationMainTable();
		identify.setIdentiryid(UUIDUtil.getUUID2());
		identify.setIdentifymark("Y");
		identify.setCreatetime(new Date());
		identify.setCompere("主持人");
		identify.setMeetingaddress("会议地址");
		identify.setMeetingcontent("会议内容");
		identify.setName("2016年年度专项辨识");
		identify.setParticipants("参会人员");
		identify.setRecorder("记录人");
		identify.setYear(new Date(2016, 10, 24));
		
		boolean result = identifyService.addRiIdentificationMainTable(identify);
		System.out.println("是否添加成功?"+result);
	}
	
	
	@Test
	public void update()throws Exception{
		RiIdentificationMainTable identify = new RiIdentificationMainTable();
		identify.setIdentiryid("581071247bb140e1a331706b430147c4");
		identify.setIdentifymark("Y");
		identify.setCreatetime(new Date());
		identify.setCompere("主持人1");
		identify.setMeetingaddress("会议地址1");
		identify.setMeetingcontent("会议内容1");
		identify.setName("2016年年度专项辨识1");
		identify.setParticipants("参会人员1");
		identify.setRecorder("记录人1");
		identify.setYear(new Date(2016, 10, 24));
		boolean result = identifyService.updateRiIdentificationMainTable(identify);
		System.out.println(result);
	}
	
	@Test
	public void find()throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		PageBean<RiIdentificationMainTable> pageBean = identifyService.findDangerSidingByCondition(1, 5, condition);
		System.out.println(pageBean.getProductList().size());
		System.out.println(pageBean.getProductList().get(0).getCompere());
	}
	
	@Test
	public void delete()throws Exception{
		boolean result = identifyService.delRiIdentificationMainTable("b345d7c5b84c410cb9dacf7cd7db8ae3");
		System.out.println(result);
		
	}
	
	@Test
	public void findriskMsgAndMainTable() throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		int currpage = 1;//当前页页号
		int currCount = 20;//每页显示的记录数
		condition.put("index", (currpage-1)*currCount);//（当前页页号-1）*每页显示的记录数
		condition.put("currentCount", currCount);
		//condition.put("identiryid", "4db947fba1a546ebaecff2ac5d1116ea");
		condition.put("identifymark", "Y");
		List<Map<String, Object>> resultMap = identifyService.findIdentifyMainAndRiskMsgByCondition(condition);
		Integer resultCount = identifyService.getIdentifyMainAndRiskMsgCountByCondition(condition);
		System.out.println("总记录数"+resultCount);
		System.out.println(resultMap.size()+" =="+resultMap);
	}
	
	
	
	@Test
	public void string2Data()throws Exception{
		String strData = "2019";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		Date parse = simpleDateFormat.parse(strData);
		System.out.println(parse.toString());
		System.out.println(new Date());
	}
	
	@Test
	public void selIdentifyMainByYear()throws Exception{
		String year ="2015";
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("year", year);
		List<RiIdentificationMainTable> selIdentifyMainByYear = identifyService.selIdentifyMainByYear(condition);
		System.out.println("条数:"+selIdentifyMainByYear.size());
		System.out.println(selIdentifyMainByYear.size()>0?true:false);
	}
	
}
