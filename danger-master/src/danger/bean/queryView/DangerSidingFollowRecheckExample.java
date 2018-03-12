package danger.bean.queryView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DangerSidingFollowRecheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DangerSidingFollowRecheckExample() {
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

        public Criteria andFindtimeIsNull() {
            addCriterion("findtime is null");
            return (Criteria) this;
        }

        public Criteria andFindtimeIsNotNull() {
            addCriterion("findtime is not null");
            return (Criteria) this;
        }

        public Criteria andFindtimeEqualTo(Date value) {
            addCriterion("findtime =", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotEqualTo(Date value) {
            addCriterion("findtime <>", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeGreaterThan(Date value) {
            addCriterion("findtime >", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("findtime >=", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeLessThan(Date value) {
            addCriterion("findtime <", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeLessThanOrEqualTo(Date value) {
            addCriterion("findtime <=", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeIn(List<Date> values) {
            addCriterion("findtime in", values, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotIn(List<Date> values) {
            addCriterion("findtime not in", values, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeBetween(Date value1, Date value2) {
            addCriterion("findtime between", value1, value2, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotBetween(Date value1, Date value2) {
            addCriterion("findtime not between", value1, value2, "findtime");
            return (Criteria) this;
        }

        public Criteria andClasstypeIsNull() {
            addCriterion("classtype is null");
            return (Criteria) this;
        }

        public Criteria andClasstypeIsNotNull() {
            addCriterion("classtype is not null");
            return (Criteria) this;
        }

        public Criteria andClasstypeEqualTo(String value) {
            addCriterion("classtype =", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeNotEqualTo(String value) {
            addCriterion("classtype <>", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeGreaterThan(String value) {
            addCriterion("classtype >", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeGreaterThanOrEqualTo(String value) {
            addCriterion("classtype >=", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeLessThan(String value) {
            addCriterion("classtype <", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeLessThanOrEqualTo(String value) {
            addCriterion("classtype <=", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeLike(String value) {
            addCriterion("classtype like", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeNotLike(String value) {
            addCriterion("classtype not like", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeIn(List<String> values) {
            addCriterion("classtype in", values, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeNotIn(List<String> values) {
            addCriterion("classtype not in", values, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeBetween(String value1, String value2) {
            addCriterion("classtype between", value1, value2, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeNotBetween(String value1, String value2) {
            addCriterion("classtype not between", value1, value2, "classtype");
            return (Criteria) this;
        }

        public Criteria andFindpersonIsNull() {
            addCriterion("findperson is null");
            return (Criteria) this;
        }

        public Criteria andFindpersonIsNotNull() {
            addCriterion("findperson is not null");
            return (Criteria) this;
        }

        public Criteria andFindpersonEqualTo(String value) {
            addCriterion("findperson =", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonNotEqualTo(String value) {
            addCriterion("findperson <>", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonGreaterThan(String value) {
            addCriterion("findperson >", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonGreaterThanOrEqualTo(String value) {
            addCriterion("findperson >=", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonLessThan(String value) {
            addCriterion("findperson <", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonLessThanOrEqualTo(String value) {
            addCriterion("findperson <=", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonLike(String value) {
            addCriterion("findperson like", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonNotLike(String value) {
            addCriterion("findperson not like", value, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonIn(List<String> values) {
            addCriterion("findperson in", values, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonNotIn(List<String> values) {
            addCriterion("findperson not in", values, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonBetween(String value1, String value2) {
            addCriterion("findperson between", value1, value2, "findperson");
            return (Criteria) this;
        }

        public Criteria andFindpersonNotBetween(String value1, String value2) {
            addCriterion("findperson not between", value1, value2, "findperson");
            return (Criteria) this;
        }

        public Criteria andCheckunitIsNull() {
            addCriterion("checkunit is null");
            return (Criteria) this;
        }

        public Criteria andCheckunitIsNotNull() {
            addCriterion("checkunit is not null");
            return (Criteria) this;
        }

        public Criteria andCheckunitEqualTo(String value) {
            addCriterion("checkunit =", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitNotEqualTo(String value) {
            addCriterion("checkunit <>", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitGreaterThan(String value) {
            addCriterion("checkunit >", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitGreaterThanOrEqualTo(String value) {
            addCriterion("checkunit >=", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitLessThan(String value) {
            addCriterion("checkunit <", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitLessThanOrEqualTo(String value) {
            addCriterion("checkunit <=", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitLike(String value) {
            addCriterion("checkunit like", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitNotLike(String value) {
            addCriterion("checkunit not like", value, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitIn(List<String> values) {
            addCriterion("checkunit in", values, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitNotIn(List<String> values) {
            addCriterion("checkunit not in", values, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitBetween(String value1, String value2) {
            addCriterion("checkunit between", value1, value2, "checkunit");
            return (Criteria) this;
        }

        public Criteria andCheckunitNotBetween(String value1, String value2) {
            addCriterion("checkunit not between", value1, value2, "checkunit");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andDangergradeIsNull() {
            addCriterion("dangerGrade is null");
            return (Criteria) this;
        }

        public Criteria andDangergradeIsNotNull() {
            addCriterion("dangerGrade is not null");
            return (Criteria) this;
        }

        public Criteria andDangergradeEqualTo(String value) {
            addCriterion("dangerGrade =", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeNotEqualTo(String value) {
            addCriterion("dangerGrade <>", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeGreaterThan(String value) {
            addCriterion("dangerGrade >", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeGreaterThanOrEqualTo(String value) {
            addCriterion("dangerGrade >=", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeLessThan(String value) {
            addCriterion("dangerGrade <", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeLessThanOrEqualTo(String value) {
            addCriterion("dangerGrade <=", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeLike(String value) {
            addCriterion("dangerGrade like", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeNotLike(String value) {
            addCriterion("dangerGrade not like", value, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeIn(List<String> values) {
            addCriterion("dangerGrade in", values, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeNotIn(List<String> values) {
            addCriterion("dangerGrade not in", values, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeBetween(String value1, String value2) {
            addCriterion("dangerGrade between", value1, value2, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andDangergradeNotBetween(String value1, String value2) {
            addCriterion("dangerGrade not between", value1, value2, "dangergrade");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumIsNull() {
            addCriterion("dangerStatusNum is null");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumIsNotNull() {
            addCriterion("dangerStatusNum is not null");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumEqualTo(String value) {
            addCriterion("dangerStatusNum =", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumNotEqualTo(String value) {
            addCriterion("dangerStatusNum <>", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumGreaterThan(String value) {
            addCriterion("dangerStatusNum >", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumGreaterThanOrEqualTo(String value) {
            addCriterion("dangerStatusNum >=", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumLessThan(String value) {
            addCriterion("dangerStatusNum <", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumLessThanOrEqualTo(String value) {
            addCriterion("dangerStatusNum <=", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumLike(String value) {
            addCriterion("dangerStatusNum like", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumNotLike(String value) {
            addCriterion("dangerStatusNum not like", value, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumIn(List<String> values) {
            addCriterion("dangerStatusNum in", values, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumNotIn(List<String> values) {
            addCriterion("dangerStatusNum not in", values, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumBetween(String value1, String value2) {
            addCriterion("dangerStatusNum between", value1, value2, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusnumNotBetween(String value1, String value2) {
            addCriterion("dangerStatusNum not between", value1, value2, "dangerstatusnum");
            return (Criteria) this;
        }

        public Criteria andDangerstatusIsNull() {
            addCriterion("dangerStatus is null");
            return (Criteria) this;
        }

        public Criteria andDangerstatusIsNotNull() {
            addCriterion("dangerStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDangerstatusEqualTo(String value) {
            addCriterion("dangerStatus =", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusNotEqualTo(String value) {
            addCriterion("dangerStatus <>", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusGreaterThan(String value) {
            addCriterion("dangerStatus >", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusGreaterThanOrEqualTo(String value) {
            addCriterion("dangerStatus >=", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusLessThan(String value) {
            addCriterion("dangerStatus <", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusLessThanOrEqualTo(String value) {
            addCriterion("dangerStatus <=", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusLike(String value) {
            addCriterion("dangerStatus like", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusNotLike(String value) {
            addCriterion("dangerStatus not like", value, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusIn(List<String> values) {
            addCriterion("dangerStatus in", values, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusNotIn(List<String> values) {
            addCriterion("dangerStatus not in", values, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusBetween(String value1, String value2) {
            addCriterion("dangerStatus between", value1, value2, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerstatusNotBetween(String value1, String value2) {
            addCriterion("dangerStatus not between", value1, value2, "dangerstatus");
            return (Criteria) this;
        }

        public Criteria andDangerreportIsNull() {
            addCriterion("dangerReport is null");
            return (Criteria) this;
        }

        public Criteria andDangerreportIsNotNull() {
            addCriterion("dangerReport is not null");
            return (Criteria) this;
        }

        public Criteria andDangerreportEqualTo(String value) {
            addCriterion("dangerReport =", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportNotEqualTo(String value) {
            addCriterion("dangerReport <>", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportGreaterThan(String value) {
            addCriterion("dangerReport >", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportGreaterThanOrEqualTo(String value) {
            addCriterion("dangerReport >=", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportLessThan(String value) {
            addCriterion("dangerReport <", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportLessThanOrEqualTo(String value) {
            addCriterion("dangerReport <=", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportLike(String value) {
            addCriterion("dangerReport like", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportNotLike(String value) {
            addCriterion("dangerReport not like", value, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportIn(List<String> values) {
            addCriterion("dangerReport in", values, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportNotIn(List<String> values) {
            addCriterion("dangerReport not in", values, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportBetween(String value1, String value2) {
            addCriterion("dangerReport between", value1, value2, "dangerreport");
            return (Criteria) this;
        }

        public Criteria andDangerreportNotBetween(String value1, String value2) {
            addCriterion("dangerReport not between", value1, value2, "dangerreport");
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

        public Criteria andSidingtimeIsNull() {
            addCriterion("sidingTime is null");
            return (Criteria) this;
        }

        public Criteria andSidingtimeIsNotNull() {
            addCriterion("sidingTime is not null");
            return (Criteria) this;
        }

        public Criteria andSidingtimeEqualTo(Date value) {
            addCriterion("sidingTime =", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeNotEqualTo(Date value) {
            addCriterion("sidingTime <>", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeGreaterThan(Date value) {
            addCriterion("sidingTime >", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sidingTime >=", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeLessThan(Date value) {
            addCriterion("sidingTime <", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeLessThanOrEqualTo(Date value) {
            addCriterion("sidingTime <=", value, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeIn(List<Date> values) {
            addCriterion("sidingTime in", values, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeNotIn(List<Date> values) {
            addCriterion("sidingTime not in", values, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeBetween(Date value1, Date value2) {
            addCriterion("sidingTime between", value1, value2, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSidingtimeNotBetween(Date value1, Date value2) {
            addCriterion("sidingTime not between", value1, value2, "sidingtime");
            return (Criteria) this;
        }

        public Criteria andSupervisorIsNull() {
            addCriterion("supervisor is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIsNotNull() {
            addCriterion("supervisor is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorEqualTo(String value) {
            addCriterion("supervisor =", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotEqualTo(String value) {
            addCriterion("supervisor <>", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThan(String value) {
            addCriterion("supervisor >", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor >=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThan(String value) {
            addCriterion("supervisor <", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThanOrEqualTo(String value) {
            addCriterion("supervisor <=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLike(String value) {
            addCriterion("supervisor like", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotLike(String value) {
            addCriterion("supervisor not like", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorIn(List<String> values) {
            addCriterion("supervisor in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotIn(List<String> values) {
            addCriterion("supervisor not in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorBetween(String value1, String value2) {
            addCriterion("supervisor between", value1, value2, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotBetween(String value1, String value2) {
            addCriterion("supervisor not between", value1, value2, "supervisor");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeIsNull() {
            addCriterion("rectificationTime is null");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeIsNotNull() {
            addCriterion("rectificationTime is not null");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeEqualTo(Date value) {
            addCriterion("rectificationTime =", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeNotEqualTo(Date value) {
            addCriterion("rectificationTime <>", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeGreaterThan(Date value) {
            addCriterion("rectificationTime >", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rectificationTime >=", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeLessThan(Date value) {
            addCriterion("rectificationTime <", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeLessThanOrEqualTo(Date value) {
            addCriterion("rectificationTime <=", value, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeIn(List<Date> values) {
            addCriterion("rectificationTime in", values, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeNotIn(List<Date> values) {
            addCriterion("rectificationTime not in", values, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeBetween(Date value1, Date value2) {
            addCriterion("rectificationTime between", value1, value2, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationtimeNotBetween(Date value1, Date value2) {
            addCriterion("rectificationTime not between", value1, value2, "rectificationtime");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureIsNull() {
            addCriterion("rectificationMeasure is null");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureIsNotNull() {
            addCriterion("rectificationMeasure is not null");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureEqualTo(String value) {
            addCriterion("rectificationMeasure =", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotEqualTo(String value) {
            addCriterion("rectificationMeasure <>", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureGreaterThan(String value) {
            addCriterion("rectificationMeasure >", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureGreaterThanOrEqualTo(String value) {
            addCriterion("rectificationMeasure >=", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureLessThan(String value) {
            addCriterion("rectificationMeasure <", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureLessThanOrEqualTo(String value) {
            addCriterion("rectificationMeasure <=", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureLike(String value) {
            addCriterion("rectificationMeasure like", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotLike(String value) {
            addCriterion("rectificationMeasure not like", value, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureIn(List<String> values) {
            addCriterion("rectificationMeasure in", values, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotIn(List<String> values) {
            addCriterion("rectificationMeasure not in", values, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureBetween(String value1, String value2) {
            addCriterion("rectificationMeasure between", value1, value2, "rectificationmeasure");
            return (Criteria) this;
        }

        public Criteria andRectificationmeasureNotBetween(String value1, String value2) {
            addCriterion("rectificationMeasure not between", value1, value2, "rectificationmeasure");
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

        public Criteria andHassecurityIsNull() {
            addCriterion("hasSecurity is null");
            return (Criteria) this;
        }

        public Criteria andHassecurityIsNotNull() {
            addCriterion("hasSecurity is not null");
            return (Criteria) this;
        }

        public Criteria andHassecurityEqualTo(String value) {
            addCriterion("hasSecurity =", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotEqualTo(String value) {
            addCriterion("hasSecurity <>", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityGreaterThan(String value) {
            addCriterion("hasSecurity >", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityGreaterThanOrEqualTo(String value) {
            addCriterion("hasSecurity >=", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityLessThan(String value) {
            addCriterion("hasSecurity <", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityLessThanOrEqualTo(String value) {
            addCriterion("hasSecurity <=", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityLike(String value) {
            addCriterion("hasSecurity like", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotLike(String value) {
            addCriterion("hasSecurity not like", value, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityIn(List<String> values) {
            addCriterion("hasSecurity in", values, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotIn(List<String> values) {
            addCriterion("hasSecurity not in", values, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityBetween(String value1, String value2) {
            addCriterion("hasSecurity between", value1, value2, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andHassecurityNotBetween(String value1, String value2) {
            addCriterion("hasSecurity not between", value1, value2, "hassecurity");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianIsNull() {
            addCriterion("safetyTechnician is null");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianIsNotNull() {
            addCriterion("safetyTechnician is not null");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianEqualTo(String value) {
            addCriterion("safetyTechnician =", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotEqualTo(String value) {
            addCriterion("safetyTechnician <>", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianGreaterThan(String value) {
            addCriterion("safetyTechnician >", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianGreaterThanOrEqualTo(String value) {
            addCriterion("safetyTechnician >=", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianLessThan(String value) {
            addCriterion("safetyTechnician <", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianLessThanOrEqualTo(String value) {
            addCriterion("safetyTechnician <=", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianLike(String value) {
            addCriterion("safetyTechnician like", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotLike(String value) {
            addCriterion("safetyTechnician not like", value, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianIn(List<String> values) {
            addCriterion("safetyTechnician in", values, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotIn(List<String> values) {
            addCriterion("safetyTechnician not in", values, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianBetween(String value1, String value2) {
            addCriterion("safetyTechnician between", value1, value2, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andSafetytechnicianNotBetween(String value1, String value2) {
            addCriterion("safetyTechnician not between", value1, value2, "safetytechnician");
            return (Criteria) this;
        }

        public Criteria andManagernameIsNull() {
            addCriterion("managerName is null");
            return (Criteria) this;
        }

        public Criteria andManagernameIsNotNull() {
            addCriterion("managerName is not null");
            return (Criteria) this;
        }

        public Criteria andManagernameEqualTo(String value) {
            addCriterion("managerName =", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotEqualTo(String value) {
            addCriterion("managerName <>", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThan(String value) {
            addCriterion("managerName >", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThanOrEqualTo(String value) {
            addCriterion("managerName >=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThan(String value) {
            addCriterion("managerName <", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThanOrEqualTo(String value) {
            addCriterion("managerName <=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLike(String value) {
            addCriterion("managerName like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotLike(String value) {
            addCriterion("managerName not like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameIn(List<String> values) {
            addCriterion("managerName in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotIn(List<String> values) {
            addCriterion("managerName not in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameBetween(String value1, String value2) {
            addCriterion("managerName between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotBetween(String value1, String value2) {
            addCriterion("managerName not between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andRechecktimeIsNull() {
            addCriterion("recheckTime is null");
            return (Criteria) this;
        }

        public Criteria andRechecktimeIsNotNull() {
            addCriterion("recheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andRechecktimeEqualTo(Date value) {
            addCriterion("recheckTime =", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeNotEqualTo(Date value) {
            addCriterion("recheckTime <>", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeGreaterThan(Date value) {
            addCriterion("recheckTime >", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recheckTime >=", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeLessThan(Date value) {
            addCriterion("recheckTime <", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeLessThanOrEqualTo(Date value) {
            addCriterion("recheckTime <=", value, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeIn(List<Date> values) {
            addCriterion("recheckTime in", values, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeNotIn(List<Date> values) {
            addCriterion("recheckTime not in", values, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeBetween(Date value1, Date value2) {
            addCriterion("recheckTime between", value1, value2, "rechecktime");
            return (Criteria) this;
        }

        public Criteria andRechecktimeNotBetween(Date value1, Date value2) {
            addCriterion("recheckTime not between", value1, value2, "rechecktime");
            return (Criteria) this;
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