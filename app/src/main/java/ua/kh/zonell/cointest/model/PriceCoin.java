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
    private Double PRICE_BTC;

    @Expose
    @Column(name = "OPENDAY_BTC")
    private Double OPENDAY_BTC;

    @Expose
    @Column(name = "HIGHDAY_BTC")
    private Double HIGHDAY_BTC;

    @Expose
    @Column(name = "LOWDAY_BTC")
    private Double LOWDAY_BTC;

    @Expose
    @Column(name = "PRICE_USD")
    private Double PRICE_USD;

    @Expose
    @Column(name = "OPENDAY_USD")
    private Double OPENDAY_USD;

    @Expose
    @Column(name = "HIGHDAY_USD")
    private Double HIGHDAY_USD;

    @Expose
    @Column(name = "LOWDAY_USD")
    private Double LOWDAY_USD;

    @Expose
    @Column(name = "PRICE_EUR")
    private Double PRICE_EUR;

    @Expose
    @Column(name = "OPENDAY_EUR")
    private Double OPENDAY_EUR;

    @Expose
    @Column(name = "HIGHDAY_EUR")
    private Double HIGHDAY_EUR;

    @Expose
    @Column(name = "LOWDAY_EUR")
    private Double LOWDAY_EUR;

    public PriceCoin(){

    }

    public PriceCoin(String name,
                     Double PRICE_BTC, Double OPENDAY_BTC, Double HIGHDAY_BTC, Double LOWDAY_BTC,
                     Double PRICE_USD, Double OPENDAY_USD, Double HIGHDAY_USD, Double LOWDAY_USD,
                     Double PRICE_EUR, Double OPENDAY_EUR, Double HIGHDAY_EUR, Double LOWDAY_EUR) {
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

    public Double getPRICE_BTC() {
        return PRICE_BTC;
    }

    public void setPRICE_BTC(Double PRICE_BTC) {
        this.PRICE_BTC = PRICE_BTC;
    }

    public Double getOPENDAY_BTC() {
        return OPENDAY_BTC;
    }

    public void setOPENDAY_BTC(Double OPENDAY_BTC) {
        this.OPENDAY_BTC = OPENDAY_BTC;
    }

    public Double getHIGHDAY_BTC() {
        return HIGHDAY_BTC;
    }

    public void setHIGHDAY_BTC(Double HIGHDAY_BTC) {
        this.HIGHDAY_BTC = HIGHDAY_BTC;
    }

    public Double getLOWDAY_BTC() {
        return LOWDAY_BTC;
    }

    public void setLOWDAY_BTC(Double LOWDAY_BTC) {
        this.LOWDAY_BTC = LOWDAY_BTC;
    }

    public Double getPRICE_USD() {
        return PRICE_USD;
    }

    public void setPRICE_USD(Double PRICE_USD) {
        this.PRICE_USD = PRICE_USD;
    }

    public Double getOPENDAY_USD() {
        return OPENDAY_USD;
    }

    public void setOPENDAY_USD(Double OPENDAY_USD) {
        this.OPENDAY_USD = OPENDAY_USD;
    }

    public Double getHIGHDAY_USD() {
        return HIGHDAY_USD;
    }

    public void setHIGHDAY_USD(Double HIGHDAY_USD) {
        this.HIGHDAY_USD = HIGHDAY_USD;
    }

    public Double getLOWDAY_USD() {
        return LOWDAY_USD;
    }

    public void setLOWDAY_USD(Double LOWDAY_USD) {
        this.LOWDAY_USD = LOWDAY_USD;
    }

    public Double getPRICE_EUR() {
        return PRICE_EUR;
    }

    public void setPRICE_EUR(Double PRICE_EUR) {
        this.PRICE_EUR = PRICE_EUR;
    }

    public Double getOPENDAY_EUR() {
        return OPENDAY_EUR;
    }

    public void setOPENDAY_EUR(Double OPENDAY_EUR) {
        this.OPENDAY_EUR = OPENDAY_EUR;
    }

    public Double getHIGHDAY_EUR() {
        return HIGHDAY_EUR;
    }

    public void setHIGHDAY_EUR(Double HIGHDAY_EUR) {
        this.HIGHDAY_EUR = HIGHDAY_EUR;
    }

    public Double getLOWDAY_EUR() {
        return LOWDAY_EUR;
    }

    public void setLOWDAY_EUR(Double LOWDAY_EUR) {
        this.LOWDAY_EUR = LOWDAY_EUR;
    }

}
