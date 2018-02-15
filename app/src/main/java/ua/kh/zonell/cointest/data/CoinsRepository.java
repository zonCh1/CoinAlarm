package ua.kh.zonell.cointest.data;


import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.model.CoinResult;
import ua.kh.zonell.cointest.network.RestClient;

public class CoinsRepository {
    private RestClient restClient;
    private MutableLiveData<List<Coin>> coinsLiveData = new MutableLiveData<>();

    public CoinsRepository(RestClient restClient) {
        this.restClient = restClient;
    }

    public MutableLiveData<List<Coin>> getCoinsLiveData() {
        return coinsLiveData;
    }

    public List<Coin> getAllLoadedCoins() {
        return coinsLiveData.getValue();
    }

    public void loadCoins() {
        loadCoinsData(null);
    }

    public Coin getCoinById(int id) {
        Coin result = new Coin();
        for (Coin coin : coinsLiveData.getValue()) {
            if (coin.get_Id() == id) {
                result = coin;
            }
        }
        return result;
    }

    public void loadCoinsData(final CoinLoadCallback callback) {
        restClient.getCoinsData(new Callback<CoinResult>() {
            @Override
            public void onResponse(@NonNull Call<CoinResult> call, @NonNull Response<CoinResult> response) {
                List<Coin> allCoins = coinsLiveData.getValue();

                if (response.isSuccessful() && response.body() != null) {
                    if (allCoins != null) {
                        allCoins.addAll(response.body().getCoins().values());
                    }
                }

                coinsLiveData.postValue(allCoins);

                if (callback != null) {
                    callback.onResponseGot(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CoinResult> call, @NonNull Throwable t) {
                // TODO: implement error displaying

                List<Coin> allCoins = coinsLiveData.getValue();
                if (allCoins == null) {
                    allCoins = new ArrayList<>();
                }

                coinsLiveData.postValue(allCoins);

                if (callback != null) {
                    // TODO :Implement
                    callback.onResponseGot(null);
                }
            }
        });
    }

    public interface CoinLoadCallback {
        void onResponseGot(CoinResult response);
    }
}
