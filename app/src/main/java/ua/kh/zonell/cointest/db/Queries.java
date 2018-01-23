package ua.kh.zonell.cointest.db;

import com.activeandroid.query.Select;

import java.util.List;

import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.model.Price;
import ua.kh.zonell.cointest.model.PriceCoin;
import ua.kh.zonell.cointest.util.Const;

public class Queries {

    public static void insertCoin(Coin coin){
        new Coin(
                coin.get_Id(),
                coin.getUrl(),
                coin.getImageUrl(),
                coin.getName(),
                coin.getCoinName()
        ).save();
    }

    public static List<Coin> selectCoin(){
        return new Select().from(Coin.class).limit(Const.TEST_LIMIT).execute();
    }

    public static List<Coin> getImgCoin(String name){
        return new Select().from(Coin.class).where("Name ='" + name + "'").execute();
    }

    public static void insertPriseCoin(String name,
                                       Price priceBTC, Price priceUSD, Price priceEUR){
        new PriceCoin(name,
                priceBTC.getPRICE(), priceBTC.getOPENDAY(), priceBTC.getLOWDAY(), priceBTC.getHIGHDAY(),
                priceUSD.getPRICE(), priceUSD.getOPENDAY(), priceUSD.getLOWDAY(), priceUSD.getHIGHDAY(),
                priceEUR.getPRICE(), priceEUR.getOPENDAY(), priceEUR.getLOWDAY(), priceEUR.getHIGHDAY()
        ).save();

    }

    public static List<PriceCoin> selectPriceCoin(String name){
        return new Select().from(PriceCoin.class).where("Name = '" + name + "'").execute();
    }

    public static List<PriceCoin> selectPrice() {
        return new Select().from(PriceCoin.class).execute();
    }
}
