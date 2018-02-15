package ua.kh.zonell.cointest.model;

import com.google.gson.annotations.Expose;

public class Price {

    @Expose
    private String PRICE;

    @Expose
    private String OPENDAY;

    @Expose
    private String HIGHDAY;

    @Expose
    private String LOWDAY;

    public Price(String PRICE, String OPENDAY, String HIGHDAY, String LOWDAY) {
        this.PRICE = PRICE;
        this.OPENDAY = OPENDAY;
        this.HIGHDAY = HIGHDAY;
        this.LOWDAY = LOWDAY;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getOPENDAY() {
        return OPENDAY;
    }

    public void setOPENDAY(String OPENDAY) {
        this.OPENDAY = OPENDAY;
    }

    public String getHIGHDAY() {
        return HIGHDAY;
    }

    public void setHIGHDAY(String HIGHDAY) {
        this.HIGHDAY = HIGHDAY;
    }

    public String getLOWDAY() {
        return LOWDAY;
    }

    public void setLOWDAY(String LOWDAY) {
        this.LOWDAY = LOWDAY;
    }
}
