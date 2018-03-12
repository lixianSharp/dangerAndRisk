package danger.bean.riIdentify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiAssessmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiAssessmentExample() {
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

        public Criteria andAssessmentidIsNull() {
            addCriterion("assessmentId is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentidIsNotNull() {
            addCriterion("assessmentId is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentidEqualTo(String value) {
            addCriterion("assessmentId =", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidNotEqualTo(String value) {
            addCriterion("assessmentId <>", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidGreaterThan(String value) {
            addCriterion("assessmentId >", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidGreaterThanOrEqualTo(String value) {
            addCriterion("assessmentId >=", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidLessThan(String value) {
            addCriterion("assessmentId <", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidLessThanOrEqualTo(String value) {
            addCriterion("assessmentId <=", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidLike(String value) {
            addCriterion("assessmentId like", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidNotLike(String value) {
            addCriterion("assessmentId not like", value, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidIn(List<String> values) {
            addCriterion("assessmentId in", values, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidNotIn(List<String> values) {
            addCriterion("assessmentId not in", values, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidBetween(String value1, String value2) {
            addCriterion("assessmentId between", value1, value2, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andAssessmentidNotBetween(String value1, String value2) {
            addCriterion("assessmentId not between", value1, value2, "assessmentid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidIsNull() {
            addCriterion("riskMsgId is null");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidIsNotNull() {
            addCriterion("riskMsgId is not null");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidEqualTo(String value) {
            addCriterion("riskMsgId =", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidNotEqualTo(String value) {
            addCriterion("riskMsgId <>", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidGreaterThan(String value) {
            addCriterion("riskMsgId >", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidGreaterThanOrEqualTo(String value) {
            addCriterion("riskMsgId >=", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidLessThan(String value) {
            addCriterion("riskMsgId <", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidLessThanOrEqualTo(String value) {
            addCriterion("riskMsgId <=", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidLike(String value) {
            addCriterion("riskMsgId like", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidNotLike(String value) {
            addCriterion("riskMsgId not like", value, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidIn(List<String> values) {
            addCriterion("riskMsgId in", values, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidNotIn(List<String> values) {
            addCriterion("riskMsgId not in", values, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidBetween(String value1, String value2) {
            addCriterion("riskMsgId between", value1, value2, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andRiskmsgidNotBetween(String value1, String value2) {
            addCriterion("riskMsgId not between", value1, value2, "riskmsgid");
            return (Criteria) this;
        }

        public Criteria andPossibilityIsNull() {
            addCriterion("possibility is null");
            return (Criteria) this;
        }

        public Criteria andPossibilityIsNotNull() {
            addCriterion("possibility is not null");
            return (Criteria) this;
        }

        public Criteria andPossibilityEqualTo(String value) {
            addCriterion("possibility =", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityNotEqualTo(String value) {
            addCriterion("possibility <>", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityGreaterThan(String value) {
            addCriterion("possibility >", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityGreaterThanOrEqualTo(String value) {
            addCriterion("possibility >=", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityLessThan(String value) {
            addCriterion("possibility <", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityLessThanOrEqualTo(String value) {
            addCriterion("possibility <=", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityLike(String value) {
            addCriterion("possibility like", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityNotLike(String value) {
            addCriterion("possibility not like", value, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityIn(List<String> values) {
            addCriterion("possibility in", values, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityNotIn(List<String> values) {
            addCriterion("possibility not in", values, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityBetween(String value1, String value2) {
            addCriterion("possibility between", value1, value2, "possibility");
            return (Criteria) this;
        }

        public Criteria andPossibilityNotBetween(String value1, String value2) {
            addCriterion("possibility not between", value1, value2, "possibility");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureIsNull() {
            addCriterion("personDegreeOfExposure is null");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureIsNotNull() {
            addCriterion("personDegreeOfExposure is not null");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureEqualTo(String value) {
            addCriterion("personDegreeOfExposure =", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureNotEqualTo(String value) {
            addCriterion("personDegreeOfExposure <>", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureGreaterThan(String value) {
            addCriterion("personDegreeOfExposure >", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureGreaterThanOrEqualTo(String value) {
            addCriterion("personDegreeOfExposure >=", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureLessThan(String value) {
            addCriterion("personDegreeOfExposure <", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureLessThanOrEqualTo(String value) {
            addCriterion("personDegreeOfExposure <=", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureLike(String value) {
            addCriterion("personDegreeOfExposure like", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureNotLike(String value) {
            addCriterion("personDegreeOfExposure not like", value, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureIn(List<String> values) {
            addCriterion("personDegreeOfExposure in", values, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureNotIn(List<String> values) {
            addCriterion("personDegreeOfExposure not in", values, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureBetween(String value1, String value2) {
            addCriterion("personDegreeOfExposure between", value1, value2, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andPersondegreeofexposureNotBetween(String value1, String value2) {
            addCriterion("personDegreeOfExposure not between", value1, value2, "persondegreeofexposure");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesIsNull() {
            addCriterion("lossOfCconsequences is null");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesIsNotNull() {
            addCriterion("lossOfCconsequences is not null");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesEqualTo(String value) {
            addCriterion("lossOfCconsequences =", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesNotEqualTo(String value) {
            addCriterion("lossOfCconsequences <>", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesGreaterThan(String value) {
            addCriterion("lossOfCconsequences >", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesGreaterThanOrEqualTo(String value) {
            addCriterion("lossOfCconsequences >=", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesLessThan(String value) {
            addCriterion("lossOfCconsequences <", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesLessThanOrEqualTo(String value) {
            addCriterion("lossOfCconsequences <=", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesLike(String value) {
            addCriterion("lossOfCconsequences like", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesNotLike(String value) {
            addCriterion("lossOfCconsequences not like", value, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesIn(List<String> values) {
            addCriterion("lossOfCconsequences in", values, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesNotIn(List<String> values) {
            addCriterion("lossOfCconsequences not in", values, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesBetween(String value1, String value2) {
            addCriterion("lossOfCconsequences between", value1, value2, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andLossofcconsequencesNotBetween(String value1, String value2) {
            addCriterion("lossOfCconsequences not between", value1, value2, "lossofcconsequences");
            return (Criteria) this;
        }

        public Criteria andRiskvalueIsNull() {
            addCriterion("riskValue is null");
            return (Criteria) this;
        }

        public Criteria andRiskvalueIsNotNull() {
            addCriterion("riskValue is not null");
            return (Criteria) this;
        }

        public Criteria andRiskvalueEqualTo(Double value) {
            addCriterion("riskValue =", value, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueNotEqualTo(Double value) {
            addCriterion("riskValue <>", value, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueGreaterThan(Double value) {
            addCriterion("riskValue >", value, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueGreaterThanOrEqualTo(Double value) {
            addCriterion("riskValue >=", value, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueLessThan(Double value) {
            addCriterion("riskValue <", value, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueLessThanOrEqualTo(Double value) {
            addCriterion("riskValue <=", value, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueIn(List<Double> values) {
            addCriterion("riskValue in", values, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueNotIn(List<Double> values) {
            addCriterion("riskValue not in", values, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueBetween(Double value1, Double value2) {
            addCriterion("riskValue between", value1, value2, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskvalueNotBetween(Double value1, Double value2) {
            addCriterion("riskValue not between", value1, value2, "riskvalue");
            return (Criteria) this;
        }

        public Criteria andRiskgradeIsNull() {
            addCriterion("riskGrade is null");
            return (Criteria) this;
        }

        public Criteria andRiskgradeIsNotNull() {
            addCriterion("riskGrade is not null");
            return (Criteria) this;
        }

        public Criteria andRiskgradeEqualTo(String value) {
            addCriterion("riskGrade =", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeNotEqualTo(String value) {
            addCriterion("riskGrade <>", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeGreaterThan(String value) {
            addCriterion("riskGrade >", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeGreaterThanOrEqualTo(String value) {
            addCriterion("riskGrade >=", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeLessThan(String value) {
            addCriterion("riskGrade <", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeLessThanOrEqualTo(String value) {
            addCriterion("riskGrade <=", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeLike(String value) {
            addCriterion("riskGrade like", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeNotLike(String value) {
            addCriterion("riskGrade not like", value, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeIn(List<String> values) {
            addCriterion("riskGrade in", values, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeNotIn(List<String> values) {
            addCriterion("riskGrade not in", values, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeBetween(String value1, String value2) {
            addCriterion("riskGrade between", value1, value2, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andRiskgradeNotBetween(String value1, String value2) {
            addCriterion("riskGrade not between", value1, value2, "riskgrade");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeIsNull() {
            addCriterion("evaluateTime is null");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeIsNotNull() {
            addCriterion("evaluateTime is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeEqualTo(Date value) {
            addCriterion("evaluateTime =", value, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeNotEqualTo(Date value) {
            addCriterion("evaluateTime <>", value, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeGreaterThan(Date value) {
            addCriterion("evaluateTime >", value, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evaluateTime >=", value, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeLessThan(Date value) {
            addCriterion("evaluateTime <", value, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeLessThanOrEqualTo(Date value) {
            addCriterion("evaluateTime <=", value, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeIn(List<Date> values) {
            addCriterion("evaluateTime in", values, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeNotIn(List<Date> values) {
            addCriterion("evaluateTime not in", values, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeBetween(Date value1, Date value2) {
            addCriterion("evaluateTime between", value1, value2, "evaluatetime");
            return (Criteria) this;
        }

        public Criteria andEvaluatetimeNotBetween(Date value1, Date value2) {
            addCriterion("evaluateTime not between", value1, value2, "evaluatetime");
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