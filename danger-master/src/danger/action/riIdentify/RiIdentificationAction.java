package danger.action.riIdentify;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.service.riIdentity.RiIdentificationMainTableService;
import danger.utils.UUIDUtil;

//年度辨识和专项辨识 -》对应  风险辨识主表
@Controller
@Scope("prototype")
public class RiIdentificationAction extends ActionSupport{
	
	@Resource
	private RiIdentificationMainTableService riIdentificationMainTableService;
	
	// 实例化要转成json的文本集合
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	//javabean 风险辨识主表
	private RiIdentificationMainTable riIdentificationMainTable;

	public RiIdentificationMainTable getRiIdentificationMainTable() {
		return riIdentificationMainTable;
	}

	public void setRiIdentificationMainTable(RiIdentificationMainTable riIdentificationMainTable) {
		this.riIdentificationMainTable = riIdentificationMainTable;
	}
	
	/**
	 * 添加辨识信息(年度Y/专项S)
	 * @return
	 * @throws Exception
	 */
	public String addRiIdentificationMainTable()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//添加主键
		this.riIdentificationMainTable.setIdentiryid(UUIDUtil.getUUID2());
		
		boolean result = riIdentificationMainTableService.addRiIdentificationMainTable(riIdentificationMainTable);
		if(result){
			map.put("result", "添加成功");
		}else{
			map.put("result", "添加失败");
		}
		
		return "ok";
	}
	
	/**
	 * 修改辨识信息(年度Y/专项S)
	 * @return
	 * @throws Exception
	 */
	public String updateRiIdentificationMainTable() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		boolean result = riIdentificationMainTableService.updateRiIdentificationMainTable(riIdentificationMainTable);
		if(result){
			map.put("result", "修改成功");
		}else{
			map.put("result", "修改失败，请重新修改");
		}
		
		return "ok";
	}
	
	/**
	 * 根据主键id删除辨识信息(年度Y/专项S)
	 * @return
	 * @throws Exception
	 */
	public String delRiIdentificationMainTable() throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收从jsp页面传过来的辨识信息id
		String identiryid = ServletActionContext.getRequest().getParameter("identiryid");
		boolean result = riIdentificationMainTableService.delRiIdentificationMainTable(identiryid);
		if(result){
			map.put("result", "删除成功");
		}else{
			map.put("result", "删除失败，请重新删除");
		}
		return "ok";
	}
	
	/**
	 * 组合条件查询辨识信息(年度Y/专项S)
	 * @return
	 * @throws Exception
	 */
	public String findRiIdentificationMainTableByCondition()throws Exception{
		
		return "ok";
	}
}
