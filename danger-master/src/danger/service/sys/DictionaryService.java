package danger.service.sys;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import danger.bean.sys.Dictionary;
import danger.utils.PageBean;

/**
 * 字典service
 * @author yuanyr
 *
 */
public interface DictionaryService {
	
	
	/**
     * 查询字典树信息
     * @return
     * @throws SQLException
     */
	public List<Map<String,Object>> getDictionaryTree() throws SQLException;
	
	
	/**
	 * 添加字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean addDictionary(Dictionary dictionary) throws SQLException;
	

	/**
	 * 根据字典Id删除字典信息
	 * @param dictionaryId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteDictionary(String dictionaryId) throws SQLException;
	
	
	/**
	 * 修改字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean updateDictionary(Dictionary dictionary) throws SQLException;
	
	
	/**
	 * 根据字典编号查询字典信息
	 * @param dictionaryId
	 * @return
	 * @throws SQLException
	 */
	public Dictionary getDictionaryById(String dictionaryId) throws SQLException;
	
	
	/**
	 * 根据上级字典编号查询字典信息
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException
	 */
	public List<Dictionary> getDictionaryByUpDicId(String upDictionaryId) throws SQLException;
	
	
	/**
	 * 根据条件查询字典信息(分页)
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	//public List<Dictionary> getDictionaryByConditon(Map<String,Object> condition) throws SQLException;
	public PageBean<Dictionary> getDictionaryByConditon(Map<String,Object> condition) throws SQLException;
	
	/**
	 * 根据上级字典Id查询下一个要插入的下一级字典的编号 
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException
	 */
	public String getMaxDictionaryId(String upDictionaryId) throws SQLException;

	//删除下级字典
	int deleteDictionary2(String dictionaryId) throws SQLException;
	
}