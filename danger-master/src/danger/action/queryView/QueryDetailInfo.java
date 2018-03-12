package danger.action.queryView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import danger.bean.dangerHandle.Follow;
import danger.bean.dangerHandle.FollowExample;
import danger.bean.dangerHandle.Sidingbiao;
import danger.bean.dangerHandle.SidingbiaoExample;
import danger.bean.dangerManage.Danger;
import danger.bean.dangerManage.Rechecktable;
import danger.bean.dangerManage.RechecktableExample;
import danger.mapper.dangerHandle.FollowMapper;
import danger.mapper.dangerHandle.SidingbiaoMapper;
import danger.mapper.dangerManage.DangerMapper;
import danger.mapper.dangerManage.RechecktableMapper;

/**
 * 查询隐患点详情的时候用
 * 
 * @author QizoLiQiang
 * @time 2017年9月7日下午12:07:55
 */

@Controller
 
@Scope("prototype")
 
// 控制层，多例模式
public class QueryDetailInfo extends ActionSupport {

	
	
	private String dangerId;

	@Autowired
	private DangerMapper danggerMapper;
	@Autowired
	private SidingbiaoMapper sidingbiaoMapper;
	@Autowired
	private FollowMapper followMapper;
	@Autowired
	private RechecktableMapper recheckMapper;
	private Map<String, Object> result;

	@Override
	public String execute() throws Exception {
		// 隐患对象
		Danger danger = danggerMapper.selectByPrimaryKey(Integer.valueOf(dangerId));
		result = new HashMap<String, Object>();
		// siding对象
		SidingbiaoExample sidingExample = new SidingbiaoExample();
		// 通过criteria构造查询条件
		SidingbiaoExample.Criteria sidingCriteria = sidingExample.createCriteria();
		sidingCriteria.andDangeridEqualTo(Integer.valueOf(dangerId));
		List<Sidingbiao> sidinglist = sidingbiaoMapper.selectByExample(sidingExample);
		System.out.println(sidinglist.size());
		if (sidinglist.size() > 0) {
			result.put("siding", sidinglist);
		}

		// 跟踪对象
		FollowExample followExample = new FollowExample();
		// 通过criteria构造查询条件
		FollowExample.Criteria followCriteria = followExample.createCriteria();
		followCriteria.andDangeridEqualTo(Integer.valueOf(dangerId));
		List<Follow> followlist = followMapper.selectByExample(followExample);
		System.out.println(followlist.size());
		if (sidinglist.size() > 0) {
			result.put("followlist", followlist);
		}

		// 复查对象
		RechecktableExample rechecktableExample = new RechecktableExample();
		// 通过criteria构造查询条件
		RechecktableExample.Criteria recheckCriteria = rechecktableExample.createCriteria();
		recheckCriteria.andDangeridEqualTo(Integer.valueOf(dangerId));
		List<Rechecktable> rechecklist = recheckMapper.selectByExample(rechecktableExample);
		System.out.println(rechecklist.size());
		if (rechecklist.size() > 0) {
			result.put("rechecklist", rechecklist);
		}

		result.put("danger", danger);
		return super.execute();
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getDangerId() {
		return dangerId;
	}

	public void setDangerId(String dangerId) {
		this.dangerId = dangerId;
	}

}
