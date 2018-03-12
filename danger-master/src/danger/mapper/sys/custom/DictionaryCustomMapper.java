package danger.mapper.sys.custom;

import java.util.List;
import java.util.Map;

import danger.bean.sys.Dictionary;

public interface DictionaryCustomMapper {

	int getDictionaryCountByDepartmentId(Map<String, Object> condition);

	List<Dictionary> findDictionaryByCondition(Map<String, Object> condition);

}