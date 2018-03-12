package danger.service.lxyTestUtil;

import java.util.Date;
import java.util.LinkedHashMap;
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
	private RiIdentificationMainTableService riIdentificationMainTableService; 
	
	@Test
	public void add()throws Exception{
		RiIdentificationMainTable riIdentificationMainTable = new RiIdentificationMainTable();
		riIdentificationMainTable.setIdentiryid(UUIDUtil.getUUID2());
		riIdentificationMainTable.setIdentifymark("Y");
		riIdentificationMainTable.setCreatetime(new Date());
		riIdentificationMainTable.setCompere("主持人");
		riIdentificationMainTable.setMeetingaddress("会议地址");
		riIdentificationMainTable.setMeetingcontent("会议内容");
		riIdentificationMainTable.setName("2016年年度专项辨识");
		riIdentificationMainTable.setParticipants("参会人员");
		riIdentificationMainTable.setRecorder("记录人");
		riIdentificationMainTable.setYear(new Date(2016, 10, 24));
		
		boolean result = riIdentificationMainTableService.addRiIdentificationMainTable(riIdentificationMainTable);
		System.out.println("是否添加成功?"+result);
	}
	
	
	@Test
	public void update()throws Exception{
		RiIdentificationMainTable riIdentificationMainTable = new RiIdentificationMainTable();
		riIdentificationMainTable.setIdentiryid("581071247bb140e1a331706b430147c4");
		riIdentificationMainTable.setIdentifymark("Y");
		riIdentificationMainTable.setCreatetime(new Date());
		riIdentificationMainTable.setCompere("主持人1");
		riIdentificationMainTable.setMeetingaddress("会议地址1");
		riIdentificationMainTable.setMeetingcontent("会议内容1");
		riIdentificationMainTable.setName("2016年年度专项辨识1");
		riIdentificationMainTable.setParticipants("参会人员1");
		riIdentificationMainTable.setRecorder("记录人1");
		riIdentificationMainTable.setYear(new Date(2016, 10, 24));
		boolean result = riIdentificationMainTableService.updateRiIdentificationMainTable(riIdentificationMainTable);
		System.out.println(result);
	}
	
	@Test
	public void find()throws Exception{
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		PageBean<RiIdentificationMainTable> pageBean = riIdentificationMainTableService.findDangerSidingByCondition(1, 5, condition);
		System.out.println(pageBean.getProductList().size());
		System.out.println(pageBean.getProductList().get(0).getCompere());
	}
	
	@Test
	public void delete()throws Exception{
		boolean result = riIdentificationMainTableService.delRiIdentificationMainTable("b345d7c5b84c410cb9dacf7cd7db8ae3");
		System.out.println(result);
		
	}
}
