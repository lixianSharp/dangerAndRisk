package danger.action.riIdentify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riIdentify.RiIdentificationRange;
import danger.service.riIdentity.RiIdentificationRangeService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;

//辨识范围
@Controller
@Scope("prototype")
public class RiIdentificationRangeAction extends ActionSupport {
	
	@Resource
	private RiIdentificationRangeService riIdentificationRangeService;
	
	// 实例化要转成json的文本集合
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	//javabean
	private RiIdentificationRange riIdentificationRange;

	public RiIdentificationRange getRiIdentificationRange() {
		return riIdentificationRange;
	}

	public void setRiIdentificationRange(RiIdentificationRange riIdentificationRange) {
		this.riIdentificationRange = riIdentificationRange;
	}
	
	
	/**
	 * 增加风险辨识范围信息
	 * @return
	 * @throws Exception
	 */
	public String addRiIdentificationRange()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//添加风险辨识范围id
		riIdentificationRange.setIdenranid(UUIDUtil.getUUID2());
		boolean result = riIdentificationRangeService.addRiIdentificationRange(riIdentificationRange);
		if(result){
			map.put("result", "添加成功");
		}else{
			map.put("result", "添加失败");
		}
		
		return "ok";
	}


	
	/**
	 * 修改风险辨识范围信息
	 * @return
	 * @throws Exception
	 */
	public String updateRiIdentificationRange()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//修改风险辨识范围信息
		boolean result = riIdentificationRangeService.updateRiIdentificationRange(riIdentificationRange);
		if(result){
			map.put("result", "修改成功");
		}else{
			map.put("result", "修改失败");
		}
		
		return "ok";
	}
	
	/**
	 * 删除风险辨识范围信息(根据风险辨识范围的id删除)
	 * @return
	 * @throws Exception
	 */
	public String delRiIdentificationRange()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//删除风险辨识范围信息
		String idenranid = ServletActionContext.getRequest().getParameter("idenranid");
		
		boolean result = riIdentificationRangeService.delRiIdentificationRange(idenranid);
		if(result){
			map.put("result", "删除成功");
		}else{
			map.put("result", "删除失败");
		}
		return "ok";
	}
	
	/**
	 * 组合条件查询风险辨识范围信息
	 * @return
	 * @throws Exception
	 */
	public String findAllRiIdentificationRange()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		//接收从前台传过来的 当前页页号  每页显示的记录数
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");
		String currentCount = request.getParameter("currentCount");
		
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		PageBean<RiIdentificationRange> pageBean = riIdentificationRangeService.findDangerSidingByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		System.out.println("pageBean内容:"+pageBean);
		
		map.put("pageBean", pageBean);
		
		return "ok";
	}
	
}
