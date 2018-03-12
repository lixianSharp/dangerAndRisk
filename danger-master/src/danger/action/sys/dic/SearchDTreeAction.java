package danger.action.sys.dic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import net.sf.json.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import danger.service.sys.DictionaryService;

/**
 * 查询字典树action
 */
@SuppressWarnings("serial")
@Component
public class SearchDTreeAction extends ActionSupport {
	
	private String treeList2;           //返回的json对象
	List<Map<String, Object>> treeList; //得到java对象

	@Resource
	private DictionaryService dictionaryService;
	
	
	public String getTreeList2() {
		return treeList2;
	}

	public void setTreeList2(String treeList2) {
		this.treeList2 = treeList2;
	}

	public List<Map<String, Object>> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<Map<String, Object>> treeList) {
		this.treeList = treeList;
	}
	
	
	/**
	 * 查询字典树
	 * @return
	 */
	public String searchDTree(){
	     try {
			this.treeList = dictionaryService.getDictionaryTree();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONArray.fromObject(treeList);
		this.treeList2 = jsonArray.toString();
		return SUCCESS;
	 }
	
}