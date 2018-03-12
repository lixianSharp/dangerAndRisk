package danger.bean.riCtrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiRiskPlanAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiRiskPlanAuditExample() {
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

        public Criteria andRiskplanauditidIsNull() {
            addCriterion("riskPlanAuditId is null");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidIsNotNull() {
            addCriterion("riskPlanAuditId is not null");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidEqualTo(String value) {
            addCriterion("riskPlanAuditId =", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidNotEqualTo(String value) {
            addCriterion("riskPlanAuditId <>", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidGreaterThan(String value) {
            addCriterion("riskPlanAuditId >", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidGreaterThanOrEqualTo(String value) {
            addCriterion("riskPlanAuditId >=", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidLessThan(String value) {
            addCriterion("riskPlanAuditId <", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidLessThanOrEqualTo(String value) {
            addCriterion("riskPlanAuditId <=", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidLike(String value) {
            addCriterion("riskPlanAuditId like", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidNotLike(String value) {
            addCriterion("riskPlanAuditId not like", value, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidIn(List<String> values) {
            addCriterion("riskPlanAuditId in", values, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidNotIn(List<String> values) {
            addCriterion("riskPlanAuditId not in", values, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidBetween(String value1, String value2) {
            addCriterion("riskPlanAuditId between", value1, value2, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRiskplanauditidNotBetween(String value1, String value2) {
            addCriterion("riskPlanAuditId not between", value1, value2, "riskplanauditid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidIsNull() {
            addCriterion("riCtrlPlanId is null");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidIsNotNull() {
            addCriterion("riCtrlPlanId is not null");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidEqualTo(String value) {
            addCriterion("riCtrlPlanId =", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidNotEqualTo(String value) {
            addCriterion("riCtrlPlanId <>", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidGreaterThan(String value) {
            addCriterion("riCtrlPlanId >", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidGreaterThanOrEqualTo(String value) {
            addCriterion("riCtrlPlanId >=", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidLessThan(String value) {
            addCriterion("riCtrlPlanId <", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidLessThanOrEqualTo(String value) {
            addCriterion("riCtrlPlanId <=", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidLike(String value) {
            addCriterion("riCtrlPlanId like", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidNotLike(String value) {
            addCriterion("riCtrlPlanId not like", value, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidIn(List<String> values) {
            addCriterion("riCtrlPlanId in", values, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidNotIn(List<String> values) {
            addCriterion("riCtrlPlanId not in", values, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidBetween(String value1, String value2) {
            addCriterion("riCtrlPlanId between", value1, value2, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andRictrlplanidNotBetween(String value1, String value2) {
            addCriterion("riCtrlPlanId not between", value1, value2, "rictrlplanid");
            return (Criteria) this;
        }

        public Criteria andAuditmsgIsNull() {
            addCriterion("auditMsg is null");
            return (Criteria) this;
        }

        public Criteria andAuditmsgIsNotNull() {
            addCriterion("auditMsg is not null");
            return (Criteria) this;
        }

        public Criteria andAuditmsgEqualTo(String value) {
            addCriterion("auditMsg =", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgNotEqualTo(String value) {
            addCriterion("auditMsg <>", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgGreaterThan(String value) {
            addCriterion("auditMsg >", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgGreaterThanOrEqualTo(String value) {
            addCriterion("auditMsg >=", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgLessThan(String value) {
            addCriterion("auditMsg <", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgLessThanOrEqualTo(String value) {
            addCriterion("auditMsg <=", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgLike(String value) {
            addCriterion("auditMsg like", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgNotLike(String value) {
            addCriterion("auditMsg not like", value, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgIn(List<String> values) {
            addCriterion("auditMsg in", values, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgNotIn(List<String> values) {
            addCriterion("auditMsg not in", values, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgBetween(String value1, String value2) {
            addCriterion("auditMsg between", value1, value2, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditmsgNotBetween(String value1, String value2) {
            addCriterion("auditMsg not between", value1, value2, "auditmsg");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNull() {
            addCriterion("auditStatus is null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNotNull() {
            addCriterion("auditStatus is not null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusEqualTo(String value) {
            addCriterion("auditStatus =", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotEqualTo(String value) {
            addCriterion("auditStatus <>", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThan(String value) {
            addCriterion("auditStatus >", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThanOrEqualTo(String value) {
            addCriterion("auditStatus >=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThan(String value) {
            addCriterion("auditStatus <", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThanOrEqualTo(String value) {
            addCriterion("auditStatus <=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLike(String value) {
            addCriterion("auditStatus like", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotLike(String value) {
            addCriterion("auditStatus not like", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIn(List<String> values) {
            addCriterion("auditStatus in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotIn(List<String> values) {
            addCriterion("auditStatus not in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusBetween(String value1, String value2) {
            addCriterion("auditStatus between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotBetween(String value1, String value2) {
            addCriterion("auditStatus not between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNull() {
            addCriterion("auditTime is null");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNotNull() {
            addCriterion("auditTime is not null");
            return (Criteria) this;
        }

        public Criteria andAudittimeEqualTo(Date value) {
            addCriterion("auditTime =", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotEqualTo(Date value) {
            addCriterion("auditTime <>", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThan(Date value) {
            addCriterion("auditTime >", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auditTime >=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThan(Date value) {
            addCriterion("auditTime <", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThanOrEqualTo(Date value) {
            addCriterion("auditTime <=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIn(List<Date> values) {
            addCriterion("auditTime in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotIn(List<Date> values) {
            addCriterion("auditTime not in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeBetween(Date value1, Date value2) {
            addCriterion("auditTime between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotBetween(Date value1, Date value2) {
            addCriterion("auditTime not between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAuditpersonIsNull() {
            addCriterion("auditPerson is null");
            return (Criteria) this;
        }

        public Criteria andAuditpersonIsNotNull() {
            addCriterion("auditPerson is not null");
            return (Criteria) this;
        }

        public Criteria andAuditpersonEqualTo(String value) {
            addCriterion("auditPerson =", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonNotEqualTo(String value) {
            addCriterion("auditPerson <>", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonGreaterThan(String value) {
            addCriterion("auditPerson >", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonGreaterThanOrEqualTo(String value) {
            addCriterion("auditPerson >=", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonLessThan(String value) {
            addCriterion("auditPerson <", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonLessThanOrEqualTo(String value) {
            addCriterion("auditPerson <=", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonLike(String value) {
            addCriterion("auditPerson like", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonNotLike(String value) {
            addCriterion("auditPerson not like", value, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonIn(List<String> values) {
            addCriterion("auditPerson in", values, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonNotIn(List<String> values) {
            addCriterion("auditPerson not in", values, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonBetween(String value1, String value2) {
            addCriterion("auditPerson between", value1, value2, "auditperson");
            return (Criteria) this;
        }

        public Criteria andAuditpersonNotBetween(String value1, String value2) {
            addCriterion("auditPerson not between", value1, value2, "auditperson");
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