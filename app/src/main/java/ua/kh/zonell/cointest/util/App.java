package ua.kh.zonell.cointest.util;

import android.app.Application;

import com.evgeniysharafan.utils.Utils;
import ua.kh.zonell.cointest.BuildConfig;
import ua.kh.zonell.cointest.data.CoinsRepository;
import ua.kh.zonell.cointest.network.RestClient;

public class App extends Application {
    private static App instance;
    private CoinsRepository coinsRepository;
    private RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this, BuildConfig.DEBUG);

        instance = this;
        restClient = new RestClient();
        coinsRepository = new CoinsRepository(restClient);
    }

    public static App getInstance() {
        return instance;
    }

    public CoinsRepository getCoinsRepository() {
        return coinsRepository;
    }
}
