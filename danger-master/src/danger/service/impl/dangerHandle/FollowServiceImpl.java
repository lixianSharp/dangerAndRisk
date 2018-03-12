package danger.service.impl.dangerHandle;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import danger.bean.dangerHandle.Follow;
import danger.bean.dangerHandle.FollowExample;
import danger.bean.dangerManage.Danger;
import danger.bean.dangerManage.Rechecktable;
import danger.bean.dangerManage.RechecktableExample;
import danger.mapper.dangerHandle.FollowMapper;
import danger.mapper.dangerManage.DangerMapper;
import danger.mapper.dangerManage.RechecktableMapper;
import danger.service.dangerHandle.FollowService;


/**   
*    
* 项目名称：danger   
* 类名称：FollowServiceImpl   
* 类描述：   五定跟踪service的实现类
* 创建人：Leilong
* 修改人：
* 修改备注：  
* @version    
*    
*/
@Transactional
@Service
public class FollowServiceImpl implements FollowService {
	@Resource
	private DangerMapper dangerMapper;
	@Resource
	private FollowMapper followMapper;
	@Resource
	private RechecktableMapper recheckTableMapper;
	
	/**
	 * 增加跟踪信息。1.增加一条跟踪记录。2.修改隐患状态为已整改
	 * 
	 * @param follow
	 * @return
	 * @throws Exception
	 */
	public boolean addFollow(Follow follow) throws Exception {
		
		boolean isAdd = true;
		int isInsert = followMapper.insert(follow);
		//判断插入跟踪信息是否正确
		if(isInsert>0){
			//修改隐患状态为已整改
			Danger dangerInfo = dangerMapper.selectByPrimaryKey(follow.getDangerid());
			dangerInfo.setDangerstatus("已整改");
			int isUpdate = dangerMapper.updateByPrimaryKey(dangerInfo);
			//判断修改隐患状态为已经整改是否成功
			if(isUpdate<0){
				isAdd = false;
			}
		}else{
			isAdd = false;
		}
		
		return isAdd;
	}

	/**
	 * 根据五定id删除跟踪信息(级联删除)
	 * 先根据五定id获取到隐患id
	 * 判断复查表中有无引用要删除的跟踪id，若有将这条记录也删除，
	 * 删除跟踪表中的信息，将隐患状态由"已整改"改为"已五定"
	 * @param sidingId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFollowById(Integer sidingId) throws Exception {
		//跟踪id
		int followId = 0;
		//跟踪信息
		Follow followInfo = null;
		boolean isDelete = false;
		FollowExample followExample = new FollowExample();
		FollowExample.Criteria criteriaFollow = followExample.createCriteria();
		criteriaFollow.andSidingidEqualTo(sidingId);
		List<Follow> followInfoList = followMapper.selectByExample(followExample);
		if(followInfoList.size()>0){
			//获取隐患id
			for (Follow follow : followInfoList) {
				followId = follow.getFollowid();
				followInfo = follow;
			}
					
			//判断复查表中有无引用该跟踪id
			//根据跟踪id查询复查信息
			RechecktableExample recheckTableExample = new RechecktableExample();
			RechecktableExample.Criteria criteria = recheckTableExample.createCriteria();
			criteria.andFollowidEqualTo(followId);	
			List<Rechecktable> recheckInfo = recheckTableMapper.selectByExample(recheckTableExample);
			//判断查询结果是否为空 判断list集合是否为空
			if(recheckInfo.size()>0){
				//将复查信息删除
				int isDeleteRecheck = recheckTableMapper.deleteByExample(recheckTableExample);
				//判断是否删除成功
				if(isDeleteRecheck<0){
					return false;
				}
			}
			
			int isDeleteFollow = followMapper.deleteByPrimaryKey(followId);
			//判断跟踪信息是否删除成功
			if(isDeleteFollow>0){
				
				Danger dangerInfo = dangerMapper.selectByPrimaryKey(followInfo.getDangerid());
				dangerInfo.setDangerstatus("已五定");
				int isUpdate = dangerMapper.updateByPrimaryKey(dangerInfo);
				//判断修改隐患状态是否成功
				if(isUpdate>0){
					isDelete = true;
				}
			}
		}
						
		return isDelete;
	}

	/**
	 * 修改跟踪信息
	 * 
	 * @param follow	修改后的跟踪信息
	 * 需要获取五定编号和隐患编号和跟踪id           
	 * @return
	 * @throws Exception
	 */
	public boolean updateFollowById(Follow follow) throws Exception {
		
		int isUpdate = followMapper.updateByPrimaryKey(follow);
		
		return isUpdate>0 ? true : false;
		
	}

	/**
	 * 根据隐患编号查询跟踪信息
	 * 一条隐患编号包含多条跟踪信息,若出现多条五定信息时
	 * @param dangerId
	 * @return
	 * @throws Exception
	 */
	public List<Follow> getFollowsByDangerId(Integer dangerId) throws Exception {
		
		FollowExample followExample = new FollowExample();
		FollowExample.Criteria criteria = followExample.createCriteria();
		criteria.andDangeridEqualTo(dangerId);
		List<Follow> follows = followMapper.selectByExample(followExample);
		
		return follows;
	}

}
