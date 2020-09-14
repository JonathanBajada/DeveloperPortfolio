package com.dmtool.webapi.model;

import com.dmtool.encryption.EncryptionsUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "direct_mail_application_log", indexes = {@Index(name = "dm_application_uk", columnList = "email")})
public class DirectMail extends EncryptionsUtils {

    @Id
    @Column(name = "dm_application_id", length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "state", length = 50)
    private String state;
    @Column(name = "ssn4", length = 4)
    private String ssn4;
    @Column(name = "promo_code", length = 250)
    private String promoCode;
    @Column(name = "campaign_name", length = 50)
    private String campaignName;
    @Column(name = "validation_date")
    private Date validationDate;
    @Column(name = "application_status")
    private Boolean status;
    @Column(name = "tierkey", length = 200)
    private String tierKey;
    @Column(name = "create_datetime")
    private Date createDatetime;
    @Column(name = "update_datetime")
    private Date updateDatetime;

    public DirectMail(){

    }

    public DirectMail(String email, String state, String ssn4, String promoCode, String campgainName, Date validationDate, Boolean status, String tierKey, Date createDatetime, Date updateDatetime) {
        this.email = email;
        this.state = state;
        this.ssn4 = ssn4;
        this.promoCode = promoCode;
        this.campaignName = campgainName;
        this.validationDate = validationDate;
        this.status = status;
        this.tierKey = tierKey;
        this.createDatetime = createDatetime;
        this.updateDatetime = updateDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSsn4() {
        return ssn4;
    }

    public void setSsn4(String ssn4) {
        this.ssn4 = ssn4;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTierKey() {
        return tierKey;
    }

    public void setTierKey(String tierKey) {
        this.tierKey = tierKey;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}
