package danger.service.impl.dangerManager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.dangerHandle.Delay;
import danger.bean.dangerHandle.DelayExample;
import danger.bean.dangerHandle.Follow;
import danger.bean.dangerHandle.FollowExample;
import danger.bean.dangerHandle.FollowExample.Criteria;
import danger.bean.dangerHandle.Sidingbiao;
import danger.bean.dangerHandle.SidingbiaoExample;
import danger.bean.dangerHandle.Spotdispose;
import danger.bean.dangerHandle.SpotdisposeExample;
import danger.bean.dangerManage.Danger;
import danger.bean.dangerManage.Rechecktable;
import danger.bean.dangerManage.RechecktableExample;
import danger.mapper.dangerHandle.DelayMapper;
import danger.mapper.dangerHandle.FollowMapper;
import danger.mapper.dangerHandle.SidingbiaoMapper;
import danger.mapper.dangerHandle.SpotdisposeMapper;
import danger.mapper.dangerManage.DangerMapper;
import danger.mapper.dangerManage.RechecktableMapper;
import danger.mapper.dangerManage.custom.DangerCustomMapper;
import danger.service.dangerHandle.SidingService;
import danger.service.dangerManage.DangerService;
import danger.utils.ChangLiang;

/**
 * xianyuan
 * 
 * @author xianyuan
 * @time 2017年9月8日下午3:20:15
 */
// 隐患录入实现类
@Service
public class DangerServiceImpl implements DangerService {
	@Resource
	private DangerMapper dangerMapper;
	// ============================================
	/******** 用于根据隐患id删除隐患信息 *******************/
	// 五定表
	@Resource
	private SidingbiaoMapper sidingbiaoMapper;
	// 五定延期表
	@Resource
	private DelayMapper delayMapper;
	// 隐患跟踪表
	@Resource
	private FollowMapper followMapper;
	// 现场处理表
	@Resource
	private SpotdisposeMapper spotDisposeMapper;
	// 复查表
	@Resource
	private RechecktableMapper rechecktableMapper;

	// ==============
	@Resource
	private DangerCustomMapper dangerCustomMapper;
	@Resource
	private SidingService sidingService;

	/****************************/
	// ===============================

	// 隐患录入
	@Override
	public boolean addDanger(Danger danger) throws Exception {
		if (danger != null) {
			danger.setDangerstatus(ChangLiang.weisiding);
			danger.setDangerstatusnum("00");
			int flag = dangerMapper.insert(danger);
			return true;
		} else {
			return false;
		}
	}

	// 级联删除
	@Override
	public boolean deleteDangerById(Integer id) throws Exception {

		// 1、根据隐患编号删除现场处理信息
		SpotdisposeExample spotdisposeExample = new SpotdisposeExample();
		SpotdisposeExample.Criteria criteria = spotdisposeExample.createCriteria();
		// 封装信息
		criteria.andDangeridEqualTo(id);
		// 执行
		List<Spotdispose> spotList = spotDisposeMapper.selectByExample(spotdisposeExample);
		if (spotList.size() > 0) {
			spotDisposeMapper.deleteByExample(spotdisposeExample);
		}
		// 2、根据隐患编号删除复查表信息
		RechecktableExample rechecktableExample = new RechecktableExample();
		RechecktableExample.Criteria criteria2 = rechecktableExample.createCriteria();
		criteria2.andDangeridEqualTo(id);
		List<Rechecktable> rechList = rechecktableMapper.selectByExample(rechecktableExample);
		if (rechList.size() > 0) {
			int countRechDel = rechecktableMapper.deleteByExample(rechecktableExample);
		}

		// 3、根据隐患编号删除隐患跟踪表信息
		FollowExample followExample = new FollowExample();
		FollowExample.Criteria criteria3 = followExample.createCriteria();
		// 封装条件
		criteria3.andDangeridEqualTo(id);
		List<Follow> followList = followMapper.selectByExample(followExample);
		if (followList.size() > 0) {
			int countFollow = followMapper.deleteByExample(followExample);
		}

		// 4、根据隐患编号删除五定表信息
		// 4.1根据隐患编号从五定表中查询出五定编号
		SidingbiaoExample sidingbiaoExample = new SidingbiaoExample();
		SidingbiaoExample.Criteria criteria41 = sidingbiaoExample.createCriteria();
		criteria41.andDangeridEqualTo(id);
		// 查询出所有五定信息
		List<Sidingbiao> sidingList = sidingbiaoMapper.selectByExample(sidingbiaoExample);
		if (sidingList.size() > 0) {
			for (Sidingbiao sidingbiao : sidingList) {
				Integer sidingid = sidingbiao.getSidingid();// 获取五定id
				// 4.2根据五定编号删除五定延期表信息
				DelayExample delayExample = new DelayExample();
				DelayExample.Criteria criteria42 = delayExample.createCriteria();
				// 封装条件
				criteria42.andSidingidEqualTo(sidingid);
				// 执行
				List<Delay> sidingDelayList = delayMapper.selectByExample(delayExample);// 根据五定id查询出所有符合条件的五定延期表信息
				if (sidingDelayList.size() > 0) {
					// 根据五定延期表对象删除五定延期表信息
					int countdelay = delayMapper.deleteByExample(delayExample);
				} // for的括号
					// 4.2.1根据五定编号删除隐患跟踪表信息
					// 01根据五定编号查询出所有隐患跟踪id
				FollowExample folloExample4 = new FollowExample();
				FollowExample.Criteria criteria4 = folloExample4.createCriteria();
				criteria4.andSidingidEqualTo(sidingid);
				List<Follow> followsidingList = followMapper.selectByExample(folloExample4);
				for (Follow folow : followsidingList) {
					Integer followid = folow.getFollowid();// 跟踪id
					// 根据跟踪id删除复查表中的信息
					RechecktableExample rechExample = new RechecktableExample();
					RechecktableExample.Criteria criteriaRecheck = rechExample.createCriteria();
					criteriaRecheck.andFollowidEqualTo(followid);
					rechecktableMapper.deleteByExample(rechExample);// 根据跟踪id删除复查表中的信息
				} // 小for的括号
					// 05根据五定编号删除跟踪表信息
				FollowExample follExample = new FollowExample();
				FollowExample.Criteria criterFollow = follExample.createCriteria();
				criterFollow.andSidingidEqualTo(sidingid);
				followMapper.deleteByExample(follExample);
			} // 大for的括号
				// 4.3根据隐患编号删除五定表信息
			int countsiding = sidingbiaoMapper.deleteByExample(sidingbiaoExample);
		} // 第4个if的括号

		// 5、根据隐患编号删除隐患信息
		int countdanger = dangerMapper.deleteByPrimaryKey(id);
		// System.out.println("删除操作成功");
		return countdanger == 1 ? true : false;

	}

	@Override
	public boolean updateDangerById(Danger danger) throws Exception {
		int result = dangerMapper.updateByPrimaryKeySelective(danger);
		return result == 1 ? true : false;

	}

	@Override
	public boolean updateDangerStatus(Integer dangerId, String status) throws Exception {
		// 根据隐患编号查询出对应的隐患记录
		Danger danger = dangerMapper.selectByPrimaryKey(dangerId);

		// 修改隐患状态
		danger.setDangerstatus(status);
		// 再将修改后的隐患信息保存到数据库
		int result = dangerMapper.updateByPrimaryKeySelective(danger);
		return result == 1 ? true : false;
	}

	@Override
	public Danger getDangerById(Integer id) throws Exception {

		Danger danger = dangerMapper.selectByPrimaryKey(id);
		return danger == null ? danger : null;

	}

	/*
	 * public ArrayList getClassType()throws Exception{ return
	 * dangerCustomMapper.findClassType(); }
	 */

	public List findAllDangerclassType() throws Exception {
		List<Danger> list = dangerCustomMapper.findAllDangerclassType();
		return list;
	}

	public List findAllDangercheckUnit() throws Exception {
		List<Danger> list = dangerCustomMapper.findAllDangercheckUnit();
		return list;
	}

	public List findAllDangertype() throws Exception {
		List<Danger> list = dangerCustomMapper.findAllDangertype();
		return list;
	}

	public List findAllDangerunit() throws Exception {
		List<Danger> list = dangerCustomMapper.findAllDangerunit();
		return list;
	}

	@Override
	public String getManagerByDepartmentName(String departmentname) {
		String manager = dangerCustomMapper.getManagerByDepartmentName(departmentname);
		if(manager!=null){
			return manager;
		}else{
			return "";
		}
	}
}
