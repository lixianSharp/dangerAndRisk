package danger.bean.dangerHandle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SidingbiaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SidingbiaoExample() {
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

        public Criteria andSidingtimeIsNull() {
            addCriterion("sidingTime is null");
            return (Criteria) this;
        }

        public Criteria andSidingtimeIsNotNull() {
            addCriterion("sidingTime is not null");
            return (Criteria) this;
        }

        public Criteria andSidingtimeEqualTo(Date value) {
            addCriterion("sidingTime =", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeNotEqualTo(Date value) {
            addCriterion("sidingTime <>", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeGreaterThan(Date value) {
            addCriterion("sidingTime >", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sidingTime >=", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeLessThan(Date value) {
            addCriterion("sidingTime <", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeLessThanOrEqualTo(Date value) {
            addCriterion("sidingTime <=", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeIn(List<Date> values) {
            addCriterion("sidingTime in", values, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeNotIn(List<Date> values) {
            addCriterion("sidingTime not in", values, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeBetween(Date value1, Date value2) {
            addCriterion("sidingTime between", value1, value2, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeNotBetween(Date value1, Date value2) {
            addCriterion("sidingTime not between", value1, value2, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSupervisorIsNull() {
            addCriterion("supervisor is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIsNotNull() {
            addCriterion("supervisor is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorEqualTo(String value) {
            addCriterion("supervisor =", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotEqualTo(String value) {
            addCriterion("supervisor <>", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThan(String value) {
            addCriterion("supervisor >", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor >=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThan(String value) {
            addCriterion("supervisor <", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThanOrEqualTo(String value) {
            addCriterion("supervisor <=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLike(String value) {
            addCriterion("supervisor like", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotLike(String value) {
            addCriterion("supervisor not like", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorIn(List<String> values) {
            addCriterion("supervisor in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotIn(List<String> values) {
            addCriterion("supervisor not in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorBetween(String value1, String value2) {
            addCriterion("supervisor between", value1, value2, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotBetween(String value1, String value2) {
            addCriterion("supervisor not between", value1, value2, "supervisor");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeIsNull() {
            addCriterion("rectificationTime is null");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeIsNotNull() {
            addCriterion("rectificationTime is not null");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeEqualTo(Date value) {
            addCriterion("rectificationTime =", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeNotEqualTo(Date value) {
            addCriterion("rectificationTime <>", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeGreaterThan(Date value) {
            addCriterion("rectificationTime >", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rectificationTime >=", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeLessThan(Date value) {
            addCriterion("rectificationTime <", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeLessThanOrEqualTo(Date value) {
            addCriterion("rectificationTime <=", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeIn(List<Date> values) {
            addCriterion("rectificationTime in", values, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeNotIn(List<Date> values) {
            addCriterion("rectificationTime not in", values, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeBetween(Date value1, Date value2) {
            addCriterion("rectificationTime between", value1, value2, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeNotBetween(Date value1, Date value2) {
            addCriterion("rectificationTime not between", value1, value2, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureIsNull() {
            addCriterion("rectificationMeasure is null");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureIsNotNull() {
            addCriterion("rectificationMeasure is not null");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureEqualTo(String value) {
            addCriterion("rectificationMeasure =", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotEqualTo(String value) {
            addCriterion("rectificationMeasure <>", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureGreaterThan(String value) {
            addCriterion("rectificationMeasure >", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureGreaterThanOrEqualTo(String value) {
            addCriterion("rectificationMeasure >=", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureLessThan(String value) {
            addCriterion("rectificationMeasure <", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureLessThanOrEqualTo(String value) {
            addCriterion("rectificationMeasure <=", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureLike(String value) {
            addCriterion("rectificationMeasure like", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotLike(String value) {
            addCriterion("rectificationMeasure not like", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureIn(List<String> values) {
            addCriterion("rectificationMeasure in", values, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotIn(List<String> values) {
            addCriterion("rectificationMeasure not in", values, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureBetween(String value1, String value2) {
            addCriterion("rectificationMeasure between", value1, value2, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotBetween(String value1, String value2) {
            addCriterion("rectificationMeasure not between", value1, value2, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andDutypersonIsNull() {
            addCriterion("dutyPerson is null");
            return (Criteria) this;
        }

        public Criteria andDutypersonIsNotNull() {
            addCriterion("dutyPerson is not null");
            return (Criteria) this;
        }

        public Criteria andDutypersonEqualTo(String value) {
            addCriterion("dutyPerson =", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonNotEqualTo(String value) {
            addCriterion("dutyPerson <>", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonGreaterThan(String value) {
            addCriterion("dutyPerson >", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonGreaterThanOrEqualTo(String value) {
            addCriterion("dutyPerson >=", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonLessThan(String value) {
            addCriterion("dutyPerson <", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonLessThanOrEqualTo(String value) {
            addCriterion("dutyPerson <=", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonLike(String value) {
            addCriterion("dutyPerson like", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonNotLike(String value) {
            addCriterion("dutyPerson not like", value, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonIn(List<String> values) {
            addCriterion("dutyPerson in", values, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonNotIn(List<String> values) {
            addCriterion("dutyPerson not in", values, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonBetween(String value1, String value2) {
            addCriterion("dutyPerson between", value1, value2, "dutyperson");
            return (Criteria) this;
        }

        public Criteria andDutypersonNotBetween(String value1, String value2) {
            addCriterion("dutyPerson not between", value1, value2, "dutyperson");
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