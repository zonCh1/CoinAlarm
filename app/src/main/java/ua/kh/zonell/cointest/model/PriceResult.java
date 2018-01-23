package ua.kh.zonell.cointest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class PriceResult {

    @SerializedName("RAW")
    @Expose
    private Map<String, PriseFull> priceFull;

    public Map<String, PriseFull> getPriceFull() {
        return priceFull;
    }

    public void setPriceFull(Map<String, PriseFull> priceFull) {
        this.priceFull = priceFull;
    }
}
