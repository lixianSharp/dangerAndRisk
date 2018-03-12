package danger.bean.dangerHandle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpotdisposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpotdisposeExample() {
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

        public Criteria andDisposeidIsNull() {
            addCriterion("disposeId is null");
            return (Criteria) this;
        }

        public Criteria andDisposeidIsNotNull() {
            addCriterion("disposeId is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeidEqualTo(Integer value) {
            addCriterion("disposeId =", value, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidNotEqualTo(Integer value) {
            addCriterion("disposeId <>", value, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidGreaterThan(Integer value) {
            addCriterion("disposeId >", value, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposeId >=", value, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidLessThan(Integer value) {
            addCriterion("disposeId <", value, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidLessThanOrEqualTo(Integer value) {
            addCriterion("disposeId <=", value, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidIn(List<Integer> values) {
            addCriterion("disposeId in", values, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidNotIn(List<Integer> values) {
            addCriterion("disposeId not in", values, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidBetween(Integer value1, Integer value2) {
            addCriterion("disposeId between", value1, value2, "disposeid");
            return (Criteria) this;
        }

        public Criteria andDisposeidNotBetween(Integer value1, Integer value2) {
            addCriterion("disposeId not between", value1, value2, "disposeid");
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

        public Criteria andHassafemeasureIsNull() {
            addCriterion("hasSafeMeasure is null");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureIsNotNull() {
            addCriterion("hasSafeMeasure is not null");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureEqualTo(String value) {
            addCriterion("hasSafeMeasure =", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureNotEqualTo(String value) {
            addCriterion("hasSafeMeasure <>", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureGreaterThan(String value) {
            addCriterion("hasSafeMeasure >", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureGreaterThanOrEqualTo(String value) {
            addCriterion("hasSafeMeasure >=", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureLessThan(String value) {
            addCriterion("hasSafeMeasure <", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureLessThanOrEqualTo(String value) {
            addCriterion("hasSafeMeasure <=", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureLike(String value) {
            addCriterion("hasSafeMeasure like", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureNotLike(String value) {
            addCriterion("hasSafeMeasure not like", value, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureIn(List<String> values) {
            addCriterion("hasSafeMeasure in", values, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureNotIn(List<String> values) {
            addCriterion("hasSafeMeasure not in", values, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureBetween(String value1, String value2) {
            addCriterion("hasSafeMeasure between", value1, value2, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andHassafemeasureNotBetween(String value1, String value2) {
            addCriterion("hasSafeMeasure not between", value1, value2, "hassafemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureIsNull() {
            addCriterion("disposeMeasure is null");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureIsNotNull() {
            addCriterion("disposeMeasure is not null");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureEqualTo(String value) {
            addCriterion("disposeMeasure =", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureNotEqualTo(String value) {
            addCriterion("disposeMeasure <>", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureGreaterThan(String value) {
            addCriterion("disposeMeasure >", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureGreaterThanOrEqualTo(String value) {
            addCriterion("disposeMeasure >=", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureLessThan(String value) {
            addCriterion("disposeMeasure <", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureLessThanOrEqualTo(String value) {
            addCriterion("disposeMeasure <=", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureLike(String value) {
            addCriterion("disposeMeasure like", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureNotLike(String value) {
            addCriterion("disposeMeasure not like", value, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureIn(List<String> values) {
            addCriterion("disposeMeasure in", values, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureNotIn(List<String> values) {
            addCriterion("disposeMeasure not in", values, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureBetween(String value1, String value2) {
            addCriterion("disposeMeasure between", value1, value2, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposemeasureNotBetween(String value1, String value2) {
            addCriterion("disposeMeasure not between", value1, value2, "disposemeasure");
            return (Criteria) this;
        }

        public Criteria andDisposedateIsNull() {
            addCriterion("disposeDate is null");
            return (Criteria) this;
        }

        public Criteria andDisposedateIsNotNull() {
            addCriterion("disposeDate is not null");
            return (Criteria) this;
        }

        public Criteria andDisposedateEqualTo(Date value) {
            addCriterion("disposeDate =", value, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateNotEqualTo(Date value) {
            addCriterion("disposeDate <>", value, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateGreaterThan(Date value) {
            addCriterion("disposeDate >", value, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateGreaterThanOrEqualTo(Date value) {
            addCriterion("disposeDate >=", value, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateLessThan(Date value) {
            addCriterion("disposeDate <", value, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateLessThanOrEqualTo(Date value) {
            addCriterion("disposeDate <=", value, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateIn(List<Date> values) {
            addCriterion("disposeDate in", values, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateNotIn(List<Date> values) {
            addCriterion("disposeDate not in", values, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateBetween(Date value1, Date value2) {
            addCriterion("disposeDate between", value1, value2, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposedateNotBetween(Date value1, Date value2) {
            addCriterion("disposeDate not between", value1, value2, "disposedate");
            return (Criteria) this;
        }

        public Criteria andDisposepersonIsNull() {
            addCriterion("disposePerson is null");
            return (Criteria) this;
        }

        public Criteria andDisposepersonIsNotNull() {
            addCriterion("disposePerson is not null");
            return (Criteria) this;
        }

        public Criteria andDisposepersonEqualTo(String value) {
            addCriterion("disposePerson =", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonNotEqualTo(String value) {
            addCriterion("disposePerson <>", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonGreaterThan(String value) {
            addCriterion("disposePerson >", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonGreaterThanOrEqualTo(String value) {
            addCriterion("disposePerson >=", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonLessThan(String value) {
            addCriterion("disposePerson <", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonLessThanOrEqualTo(String value) {
            addCriterion("disposePerson <=", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonLike(String value) {
            addCriterion("disposePerson like", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonNotLike(String value) {
            addCriterion("disposePerson not like", value, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonIn(List<String> values) {
            addCriterion("disposePerson in", values, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonNotIn(List<String> values) {
            addCriterion("disposePerson not in", values, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonBetween(String value1, String value2) {
            addCriterion("disposePerson between", value1, value2, "disposeperson");
            return (Criteria) this;
        }

        public Criteria andDisposepersonNotBetween(String value1, String value2) {
            addCriterion("disposePerson not between", value1, value2, "disposeperson");
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