package danger.bean.sys;

/**
 * 字典实体
 * @author yuanyr
 *
 */
public class Dictionary {
	
	private String dictionaryId;
	private String name;
	private String upDictionaryId;
	private boolean isUse;
	private String description;
	
	
	public String getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpDictionaryId() {
		return upDictionaryId;
	}
	public void setUpDictionaryId(String upDictionaryId) {
		this.upDictionaryId = upDictionaryId;
	}
	public boolean isUse() {
		return isUse;
	}
	/**
	 * 容易出错
	 * @param isUse
	 */
	public void setIsUse(boolean isUse) {
		this.isUse = isUse;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Dictionary [dictionaryId=" + dictionaryId + ", name=" + name + ", upDictionaryId=" + upDictionaryId
				+ ", isUse=" + isUse + ", description=" + description + "]";
	}
	
	
}