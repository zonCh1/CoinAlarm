package ua.kh.zonell.cointest.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

@Table(name = "PriceCoin")
public class PriceCoin extends Model {

    @Expose
    @Column(name = "Name", unique = true)
    private String name;

    @Expose
    @Column(name = "PRICE_BTC")
    private String PRICE_BTC;

    @Expose
    @Column(name = "OPENDAY_BTC")
    private String OPENDAY_BTC;

    @Expose
    @Column(name = "HIGHDAY_BTC")
    private String HIGHDAY_BTC;

    @Expose
    @Column(name = "LOWDAY_BTC")
    private String LOWDAY_BTC;

    @Expose
    @Column(name = "PRICE_USD")
    private String PRICE_USD;

    @Expose
    @Column(name = "OPENDAY_USD")
    private String OPENDAY_USD;

    @Expose
    @Column(name = "HIGHDAY_USD")
    private String HIGHDAY_USD;

    @Expose
    @Column(name = "LOWDAY_USD")
    private String LOWDAY_USD;

    @Expose
    @Column(name = "PRICE_EUR")
    private String PRICE_EUR;

    @Expose
    @Column(name = "OPENDAY_EUR")
    private String OPENDAY_EUR;

    @Expose
    @Column(name = "HIGHDAY_EUR")
    private String HIGHDAY_EUR;

    @Expose
    @Column(name = "LOWDAY_EUR")
    private String LOWDAY_EUR;

    public PriceCoin(){

    }

    public PriceCoin(String name,
                     String PRICE_BTC, String OPENDAY_BTC, String HIGHDAY_BTC, String LOWDAY_BTC,
                     String PRICE_USD, String OPENDAY_USD, String HIGHDAY_USD, String LOWDAY_USD,
                     String PRICE_EUR, String OPENDAY_EUR, String HIGHDAY_EUR, String LOWDAY_EUR) {
        this.name = name;
        this.PRICE_BTC = PRICE_BTC;
        this.OPENDAY_BTC = OPENDAY_BTC;
        this.HIGHDAY_BTC = HIGHDAY_BTC;
        this.LOWDAY_BTC = LOWDAY_BTC;
        this.PRICE_USD = PRICE_USD;
        this.OPENDAY_USD = OPENDAY_USD;
        this.HIGHDAY_USD = HIGHDAY_USD;
        this.LOWDAY_USD = LOWDAY_USD;
        this.PRICE_EUR = PRICE_EUR;
        this.OPENDAY_EUR = OPENDAY_EUR;
        this.HIGHDAY_EUR = HIGHDAY_EUR;
        this.LOWDAY_EUR = LOWDAY_EUR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPRICE_BTC() {
        return PRICE_BTC;
    }

    public void setPRICE_BTC(String PRICE_BTC) {
        this.PRICE_BTC = PRICE_BTC;
    }

    public String getOPENDAY_BTC() {
        return OPENDAY_BTC;
    }

    public void setOPENDAY_BTC(String OPENDAY_BTC) {
        this.OPENDAY_BTC = OPENDAY_BTC;
    }

    public String getHIGHDAY_BTC() {
        return HIGHDAY_BTC;
    }

    public void setHIGHDAY_BTC(String HIGHDAY_BTC) {
        this.HIGHDAY_BTC = HIGHDAY_BTC;
    }

    public String getLOWDAY_BTC() {
        return LOWDAY_BTC;
    }

    public void setLOWDAY_BTC(String LOWDAY_BTC) {
        this.LOWDAY_BTC = LOWDAY_BTC;
    }

    public String getPRICE_USD() {
        return PRICE_USD;
    }

    public void setPRICE_USD(String PRICE_USD) {
        this.PRICE_USD = PRICE_USD;
    }

    public String getOPENDAY_USD() {
        return OPENDAY_USD;
    }

    public void setOPENDAY_USD(String OPENDAY_USD) {
        this.OPENDAY_USD = OPENDAY_USD;
    }

    public String getHIGHDAY_USD() {
        return HIGHDAY_USD;
    }

    public void setHIGHDAY_USD(String HIGHDAY_USD) {
        this.HIGHDAY_USD = HIGHDAY_USD;
    }

    public String getLOWDAY_USD() {
        return LOWDAY_USD;
    }

    public void setLOWDAY_USD(String LOWDAY_USD) {
        this.LOWDAY_USD = LOWDAY_USD;
    }

    public String getPRICE_EUR() {
        return PRICE_EUR;
    }

    public void setPRICE_EUR(String PRICE_EUR) {
        this.PRICE_EUR = PRICE_EUR;
    }

    public String getOPENDAY_EUR() {
        return OPENDAY_EUR;
    }

    public void setOPENDAY_EUR(String OPENDAY_EUR) {
        this.OPENDAY_EUR = OPENDAY_EUR;
    }

    public String getHIGHDAY_EUR() {
        return HIGHDAY_EUR;
    }

    public void setHIGHDAY_EUR(String HIGHDAY_EUR) {
        this.HIGHDAY_EUR = HIGHDAY_EUR;
    }

    public String getLOWDAY_EUR() {
        return LOWDAY_EUR;
    }

    public void setLOWDAY_EUR(String LOWDAY_EUR) {
        this.LOWDAY_EUR = LOWDAY_EUR;
    }
}
