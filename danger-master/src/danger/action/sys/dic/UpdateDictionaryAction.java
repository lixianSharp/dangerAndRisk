package danger.action.sys.dic;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import danger.bean.sys.Dictionary;
import danger.service.sys.DictionaryService;

/**
 * 更新字典action
 * @author yuanyr
 *
 */
@SuppressWarnings("serial")
@Component
public class UpdateDictionaryAction extends ActionSupport implements ModelDriven<Dictionary> {
	
	private Dictionary dictionary = new Dictionary();
	private Dictionary result;
	private boolean updateResult;
   
	@Resource
	private DictionaryService dictionaryService;
	
	
	public Dictionary getResult() {
		return result;
	}

	public void setResult(Dictionary result) {
		this.result = result;
	}

	public boolean isUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(boolean updateResult) {
		this.updateResult = updateResult;
	}
	
	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	
	/**
	 * 更新字典信息
	 * @return
	 */
	public String updateDictionary(){
		boolean updateResult = false;
		try {
			updateResult = dictionaryService.updateDictionary(dictionary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(updateResult){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	/**
	 * 查找要更新的字典信息
	 * @return
	 */
	public String getUpdateDictionary(){
		try {
			this.result = dictionaryService.getDictionaryById(dictionary.getDictionaryId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Override
	public Dictionary getModel() {
		// TODO Auto-generated method stub
		return dictionary;
	}

}