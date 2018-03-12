package danger.service.impl.dangerHandle;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import danger.bean.dangerHandle.Delay;
import danger.bean.dangerHandle.DelayExample;
import danger.bean.dangerHandle.Sidingbiao;
import danger.mapper.dangerHandle.DelayMapper;
import danger.mapper.dangerHandle.SidingbiaoMapper;
import danger.service.dangerHandle.DelayService;


/**   
*    
* 项目名称：danger   
* 类名称：DelayServiceImpl   
* 类描述： 五定延期service的实现类  
* 创建人：Leilong  
* 修改人： 
* 修改备注：   
* @version    
*    
*/
@Transactional
@Service
public class DelayServiceImpl implements DelayService {
	
	@Resource
	private DelayMapper delayMapper;
	@Resource
	private SidingbiaoMapper siDingBiaoMapper;

	/**
	 * 增加延期记录。
	 * 首先需要设置这次延期的序号
	 * 先根据五定ID查询五定信息
	 * 通过五定信息中的上次最新整改时间获取到上次延期的次序，加1设置到最新的延期对象中
	 * 1.增加一条延迟记录。2.修改五定表的整改时间为最新的时间
	 * 
	 * @param delay
	 * @return
	 * @throws Exception
	 */
	public boolean addDelay(Delay delay) throws Exception {
		
		boolean isAdd = true;
		//先根据五定id查询出五定信息		
		Sidingbiao sidingInfo = siDingBiaoMapper.selectByPrimaryKey(delay.getSidingid());
		DelayExample delayExample = new DelayExample();
		DelayExample.Criteria criteria = delayExample.createCriteria();
		//根据整改时间查询上一次的延期信息
		criteria.andDelaytimeEqualTo(sidingInfo.getRectificationtime());
		List<Delay> delayOldInfoList = delayMapper.selectByExample(delayExample);
		//list集合是否为空
		if(delayOldInfoList.size()>0){
			for (Delay delayOldInfo : delayOldInfoList) {
				//将延期次数加1,设置到延期对象中
				delay.setDelayseq(delayOldInfo.getDelayseq()+1);
			}	
		}else{
			//若出现无延期记录的情况，默认将延期次数设置为1
			delay.setDelayseq(1);
		}
						
		int isInsert = delayMapper.insert(delay);
		//判断增加延迟信息是否成功
		if(isInsert>0){
			//设置整改时间为最新的时间，即延迟时间
			sidingInfo.setRectificationtime(delay.getDelaytime());
			int isUpdate = siDingBiaoMapper.updateByPrimaryKey(sidingInfo);
			//判断修改整改时间是否成功
			if(isUpdate<0){
				isAdd = false;
			}
		}
		return isAdd;
	}
	
	/**
	 * 根据延期id删除记录(级联删除)
	 * 先将延期的信息和五定信息查出来，判断延期次数是否大于等于1
	 * 还需要判断当前要删除的延期信息是否是最新的
	 * 根据五定编号和延期次数-1查出上一次的延期记录，
	 * 将上一次的延期时间设置到五定信息中， 删除延期信息
	 * @return
	 * @throws Exception
	 */
	public boolean deleteDelayById(Integer delayId) throws Exception {
		Boolean isDeleteDelayInfo = false;
		//查询出延迟信息
		Delay delayLastInfo = delayMapper.selectByPrimaryKey(delayId);
		//查询出五定信息
		Sidingbiao sidingInfo = siDingBiaoMapper.selectByPrimaryKey(delayLastInfo.getSidingid());
		DelayExample delayExample = new DelayExample();
		DelayExample.Criteria criteria = delayExample.createCriteria();		
		criteria.andSidingidEqualTo(delayLastInfo.getSidingid());
		List<Delay> delayOldInfoList = delayMapper.selectByExample(delayExample);
		//该五定消息总共延期的次数 实现统计延期信息的功能
		int delayInfoCount = delayOldInfoList.size();
		
		//判断当前延期信息的次数是否大于等于1
		if(delayLastInfo.getDelayseq()>=1){
			//判断当前延期次数是否是最新的值
			if(delayInfoCount-1 == delayLastInfo.getDelayseq()){
				//设置条件查询上一条延期记录
				criteria.andDelayseqEqualTo(delayLastInfo.getDelayseq()-1);
				List<Delay> delayOldInfo_List = delayMapper.selectByExample(delayExample);
				for (Delay delayOldInfo : delayOldInfo_List) {
					Date delaytimeOld = delayOldInfo.getDelaytime();
					sidingInfo.setRectificationtime(delaytimeOld);
				}
				int isUpdate = siDingBiaoMapper.updateByPrimaryKey(sidingInfo);
				//判断五定表中的记录是否已经修改
				if(isUpdate>0){
					int isDelete = delayMapper.deleteByPrimaryKey(delayId);
					//判断延迟表中的数据是否删除
					if(isDelete>0){
						isDeleteDelayInfo = true;
					}
				}
			}
			
		}
		
		return isDeleteDelayInfo;
	}

	/**
	 * 修改延期记录
	 * 
	 * @param delay修改后的记录
	 *            
	 * @return
	 * @throws Exception
	 */
	public boolean updateDelayById(Delay delay) throws Exception {
		
		int isUpdate = delayMapper.updateByPrimaryKey(delay);
		
		return isUpdate>0 ? true : false;
	}

}
