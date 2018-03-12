package danger.bean.dangerManage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RechecktableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RechecktableExample() {
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

        public Criteria andRecheckidIsNull() {
            addCriterion("recheckid is null");
            return (Criteria) this;
        }

        public Criteria andRecheckidIsNotNull() {
            addCriterion("recheckid is not null");
            return (Criteria) this;
        }

        public Criteria andRecheckidEqualTo(Integer value) {
            addCriterion("recheckid =", value, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidNotEqualTo(Integer value) {
            addCriterion("recheckid <>", value, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidGreaterThan(Integer value) {
            addCriterion("recheckid >", value, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recheckid >=", value, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidLessThan(Integer value) {
            addCriterion("recheckid <", value, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidLessThanOrEqualTo(Integer value) {
            addCriterion("recheckid <=", value, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidIn(List<Integer> values) {
            addCriterion("recheckid in", values, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidNotIn(List<Integer> values) {
            addCriterion("recheckid not in", values, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidBetween(Integer value1, Integer value2) {
            addCriterion("recheckid between", value1, value2, "recheckid");
            return (Criteria) this;
        }

        public Criteria andRecheckidNotBetween(Integer value1, Integer value2) {
            addCriterion("recheckid not between", value1, value2, "recheckid");
            return (Criteria) this;
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

        public Criteria andRecheckmanIsNull() {
            addCriterion("recheckMan is null");
            return (Criteria) this;
        }

        public Criteria andRecheckmanIsNotNull() {
            addCriterion("recheckMan is not null");
            return (Criteria) this;
        }

        public Criteria andRecheckmanEqualTo(String value) {
            addCriterion("recheckMan =", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanNotEqualTo(String value) {
            addCriterion("recheckMan <>", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanGreaterThan(String value) {
            addCriterion("recheckMan >", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanGreaterThanOrEqualTo(String value) {
            addCriterion("recheckMan >=", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanLessThan(String value) {
            addCriterion("recheckMan <", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanLessThanOrEqualTo(String value) {
            addCriterion("recheckMan <=", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanLike(String value) {
            addCriterion("recheckMan like", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanNotLike(String value) {
            addCriterion("recheckMan not like", value, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanIn(List<String> values) {
            addCriterion("recheckMan in", values, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanNotIn(List<String> values) {
            addCriterion("recheckMan not in", values, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanBetween(String value1, String value2) {
            addCriterion("recheckMan between", value1, value2, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckmanNotBetween(String value1, String value2) {
            addCriterion("recheckMan not between", value1, value2, "recheckman");
            return (Criteria) this;
        }

        public Criteria andRecheckdateIsNull() {
            addCriterion("recheckdate is null");
            return (Criteria) this;
        }

        public Criteria andRecheckdateIsNotNull() {
            addCriterion("recheckdate is not null");
            return (Criteria) this;
        }

        public Criteria andRecheckdateEqualTo(Date value) {
            addCriterion("recheckdate =", value, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateNotEqualTo(Date value) {
            addCriterion("recheckdate <>", value, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateGreaterThan(Date value) {
            addCriterion("recheckdate >", value, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateGreaterThanOrEqualTo(Date value) {
            addCriterion("recheckdate >=", value, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateLessThan(Date value) {
            addCriterion("recheckdate <", value, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateLessThanOrEqualTo(Date value) {
            addCriterion("recheckdate <=", value, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateIn(List<Date> values) {
            addCriterion("recheckdate in", values, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateNotIn(List<Date> values) {
            addCriterion("recheckdate not in", values, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateBetween(Date value1, Date value2) {
            addCriterion("recheckdate between", value1, value2, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckdateNotBetween(Date value1, Date value2) {
            addCriterion("recheckdate not between", value1, value2, "recheckdate");
            return (Criteria) this;
        }

        public Criteria andRecheckresultIsNull() {
            addCriterion("recheckresult is null");
            return (Criteria) this;
        }

        public Criteria andRecheckresultIsNotNull() {
            addCriterion("recheckresult is not null");
            return (Criteria) this;
        }

        public Criteria andRecheckresultEqualTo(String value) {
            addCriterion("recheckresult =", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultNotEqualTo(String value) {
            addCriterion("recheckresult <>", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultGreaterThan(String value) {
            addCriterion("recheckresult >", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultGreaterThanOrEqualTo(String value) {
            addCriterion("recheckresult >=", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultLessThan(String value) {
            addCriterion("recheckresult <", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultLessThanOrEqualTo(String value) {
            addCriterion("recheckresult <=", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultLike(String value) {
            addCriterion("recheckresult like", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultNotLike(String value) {
            addCriterion("recheckresult not like", value, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultIn(List<String> values) {
            addCriterion("recheckresult in", values, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultNotIn(List<String> values) {
            addCriterion("recheckresult not in", values, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultBetween(String value1, String value2) {
            addCriterion("recheckresult between", value1, value2, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andRecheckresultNotBetween(String value1, String value2) {
            addCriterion("recheckresult not between", value1, value2, "recheckresult");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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