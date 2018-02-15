package ua.kh.zonell.cointest.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.kh.zonell.cointest.model.CoinResult;

public class RestClient {
    private static final String BASE_URL = "https://www.cryptocompare.com/api/data/";
    private static final int CONNECTION_TIMEOUT = 5;
    private static final int WRITE_TIMEOUT = 5;
    private static final int READ_TIMEOUT = 10;

    private final Service service;

    public RestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        service = retrofit.create(Service.class);
    }

    public void getCoinsData(Callback<CoinResult> callback) {
        getData(callback);
    }

    private void getData(Callback<CoinResult> callback) {
        Call<CoinResult> call = service.getListCoin();
        call.enqueue(callback);
    }
}
