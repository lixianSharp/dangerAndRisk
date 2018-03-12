package danger.action.dangerHandle;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.dangerHandle.Spotdispose;
import danger.service.dangerHandle.SpotDisposeService;
import danger.service.impl.dangerHandle.SpotDisposeServiceImpl;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
// 控制层，多例模式
public class SpotDisposeAction extends ActionSupport {

	private Spotdispose spotdispose;

	public Spotdispose getSpotdispose() {
		return spotdispose;
	}

	public void setSpotdispose(Spotdispose spotdispose) {
		this.spotdispose = spotdispose;
	}

	@Resource
	private SpotDisposeService spotDisposeService;

	public String add() throws Exception {

		// spotdispose.setDangerid(1);
		System.out.println(spotdispose);
		boolean flag = spotDisposeService.addSpotDispose(spotdispose);

		//
		JSONObject json = new JSONObject();
		if (flag) {
			json.put("result", "保存成功");
		} else {
			json.put("result", "保存失败");
		}
		// 将反馈信息发送给对应页面
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json.toString());

		return null;
	}

	public String findByDangerId() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dangerid = request.getParameter("dangerid");
		Spotdispose spotd = spotDisposeService.selectByDangerId(Integer.parseInt(dangerid));

		JSONObject json = new JSONObject();
		json.put("hassafemeasure", spotd.getHassafemeasure().equals("1") ? "有" : "无");
		json.put("disposemeasure", spotd.getDisposemeasure());

		Date date = spotd.getDisposedate();
		SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String localdate = sdfm.format(date);

		json.put("disposedate", localdate);
		System.err.println("现场处理人:" + spotd.getDisposeperson());
		json.put("disposeperson", spotd.getDisposeperson());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json.toString());
		return null;
	}
}
