package danger.service.impl.dangerManager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import danger.bean.dangerManage.Danger;
import danger.bean.dangerManage.Rechecktable;
import danger.bean.dangerManage.RechecktableExample;
import danger.mapper.dangerManage.DangerMapper;
import danger.mapper.dangerManage.RechecktableMapper;
import danger.service.dangerManage.RechecktableService;

@Service("rechecktableService")
public class RechecktableServiceImpl implements RechecktableService {

	@Resource
	private RechecktableMapper rechecktableMapper;
	@Resource
	private DangerMapper dangerMapper;

	/**
	 * 增加复查记录1.增加一条复查信息。2.修改隐患表状态为已复查
	 * 
	 * @param recheckTable
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean addRechecktable(Rechecktable recheckTable) throws Exception {
		boolean b = false;
		if (recheckTable != null) {
			//增加一条复查信息
			int insert = rechecktableMapper.insert(recheckTable);
			Danger danger = new Danger();
			//修改隐患表状态
			danger.setDangerstatus("已复查");
			danger.setDangerid(recheckTable.getDangerid());
			int update = dangerMapper.updateByPrimaryKeySelective(danger);
			b = insert > 0 && update > 0 ? true : false;
		}
		return b;
	}

	/**
	 * 根据复查id删除复查信息。(级联删除)
	 * 
	 * @param recheeckTableId
	 * @return
	 * @throws Exception
	 */

	@Override
	public boolean deleteRechecktableById(Integer recheckTableId) throws Exception {
		boolean b = false;
		if (recheckTableId != null) {
			rechecktableMapper.deleteByPrimaryKey(recheckTableId);
			b = true;
		}
		return b;
	}

	/**
	 * 根据隐患编号查询信息集合
	 * 
	 * @param dangerId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Rechecktable> getRechecktableByDangerId(Integer dangerId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据复查编号查询复查信息
	 * 
	 * @param recheckId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Rechecktable getRechecktableByRecheckId(Integer recheckId) throws Exception {
		Rechecktable rechecktable = rechecktableMapper.selectByPrimaryKey(recheckId);
		return rechecktable;
	}

	@Override
	public Rechecktable getRechecktableByFollowId(Integer followid) throws Exception {
		RechecktableExample rechecktableExample = new RechecktableExample();
		RechecktableExample.Criteria criteria = rechecktableExample.createCriteria();
		criteria.andFollowidEqualTo(followid);
		List<Rechecktable> rechecks = rechecktableMapper.selectByExample(rechecktableExample);

		// TODO Auto-generated method stub
		return rechecks.get(0);
	}

}
