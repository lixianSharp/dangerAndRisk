package danger.action.riIdentify;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.riIdentify.RiAssessment;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.service.riIdentity.RiAssessmentService;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.PageBean;

//风险清单
@Controller
@Scope("prototype")
public class RiRiskListAction extends ActionSupport{

	//风险评估
	@Resource
	private RiAssessmentService riAssessmentService;
	
	//辨识风险信息
	@Resource
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService;
	
	// 实例化要转成json的文本集合
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	//javabean风险评估
	private RiAssessment riAssessment;
	public RiAssessment getRiAssessment() {
		return riAssessment;
	}

	public void setRiAssessment(RiAssessment riAssessment) {
		this.riAssessment = riAssessment;
	}
	
	//javabean辨识风险信息
	private RiIdentificationRriskMsg riIdentificationRriskMsg;
	public RiIdentificationRriskMsg getRiIdentificationRriskMsg() {
		return riIdentificationRriskMsg;
	}

	public void setRiIdentificationRriskMsg(RiIdentificationRriskMsg riIdentificationRriskMsg) {
		this.riIdentificationRriskMsg = riIdentificationRriskMsg;
	}

	
	
	/**
	 * 组合条件查询 风险辨识主表的名称name+辨识风险信息表+风险评估表信息
	 * @return
	 * @throws Exception
	 */
	public String findRiskMsgAndAssessmentByCondition()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//接收从jsp传过来的 当前页页号 每页显示的记录数
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentPage = request.getParameter("currentPage");//当前页页号
		String currentCount = request.getParameter("currentCount");//每页显示的记录数
		String risktype = request.getParameter("risktype");//风险类型
		String professionaltypes = request.getParameter("professionaltypes");//专业类型
		String disastertypes = request.getParameter("disastertypes");//灾害类型
		String riskgrade = request.getParameter("riskgrade");//风险等级
		
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("riskgrade", riskgrade);//风险等级
		condition.put("risktype",risktype );//风险类型
		condition.put("professionaltypes", professionaltypes);//专业类型
		condition.put("disastertypes", disastertypes);//灾害类型
		condition.put("evaluationstatus", "Y");//评估状态 查询状态=已评估的 "Y" 
		PageBean<Map<String, Object>> pageBean = riAssessmentService.findRiskMsgAndAssessmentByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		map.put("pageBean", pageBean);
		return "ok";
	}
	
	
}
