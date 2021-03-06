package ua.kh.zonell.cointest.db;

import com.activeandroid.Model;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

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

    public static List<Coin> selectAllCoin(){
        return new Select()
                .from(Coin.class)
                .execute();
    }

    public static List<Coin> selectLimitCoin(int limit){
        return new Select()
                .from(Coin.class)
                .limit(limit)
                .execute();
    }

    public static List<Coin> getImgCoin(String name){
        return new Select()
                .from(Coin.class)
                .where("Name ='" + name + "'")
                .execute();
    }

    public static void insertPriseCoin(String name,
                                       Price priceBTC, Price priceUSD, Price priceEUR,
                                       boolean action){
        if (action){
            new PriceCoin(name,
                    priceBTC.getPRICE(), priceBTC.getOPENDAY(), priceBTC.getLOWDAY(), priceBTC.getHIGHDAY(),
                    priceUSD.getPRICE(), priceUSD.getOPENDAY(), priceUSD.getLOWDAY(), priceUSD.getHIGHDAY(),
                    priceEUR.getPRICE(), priceEUR.getOPENDAY(), priceEUR.getLOWDAY(), priceEUR.getHIGHDAY()
            ).save();
        } else {
            new Update(PriceCoin.class)
                    .set("PRICE_BTC ='" + priceBTC.getPRICE() + "', OPENDAY_BTC = '" + priceBTC.getOPENDAY() + "', HIGHDAY_BTC = '" + priceBTC.getLOWDAY() + "', LOWDAY_BTC = '" + priceBTC.getHIGHDAY() + "', " +
                         "PRICE_USD ='" + priceUSD.getPRICE() + "', OPENDAY_USD = '" + priceUSD.getOPENDAY() + "', HIGHDAY_USD = '" + priceUSD.getLOWDAY() + "', LOWDAY_USD = '" + priceUSD.getHIGHDAY() + "', " +
                         "PRICE_EUR ='" + priceEUR.getPRICE() + "', OPENDAY_EUR = '" + priceEUR.getOPENDAY() + "', HIGHDAY_EUR = '" + priceEUR.getLOWDAY() + "', LOWDAY_EUR = '" + priceEUR.getHIGHDAY() + "'"
                    )
                    .where("Name = '" + name + "'")
                    .execute();
        }
    }

    public static PriceCoin selectPriceCoin(String name){
        return new Select()
                .from(PriceCoin.class)
                .where("Name = '" + name + "'")
                .executeSingle();
    }

    public static List<PriceCoin> selectPrice() {
        return new Select()
                .from(PriceCoin.class)
                .execute();
    }

    public static Coin selectAllCoin(String name){
        return new Select()
                .from(Coin.class)
                .where("Name = '" + name + "'")
                .executeSingle();
    }
}
