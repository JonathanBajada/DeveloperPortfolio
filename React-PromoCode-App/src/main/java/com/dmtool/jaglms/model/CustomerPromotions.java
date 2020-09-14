package com.dmtool.jaglms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mk_customer_promotions", indexes = {@Index(name = "ix_pc", columnList = "promo_code"),
        @Index(name = "mk_customer_promotions_fkix1", columnList = "dm_campaign_id")})
public class CustomerPromotions {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "last_name", length = 45)
    private String last_name;
    @Column(name = "first_name", length = 45)
    private String firstName;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "address2", length = 100)
    private String address2;
    @Column(name = "city", length = 45)
    private String city;
    @Column(name = "state", length = 45)
    private String state;
    @Column(name = "zipcode", length = 45)
    private String zipcode;
    @Column(name = "ssn", length =256 )
    private Byte[] ssn;
    @Column(name = "is_claimed", length = 1)
    private Boolean is_claimed;
    @Column(name = "claimed_timestamp")
    private Date claimed_timestamp;
    @Column(name = "promo_code", length = 45)
    private String promoCode;
    @Column(name = "loan_amount", length = 5)
    private Integer loan_amount;
    @Column(name = "dm_campaign_id", length = 11)
    private Integer dm_campaign_id;
    @Column(name = "expired_timestamp")
    private Date expired_timestamp;

    @javax.persistence.Transient
    private String convertedSSN;

    public CustomerPromotions(){
    }

    public CustomerPromotions(String last_name, String firstName, String address, String address2, String city, String state, String zipcode, Byte[] ssn, Boolean is_claimed, Date currentDate, String promo_code, Integer loan_amount, Integer dm_campaign_id, Date expired_timestamp) {
        this.last_name = last_name;
        this.firstName = firstName;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.ssn = ssn;
        this.is_claimed = is_claimed;
        this.claimed_timestamp = currentDate;
        this.promoCode = promo_code;
        this.loan_amount = loan_amount;
        this.dm_campaign_id = dm_campaign_id;
        this.expired_timestamp = expired_timestamp;
    }

    public String getConvertedSSN() {
        return convertedSSN;
    }

    public void setConvertedSSN(String convertedSSN) {
        this.convertedSSN = convertedSSN;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Byte[] getSsn() {
        return ssn;
    }

    public void setSsn(Byte[] ssn) {
        this.ssn = ssn;
    }

    public Boolean getIs_claimed() {
        return is_claimed;
    }

    public void setIs_claimed(Boolean is_claimed) {
        this.is_claimed = is_claimed;
    }

    public Date getClaimed_timestamp() {
        return claimed_timestamp;
    }

    public void setClaimed_timestamp(Date claimed_timestamp) {
        this.claimed_timestamp = claimed_timestamp;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Integer getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(Integer loan_amount) {
        this.loan_amount = loan_amount;
    }

    public Integer getDm_campaign_id() {
        return dm_campaign_id;
    }

    public void setDm_campaign_id(Integer dm_campaign_id) {
        this.dm_campaign_id = dm_campaign_id;
    }

    public Date getExpired_timestamp() {
        return expired_timestamp;
    }

    public void setExpired_timestamp(Date expired_timestamp) {
        this.expired_timestamp = expired_timestamp;
    }
}
