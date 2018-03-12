package danger.bean.riIdentify;

import java.util.ArrayList;
import java.util.List;

public class RiResponsibilityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiResponsibilityExample() {
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

        public Criteria andRespidIsNull() {
            addCriterion("respId is null");
            return (Criteria) this;
        }

        public Criteria andRespidIsNotNull() {
            addCriterion("respId is not null");
            return (Criteria) this;
        }

        public Criteria andRespidEqualTo(String value) {
            addCriterion("respId =", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidNotEqualTo(String value) {
            addCriterion("respId <>", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidGreaterThan(String value) {
            addCriterion("respId >", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidGreaterThanOrEqualTo(String value) {
            addCriterion("respId >=", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidLessThan(String value) {
            addCriterion("respId <", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidLessThanOrEqualTo(String value) {
            addCriterion("respId <=", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidLike(String value) {
            addCriterion("respId like", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidNotLike(String value) {
            addCriterion("respId not like", value, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidIn(List<String> values) {
            addCriterion("respId in", values, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidNotIn(List<String> values) {
            addCriterion("respId not in", values, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidBetween(String value1, String value2) {
            addCriterion("respId between", value1, value2, "respid");
            return (Criteria) this;
        }

        public Criteria andRespidNotBetween(String value1, String value2) {
            addCriterion("respId not between", value1, value2, "respid");
            return (Criteria) this;
        }

        public Criteria andQuartersIsNull() {
            addCriterion("quarters is null");
            return (Criteria) this;
        }

        public Criteria andQuartersIsNotNull() {
            addCriterion("quarters is not null");
            return (Criteria) this;
        }

        public Criteria andQuartersEqualTo(String value) {
            addCriterion("quarters =", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersNotEqualTo(String value) {
            addCriterion("quarters <>", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersGreaterThan(String value) {
            addCriterion("quarters >", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersGreaterThanOrEqualTo(String value) {
            addCriterion("quarters >=", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersLessThan(String value) {
            addCriterion("quarters <", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersLessThanOrEqualTo(String value) {
            addCriterion("quarters <=", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersLike(String value) {
            addCriterion("quarters like", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersNotLike(String value) {
            addCriterion("quarters not like", value, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersIn(List<String> values) {
            addCriterion("quarters in", values, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersNotIn(List<String> values) {
            addCriterion("quarters not in", values, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersBetween(String value1, String value2) {
            addCriterion("quarters between", value1, value2, "quarters");
            return (Criteria) this;
        }

        public Criteria andQuartersNotBetween(String value1, String value2) {
            addCriterion("quarters not between", value1, value2, "quarters");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(String value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(String value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(String value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(String value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(String value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(String value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLike(String value) {
            addCriterion("duty like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotLike(String value) {
            addCriterion("duty not like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<String> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<String> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(String value1, String value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(String value1, String value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentIsNull() {
            addCriterion("ctrlContent is null");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentIsNotNull() {
            addCriterion("ctrlContent is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentEqualTo(String value) {
            addCriterion("ctrlContent =", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentNotEqualTo(String value) {
            addCriterion("ctrlContent <>", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentGreaterThan(String value) {
            addCriterion("ctrlContent >", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentGreaterThanOrEqualTo(String value) {
            addCriterion("ctrlContent >=", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentLessThan(String value) {
            addCriterion("ctrlContent <", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentLessThanOrEqualTo(String value) {
            addCriterion("ctrlContent <=", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentLike(String value) {
            addCriterion("ctrlContent like", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentNotLike(String value) {
            addCriterion("ctrlContent not like", value, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentIn(List<String> values) {
            addCriterion("ctrlContent in", values, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentNotIn(List<String> values) {
            addCriterion("ctrlContent not in", values, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentBetween(String value1, String value2) {
            addCriterion("ctrlContent between", value1, value2, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlcontentNotBetween(String value1, String value2) {
            addCriterion("ctrlContent not between", value1, value2, "ctrlcontent");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyIsNull() {
            addCriterion("ctrlFrequency is null");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyIsNotNull() {
            addCriterion("ctrlFrequency is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyEqualTo(String value) {
            addCriterion("ctrlFrequency =", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyNotEqualTo(String value) {
            addCriterion("ctrlFrequency <>", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyGreaterThan(String value) {
            addCriterion("ctrlFrequency >", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("ctrlFrequency >=", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyLessThan(String value) {
            addCriterion("ctrlFrequency <", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyLessThanOrEqualTo(String value) {
            addCriterion("ctrlFrequency <=", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyLike(String value) {
            addCriterion("ctrlFrequency like", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyNotLike(String value) {
            addCriterion("ctrlFrequency not like", value, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyIn(List<String> values) {
            addCriterion("ctrlFrequency in", values, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyNotIn(List<String> values) {
            addCriterion("ctrlFrequency not in", values, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyBetween(String value1, String value2) {
            addCriterion("ctrlFrequency between", value1, value2, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andCtrlfrequencyNotBetween(String value1, String value2) {
            addCriterion("ctrlFrequency not between", value1, value2, "ctrlfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyIsNull() {
            addCriterion("analysisFrequency is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyIsNotNull() {
            addCriterion("analysisFrequency is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyEqualTo(String value) {
            addCriterion("analysisFrequency =", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyNotEqualTo(String value) {
            addCriterion("analysisFrequency <>", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyGreaterThan(String value) {
            addCriterion("analysisFrequency >", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("analysisFrequency >=", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyLessThan(String value) {
            addCriterion("analysisFrequency <", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyLessThanOrEqualTo(String value) {
            addCriterion("analysisFrequency <=", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyLike(String value) {
            addCriterion("analysisFrequency like", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyNotLike(String value) {
            addCriterion("analysisFrequency not like", value, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyIn(List<String> values) {
            addCriterion("analysisFrequency in", values, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyNotIn(List<String> values) {
            addCriterion("analysisFrequency not in", values, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyBetween(String value1, String value2) {
            addCriterion("analysisFrequency between", value1, value2, "analysisfrequency");
            return (Criteria) this;
        }

        public Criteria andAnalysisfrequencyNotBetween(String value1, String value2) {
            addCriterion("analysisFrequency not between", value1, value2, "analysisfrequency");
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