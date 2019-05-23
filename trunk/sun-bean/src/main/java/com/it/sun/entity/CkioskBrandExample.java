package com.it.sun.entity;

import java.util.ArrayList;
import java.util.List;

public class CkioskBrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkioskBrandExample() {
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

        public Criteria andCkioskBrandidIsNull() {
            addCriterion("Ckiosk_BrandID is null");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidIsNotNull() {
            addCriterion("Ckiosk_BrandID is not null");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidEqualTo(Integer value) {
            addCriterion("Ckiosk_BrandID =", value, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidNotEqualTo(Integer value) {
            addCriterion("Ckiosk_BrandID <>", value, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidGreaterThan(Integer value) {
            addCriterion("Ckiosk_BrandID >", value, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ckiosk_BrandID >=", value, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidLessThan(Integer value) {
            addCriterion("Ckiosk_BrandID <", value, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidLessThanOrEqualTo(Integer value) {
            addCriterion("Ckiosk_BrandID <=", value, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidIn(List<Integer> values) {
            addCriterion("Ckiosk_BrandID in", values, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidNotIn(List<Integer> values) {
            addCriterion("Ckiosk_BrandID not in", values, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidBetween(Integer value1, Integer value2) {
            addCriterion("Ckiosk_BrandID between", value1, value2, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandidNotBetween(Integer value1, Integer value2) {
            addCriterion("Ckiosk_BrandID not between", value1, value2, "ckioskBrandid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidIsNull() {
            addCriterion("Ckiosk_BrandGUID is null");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidIsNotNull() {
            addCriterion("Ckiosk_BrandGUID is not null");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidEqualTo(String value) {
            addCriterion("Ckiosk_BrandGUID =", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidNotEqualTo(String value) {
            addCriterion("Ckiosk_BrandGUID <>", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidGreaterThan(String value) {
            addCriterion("Ckiosk_BrandGUID >", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidGreaterThanOrEqualTo(String value) {
            addCriterion("Ckiosk_BrandGUID >=", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidLessThan(String value) {
            addCriterion("Ckiosk_BrandGUID <", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidLessThanOrEqualTo(String value) {
            addCriterion("Ckiosk_BrandGUID <=", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidLike(String value) {
            addCriterion("Ckiosk_BrandGUID like", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidNotLike(String value) {
            addCriterion("Ckiosk_BrandGUID not like", value, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidIn(List<String> values) {
            addCriterion("Ckiosk_BrandGUID in", values, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidNotIn(List<String> values) {
            addCriterion("Ckiosk_BrandGUID not in", values, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidBetween(String value1, String value2) {
            addCriterion("Ckiosk_BrandGUID between", value1, value2, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andCkioskBrandguidNotBetween(String value1, String value2) {
            addCriterion("Ckiosk_BrandGUID not between", value1, value2, "ckioskBrandguid");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("Project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("Project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("Project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("Project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("Project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("Project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("Project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("Project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("Project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("Project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("Project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("Project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("Project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("Project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFirstletterIsNull() {
            addCriterion("FirstLetter is null");
            return (Criteria) this;
        }

        public Criteria andFirstletterIsNotNull() {
            addCriterion("FirstLetter is not null");
            return (Criteria) this;
        }

        public Criteria andFirstletterEqualTo(String value) {
            addCriterion("FirstLetter =", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterNotEqualTo(String value) {
            addCriterion("FirstLetter <>", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterGreaterThan(String value) {
            addCriterion("FirstLetter >", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterGreaterThanOrEqualTo(String value) {
            addCriterion("FirstLetter >=", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterLessThan(String value) {
            addCriterion("FirstLetter <", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterLessThanOrEqualTo(String value) {
            addCriterion("FirstLetter <=", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterLike(String value) {
            addCriterion("FirstLetter like", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterNotLike(String value) {
            addCriterion("FirstLetter not like", value, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterIn(List<String> values) {
            addCriterion("FirstLetter in", values, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterNotIn(List<String> values) {
            addCriterion("FirstLetter not in", values, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterBetween(String value1, String value2) {
            addCriterion("FirstLetter between", value1, value2, "firstletter");
            return (Criteria) this;
        }

        public Criteria andFirstletterNotBetween(String value1, String value2) {
            addCriterion("FirstLetter not between", value1, value2, "firstletter");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("Introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("Introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("Introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("Introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("Introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("Introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("Introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("Introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("Introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("Introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("Introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("Introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("Introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("Introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("Logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("Logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("Logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("Logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("Logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("Logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("Logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("Logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("Logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("Logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("Logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("Logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("Logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("Logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("Image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("Image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("Image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("Image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("Image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("Image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("Image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("Image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("Image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("Image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("Image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("Image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("Image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("Image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeIsNull() {
            addCriterion("BusinessScope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeIsNotNull() {
            addCriterion("BusinessScope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeEqualTo(String value) {
            addCriterion("BusinessScope =", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotEqualTo(String value) {
            addCriterion("BusinessScope <>", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeGreaterThan(String value) {
            addCriterion("BusinessScope >", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeGreaterThanOrEqualTo(String value) {
            addCriterion("BusinessScope >=", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeLessThan(String value) {
            addCriterion("BusinessScope <", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeLessThanOrEqualTo(String value) {
            addCriterion("BusinessScope <=", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeLike(String value) {
            addCriterion("BusinessScope like", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotLike(String value) {
            addCriterion("BusinessScope not like", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeIn(List<String> values) {
            addCriterion("BusinessScope in", values, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotIn(List<String> values) {
            addCriterion("BusinessScope not in", values, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeBetween(String value1, String value2) {
            addCriterion("BusinessScope between", value1, value2, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotBetween(String value1, String value2) {
            addCriterion("BusinessScope not between", value1, value2, "businessscope");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionIsNull() {
            addCriterion("PerCapitaConsumption is null");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionIsNotNull() {
            addCriterion("PerCapitaConsumption is not null");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionEqualTo(String value) {
            addCriterion("PerCapitaConsumption =", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionNotEqualTo(String value) {
            addCriterion("PerCapitaConsumption <>", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionGreaterThan(String value) {
            addCriterion("PerCapitaConsumption >", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("PerCapitaConsumption >=", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionLessThan(String value) {
            addCriterion("PerCapitaConsumption <", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionLessThanOrEqualTo(String value) {
            addCriterion("PerCapitaConsumption <=", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionLike(String value) {
            addCriterion("PerCapitaConsumption like", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionNotLike(String value) {
            addCriterion("PerCapitaConsumption not like", value, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionIn(List<String> values) {
            addCriterion("PerCapitaConsumption in", values, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionNotIn(List<String> values) {
            addCriterion("PerCapitaConsumption not in", values, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionBetween(String value1, String value2) {
            addCriterion("PerCapitaConsumption between", value1, value2, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andPercapitaconsumptionNotBetween(String value1, String value2) {
            addCriterion("PerCapitaConsumption not between", value1, value2, "percapitaconsumption");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursIsNull() {
            addCriterion("BusinessHours is null");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursIsNotNull() {
            addCriterion("BusinessHours is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursEqualTo(String value) {
            addCriterion("BusinessHours =", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursNotEqualTo(String value) {
            addCriterion("BusinessHours <>", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursGreaterThan(String value) {
            addCriterion("BusinessHours >", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursGreaterThanOrEqualTo(String value) {
            addCriterion("BusinessHours >=", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursLessThan(String value) {
            addCriterion("BusinessHours <", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursLessThanOrEqualTo(String value) {
            addCriterion("BusinessHours <=", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursLike(String value) {
            addCriterion("BusinessHours like", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursNotLike(String value) {
            addCriterion("BusinessHours not like", value, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursIn(List<String> values) {
            addCriterion("BusinessHours in", values, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursNotIn(List<String> values) {
            addCriterion("BusinessHours not in", values, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursBetween(String value1, String value2) {
            addCriterion("BusinessHours between", value1, value2, "businesshours");
            return (Criteria) this;
        }

        public Criteria andBusinesshoursNotBetween(String value1, String value2) {
            addCriterion("BusinessHours not between", value1, value2, "businesshours");
            return (Criteria) this;
        }

        public Criteria andContactnumberIsNull() {
            addCriterion("ContactNumber is null");
            return (Criteria) this;
        }

        public Criteria andContactnumberIsNotNull() {
            addCriterion("ContactNumber is not null");
            return (Criteria) this;
        }

        public Criteria andContactnumberEqualTo(String value) {
            addCriterion("ContactNumber =", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberNotEqualTo(String value) {
            addCriterion("ContactNumber <>", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberGreaterThan(String value) {
            addCriterion("ContactNumber >", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberGreaterThanOrEqualTo(String value) {
            addCriterion("ContactNumber >=", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberLessThan(String value) {
            addCriterion("ContactNumber <", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberLessThanOrEqualTo(String value) {
            addCriterion("ContactNumber <=", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberLike(String value) {
            addCriterion("ContactNumber like", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberNotLike(String value) {
            addCriterion("ContactNumber not like", value, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberIn(List<String> values) {
            addCriterion("ContactNumber in", values, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberNotIn(List<String> values) {
            addCriterion("ContactNumber not in", values, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberBetween(String value1, String value2) {
            addCriterion("ContactNumber between", value1, value2, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactnumberNotBetween(String value1, String value2) {
            addCriterion("ContactNumber not between", value1, value2, "contactnumber");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("Contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("Contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("Contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("Contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("Contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("Contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("Contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("Contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("Contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("Contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("Contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("Contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("Contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("Contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("Fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("Fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("Fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("Fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("Fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("Fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("Fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("Fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("Fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("Fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("Fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("Fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("Fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("Fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("Site is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("Site is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("Site =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("Site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("Site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("Site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("Site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("Site <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("Site like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("Site not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("Site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("Site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("Site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("Site not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("Wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("Wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("Wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("Wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("Wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("Wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("Wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("Wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("Wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("Wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("Wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("Wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("Wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("Wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNull() {
            addCriterion("QRCode is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNotNull() {
            addCriterion("QRCode is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEqualTo(String value) {
            addCriterion("QRCode =", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotEqualTo(String value) {
            addCriterion("QRCode <>", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThan(String value) {
            addCriterion("QRCode >", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("QRCode >=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThan(String value) {
            addCriterion("QRCode <", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThanOrEqualTo(String value) {
            addCriterion("QRCode <=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLike(String value) {
            addCriterion("QRCode like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotLike(String value) {
            addCriterion("QRCode not like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeIn(List<String> values) {
            addCriterion("QRCode in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotIn(List<String> values) {
            addCriterion("QRCode not in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeBetween(String value1, String value2) {
            addCriterion("QRCode between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotBetween(String value1, String value2) {
            addCriterion("QRCode not between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageIsNull() {
            addCriterion("QRCodeImage is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageIsNotNull() {
            addCriterion("QRCodeImage is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageEqualTo(String value) {
            addCriterion("QRCodeImage =", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageNotEqualTo(String value) {
            addCriterion("QRCodeImage <>", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageGreaterThan(String value) {
            addCriterion("QRCodeImage >", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageGreaterThanOrEqualTo(String value) {
            addCriterion("QRCodeImage >=", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageLessThan(String value) {
            addCriterion("QRCodeImage <", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageLessThanOrEqualTo(String value) {
            addCriterion("QRCodeImage <=", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageLike(String value) {
            addCriterion("QRCodeImage like", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageNotLike(String value) {
            addCriterion("QRCodeImage not like", value, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageIn(List<String> values) {
            addCriterion("QRCodeImage in", values, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageNotIn(List<String> values) {
            addCriterion("QRCodeImage not in", values, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageBetween(String value1, String value2) {
            addCriterion("QRCodeImage between", value1, value2, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andQrcodeimageNotBetween(String value1, String value2) {
            addCriterion("QRCodeImage not between", value1, value2, "qrcodeimage");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("Other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("Other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("Other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("Other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("Other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("Other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("Other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("Other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("Other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("Other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("Other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("Other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("Other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("Other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andShowsdsIsNull() {
            addCriterion("ShowSDS is null");
            return (Criteria) this;
        }

        public Criteria andShowsdsIsNotNull() {
            addCriterion("ShowSDS is not null");
            return (Criteria) this;
        }

        public Criteria andShowsdsEqualTo(Boolean value) {
            addCriterion("ShowSDS =", value, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsNotEqualTo(Boolean value) {
            addCriterion("ShowSDS <>", value, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsGreaterThan(Boolean value) {
            addCriterion("ShowSDS >", value, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ShowSDS >=", value, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsLessThan(Boolean value) {
            addCriterion("ShowSDS <", value, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsLessThanOrEqualTo(Boolean value) {
            addCriterion("ShowSDS <=", value, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsIn(List<Boolean> values) {
            addCriterion("ShowSDS in", values, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsNotIn(List<Boolean> values) {
            addCriterion("ShowSDS not in", values, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsBetween(Boolean value1, Boolean value2) {
            addCriterion("ShowSDS between", value1, value2, "showsds");
            return (Criteria) this;
        }

        public Criteria andShowsdsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ShowSDS not between", value1, value2, "showsds");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("Order is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("Order is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("Order =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("Order <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("Order >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("Order >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(Integer value) {
            addCriterion("Order <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("Order <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("Order in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("Order not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("Order between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("Order not between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andLanIsNull() {
            addCriterion("Lan is null");
            return (Criteria) this;
        }

        public Criteria andLanIsNotNull() {
            addCriterion("Lan is not null");
            return (Criteria) this;
        }

        public Criteria andLanEqualTo(String value) {
            addCriterion("Lan =", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotEqualTo(String value) {
            addCriterion("Lan <>", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanGreaterThan(String value) {
            addCriterion("Lan >", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanGreaterThanOrEqualTo(String value) {
            addCriterion("Lan >=", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLessThan(String value) {
            addCriterion("Lan <", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLessThanOrEqualTo(String value) {
            addCriterion("Lan <=", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLike(String value) {
            addCriterion("Lan like", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotLike(String value) {
            addCriterion("Lan not like", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanIn(List<String> values) {
            addCriterion("Lan in", values, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotIn(List<String> values) {
            addCriterion("Lan not in", values, "lan");
            return (Criteria) this;
        }

        public Criteria andLanBetween(String value1, String value2) {
            addCriterion("Lan between", value1, value2, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotBetween(String value1, String value2) {
            addCriterion("Lan not between", value1, value2, "lan");
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