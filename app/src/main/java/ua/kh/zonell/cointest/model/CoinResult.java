package ua.kh.zonell.cointest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CoinResult {

    @SerializedName("Data")
    @Expose
    public Map<String, Coin> coins;

    public Map<String, Coin> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Coin> coins) {
        this.coins = coins;
    }
}
