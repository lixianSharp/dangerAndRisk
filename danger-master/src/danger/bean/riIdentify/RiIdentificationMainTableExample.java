package danger.bean.riIdentify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiIdentificationMainTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiIdentificationMainTableExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Date value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Date value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Date value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Date value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Date value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Date value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Date> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Date> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Date value1, Date value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Date value1, Date value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressIsNull() {
            addCriterion("meetingAddress is null");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressIsNotNull() {
            addCriterion("meetingAddress is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressEqualTo(String value) {
            addCriterion("meetingAddress =", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressNotEqualTo(String value) {
            addCriterion("meetingAddress <>", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressGreaterThan(String value) {
            addCriterion("meetingAddress >", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressGreaterThanOrEqualTo(String value) {
            addCriterion("meetingAddress >=", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressLessThan(String value) {
            addCriterion("meetingAddress <", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressLessThanOrEqualTo(String value) {
            addCriterion("meetingAddress <=", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressLike(String value) {
            addCriterion("meetingAddress like", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressNotLike(String value) {
            addCriterion("meetingAddress not like", value, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressIn(List<String> values) {
            addCriterion("meetingAddress in", values, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressNotIn(List<String> values) {
            addCriterion("meetingAddress not in", values, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressBetween(String value1, String value2) {
            addCriterion("meetingAddress between", value1, value2, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andMeetingaddressNotBetween(String value1, String value2) {
            addCriterion("meetingAddress not between", value1, value2, "meetingaddress");
            return (Criteria) this;
        }

        public Criteria andCompereIsNull() {
            addCriterion("compere is null");
            return (Criteria) this;
        }

        public Criteria andCompereIsNotNull() {
            addCriterion("compere is not null");
            return (Criteria) this;
        }

        public Criteria andCompereEqualTo(String value) {
            addCriterion("compere =", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereNotEqualTo(String value) {
            addCriterion("compere <>", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereGreaterThan(String value) {
            addCriterion("compere >", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereGreaterThanOrEqualTo(String value) {
            addCriterion("compere >=", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereLessThan(String value) {
            addCriterion("compere <", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereLessThanOrEqualTo(String value) {
            addCriterion("compere <=", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereLike(String value) {
            addCriterion("compere like", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereNotLike(String value) {
            addCriterion("compere not like", value, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereIn(List<String> values) {
            addCriterion("compere in", values, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereNotIn(List<String> values) {
            addCriterion("compere not in", values, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereBetween(String value1, String value2) {
            addCriterion("compere between", value1, value2, "compere");
            return (Criteria) this;
        }

        public Criteria andCompereNotBetween(String value1, String value2) {
            addCriterion("compere not between", value1, value2, "compere");
            return (Criteria) this;
        }

        public Criteria andRecorderIsNull() {
            addCriterion("recorder is null");
            return (Criteria) this;
        }

        public Criteria andRecorderIsNotNull() {
            addCriterion("recorder is not null");
            return (Criteria) this;
        }

        public Criteria andRecorderEqualTo(String value) {
            addCriterion("recorder =", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotEqualTo(String value) {
            addCriterion("recorder <>", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThan(String value) {
            addCriterion("recorder >", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThanOrEqualTo(String value) {
            addCriterion("recorder >=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThan(String value) {
            addCriterion("recorder <", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThanOrEqualTo(String value) {
            addCriterion("recorder <=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLike(String value) {
            addCriterion("recorder like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotLike(String value) {
            addCriterion("recorder not like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderIn(List<String> values) {
            addCriterion("recorder in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotIn(List<String> values) {
            addCriterion("recorder not in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderBetween(String value1, String value2) {
            addCriterion("recorder between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotBetween(String value1, String value2) {
            addCriterion("recorder not between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNull() {
            addCriterion("participants is null");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNotNull() {
            addCriterion("participants is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantsEqualTo(String value) {
            addCriterion("participants =", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotEqualTo(String value) {
            addCriterion("participants <>", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThan(String value) {
            addCriterion("participants >", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThanOrEqualTo(String value) {
            addCriterion("participants >=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThan(String value) {
            addCriterion("participants <", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThanOrEqualTo(String value) {
            addCriterion("participants <=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLike(String value) {
            addCriterion("participants like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotLike(String value) {
            addCriterion("participants not like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsIn(List<String> values) {
            addCriterion("participants in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotIn(List<String> values) {
            addCriterion("participants not in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsBetween(String value1, String value2) {
            addCriterion("participants between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotBetween(String value1, String value2) {
            addCriterion("participants not between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentIsNull() {
            addCriterion("meetingContent is null");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentIsNotNull() {
            addCriterion("meetingContent is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentEqualTo(String value) {
            addCriterion("meetingContent =", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentNotEqualTo(String value) {
            addCriterion("meetingContent <>", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentGreaterThan(String value) {
            addCriterion("meetingContent >", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentGreaterThanOrEqualTo(String value) {
            addCriterion("meetingContent >=", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentLessThan(String value) {
            addCriterion("meetingContent <", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentLessThanOrEqualTo(String value) {
            addCriterion("meetingContent <=", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentLike(String value) {
            addCriterion("meetingContent like", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentNotLike(String value) {
            addCriterion("meetingContent not like", value, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentIn(List<String> values) {
            addCriterion("meetingContent in", values, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentNotIn(List<String> values) {
            addCriterion("meetingContent not in", values, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentBetween(String value1, String value2) {
            addCriterion("meetingContent between", value1, value2, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andMeetingcontentNotBetween(String value1, String value2) {
            addCriterion("meetingContent not between", value1, value2, "meetingcontent");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkIsNull() {
            addCriterion("identifyMark is null");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkIsNotNull() {
            addCriterion("identifyMark is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkEqualTo(String value) {
            addCriterion("identifyMark =", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkNotEqualTo(String value) {
            addCriterion("identifyMark <>", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkGreaterThan(String value) {
            addCriterion("identifyMark >", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkGreaterThanOrEqualTo(String value) {
            addCriterion("identifyMark >=", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkLessThan(String value) {
            addCriterion("identifyMark <", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkLessThanOrEqualTo(String value) {
            addCriterion("identifyMark <=", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkLike(String value) {
            addCriterion("identifyMark like", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkNotLike(String value) {
            addCriterion("identifyMark not like", value, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkIn(List<String> values) {
            addCriterion("identifyMark in", values, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkNotIn(List<String> values) {
            addCriterion("identifyMark not in", values, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkBetween(String value1, String value2) {
            addCriterion("identifyMark between", value1, value2, "identifymark");
            return (Criteria) this;
        }

        public Criteria andIdentifymarkNotBetween(String value1, String value2) {
            addCriterion("identifyMark not between", value1, value2, "identifymark");
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