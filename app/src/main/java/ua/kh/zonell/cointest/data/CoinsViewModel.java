package ua.kh.zonell.cointest.data;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.model.CoinResult;
import ua.kh.zonell.cointest.util.App;

public class CoinsViewModel extends ViewModel implements Observer<List<Coin>> {
    private final CoinsRepository coinsRepository;

    private MutableLiveData<List<Coin>> coinsLiveData = new MutableLiveData<>();

    public CoinsViewModel() {
        coinsRepository = App.getInstance().getCoinsRepository();
    }

    public LiveData<List<Coin>> setObserver(LifecycleOwner owner) {
        coinsRepository.getCoinsLiveData().observe(owner, this);
        return coinsLiveData;
    }

    public void addCoins() {
        coinsRepository.loadCoinsData(new CoinsRepository.CoinLoadCallback() {
            @Override
            public void onResponseGot(CoinResult response) {
                List<Coin> coins = coinsLiveData.getValue();
                if (coins == null) {
                    coins = new ArrayList<>();
                }

                coins.addAll(response.getCoins().values());
                coinsLiveData.postValue(coins);
            }
        });
    }

    @Override
    public void onChanged(@Nullable List<Coin> coins) {
        if (coins != null) {
            coinsLiveData.setValue(coins);
        }
    }
}
