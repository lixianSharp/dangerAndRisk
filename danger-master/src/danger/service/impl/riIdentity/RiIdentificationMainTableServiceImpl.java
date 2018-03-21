package danger.service.impl.riIdentity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.riIdentify.RiIdentificationMainTable;
import danger.bean.riIdentify.RiIdentificationRriskMsg;
import danger.bean.riIdentify.RiIdentificationRriskMsgExample;
import danger.mapper.riIdentify.RiIdentificationMainTableMapper;
import danger.mapper.riIdentify.RiIdentificationRriskMsgMapper;
import danger.mapper.riIdentify.custom.RiIdentificationMainTableCustomMapper;
import danger.service.riIdentity.RiIdentificationMainTableService;
import danger.service.riIdentity.RiIdentificationRriskMsgService;
import danger.utils.PageBean;
//风险辨识信息主表
@Service
public class RiIdentificationMainTableServiceImpl implements RiIdentificationMainTableService{

	@Resource
	private RiIdentificationMainTableMapper riIdentificationMainTableMapper;
	
	@Resource
	private RiIdentificationMainTableCustomMapper riIdentificationMainTableCustomMapper;
	
	//辨识风险信息
	@Resource
	private RiIdentificationRriskMsgService riIdentificationRriskMsgService;
	
	@Resource
	private RiIdentificationRriskMsgMapper riIdentificationRriskMsgMapper;
	
	
	
	/**
	 * 添加风险辨识主表信息
	 */
	@Override
	public boolean addRiIdentificationMainTable(RiIdentificationMainTable riIdentificationMainTable) throws Exception {
		int result = riIdentificationMainTableMapper.insert(riIdentificationMainTable);
		return (result>0?true:false);
	}

	/**
	 * 修改风险辨识主表信息
	 */
	@Override
	public boolean updateRiIdentificationMainTable(RiIdentificationMainTable riIdentificationMainTable)
			throws Exception {
		int result = riIdentificationMainTableMapper.updateByPrimaryKeySelective(riIdentificationMainTable);
		return (result>0?true:false);
	}

	/**
	 * 根据风险辨识主表id删除风险辨识主表信息
	 * 	 (级联删除，要先删除辨识风险信息表信息(直接调用删除辨识风险信息表的service方法)，最后再删除风险辨识主表信息)
	 */
	@Override
	public boolean delRiIdentificationMainTable(String identiryid) throws Exception {
		//0.根据辨识表id获取风险信息id
		RiIdentificationRriskMsgExample riIdentificationRriskMsgExample = new RiIdentificationRriskMsgExample();
		RiIdentificationRriskMsgExample.Criteria criteria = riIdentificationRriskMsgExample.createCriteria();
		//0.1 封装条件
		criteria.andIdentiryidEqualTo(identiryid);
		List<RiIdentificationRriskMsg> riIdentificationRriskMsgList = riIdentificationRriskMsgMapper.selectByExample(riIdentificationRriskMsgExample);
		//0.2 如果该条风险辨识主表信息有对应的辨识风险信息，则将其对应的辨识风险信息也删除   
		if(riIdentificationRriskMsgList.size()>0){
			//0.2.1(其对应的辨识风险信息有>=1条的时候)
			for(int i=0;i<riIdentificationRriskMsgList.size();i++){
				RiIdentificationRriskMsg riIdentificationRriskMsg = riIdentificationRriskMsgList.get(i);
				String riskmsgid = riIdentificationRriskMsg.getRiskmsgid();//获取风险信息id
				//1.删除辨识风险信息表信息(已经包括了辨识风险信息表的级联删除) 参数：风险信息id
				boolean result = riIdentificationRriskMsgService.delRiIdentificationRriskMsg(riskmsgid);
			}
			
			//2.根据风险辨识主表id删除风险辨识主表信息
			int result2 = riIdentificationMainTableMapper.deleteByPrimaryKey(identiryid);
			return (result2>0?true:false);
		}else{
			//2.根据风险辨识主表id删除风险辨识主表信息   其对应的辨识风险信息只有0条的时候
			int result2 = riIdentificationMainTableMapper.deleteByPrimaryKey(identiryid);
			return ((result2>0?true:false));
		}
	}

	
	
	/**
	 * 组合条件查询 风险辨识主表信息
	 */
	@Override
	public PageBean<RiIdentificationMainTable> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiIdentificationMainTable> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = riIdentificationMainTableCustomMapper.getRiIdentificationMainTableCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);// 当前页页号
		condition.put("currentCount", currentCount);// 每页显示的记录数
		List<RiIdentificationMainTable> riIdentificationMainTableList = riIdentificationMainTableCustomMapper.findRiIdentificationMainTableByCondition(condition);
		pageBean.setProductList(riIdentificationMainTableList);

		return pageBean;
	}

	
	/**
	 * 根据组合条件查询风险辨识主表信息及其对应的辨识风险信息 
	 * 			如果没有输入 identiryid，则说明是只需要显示所有风险辨识主表信息及其对应的(辨识风险信息及数量) 
	 * 			输入identiryid，则说明是查询当前风险辨识主表信息及其对应的所有辨识风险信息
	 */
	@Override
	public List<Map<String, Object>> findIdentifyMainAndRiskMsgByCondition(Map<String, Object> condition) throws Exception {
		List<Map<String, Object>> resultListMap = riIdentificationMainTableCustomMapper.findIdentifyMainAndRiskMsgByCondition(condition);
		return resultListMap;
	}

	/**
	 * 根据组合条件查询风险辨识主表信息及其对应的辨识风险信息 的总记录数
	 */
	@Override
	public Integer getIdentifyMainAndRiskMsgCountByCondition(Map<String, Object> condition) throws Exception {
		Integer currentCount = riIdentificationMainTableCustomMapper.getIdentifyMainAndRiskMsgCountByCondition(condition);
		return currentCount;
	}
	
	
	/**
	 * 根据主键id获取辨识主表信息
	 * @param identiryid
	 * @return  辨识主表信息的javabean
	 * @throws Exception
	 */
	public RiIdentificationMainTable findIdentifyMainByIdentifyId(String identiryid) throws Exception{
		RiIdentificationMainTable identificationMainTable = riIdentificationMainTableMapper.selectByPrimaryKey(identiryid);
		return identificationMainTable;
	}

	@Override
	public List<RiIdentificationMainTable> selIdentifyMainByYear(Map<String,Object> condition) throws Exception {
		List<RiIdentificationMainTable> identificationMainTableList = riIdentificationMainTableCustomMapper.selIdentifyMainByYear(condition);
		return identificationMainTableList;
	}

}
