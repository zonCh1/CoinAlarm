package ua.kh.zonell.cointest.model;

import com.google.gson.annotations.Expose;

public class Coin {

    @Expose
    private long _Id;

    @Expose
    private String Url;

    @Expose
    private String ImageUrl;

    @Expose
    private String Name;

    @Expose
    private String CoinName;

    public Coin() {
    }

    public Coin(long _Id, String url, String imageUrl, String name, String coinName) {
        this._Id = _Id;
        Url = url;
        ImageUrl = imageUrl;
        Name = name;
        CoinName = coinName;
    }

    public long get_Id() {
        return _Id;
    }

    public void set_Id(long _Id) {
        this._Id = _Id;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCoinName() {
        return CoinName;
    }

    public void setCoinName(String coinName) {
        CoinName = coinName;
    }

    @Override
    public String toString() {
        return getName();
    }
}
