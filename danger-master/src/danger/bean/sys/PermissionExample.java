package danger.bean.sys;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPermissionidIsNull() {
            addCriterion("permissionId is null");
            return (Criteria) this;
        }

        public Criteria andPermissionidIsNotNull() {
            addCriterion("permissionId is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionidEqualTo(String value) {
            addCriterion("permissionId =", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotEqualTo(String value) {
            addCriterion("permissionId <>", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidGreaterThan(String value) {
            addCriterion("permissionId >", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidGreaterThanOrEqualTo(String value) {
            addCriterion("permissionId >=", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLessThan(String value) {
            addCriterion("permissionId <", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLessThanOrEqualTo(String value) {
            addCriterion("permissionId <=", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLike(String value) {
            addCriterion("permissionId like", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotLike(String value) {
            addCriterion("permissionId not like", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidIn(List<String> values) {
            addCriterion("permissionId in", values, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotIn(List<String> values) {
            addCriterion("permissionId not in", values, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidBetween(String value1, String value2) {
            addCriterion("permissionId between", value1, value2, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotBetween(String value1, String value2) {
            addCriterion("permissionId not between", value1, value2, "permissionid");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeIsNull() {
            addCriterion("permissionCode is null");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeIsNotNull() {
            addCriterion("permissionCode is not null");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeEqualTo(String value) {
            addCriterion("permissionCode =", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeNotEqualTo(String value) {
            addCriterion("permissionCode <>", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeGreaterThan(String value) {
            addCriterion("permissionCode >", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeGreaterThanOrEqualTo(String value) {
            addCriterion("permissionCode >=", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeLessThan(String value) {
            addCriterion("permissionCode <", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeLessThanOrEqualTo(String value) {
            addCriterion("permissionCode <=", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeLike(String value) {
            addCriterion("permissionCode like", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeNotLike(String value) {
            addCriterion("permissionCode not like", value, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeIn(List<String> values) {
            addCriterion("permissionCode in", values, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeNotIn(List<String> values) {
            addCriterion("permissionCode not in", values, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeBetween(String value1, String value2) {
            addCriterion("permissionCode between", value1, value2, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andPermissioncodeNotBetween(String value1, String value2) {
            addCriterion("permissionCode not between", value1, value2, "permissioncode");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("parentId like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("parentId not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentsidIsNull() {
            addCriterion("parentsId is null");
            return (Criteria) this;
        }

        public Criteria andParentsidIsNotNull() {
            addCriterion("parentsId is not null");
            return (Criteria) this;
        }

        public Criteria andParentsidEqualTo(String value) {
            addCriterion("parentsId =", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidNotEqualTo(String value) {
            addCriterion("parentsId <>", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidGreaterThan(String value) {
            addCriterion("parentsId >", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidGreaterThanOrEqualTo(String value) {
            addCriterion("parentsId >=", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidLessThan(String value) {
            addCriterion("parentsId <", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidLessThanOrEqualTo(String value) {
            addCriterion("parentsId <=", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidLike(String value) {
            addCriterion("parentsId like", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidNotLike(String value) {
            addCriterion("parentsId not like", value, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidIn(List<String> values) {
            addCriterion("parentsId in", values, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidNotIn(List<String> values) {
            addCriterion("parentsId not in", values, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidBetween(String value1, String value2) {
            addCriterion("parentsId between", value1, value2, "parentsid");
            return (Criteria) this;
        }

        public Criteria andParentsidNotBetween(String value1, String value2) {
            addCriterion("parentsId not between", value1, value2, "parentsid");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNull() {
            addCriterion("sortNo is null");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNotNull() {
            addCriterion("sortNo is not null");
            return (Criteria) this;
        }

        public Criteria andSortnoEqualTo(String value) {
            addCriterion("sortNo =", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotEqualTo(String value) {
            addCriterion("sortNo <>", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThan(String value) {
            addCriterion("sortNo >", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThanOrEqualTo(String value) {
            addCriterion("sortNo >=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThan(String value) {
            addCriterion("sortNo <", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThanOrEqualTo(String value) {
            addCriterion("sortNo <=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLike(String value) {
            addCriterion("sortNo like", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotLike(String value) {
            addCriterion("sortNo not like", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoIn(List<String> values) {
            addCriterion("sortNo in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotIn(List<String> values) {
            addCriterion("sortNo not in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoBetween(String value1, String value2) {
            addCriterion("sortNo between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotBetween(String value1, String value2) {
            addCriterion("sortNo not between", value1, value2, "sortno");
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