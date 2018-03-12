package danger.bean.riCtrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiDetailedOfRiskCtrlPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiDetailedOfRiskCtrlPlanExample() {
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

        public Criteria andDetailedofriskctrlplanidIsNull() {
            addCriterion("detailedOfRiskCtrlPlanId is null");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidIsNotNull() {
            addCriterion("detailedOfRiskCtrlPlanId is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidEqualTo(String value) {
            addCriterion("detailedOfRiskCtrlPlanId =", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidNotEqualTo(String value) {
            addCriterion("detailedOfRiskCtrlPlanId <>", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidGreaterThan(String value) {
            addCriterion("detailedOfRiskCtrlPlanId >", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidGreaterThanOrEqualTo(String value) {
            addCriterion("detailedOfRiskCtrlPlanId >=", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidLessThan(String value) {
            addCriterion("detailedOfRiskCtrlPlanId <", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidLessThanOrEqualTo(String value) {
            addCriterion("detailedOfRiskCtrlPlanId <=", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidLike(String value) {
            addCriterion("detailedOfRiskCtrlPlanId like", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidNotLike(String value) {
            addCriterion("detailedOfRiskCtrlPlanId not like", value, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidIn(List<String> values) {
            addCriterion("detailedOfRiskCtrlPlanId in", values, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidNotIn(List<String> values) {
            addCriterion("detailedOfRiskCtrlPlanId not in", values, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidBetween(String value1, String value2) {
            addCriterion("detailedOfRiskCtrlPlanId between", value1, value2, "detailedofriskctrlplanid");
            return (Criteria) this;
        }

        public Criteria andDetailedofriskctrlplanidNotBetween(String value1, String value2) {
            addCriterion("detailedOfRiskCtrlPlanId not between", value1, value2, "detailedofriskctrlplanid");
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

        public Criteria andDutydepartmentIsNull() {
            addCriterion("dutyDepartment is null");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentIsNotNull() {
            addCriterion("dutyDepartment is not null");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentEqualTo(String value) {
            addCriterion("dutyDepartment =", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentNotEqualTo(String value) {
            addCriterion("dutyDepartment <>", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentGreaterThan(String value) {
            addCriterion("dutyDepartment >", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("dutyDepartment >=", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentLessThan(String value) {
            addCriterion("dutyDepartment <", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentLessThanOrEqualTo(String value) {
            addCriterion("dutyDepartment <=", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentLike(String value) {
            addCriterion("dutyDepartment like", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentNotLike(String value) {
            addCriterion("dutyDepartment not like", value, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentIn(List<String> values) {
            addCriterion("dutyDepartment in", values, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentNotIn(List<String> values) {
            addCriterion("dutyDepartment not in", values, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentBetween(String value1, String value2) {
            addCriterion("dutyDepartment between", value1, value2, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andDutydepartmentNotBetween(String value1, String value2) {
            addCriterion("dutyDepartment not between", value1, value2, "dutydepartment");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresIsNull() {
            addCriterion("implementationOfMeasures is null");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresIsNotNull() {
            addCriterion("implementationOfMeasures is not null");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresEqualTo(String value) {
            addCriterion("implementationOfMeasures =", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresNotEqualTo(String value) {
            addCriterion("implementationOfMeasures <>", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresGreaterThan(String value) {
            addCriterion("implementationOfMeasures >", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("implementationOfMeasures >=", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresLessThan(String value) {
            addCriterion("implementationOfMeasures <", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresLessThanOrEqualTo(String value) {
            addCriterion("implementationOfMeasures <=", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresLike(String value) {
            addCriterion("implementationOfMeasures like", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresNotLike(String value) {
            addCriterion("implementationOfMeasures not like", value, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresIn(List<String> values) {
            addCriterion("implementationOfMeasures in", values, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresNotIn(List<String> values) {
            addCriterion("implementationOfMeasures not in", values, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresBetween(String value1, String value2) {
            addCriterion("implementationOfMeasures between", value1, value2, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andImplementationofmeasuresNotBetween(String value1, String value2) {
            addCriterion("implementationOfMeasures not between", value1, value2, "implementationofmeasures");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidIsNull() {
            addCriterion("measureIsValid is null");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidIsNotNull() {
            addCriterion("measureIsValid is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidEqualTo(String value) {
            addCriterion("measureIsValid =", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidNotEqualTo(String value) {
            addCriterion("measureIsValid <>", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidGreaterThan(String value) {
            addCriterion("measureIsValid >", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidGreaterThanOrEqualTo(String value) {
            addCriterion("measureIsValid >=", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidLessThan(String value) {
            addCriterion("measureIsValid <", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidLessThanOrEqualTo(String value) {
            addCriterion("measureIsValid <=", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidLike(String value) {
            addCriterion("measureIsValid like", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidNotLike(String value) {
            addCriterion("measureIsValid not like", value, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidIn(List<String> values) {
            addCriterion("measureIsValid in", values, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidNotIn(List<String> values) {
            addCriterion("measureIsValid not in", values, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidBetween(String value1, String value2) {
            addCriterion("measureIsValid between", value1, value2, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andMeasureisvalidNotBetween(String value1, String value2) {
            addCriterion("measureIsValid not between", value1, value2, "measureisvalid");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationIsNull() {
            addCriterion("inspectionSituation is null");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationIsNotNull() {
            addCriterion("inspectionSituation is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationEqualTo(String value) {
            addCriterion("inspectionSituation =", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationNotEqualTo(String value) {
            addCriterion("inspectionSituation <>", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationGreaterThan(String value) {
            addCriterion("inspectionSituation >", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationGreaterThanOrEqualTo(String value) {
            addCriterion("inspectionSituation >=", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationLessThan(String value) {
            addCriterion("inspectionSituation <", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationLessThanOrEqualTo(String value) {
            addCriterion("inspectionSituation <=", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationLike(String value) {
            addCriterion("inspectionSituation like", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationNotLike(String value) {
            addCriterion("inspectionSituation not like", value, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationIn(List<String> values) {
            addCriterion("inspectionSituation in", values, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationNotIn(List<String> values) {
            addCriterion("inspectionSituation not in", values, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationBetween(String value1, String value2) {
            addCriterion("inspectionSituation between", value1, value2, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andInspectionsituationNotBetween(String value1, String value2) {
            addCriterion("inspectionSituation not between", value1, value2, "inspectionsituation");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeIsNull() {
            addCriterion("analysisTime is null");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeIsNotNull() {
            addCriterion("analysisTime is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeEqualTo(Date value) {
            addCriterion("analysisTime =", value, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeNotEqualTo(Date value) {
            addCriterion("analysisTime <>", value, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeGreaterThan(Date value) {
            addCriterion("analysisTime >", value, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysisTime >=", value, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeLessThan(Date value) {
            addCriterion("analysisTime <", value, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeLessThanOrEqualTo(Date value) {
            addCriterion("analysisTime <=", value, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeIn(List<Date> values) {
            addCriterion("analysisTime in", values, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeNotIn(List<Date> values) {
            addCriterion("analysisTime not in", values, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeBetween(Date value1, Date value2) {
            addCriterion("analysisTime between", value1, value2, "analysistime");
            return (Criteria) this;
        }

        public Criteria andAnalysistimeNotBetween(Date value1, Date value2) {
            addCriterion("analysisTime not between", value1, value2, "analysistime");
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