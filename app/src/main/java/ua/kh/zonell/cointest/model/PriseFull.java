package ua.kh.zonell.cointest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriseFull {

    @SerializedName("BTC")
    @Expose
    private Price priceBTC;

    @SerializedName("USD")
    @Expose
    private Price priceUSD;

    @SerializedName("EUR")
    @Expose
    private Price priceEUR;

    public Price getPriceBTC() {
        return priceBTC;
    }

    public void setPriceBTC(Price priceBTC) {
        this.priceBTC = priceBTC;
    }

    public Price getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(Price priceUSD) {
        this.priceUSD = priceUSD;
    }

    public Price getPriceEUR() {
        return priceEUR;
    }

    public void setPriceEUR(Price priceEUR) {
        this.priceEUR = priceEUR;
    }
}
