package danger.service.impl.riIdentity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.dangerManage.Danger;
import danger.bean.riIdentify.RiIdentificationRange;
import danger.mapper.riIdentify.RiIdentificationRangeMapper;
import danger.mapper.riIdentify.custom.RiIdentificationRangeCustomMapper;
import danger.service.riIdentity.RiIdentificationRangeService;
import danger.utils.PageBean;

//风险辨识范围的实现
@Service
public class RiIdentificationRangeServiceImpl implements RiIdentificationRangeService{

	@Resource
	private RiIdentificationRangeMapper riIdentificationRangeMapper;
	
	@Resource
	private RiIdentificationRangeCustomMapper riIdentificationRangeCustomMapper;
	
	/**
	 * 添加风险辨识范围信息
	 */
	@Override
	public boolean addRiIdentificationRange(RiIdentificationRange riIdentificationRange) throws Exception {
		int result = riIdentificationRangeMapper.insert(riIdentificationRange);
		return (result>0?true:false);
	}

	/**
	 * 删除风险辨识范围信息 根据主键id删除
	 */
	@Override
	public boolean delRiIdentificationRange(String idenranid) throws Exception {
		int result = riIdentificationRangeMapper.deleteByPrimaryKey(idenranid);
		return (result>0?true:false);
	}

	/**
	 * 修改风险辨识范围信息
	 */
	@Override
	public boolean updateRiIdentificationRange(RiIdentificationRange riIdentificationRange) throws Exception {
		int result = riIdentificationRangeMapper.updateByPrimaryKeySelective(riIdentificationRange);
		return (result>0?true:false);
	}

	
	/**
	 * 组合条件查询 风险辨识范围信息
	 */
	@Override
	public PageBean<RiIdentificationRange> findDangerSidingByCondition(int currentPage, int currentCount,
			Map<String, Object> condition) throws Exception {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<RiIdentificationRange> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = 0;
		totalCount = riIdentificationRangeCustomMapper.getRiIdentificationRangeCountByCondition(condition);
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
		condition.put("index", index);//当前页页号
		condition.put("currentCount", currentCount);//每页显示的记录数
		List<RiIdentificationRange> riIdentificationRangeList = riIdentificationRangeCustomMapper.findRiIdentificationRangeByCondition(condition);
		pageBean.setProductList(riIdentificationRangeList);

		return pageBean;
	}

	
	

}
