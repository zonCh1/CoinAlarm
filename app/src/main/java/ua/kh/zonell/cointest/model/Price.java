package ua.kh.zonell.cointest.model;

import com.activeandroid.Model;
import com.google.gson.annotations.Expose;

public class Price extends Model{

    @Expose
    private Double PRICE;

    @Expose
    private Double OPENDAY;

    @Expose
    private Double HIGHDAY;

    @Expose
    private Double LOWDAY;

    public Price(Double PRICE, Double OPENDAY, Double HIGHDAY, Double LOWDAY) {
        this.PRICE = PRICE;
        this.OPENDAY = OPENDAY;
        this.HIGHDAY = HIGHDAY;
        this.LOWDAY = LOWDAY;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public Double getOPENDAY() {
        return OPENDAY;
    }

    public void setOPENDAY(Double OPENDAY) {
        this.OPENDAY = OPENDAY;
    }

    public Double getHIGHDAY() {
        return HIGHDAY;
    }

    public void setHIGHDAY(Double HIGHDAY) {
        this.HIGHDAY = HIGHDAY;
    }

    public Double getLOWDAY() {
        return LOWDAY;
    }

    public void setLOWDAY(Double LOWDAY) {
        this.LOWDAY = LOWDAY;
    }
}
