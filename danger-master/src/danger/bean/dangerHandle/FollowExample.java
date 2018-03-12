package danger.bean.dangerHandle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FollowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowExample() {
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

        public Criteria andFollowidIsNull() {
            addCriterion("followId is null");
            return (Criteria) this;
        }

        public Criteria andFollowidIsNotNull() {
            addCriterion("followId is not null");
            return (Criteria) this;
        }

        public Criteria andFollowidEqualTo(Integer value) {
            addCriterion("followId =", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotEqualTo(Integer value) {
            addCriterion("followId <>", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidGreaterThan(Integer value) {
            addCriterion("followId >", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("followId >=", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidLessThan(Integer value) {
            addCriterion("followId <", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidLessThanOrEqualTo(Integer value) {
            addCriterion("followId <=", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidIn(List<Integer> values) {
            addCriterion("followId in", values, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotIn(List<Integer> values) {
            addCriterion("followId not in", values, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidBetween(Integer value1, Integer value2) {
            addCriterion("followId between", value1, value2, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotBetween(Integer value1, Integer value2) {
            addCriterion("followId not between", value1, value2, "followid");
            return (Criteria) this;
        }

        public Criteria andSidingidIsNull() {
            addCriterion("sidingId is null");
            return (Criteria) this;
        }

        public Criteria andSidingidIsNotNull() {
            addCriterion("sidingId is not null");
            return (Criteria) this;
        }

        public Criteria andSidingidEqualTo(Integer value) {
            addCriterion("sidingId =", value, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidNotEqualTo(Integer value) {
            addCriterion("sidingId <>", value, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidGreaterThan(Integer value) {
            addCriterion("sidingId >", value, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sidingId >=", value, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidLessThan(Integer value) {
            addCriterion("sidingId <", value, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidLessThanOrEqualTo(Integer value) {
            addCriterion("sidingId <=", value, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidIn(List<Integer> values) {
            addCriterion("sidingId in", values, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidNotIn(List<Integer> values) {
            addCriterion("sidingId not in", values, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidBetween(Integer value1, Integer value2) {
            addCriterion("sidingId between", value1, value2, "sidingid");
            return (Criteria) this;
        }

        public Criteria andSidingidNotBetween(Integer value1, Integer value2) {
            addCriterion("sidingId not between", value1, value2, "sidingid");
            return (Criteria) this;
        }

        public Criteria andDangeridIsNull() {
            addCriterion("dangerId is null");
            return (Criteria) this;
        }

        public Criteria andDangeridIsNotNull() {
            addCriterion("dangerId is not null");
            return (Criteria) this;
        }

        public Criteria andDangeridEqualTo(Integer value) {
            addCriterion("dangerId =", value, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridNotEqualTo(Integer value) {
            addCriterion("dangerId <>", value, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridGreaterThan(Integer value) {
            addCriterion("dangerId >", value, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("dangerId >=", value, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridLessThan(Integer value) {
            addCriterion("dangerId <", value, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridLessThanOrEqualTo(Integer value) {
            addCriterion("dangerId <=", value, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridIn(List<Integer> values) {
            addCriterion("dangerId in", values, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridNotIn(List<Integer> values) {
            addCriterion("dangerId not in", values, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridBetween(Integer value1, Integer value2) {
            addCriterion("dangerId between", value1, value2, "dangerid");
            return (Criteria) this;
        }

        public Criteria andDangeridNotBetween(Integer value1, Integer value2) {
            addCriterion("dangerId not between", value1, value2, "dangerid");
            return (Criteria) this;
        }

        public Criteria andHassecurityIsNull() {
            addCriterion("hasSecurity is null");
            return (Criteria) this;
        }

        public Criteria andHassecurityIsNotNull() {
            addCriterion("hasSecurity is not null");
            return (Criteria) this;
        }

        public Criteria andHassecurityEqualTo(String value) {
            addCriterion("hasSecurity =", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotEqualTo(String value) {
            addCriterion("hasSecurity <>", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityGreaterThan(String value) {
            addCriterion("hasSecurity >", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityGreaterThanOrEqualTo(String value) {
            addCriterion("hasSecurity >=", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityLessThan(String value) {
            addCriterion("hasSecurity <", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityLessThanOrEqualTo(String value) {
            addCriterion("hasSecurity <=", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityLike(String value) {
            addCriterion("hasSecurity like", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotLike(String value) {
            addCriterion("hasSecurity not like", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityIn(List<String> values) {
            addCriterion("hasSecurity in", values, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotIn(List<String> values) {
            addCriterion("hasSecurity not in", values, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityBetween(String value1, String value2) {
            addCriterion("hasSecurity between", value1, value2, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotBetween(String value1, String value2) {
            addCriterion("hasSecurity not between", value1, value2, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianIsNull() {
            addCriterion("safetyTechnician is null");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianIsNotNull() {
            addCriterion("safetyTechnician is not null");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianEqualTo(String value) {
            addCriterion("safetyTechnician =", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotEqualTo(String value) {
            addCriterion("safetyTechnician <>", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianGreaterThan(String value) {
            addCriterion("safetyTechnician >", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianGreaterThanOrEqualTo(String value) {
            addCriterion("safetyTechnician >=", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianLessThan(String value) {
            addCriterion("safetyTechnician <", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianLessThanOrEqualTo(String value) {
            addCriterion("safetyTechnician <=", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianLike(String value) {
            addCriterion("safetyTechnician like", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotLike(String value) {
            addCriterion("safetyTechnician not like", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianIn(List<String> values) {
            addCriterion("safetyTechnician in", values, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotIn(List<String> values) {
            addCriterion("safetyTechnician not in", values, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianBetween(String value1, String value2) {
            addCriterion("safetyTechnician between", value1, value2, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotBetween(String value1, String value2) {
            addCriterion("safetyTechnician not between", value1, value2, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andManagernameIsNull() {
            addCriterion("managerName is null");
            return (Criteria) this;
        }

        public Criteria andManagernameIsNotNull() {
            addCriterion("managerName is not null");
            return (Criteria) this;
        }

        public Criteria andManagernameEqualTo(String value) {
            addCriterion("managerName =", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotEqualTo(String value) {
            addCriterion("managerName <>", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThan(String value) {
            addCriterion("managerName >", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThanOrEqualTo(String value) {
            addCriterion("managerName >=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThan(String value) {
            addCriterion("managerName <", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThanOrEqualTo(String value) {
            addCriterion("managerName <=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLike(String value) {
            addCriterion("managerName like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotLike(String value) {
            addCriterion("managerName not like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameIn(List<String> values) {
            addCriterion("managerName in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotIn(List<String> values) {
            addCriterion("managerName not in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameBetween(String value1, String value2) {
            addCriterion("managerName between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotBetween(String value1, String value2) {
            addCriterion("managerName not between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andRechecktimeIsNull() {
            addCriterion("recheckTime is null");
            return (Criteria) this;
        }

        public Criteria andRechecktimeIsNotNull() {
            addCriterion("recheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andRechecktimeEqualTo(Date value) {
            addCriterion("recheckTime =", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeNotEqualTo(Date value) {
            addCriterion("recheckTime <>", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeGreaterThan(Date value) {
            addCriterion("recheckTime >", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recheckTime >=", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeLessThan(Date value) {
            addCriterion("recheckTime <", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeLessThanOrEqualTo(Date value) {
            addCriterion("recheckTime <=", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeIn(List<Date> values) {
            addCriterion("recheckTime in", values, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeNotIn(List<Date> values) {
            addCriterion("recheckTime not in", values, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeBetween(Date value1, Date value2) {
            addCriterion("recheckTime between", value1, value2, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeNotBetween(Date value1, Date value2) {
            addCriterion("recheckTime not between", value1, value2, "rechecktime");
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