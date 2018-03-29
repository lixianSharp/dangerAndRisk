package danger.service.lxyTestUtil;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import danger.service.impl.export2Excel.ExportExcelImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestExportExcel {
	
	@Resource
	private ExportExcelImpl exportExcelImpl;
	
	
	@Test
	public void test()throws Exception{
		String result = exportExcelImpl.exportIdentifyMainYS("");
		System.out.println(result);
	}
	
	@Test
	public void exportRiskList()throws Exception{
		exportExcelImpl.exportRiskList(null);
	}
	
	@Test
	public void exportdangerFind()throws Exception{
		//exportExcelImpl.exportDangerFind();
		System.out.println("ok");
	}
	
	@Test
	public void exportDangerMonthReportTest()throws Exception{
		//exportExcelImpl.exportDangerMonthReport();
	}
	
	@Test
	public void exportDangerDayReportTest()throws Exception{
		//exportExcelImpl.exportDangerDayReport();
	}
}

