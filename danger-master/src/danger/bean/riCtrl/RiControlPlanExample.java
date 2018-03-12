package danger.bean.riCtrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiControlPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiControlPlanExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthorweekIsNull() {
            addCriterion("monthOrWeek is null");
            return (Criteria) this;
        }

        public Criteria andMonthorweekIsNotNull() {
            addCriterion("monthOrWeek is not null");
            return (Criteria) this;
        }

        public Criteria andMonthorweekEqualTo(String value) {
            addCriterion("monthOrWeek =", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekNotEqualTo(String value) {
            addCriterion("monthOrWeek <>", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekGreaterThan(String value) {
            addCriterion("monthOrWeek >", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekGreaterThanOrEqualTo(String value) {
            addCriterion("monthOrWeek >=", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekLessThan(String value) {
            addCriterion("monthOrWeek <", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekLessThanOrEqualTo(String value) {
            addCriterion("monthOrWeek <=", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekLike(String value) {
            addCriterion("monthOrWeek like", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekNotLike(String value) {
            addCriterion("monthOrWeek not like", value, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekIn(List<String> values) {
            addCriterion("monthOrWeek in", values, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekNotIn(List<String> values) {
            addCriterion("monthOrWeek not in", values, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekBetween(String value1, String value2) {
            addCriterion("monthOrWeek between", value1, value2, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andMonthorweekNotBetween(String value1, String value2) {
            addCriterion("monthOrWeek not between", value1, value2, "monthorweek");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("specialty is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("specialty is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("specialty =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("specialty <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("specialty >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("specialty >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("specialty <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("specialty <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("specialty like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("specialty not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("specialty in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("specialty not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("specialty between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("specialty not between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkIsNull() {
            addCriterion("riskCtrlPlanMark is null");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkIsNotNull() {
            addCriterion("riskCtrlPlanMark is not null");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkEqualTo(String value) {
            addCriterion("riskCtrlPlanMark =", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkNotEqualTo(String value) {
            addCriterion("riskCtrlPlanMark <>", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkGreaterThan(String value) {
            addCriterion("riskCtrlPlanMark >", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkGreaterThanOrEqualTo(String value) {
            addCriterion("riskCtrlPlanMark >=", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkLessThan(String value) {
            addCriterion("riskCtrlPlanMark <", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkLessThanOrEqualTo(String value) {
            addCriterion("riskCtrlPlanMark <=", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkLike(String value) {
            addCriterion("riskCtrlPlanMark like", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkNotLike(String value) {
            addCriterion("riskCtrlPlanMark not like", value, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkIn(List<String> values) {
            addCriterion("riskCtrlPlanMark in", values, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkNotIn(List<String> values) {
            addCriterion("riskCtrlPlanMark not in", values, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkBetween(String value1, String value2) {
            addCriterion("riskCtrlPlanMark between", value1, value2, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andRiskctrlplanmarkNotBetween(String value1, String value2) {
            addCriterion("riskCtrlPlanMark not between", value1, value2, "riskctrlplanmark");
            return (Criteria) this;
        }

        public Criteria andReportstatusIsNull() {
            addCriterion("reportStatus is null");
            return (Criteria) this;
        }

        public Criteria andReportstatusIsNotNull() {
            addCriterion("reportStatus is not null");
            return (Criteria) this;
        }

        public Criteria andReportstatusEqualTo(String value) {
            addCriterion("reportStatus =", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusNotEqualTo(String value) {
            addCriterion("reportStatus <>", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusGreaterThan(String value) {
            addCriterion("reportStatus >", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusGreaterThanOrEqualTo(String value) {
            addCriterion("reportStatus >=", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusLessThan(String value) {
            addCriterion("reportStatus <", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusLessThanOrEqualTo(String value) {
            addCriterion("reportStatus <=", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusLike(String value) {
            addCriterion("reportStatus like", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusNotLike(String value) {
            addCriterion("reportStatus not like", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusIn(List<String> values) {
            addCriterion("reportStatus in", values, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusNotIn(List<String> values) {
            addCriterion("reportStatus not in", values, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusBetween(String value1, String value2) {
            addCriterion("reportStatus between", value1, value2, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusNotBetween(String value1, String value2) {
            addCriterion("reportStatus not between", value1, value2, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIsNull() {
            addCriterion("checkStatus is null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIsNotNull() {
            addCriterion("checkStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusEqualTo(String value) {
            addCriterion("checkStatus =", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotEqualTo(String value) {
            addCriterion("checkStatus <>", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThan(String value) {
            addCriterion("checkStatus >", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThanOrEqualTo(String value) {
            addCriterion("checkStatus >=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThan(String value) {
            addCriterion("checkStatus <", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThanOrEqualTo(String value) {
            addCriterion("checkStatus <=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLike(String value) {
            addCriterion("checkStatus like", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotLike(String value) {
            addCriterion("checkStatus not like", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIn(List<String> values) {
            addCriterion("checkStatus in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotIn(List<String> values) {
            addCriterion("checkStatus not in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusBetween(String value1, String value2) {
            addCriterion("checkStatus between", value1, value2, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotBetween(String value1, String value2) {
            addCriterion("checkStatus not between", value1, value2, "checkstatus");
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