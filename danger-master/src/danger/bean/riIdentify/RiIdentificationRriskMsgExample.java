package danger.bean.riIdentify;

import java.util.ArrayList;
import java.util.List;

public class RiIdentificationRriskMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiIdentificationRriskMsgExample() {
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

        public Criteria andIdentiryidIsNull() {
            addCriterion("identiryId is null");
            return (Criteria) this;
        }

        public Criteria andIdentiryidIsNotNull() {
            addCriterion("identiryId is not null");
            return (Criteria) this;
        }

        public Criteria andIdentiryidEqualTo(String value) {
            addCriterion("identiryId =", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidNotEqualTo(String value) {
            addCriterion("identiryId <>", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidGreaterThan(String value) {
            addCriterion("identiryId >", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidGreaterThanOrEqualTo(String value) {
            addCriterion("identiryId >=", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidLessThan(String value) {
            addCriterion("identiryId <", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidLessThanOrEqualTo(String value) {
            addCriterion("identiryId <=", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidLike(String value) {
            addCriterion("identiryId like", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidNotLike(String value) {
            addCriterion("identiryId not like", value, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidIn(List<String> values) {
            addCriterion("identiryId in", values, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidNotIn(List<String> values) {
            addCriterion("identiryId not in", values, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidBetween(String value1, String value2) {
            addCriterion("identiryId between", value1, value2, "identiryid");
            return (Criteria) this;
        }

        public Criteria andIdentiryidNotBetween(String value1, String value2) {
            addCriterion("identiryId not between", value1, value2, "identiryid");
            return (Criteria) this;
        }

        public Criteria andRiskaddressIsNull() {
            addCriterion("riskAddress is null");
            return (Criteria) this;
        }

        public Criteria andRiskaddressIsNotNull() {
            addCriterion("riskAddress is not null");
            return (Criteria) this;
        }

        public Criteria andRiskaddressEqualTo(String value) {
            addCriterion("riskAddress =", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressNotEqualTo(String value) {
            addCriterion("riskAddress <>", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressGreaterThan(String value) {
            addCriterion("riskAddress >", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressGreaterThanOrEqualTo(String value) {
            addCriterion("riskAddress >=", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressLessThan(String value) {
            addCriterion("riskAddress <", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressLessThanOrEqualTo(String value) {
            addCriterion("riskAddress <=", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressLike(String value) {
            addCriterion("riskAddress like", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressNotLike(String value) {
            addCriterion("riskAddress not like", value, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressIn(List<String> values) {
            addCriterion("riskAddress in", values, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressNotIn(List<String> values) {
            addCriterion("riskAddress not in", values, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressBetween(String value1, String value2) {
            addCriterion("riskAddress between", value1, value2, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskaddressNotBetween(String value1, String value2) {
            addCriterion("riskAddress not between", value1, value2, "riskaddress");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeIsNull() {
            addCriterion("riskDescribe is null");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeIsNotNull() {
            addCriterion("riskDescribe is not null");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeEqualTo(String value) {
            addCriterion("riskDescribe =", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeNotEqualTo(String value) {
            addCriterion("riskDescribe <>", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeGreaterThan(String value) {
            addCriterion("riskDescribe >", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeGreaterThanOrEqualTo(String value) {
            addCriterion("riskDescribe >=", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeLessThan(String value) {
            addCriterion("riskDescribe <", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeLessThanOrEqualTo(String value) {
            addCriterion("riskDescribe <=", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeLike(String value) {
            addCriterion("riskDescribe like", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeNotLike(String value) {
            addCriterion("riskDescribe not like", value, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeIn(List<String> values) {
            addCriterion("riskDescribe in", values, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeNotIn(List<String> values) {
            addCriterion("riskDescribe not in", values, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeBetween(String value1, String value2) {
            addCriterion("riskDescribe between", value1, value2, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRiskdescribeNotBetween(String value1, String value2) {
            addCriterion("riskDescribe not between", value1, value2, "riskdescribe");
            return (Criteria) this;
        }

        public Criteria andRisktypeIsNull() {
            addCriterion("riskType is null");
            return (Criteria) this;
        }

        public Criteria andRisktypeIsNotNull() {
            addCriterion("riskType is not null");
            return (Criteria) this;
        }

        public Criteria andRisktypeEqualTo(String value) {
            addCriterion("riskType =", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeNotEqualTo(String value) {
            addCriterion("riskType <>", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeGreaterThan(String value) {
            addCriterion("riskType >", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeGreaterThanOrEqualTo(String value) {
            addCriterion("riskType >=", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeLessThan(String value) {
            addCriterion("riskType <", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeLessThanOrEqualTo(String value) {
            addCriterion("riskType <=", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeLike(String value) {
            addCriterion("riskType like", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeNotLike(String value) {
            addCriterion("riskType not like", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeIn(List<String> values) {
            addCriterion("riskType in", values, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeNotIn(List<String> values) {
            addCriterion("riskType not in", values, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeBetween(String value1, String value2) {
            addCriterion("riskType between", value1, value2, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeNotBetween(String value1, String value2) {
            addCriterion("riskType not between", value1, value2, "risktype");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesIsNull() {
            addCriterion("professionalTypes is null");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesIsNotNull() {
            addCriterion("professionalTypes is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesEqualTo(String value) {
            addCriterion("professionalTypes =", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesNotEqualTo(String value) {
            addCriterion("professionalTypes <>", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesGreaterThan(String value) {
            addCriterion("professionalTypes >", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesGreaterThanOrEqualTo(String value) {
            addCriterion("professionalTypes >=", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesLessThan(String value) {
            addCriterion("professionalTypes <", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesLessThanOrEqualTo(String value) {
            addCriterion("professionalTypes <=", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesLike(String value) {
            addCriterion("professionalTypes like", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesNotLike(String value) {
            addCriterion("professionalTypes not like", value, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesIn(List<String> values) {
            addCriterion("professionalTypes in", values, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesNotIn(List<String> values) {
            addCriterion("professionalTypes not in", values, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesBetween(String value1, String value2) {
            addCriterion("professionalTypes between", value1, value2, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andProfessionaltypesNotBetween(String value1, String value2) {
            addCriterion("professionalTypes not between", value1, value2, "professionaltypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesIsNull() {
            addCriterion("disasterTypes is null");
            return (Criteria) this;
        }

        public Criteria andDisastertypesIsNotNull() {
            addCriterion("disasterTypes is not null");
            return (Criteria) this;
        }

        public Criteria andDisastertypesEqualTo(String value) {
            addCriterion("disasterTypes =", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesNotEqualTo(String value) {
            addCriterion("disasterTypes <>", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesGreaterThan(String value) {
            addCriterion("disasterTypes >", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesGreaterThanOrEqualTo(String value) {
            addCriterion("disasterTypes >=", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesLessThan(String value) {
            addCriterion("disasterTypes <", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesLessThanOrEqualTo(String value) {
            addCriterion("disasterTypes <=", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesLike(String value) {
            addCriterion("disasterTypes like", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesNotLike(String value) {
            addCriterion("disasterTypes not like", value, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesIn(List<String> values) {
            addCriterion("disasterTypes in", values, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesNotIn(List<String> values) {
            addCriterion("disasterTypes not in", values, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesBetween(String value1, String value2) {
            addCriterion("disasterTypes between", value1, value2, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andDisastertypesNotBetween(String value1, String value2) {
            addCriterion("disasterTypes not between", value1, value2, "disastertypes");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsIsNull() {
            addCriterion("canCauseAccidents is null");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsIsNotNull() {
            addCriterion("canCauseAccidents is not null");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsEqualTo(String value) {
            addCriterion("canCauseAccidents =", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsNotEqualTo(String value) {
            addCriterion("canCauseAccidents <>", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsGreaterThan(String value) {
            addCriterion("canCauseAccidents >", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsGreaterThanOrEqualTo(String value) {
            addCriterion("canCauseAccidents >=", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsLessThan(String value) {
            addCriterion("canCauseAccidents <", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsLessThanOrEqualTo(String value) {
            addCriterion("canCauseAccidents <=", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsLike(String value) {
            addCriterion("canCauseAccidents like", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsNotLike(String value) {
            addCriterion("canCauseAccidents not like", value, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsIn(List<String> values) {
            addCriterion("canCauseAccidents in", values, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsNotIn(List<String> values) {
            addCriterion("canCauseAccidents not in", values, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsBetween(String value1, String value2) {
            addCriterion("canCauseAccidents between", value1, value2, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCancauseaccidentsNotBetween(String value1, String value2) {
            addCriterion("canCauseAccidents not between", value1, value2, "cancauseaccidents");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureIsNull() {
            addCriterion("ctrlMeasure is null");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureIsNotNull() {
            addCriterion("ctrlMeasure is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureEqualTo(String value) {
            addCriterion("ctrlMeasure =", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureNotEqualTo(String value) {
            addCriterion("ctrlMeasure <>", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureGreaterThan(String value) {
            addCriterion("ctrlMeasure >", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureGreaterThanOrEqualTo(String value) {
            addCriterion("ctrlMeasure >=", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureLessThan(String value) {
            addCriterion("ctrlMeasure <", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureLessThanOrEqualTo(String value) {
            addCriterion("ctrlMeasure <=", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureLike(String value) {
            addCriterion("ctrlMeasure like", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureNotLike(String value) {
            addCriterion("ctrlMeasure not like", value, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureIn(List<String> values) {
            addCriterion("ctrlMeasure in", values, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureNotIn(List<String> values) {
            addCriterion("ctrlMeasure not in", values, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureBetween(String value1, String value2) {
            addCriterion("ctrlMeasure between", value1, value2, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andCtrlmeasureNotBetween(String value1, String value2) {
            addCriterion("ctrlMeasure not between", value1, value2, "ctrlmeasure");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andSuperintendentIsNull() {
            addCriterion("superintendent is null");
            return (Criteria) this;
        }

        public Criteria andSuperintendentIsNotNull() {
            addCriterion("superintendent is not null");
            return (Criteria) this;
        }

        public Criteria andSuperintendentEqualTo(String value) {
            addCriterion("superintendent =", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentNotEqualTo(String value) {
            addCriterion("superintendent <>", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentGreaterThan(String value) {
            addCriterion("superintendent >", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentGreaterThanOrEqualTo(String value) {
            addCriterion("superintendent >=", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentLessThan(String value) {
            addCriterion("superintendent <", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentLessThanOrEqualTo(String value) {
            addCriterion("superintendent <=", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentLike(String value) {
            addCriterion("superintendent like", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentNotLike(String value) {
            addCriterion("superintendent not like", value, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentIn(List<String> values) {
            addCriterion("superintendent in", values, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentNotIn(List<String> values) {
            addCriterion("superintendent not in", values, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentBetween(String value1, String value2) {
            addCriterion("superintendent between", value1, value2, "superintendent");
            return (Criteria) this;
        }

        public Criteria andSuperintendentNotBetween(String value1, String value2) {
            addCriterion("superintendent not between", value1, value2, "superintendent");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodIsNull() {
            addCriterion("monitoringPeriod is null");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodIsNotNull() {
            addCriterion("monitoringPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodEqualTo(String value) {
            addCriterion("monitoringPeriod =", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodNotEqualTo(String value) {
            addCriterion("monitoringPeriod <>", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodGreaterThan(String value) {
            addCriterion("monitoringPeriod >", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodGreaterThanOrEqualTo(String value) {
            addCriterion("monitoringPeriod >=", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodLessThan(String value) {
            addCriterion("monitoringPeriod <", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodLessThanOrEqualTo(String value) {
            addCriterion("monitoringPeriod <=", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodLike(String value) {
            addCriterion("monitoringPeriod like", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodNotLike(String value) {
            addCriterion("monitoringPeriod not like", value, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodIn(List<String> values) {
            addCriterion("monitoringPeriod in", values, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodNotIn(List<String> values) {
            addCriterion("monitoringPeriod not in", values, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodBetween(String value1, String value2) {
            addCriterion("monitoringPeriod between", value1, value2, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andMonitoringperiodNotBetween(String value1, String value2) {
            addCriterion("monitoringPeriod not between", value1, value2, "monitoringperiod");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusIsNull() {
            addCriterion("evaluationStatus is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusIsNotNull() {
            addCriterion("evaluationStatus is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusEqualTo(String value) {
            addCriterion("evaluationStatus =", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusNotEqualTo(String value) {
            addCriterion("evaluationStatus <>", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusGreaterThan(String value) {
            addCriterion("evaluationStatus >", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusGreaterThanOrEqualTo(String value) {
            addCriterion("evaluationStatus >=", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusLessThan(String value) {
            addCriterion("evaluationStatus <", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusLessThanOrEqualTo(String value) {
            addCriterion("evaluationStatus <=", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusLike(String value) {
            addCriterion("evaluationStatus like", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusNotLike(String value) {
            addCriterion("evaluationStatus not like", value, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusIn(List<String> values) {
            addCriterion("evaluationStatus in", values, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusNotIn(List<String> values) {
            addCriterion("evaluationStatus not in", values, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusBetween(String value1, String value2) {
            addCriterion("evaluationStatus between", value1, value2, "evaluationstatus");
            return (Criteria) this;
        }

        public Criteria andEvaluationstatusNotBetween(String value1, String value2) {
            addCriterion("evaluationStatus not between", value1, value2, "evaluationstatus");
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