package ua.kh.zonell.cointest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class PriceResult {

    @SerializedName("RAW")
    @Expose
    private Map<String, PriceFull> priceFull;

    public Map<String, PriceFull> getPriceFull() {
        return priceFull;
    }

    public void setPriceFull(Map<String, PriceFull> priceFull) {
        this.priceFull = priceFull;
    }
}
