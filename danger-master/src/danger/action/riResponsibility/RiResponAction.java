package danger.action.riResponsibility;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riIdentify.RiResponsibility;
import danger.service.riResponsibility.RiResponsibilityService;
import danger.utils.PageBean;
import danger.utils.UUIDUtil;
/**
 * 职责分工
 * @author 贤元
 *
 */
@Controller
@Scope("prototype")
public class RiResponAction extends ActionSupport{

	@Resource
	private RiResponsibilityService riResponsibilityService;

	// 实例化要转成json的文本集合
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	// 岗位职责的bean
	private RiResponsibility riResponsibility;

	public RiResponsibility getRiResponsibility() {
		return riResponsibility;
	}

	public void setRiResponsibility(RiResponsibility riResponsibility) {
		this.riResponsibility = riResponsibility;
	}

	/**
	 * 添加岗位职责
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addRiRespon() throws Exception {
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();

		// 为岗位职责添加id
		riResponsibility.setRespid(UUIDUtil.getUUID2());
		boolean result = riResponsibilityService.addRiResponsibility(riResponsibility);
		if (result) {
			map.put("result", "添加成功");
		} else {
			map.put("result", "添加失败,请重新添加");
		}
		return "ok";
	}

	/**
	 * 删除岗位职责 根据岗位职责id删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delRiRespon() throws Exception {
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		String respId = ServletActionContext.getRequest().getParameter("respId");
		boolean result = riResponsibilityService.deleteRiResponsibility(respId);
		if (result) {
			map.put("result", "删除成功");
		} else {
			map.put("result", "删除失败，请重新删除");
		}

		return "ok";
	}

	/**
	 * 修改岗位职责
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String updateRiRespon() throws Exception {
		// 实例化要转成json的map集合
		map = new LinkedHashMap<String, Object>();
		boolean result = riResponsibilityService.updateRiResponsibility(riResponsibility);
		if(result){
			map.put("result", "修改成功");
		}else{
			map.put("result", "修改失败,请重新修改");
		}
		return "ok";
	}

	/**
	 * 默认查询出全部职责分工 (分页显示)
	 * 
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String findRiRespon() throws Exception {
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		
		//获取当前页页号、每页显示的记录数
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");
		String currentCount = request.getParameter("currentCount");
		
		PageBean<RiResponsibility> riResponsibilityList = riResponsibilityService.findRiResponsibilityByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		
		//将要转换成json的map集合响应给对应的jsp页面
		map.put("riResponsibilityList", riResponsibilityList);
		
		return "ok";
	}

	/**
	 * 导出岗位职责
	 * 
	 * @return
	 */
	public String exportRiRespon() {

		return "addRiRespon";
	}
}
