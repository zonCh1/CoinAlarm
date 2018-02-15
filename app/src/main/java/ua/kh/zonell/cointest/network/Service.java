package ua.kh.zonell.cointest.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.kh.zonell.cointest.model.CoinResult;
import ua.kh.zonell.cointest.model.PriceResult;

public interface Service {

    @GET("coinlist")
    Call<CoinResult> getListCoin();

    @GET("pricemultifull?tsyms=BTC,USD,EUR")
    Call<PriceResult> getCoinInfo(@Query("fsyms") String name);
}
