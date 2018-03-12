package danger.bean.sys;

import java.util.ArrayList;
import java.util.List;

public class DictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDictionaryidIsNull() {
            addCriterion("dictionaryId is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryidIsNotNull() {
            addCriterion("dictionaryId is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryidEqualTo(String value) {
            addCriterion("dictionaryId =", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotEqualTo(String value) {
            addCriterion("dictionaryId <>", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidGreaterThan(String value) {
            addCriterion("dictionaryId >", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidGreaterThanOrEqualTo(String value) {
            addCriterion("dictionaryId >=", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLessThan(String value) {
            addCriterion("dictionaryId <", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLessThanOrEqualTo(String value) {
            addCriterion("dictionaryId <=", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLike(String value) {
            addCriterion("dictionaryId like", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotLike(String value) {
            addCriterion("dictionaryId not like", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidIn(List<String> values) {
            addCriterion("dictionaryId in", values, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotIn(List<String> values) {
            addCriterion("dictionaryId not in", values, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidBetween(String value1, String value2) {
            addCriterion("dictionaryId between", value1, value2, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotBetween(String value1, String value2) {
            addCriterion("dictionaryId not between", value1, value2, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidIsNull() {
            addCriterion("upDictionaryId is null");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidIsNotNull() {
            addCriterion("upDictionaryId is not null");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidEqualTo(String value) {
            addCriterion("upDictionaryId =", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidNotEqualTo(String value) {
            addCriterion("upDictionaryId <>", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidGreaterThan(String value) {
            addCriterion("upDictionaryId >", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidGreaterThanOrEqualTo(String value) {
            addCriterion("upDictionaryId >=", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidLessThan(String value) {
            addCriterion("upDictionaryId <", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidLessThanOrEqualTo(String value) {
            addCriterion("upDictionaryId <=", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidLike(String value) {
            addCriterion("upDictionaryId like", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidNotLike(String value) {
            addCriterion("upDictionaryId not like", value, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidIn(List<String> values) {
            addCriterion("upDictionaryId in", values, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidNotIn(List<String> values) {
            addCriterion("upDictionaryId not in", values, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidBetween(String value1, String value2) {
            addCriterion("upDictionaryId between", value1, value2, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andUpdictionaryidNotBetween(String value1, String value2) {
            addCriterion("upDictionaryId not between", value1, value2, "updictionaryid");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("isUse is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("isUse is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(String value) {
            addCriterion("isUse =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(String value) {
            addCriterion("isUse <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(String value) {
            addCriterion("isUse >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(String value) {
            addCriterion("isUse >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(String value) {
            addCriterion("isUse <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(String value) {
            addCriterion("isUse <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLike(String value) {
            addCriterion("isUse like", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotLike(String value) {
            addCriterion("isUse not like", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<String> values) {
            addCriterion("isUse in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<String> values) {
            addCriterion("isUse not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(String value1, String value2) {
            addCriterion("isUse between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(String value1, String value2) {
            addCriterion("isUse not between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}