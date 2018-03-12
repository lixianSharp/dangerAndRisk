package danger.action.dangerManager;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.dangerManage.Danger;
import danger.mapper.dangerManage.DangerMapper;
import danger.mapper.dangerManage.custom.DangerCustomMapper;
import danger.service.dangerManage.DangerService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
// 控制层，多例模式
public class DangerAction extends ActionSupport {

	
	@Resource
	private DangerCustomMapper dangerCustomMapper;
	@Resource
	private DangerService dangerService;
	@Resource
	DangerMapper dangerMapper;
	// 班次
	private List<Danger> banciList;

	public List<Danger> getBanciList() {
		return banciList;
	}

	public void setBanciList(List<Danger> banciList) {
		this.banciList = banciList;
	}

	// 检查单位
	private List<Danger> jianChaList;

	public List<Danger> getJianChaList() {
		return jianChaList;
	}

	public void setJianChaList(List<Danger> jianChaList) {
		this.jianChaList = jianChaList;
	}

	// 隐患类型
	private List<Danger> dangeTpList;

	public List<Danger> getDangeTpList() {
		return dangeTpList;
	}

	public void setDangeTpList(List<Danger> dangeTpList) {
		this.dangeTpList = dangeTpList;
	}

	// 责任单位
	private List<Danger> zeRenList;

	public List<Danger> getZeRenList() {
		return zeRenList;
	}

	public void setZeRenList(List<Danger> zeRenList) {
		this.zeRenList = zeRenList;
	}

	private List<Danger> jbztList;

	public List<Danger> getJbztList() {
		return jbztList;
	}

	public void setJbztList(List<Danger> jbztList) {
		this.jbztList = jbztList;
	}

	private Danger danger;

	public Danger getDanger() {
		return danger;
	}

	public void setDanger(Danger danger) {
		this.danger = danger;
	}

	// 隐患录入
	public String addDanger() throws Exception {

		//System.out.println(danger);
		// System.out.println(danger+"好了sd没");
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//根据责任单位名称获取责任单位的负责任人(也就是根据机构名称获取该机构对应的负责人)
		String manager = dangerService.getManagerByDepartmentName(danger.getUnit());
		danger.setManager(manager);//为隐患信息设置责任单位的负责人
		boolean flag = dangerService.addDanger(danger);

		JSONObject json = new JSONObject();
		if (flag) {
			System.out.println(flag);
			json.put("result", "录入成功");
		} else {
			System.out.println(flag);
			json.put("result", "录入失败");
		}
		//System.out.println(json.toString());
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json.toString());

		return null;
	}

	// 隐患修改，根据javabean修改
	public String updateBydanger() throws Exception {
		//System.out.println("进入updateBydanger()Action中");
		//System.out.println(danger);
		// 根据一个隐患对象修改隐患记录
		boolean flag = dangerService.updateDangerById(danger);

		//System.out.println(flag);

		HttpServletResponse response = ServletActionContext.getResponse();

		JSONObject json = new JSONObject();
		if (flag) {
			json.put("result", "修改成功");
		} else {
			json.put("result", "修改失败");
		}

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json.toString());

		return null;// "updateByDanger";
	}

	// 初始化班次
	public String initBanciData() throws IOException {
		// 从数据库中查询班次、检查单位、隐患类型、责任单位
		banciList = dangerCustomMapper.findAllDangerclassType();
		return SUCCESS;
	}

	// 初始化检查单位
	public String initcheckUnitData() throws IOException {
		// 从数据库中查询班次、检查单位、隐患类型、责任单位
		jianChaList = dangerCustomMapper.findAllDangercheckUnit();
		System.out.println(jianChaList.get(0).getCheckunit());
		return SUCCESS;
	}

	// 初始化隐患类型
	public String initDangerType() throws IOException {
		// 查询出来的数据是不对的
		dangeTpList = dangerCustomMapper.findAllDangercheckUnit();
	//	System.out.println(dangeTpList);
		return SUCCESS;
	}

	// 初始化责任单位
	public String initUnitData() throws IOException {
		// 从数据库中查询班次、检查单位、隐患类型、责任单位
		zeRenList = dangerCustomMapper.findAllDangerunit();
		//System.out.println(zeRenList);
		/*
		 * if(banciList!=null){ JSONArray formObject =
		 * JSONArray.fromObject(banciList); String str = formObject.toString();
		 * System.out.println(str);
		 * ServletActionContext.getResponse().getWriter().write(str); }
		 */
		return SUCCESS;
	}

	// 将所有级别=无且状态="未五定的隐患信息查询出来 页面初始化用的
	public String findDangerByJBZT() throws IOException {
		// 这个查询出来的数据是错误的
		jbztList = dangerCustomMapper.findAllDangerclassType();
		//System.out.println(jbztList);
		return SUCCESS;
	}

	public String deletebydangerid() throws Exception {
		//System.out.println("进入Action删除方法");
		String dangerid = ServletActionContext.getRequest().getParameter("dangerid");
		//System.out.println("传过来的隐患id是:" + dangerid);
		//
		// 根据隐患id删除隐患信息
		boolean flag = dangerService.deleteDangerById(Integer.parseInt(dangerid));
		//System.out.println("是否根据隐患id删除了隐患信息？" + flag);

		// 将数据以json格式响应给ajax
		HttpServletResponse response = ServletActionContext.getResponse();

		JSONObject json = new JSONObject();
		if (flag) {
			json.put("message", "删除成功");
		} else {
			json.put("message", "删除失败");
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json.toString());

		return null;
	}
}
