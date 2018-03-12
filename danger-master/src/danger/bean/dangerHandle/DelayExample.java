package danger.bean.dangerHandle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DelayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DelayExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andDelayseqIsNull() {
            addCriterion("delaySeq is null");
            return (Criteria) this;
        }

        public Criteria andDelayseqIsNotNull() {
            addCriterion("delaySeq is not null");
            return (Criteria) this;
        }

        public Criteria andDelayseqEqualTo(Integer value) {
            addCriterion("delaySeq =", value, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqNotEqualTo(Integer value) {
            addCriterion("delaySeq <>", value, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqGreaterThan(Integer value) {
            addCriterion("delaySeq >", value, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqGreaterThanOrEqualTo(Integer value) {
            addCriterion("delaySeq >=", value, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqLessThan(Integer value) {
            addCriterion("delaySeq <", value, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqLessThanOrEqualTo(Integer value) {
            addCriterion("delaySeq <=", value, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqIn(List<Integer> values) {
            addCriterion("delaySeq in", values, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqNotIn(List<Integer> values) {
            addCriterion("delaySeq not in", values, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqBetween(Integer value1, Integer value2) {
            addCriterion("delaySeq between", value1, value2, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDelayseqNotBetween(Integer value1, Integer value2) {
            addCriterion("delaySeq not between", value1, value2, "delayseq");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonIsNull() {
            addCriterion("deleayReason is null");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonIsNotNull() {
            addCriterion("deleayReason is not null");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonEqualTo(String value) {
            addCriterion("deleayReason =", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonNotEqualTo(String value) {
            addCriterion("deleayReason <>", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonGreaterThan(String value) {
            addCriterion("deleayReason >", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonGreaterThanOrEqualTo(String value) {
            addCriterion("deleayReason >=", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonLessThan(String value) {
            addCriterion("deleayReason <", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonLessThanOrEqualTo(String value) {
            addCriterion("deleayReason <=", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonLike(String value) {
            addCriterion("deleayReason like", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonNotLike(String value) {
            addCriterion("deleayReason not like", value, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonIn(List<String> values) {
            addCriterion("deleayReason in", values, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonNotIn(List<String> values) {
            addCriterion("deleayReason not in", values, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonBetween(String value1, String value2) {
            addCriterion("deleayReason between", value1, value2, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDeleayreasonNotBetween(String value1, String value2) {
            addCriterion("deleayReason not between", value1, value2, "deleayreason");
            return (Criteria) this;
        }

        public Criteria andDelaytimeIsNull() {
            addCriterion("delayTime is null");
            return (Criteria) this;
        }

        public Criteria andDelaytimeIsNotNull() {
            addCriterion("delayTime is not null");
            return (Criteria) this;
        }

        public Criteria andDelaytimeEqualTo(Date value) {
            addCriterion("delayTime =", value, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeNotEqualTo(Date value) {
            addCriterion("delayTime <>", value, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeGreaterThan(Date value) {
            addCriterion("delayTime >", value, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delayTime >=", value, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeLessThan(Date value) {
            addCriterion("delayTime <", value, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeLessThanOrEqualTo(Date value) {
            addCriterion("delayTime <=", value, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeIn(List<Date> values) {
            addCriterion("delayTime in", values, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeNotIn(List<Date> values) {
            addCriterion("delayTime not in", values, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeBetween(Date value1, Date value2) {
            addCriterion("delayTime between", value1, value2, "delaytime");
            return (Criteria) this;
        }

        public Criteria andDelaytimeNotBetween(Date value1, Date value2) {
            addCriterion("delayTime not between", value1, value2, "delaytime");
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