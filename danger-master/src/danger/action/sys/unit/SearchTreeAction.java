package danger.action.sys.unit;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import danger.service.sys.DepartmentService;
import net.sf.json.JSONArray;

/**
 * 搜索机构树action
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Component
public class SearchTreeAction extends ActionSupport {
	
	private String treeList2;           //返回的json对象
	List<Map<String, Object>> treeList; //得到java对象

	@Resource
	private DepartmentService departmentService;

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
	 * 查询机构树方法
	 * @return
	 */
	public String searchTree(){
	    try {
			this.treeList =departmentService.getUnitTree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONArray.fromObject(treeList);
		this.treeList2 = jsonArray.toString();
		return SUCCESS;
	 }
	
}