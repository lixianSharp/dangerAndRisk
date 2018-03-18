package danger.action.riIdentify;

import java.util.Date;
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
import danger.utils.UUIDUtil;
/**
 * 风险评估
 * @author 贤元
 *
 */
@Controller
@Scope("prototype")
public class RiAssessmentAction extends ActionSupport{
	
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
	 * 新增年度或专项环节未识别出来的风险信息。
	 * @return
	 * @throws Exception
	 */
	public String addYOrSRiskMsg()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//1.保存年度或专项环节未识别出来的风险信息
		//1.1添加主键风险信息id
		riIdentificationRriskMsg.setRiskmsgid(UUIDUtil.getUUID2());
		//1.2添加辨识表id(风险辨识主表的id)==》这个在jsp中弄
		//1.3设置评估状态 未评估"N"
		riIdentificationRriskMsg.setEvaluationstatus("N");
		//1.3执行保存操作
		boolean result = riIdentificationRriskMsgService.addRiIdentificationRriskMsg(riIdentificationRriskMsg);
		if(result){
			map.put("result", "添加成功");
		}else{
			map.put("result", "添加失败");
		}
		
		return "ok";
	}
	
	
	
	/**
	 * 对该条风险信息进行评估
	 * @return
	 * @throws Exception
	 */
	public String addRiAssessment()throws Exception{
		//实例化要转成json的map集合
		map = new LinkedHashMap<String,Object>();
		
		//1.设置评估id
		riAssessment.setAssessmentid(UUIDUtil.getUUID2());
		//1.1将该条风险信息的风险信息id放在评估表中=》放在jsp中处理，弄个隐藏域
		//1.2设置评估时间
		riAssessment.setEvaluatetime(new Date());
		
		//2.添加评估
		boolean result = riAssessmentService.addRiAssessment(riAssessment);
		//3.如果评估完成，则修改辨识风险信息中的评估状态，修改为已评估"Y"
		if(result){
			//3.1根据辨识风险信息id查找辨识风险信息，并修改该条辨识风险信息的评估状态，设置为"Y"
			String riskmsgid = riAssessment.getRiskmsgid();//获取风险信息id
			RiIdentificationRriskMsg identifyRiskMsg = riIdentificationRriskMsgService.selRiIdentifyRriskMsgByRiskMsgId(riskmsgid);//风险信息id查找辨识风险信息
			identifyRiskMsg.setEvaluationstatus("Y");//修改评估状态
			//3.2将修改后的信息保存在辨识风险信息表中
			boolean resultUpdate = riIdentificationRriskMsgService.updateRiIdentificationRriskMsg(identifyRiskMsg);
			map.put("result", "评估完成");
		}else{
			map.put("result", "评估失败,请重新评估");
		}
		
		return "ok";
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
		String riskdescribe = request.getParameter("riskdescribe");//风险描述
		String riskaddress = request.getParameter("riskaddress");//风险地点
		String evaluationstatus = request.getParameter("evaluationstatus");//评估状态
		//封装查询条件的map集合
		Map<String,Object> condition = new LinkedHashMap<String,Object>();
		condition.put("riskdescribe",riskdescribe );
		condition.put("riskaddress", riskaddress);
		condition.put("evaluationstatus", evaluationstatus);
		PageBean<Map<String, Object>> pageBean = riAssessmentService.findRiskMsgAndAssessmentByCondition(Integer.parseInt(currentPage), Integer.parseInt(currentCount), condition);
		map.put("pageBean", pageBean);
		return "ok";
	}
	
	
	
	
	
}
