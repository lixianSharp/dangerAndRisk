package danger.action.sys.dic;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import danger.bean.sys.Dictionary;
import danger.service.sys.DictionaryService;

/**
 * 添加字典action
 * @author yuanyr
 *
 */
@SuppressWarnings("serial")
@Component
public class AddDictionaryAction extends ActionSupport implements ModelDriven<Dictionary> {
	
	private Dictionary dictionary = new Dictionary();
	private boolean addResult;
	
	
	@Resource
	private DictionaryService dictionaryService;
	
	public boolean isAddResult() {
		return addResult;
	}

	public void setAddResult(boolean addResult) {
		this.addResult = addResult;
	}

	
	/**
	 * 添加字典方法
	 * @return
	 */
	public String addDictionary() {
		boolean result = false;
		try {
			result = dictionaryService.addDictionary(dictionary);
			this.addResult = result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Logger logger = Logger.getLogger(AddDictionaryAction.class);
			logger.info(logger);
		}
		if (result) {
			return SUCCESS;
		} 
		return ERROR;
	}

	@Override
	public Dictionary getModel() {
		// TODO Auto-generated method stub
		return dictionary;
	}

}