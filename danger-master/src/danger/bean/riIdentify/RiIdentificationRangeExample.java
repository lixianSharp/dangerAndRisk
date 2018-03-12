package danger.bean.riIdentify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiIdentificationRangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiIdentificationRangeExample() {
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

        public Criteria andIdenranidIsNull() {
            addCriterion("idenRanId is null");
            return (Criteria) this;
        }

        public Criteria andIdenranidIsNotNull() {
            addCriterion("idenRanId is not null");
            return (Criteria) this;
        }

        public Criteria andIdenranidEqualTo(String value) {
            addCriterion("idenRanId =", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidNotEqualTo(String value) {
            addCriterion("idenRanId <>", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidGreaterThan(String value) {
            addCriterion("idenRanId >", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidGreaterThanOrEqualTo(String value) {
            addCriterion("idenRanId >=", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidLessThan(String value) {
            addCriterion("idenRanId <", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidLessThanOrEqualTo(String value) {
            addCriterion("idenRanId <=", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidLike(String value) {
            addCriterion("idenRanId like", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidNotLike(String value) {
            addCriterion("idenRanId not like", value, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidIn(List<String> values) {
            addCriterion("idenRanId in", values, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidNotIn(List<String> values) {
            addCriterion("idenRanId not in", values, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidBetween(String value1, String value2) {
            addCriterion("idenRanId between", value1, value2, "idenranid");
            return (Criteria) this;
        }

        public Criteria andIdenranidNotBetween(String value1, String value2) {
            addCriterion("idenRanId not between", value1, value2, "idenranid");
            return (Criteria) this;
        }

        public Criteria andFacenameIsNull() {
            addCriterion("faceName is null");
            return (Criteria) this;
        }

        public Criteria andFacenameIsNotNull() {
            addCriterion("faceName is not null");
            return (Criteria) this;
        }

        public Criteria andFacenameEqualTo(String value) {
            addCriterion("faceName =", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameNotEqualTo(String value) {
            addCriterion("faceName <>", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameGreaterThan(String value) {
            addCriterion("faceName >", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameGreaterThanOrEqualTo(String value) {
            addCriterion("faceName >=", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameLessThan(String value) {
            addCriterion("faceName <", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameLessThanOrEqualTo(String value) {
            addCriterion("faceName <=", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameLike(String value) {
            addCriterion("faceName like", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameNotLike(String value) {
            addCriterion("faceName not like", value, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameIn(List<String> values) {
            addCriterion("faceName in", values, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameNotIn(List<String> values) {
            addCriterion("faceName not in", values, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameBetween(String value1, String value2) {
            addCriterion("faceName between", value1, value2, "facename");
            return (Criteria) this;
        }

        public Criteria andFacenameNotBetween(String value1, String value2) {
            addCriterion("faceName not between", value1, value2, "facename");
            return (Criteria) this;
        }

        public Criteria andSurveyIsNull() {
            addCriterion("survey is null");
            return (Criteria) this;
        }

        public Criteria andSurveyIsNotNull() {
            addCriterion("survey is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyEqualTo(String value) {
            addCriterion("survey =", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyNotEqualTo(String value) {
            addCriterion("survey <>", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyGreaterThan(String value) {
            addCriterion("survey >", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyGreaterThanOrEqualTo(String value) {
            addCriterion("survey >=", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyLessThan(String value) {
            addCriterion("survey <", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyLessThanOrEqualTo(String value) {
            addCriterion("survey <=", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyLike(String value) {
            addCriterion("survey like", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyNotLike(String value) {
            addCriterion("survey not like", value, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyIn(List<String> values) {
            addCriterion("survey in", values, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyNotIn(List<String> values) {
            addCriterion("survey not in", values, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyBetween(String value1, String value2) {
            addCriterion("survey between", value1, value2, "survey");
            return (Criteria) this;
        }

        public Criteria andSurveyNotBetween(String value1, String value2) {
            addCriterion("survey not between", value1, value2, "survey");
            return (Criteria) this;
        }

        public Criteria andRirtypeIsNull() {
            addCriterion("rIRType is null");
            return (Criteria) this;
        }

        public Criteria andRirtypeIsNotNull() {
            addCriterion("rIRType is not null");
            return (Criteria) this;
        }

        public Criteria andRirtypeEqualTo(String value) {
            addCriterion("rIRType =", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeNotEqualTo(String value) {
            addCriterion("rIRType <>", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeGreaterThan(String value) {
            addCriterion("rIRType >", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeGreaterThanOrEqualTo(String value) {
            addCriterion("rIRType >=", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeLessThan(String value) {
            addCriterion("rIRType <", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeLessThanOrEqualTo(String value) {
            addCriterion("rIRType <=", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeLike(String value) {
            addCriterion("rIRType like", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeNotLike(String value) {
            addCriterion("rIRType not like", value, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeIn(List<String> values) {
            addCriterion("rIRType in", values, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeNotIn(List<String> values) {
            addCriterion("rIRType not in", values, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeBetween(String value1, String value2) {
            addCriterion("rIRType between", value1, value2, "rirtype");
            return (Criteria) this;
        }

        public Criteria andRirtypeNotBetween(String value1, String value2) {
            addCriterion("rIRType not between", value1, value2, "rirtype");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
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