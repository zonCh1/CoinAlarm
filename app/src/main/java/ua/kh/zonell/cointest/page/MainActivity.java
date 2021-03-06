package ua.kh.zonell.cointest.page;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.kh.zonell.cointest.App;
import ua.kh.zonell.cointest.R;
import ua.kh.zonell.cointest.adapter.CoinListAdapter;
import ua.kh.zonell.cointest.db.Queries;
import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.model.CoinResult;
import ua.kh.zonell.cointest.model.PriceResult;
import ua.kh.zonell.cointest.model.PriseFull;
import ua.kh.zonell.cointest.util.Const;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvCoin)
    RecyclerView rvCoin;
    @BindView(R.id.swipeListCoin)
    SwipeRefreshLayout swipeListCoin;
    @BindView(R.id.pbCoin)
    ProgressBar pbCoin;
    private Map<String, Coin> coinMap;
    private Map<String, PriseFull> priseFullMap;
    private List<Coin> coinList;
    private List<String> priceNameKey;

    private int count;
    private CoinListAdapter coinListAdapter;

    private StringBuilder paramsGetPriceCoin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
        pbCoin.setVisibility(ProgressBar.VISIBLE);
        priceNameKey = new ArrayList<>();
        count = Const.DEFAULT;
        paramsGetPriceCoin = new StringBuilder();

        loadListCoin();
        setRefreshListener();
    }

    private void loadCoinPrice(final boolean action) {
        coinList = Queries.selectLimitCoin(Const.TEST_LIMIT);
        for (int i = 0; i < coinList.size(); i++) {
            paramsGetPriceCoin.append(coinList.get(i).getName() + Const.SEPARATOR);
        }

        App.getApi(Const.URL_MIN_API).getCoinInfo(paramsGetPriceCoin.toString()).enqueue(new Callback<PriceResult>() {
            @Override
            public void onResponse(Call<PriceResult> call, Response<PriceResult> response) {
                priseFullMap = response.body().getPriceFull();

                for (String name : priseFullMap.keySet()) {
                    priceNameKey.add(name);
                }

                for (PriseFull priseFull : priseFullMap.values()) {
                    Queries.insertPriseCoin(priceNameKey.get(count),
                            priseFull.getPriceBTC(), priseFull.getPriceUSD(), priseFull.getPriceEUR(),
                            action);
                    count++;
                }

                count = Const.DEFAULT;
                priceNameKey.clear();

                displayData(Queries.selectLimitCoin(Const.TEST_LIMIT));
            }

            @Override
            public void onFailure(Call<PriceResult> call, Throwable t) {
            }
        });

        paramsGetPriceCoin.setLength(Const.DEFAULT);
    }

    private void loadListCoin() {
        if (Queries.selectAllCoin().isEmpty()) {
            App.getApi(Const.BASE_URL).getListCoin().enqueue(new Callback<CoinResult>() {
                @Override
                public void onResponse(Call<CoinResult> call, Response<CoinResult> response) {
                    coinMap = response.body().getCoins();
                    for (Coin coinMup : coinMap.values()) {
                        Queries.insertCoin(coinMup);
                    }
                    loadCoinPrice(Const.SELECT);
                }

                @Override
                public void onFailure(Call<CoinResult> call, Throwable t) {
                }
            });
        } else {
            loadCoinPrice(Const.UPDATE);
        }
    }

    private void displayData(List<Coin> coinList) {
        rvCoin.setLayoutManager(new LinearLayoutManager(this));
        rvCoin.setHasFixedSize(true);
        rvCoin.setAdapter(initCoinListAdapter(coinList));
        pbCoin.setVisibility(ProgressBar.INVISIBLE);
    }

    private CoinListAdapter initCoinListAdapter(List<Coin> coinList) {
        if (coinListAdapter == null) {
            coinListAdapter = new CoinListAdapter(coinList, getApplicationContext());
        }
        return coinListAdapter;
    }

    private void setRefreshListener() {
        swipeListCoin.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadCoinPrice(Const.UPDATE);
                pbCoin.setVisibility(ProgressBar.VISIBLE);
                swipeListCoin.setRefreshing(false);
            }
        });
    }
}
