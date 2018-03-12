package danger.action.sys.dic;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import danger.service.sys.DictionaryService;

/**
 * 添加字典action
 * @author yuanyr
 *
 */
@SuppressWarnings("serial")
@Component
public class DeleteDictionaryAction extends ActionSupport {

	private String dictionaryIds;  //Ajax传过来的值（字典编号）
	private boolean deleteResult;
	private boolean deleteSingleResult;

	@Resource
	private DictionaryService dictionaryService;
	
	
	public boolean isDeleteSingleResult() {
		return deleteSingleResult;
	}

	public void setDeleteSingleResult(boolean deleteSingleResult) {
		this.deleteSingleResult = deleteSingleResult;
	}

	public String getDictionaryIds() {
		return dictionaryIds;
	}

	public void setDictionaryIds(String dictionaryIds) {
		this.dictionaryIds = dictionaryIds;
	}

	public boolean isDeleteResult() {
		return deleteResult;
	}

	public void setDeleteResult(boolean deleteResult) {
		this.deleteResult = deleteResult;
	}


	/**
	 * 批量删除字典
	 * @return
	 */
	public String deleteDictionary() {
		boolean deleteResult = false;
		//将得到的字典编号的字符串变为列表
		List<String> dictionaryIdList = java.util.Arrays.asList(dictionaryIds.split(","));
		//通过迭代达到批量删除用户的目的
		for(String dictionaryId:dictionaryIdList){
			try {
				deleteResult = dictionaryService.deleteDictionary(dictionaryId);
				this.deleteResult = deleteResult;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(deleteResult) {
			return SUCCESS;
		} else {
		return ERROR;
		}
	}
	
	
	/**
	 * 删除单条字典
	 * @return
	 */
	/*public String deleteSingleDic() {
		boolean deleteResult = false;
		
		try {
			deleteResult = dictionaryService.deleteDictionary(dictionaryIds);
			deleteSingleResult = deleteResult;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (deleteResult) {
			return SUCCESS;
		}
			return ERROR;
	}*/
	
	public String deleteSingleDic() {
		int deleteResult = 0;
		
		try {
			deleteResult = dictionaryService.deleteDictionary2(dictionaryIds);
			deleteSingleResult2 = deleteResult;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (deleteResult!=0) {
			return SUCCESS;
		}
			return ERROR;
	}
	
	private Integer deleteSingleResult2;


	public Integer getDeleteSingleResult2() {
		return deleteSingleResult2;
	}

	public void setDeleteSingleResult2(Integer deleteSingleResult2) {
		this.deleteSingleResult2 = deleteSingleResult2;
	}
	
	
}