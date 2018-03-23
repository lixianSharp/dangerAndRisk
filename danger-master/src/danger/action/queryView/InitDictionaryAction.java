package danger.action.queryView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 初始化下拉列表
 * @author lxy
 *
 */

import danger.bean.sys.Dictionary;
import danger.service.sys.DictionaryService;
@Controller
@Scope("prototype")
public class InitDictionaryAction extends ActionSupport{
	
	//要转成json的map集合
	private Map<String,Object> map;
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	@Resource
	private DictionaryService dictionaryService;
	
	/**
	 * 初始化检查单位
	 * @return
	 * @throws Exception
	 */
	public String initCheckUnit() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10001");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
		
	}
	
	/**
	 * 初始化隐患类型
	 * @return
	 * @throws Exception
	 */
	public String initDangerType() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10101");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	/**
	 * 初始化隐患状态
	 * @return
	 * @throws Exception
	 */
	public String initDangerStatus() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10201");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	
	/**
	 * 初始化班次
	 * @return
	 * @throws Exception
	 */
	public String initBanCi() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10301");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	//===========================以下是风险的
	
	/**
	 * 初始化风险等级
	 * @return
	 * @throws Exception
	 */
	public String initRiGrade()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10401");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	/**
	 * 初始化风险辨识范围类型
	 * @return
	 * @throws Exception
	 */
	public String initRiIdentifyRangeType()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10501");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	
	/**
	 * 初始化风险类型
	 * @return
	 * @throws Exception
	 */
	public String initRiType()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10601");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	
	
	/**
	 * 初始化灾害类型
	 * @return
	 * @throws Exception
	 */
	public String initDisasterType()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10701");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	
	/**
	 * 初始化可能导致事故
	 * @return
	 * @throws Exception
	 */
	public String initCanCauseAccident()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryByUpDicId("10801");
		
		map.put("dictionaryList", dictionaryList);
		return "ok";
	}
	
	
}
