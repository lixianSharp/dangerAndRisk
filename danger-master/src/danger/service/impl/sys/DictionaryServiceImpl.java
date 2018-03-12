package danger.service.impl.sys;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import danger.bean.sys.Dictionary;
import danger.mapper.sys.DictionaryMapper;
import danger.mapper.sys.custom.DictionaryCustomMapper;
import danger.service.sys.DictionaryService;
import danger.utils.PageBean;

/**
 * 字典service实现类
 * @author yuanyr
 *
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Resource
	private DictionaryMapper dictionaryMapper;
	
	@Resource
	private DictionaryCustomMapper dictionaryCustomMapper;
	
	
	public DictionaryMapper getDictionaryMapper() {
		return dictionaryMapper;
	}


	public void setDictionaryMapper(DictionaryMapper dictionaryMapper) {
		this.dictionaryMapper = dictionaryMapper;
	}


	public DictionaryCustomMapper getDictionaryCustomMapper() {
		return dictionaryCustomMapper;
	}


	public void setDictionaryCustomMapper(DictionaryCustomMapper dictionaryCustomMapper) {
		this.dictionaryCustomMapper = dictionaryCustomMapper;
	}


	@Override
	public List<Map<String, Object>> getDictionaryTree() throws SQLException {
		// TODO Auto-generated method stub
		return dictionaryMapper.getDictionaryTree();
	}

	
	@Override
	public boolean addDictionary(Dictionary dictionary) throws SQLException {
		// TODO Auto-generated method stub
		return dictionaryMapper.addDictionary(dictionary);
	}

	
	@Override
	public boolean deleteDictionary(String dictionaryId) throws SQLException {
		// TODO Auto-generated method stub
		
		
			return dictionaryMapper.deleteDictionary(dictionaryId);
		
		
	}
	
	@Override
	public int deleteDictionary2(String dictionaryId) throws SQLException {
		// TODO Auto-generated method stub
		
		List<Dictionary> Dictionarys =getDictionaryByUpDicId(dictionaryId);
		if(Dictionarys.size()==0){

			if(dictionaryMapper.deleteDictionary(dictionaryId)){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 2;
		}
				
		
	}

	
	@Override
	public boolean updateDictionary(Dictionary dictionary) throws SQLException {
		// TODO Auto-generated method stub
		return dictionaryMapper.updateDictionary(dictionary);
	}

	
	@Override
	public Dictionary getDictionaryById(String dictionaryId) throws SQLException {
		// TODO Auto-generated method stub
		return dictionaryMapper.getDictionaryById(dictionaryId);
	}

	
	@Override
	public List<Dictionary> getDictionaryByUpDicId(String upDictionaryId) throws SQLException {
		// TODO Auto-generated method stub
		return dictionaryMapper.getDictionaryByUpDicId(upDictionaryId);
	}

	//分页按条件查询字典
	/*@Override
	public List<Dictionary> getDictionaryByConditon(Map<String, Object> condition) throws SQLException {
		// TODO Auto-generated method stub
		return dictionaryMapper.getDictionaryByConditon(condition);
	}*/
	
	@Override
	public PageBean<Dictionary> getDictionaryByConditon(Map<String, Object> condition) throws SQLException {

		PageBean<Dictionary> pageBean = new PageBean<Dictionary>();
		System.out.println(condition.get("currentPage"));
		
		
		/*pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);*/
		
		// 1、当前页private int currentPage;
		String strcurrentPage = (String) condition.get("currentPage");
		int currentPage = Integer.valueOf(strcurrentPage);

		pageBean.setCurrentPage(currentPage);

		// 2、当前页显示的条数private int currentCount;
		String strcurrentCount = (String) condition.get("currentCount");
		int currentCount = Integer.valueOf(strcurrentCount);

		pageBean.setCurrentCount(currentCount);
		
		// 3、总条数private int totalCount;
		int totalCount = 0;
		//调用dao方法
		totalCount = dictionaryCustomMapper.getDictionaryCountByDepartmentId(condition);
		
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
		 * * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		condition.put("index", index);
		condition.put("currentCount", currentCount);
		
		pageBean.setProductList(dictionaryCustomMapper.findDictionaryByCondition(condition));
		System.out.println("pageBean.getProductList()"+pageBean.getProductList());
		return pageBean;
	}


	
	@Override
	public String getMaxDictionaryId(String upDictionaryId) throws SQLException {
		String nextId = dictionaryMapper.getMaxDictionaryId(upDictionaryId);
		if (nextId == null) {
			nextId = upDictionaryId + "001";
		} else if (Integer.parseInt(nextId) / 100 < 1000) {
			nextId = Integer.toString(Integer.parseInt(nextId) + 100);
		} else {
			nextId = Integer.toString(Integer.parseInt(nextId) + 1);
		}
		return nextId;
	}
	
}