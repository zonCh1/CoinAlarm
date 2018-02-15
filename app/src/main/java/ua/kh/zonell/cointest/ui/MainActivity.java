package ua.kh.zonell.cointest.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.kh.zonell.cointest.R;
import ua.kh.zonell.cointest.adapter.CoinsAdapter;
import ua.kh.zonell.cointest.data.CoinsViewModel;
import ua.kh.zonell.cointest.model.Coin;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvCoin)
    RecyclerView coinsList;
    @BindView(R.id.swipeListCoin)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.pbCoin)
    ProgressBar progressBar;

    private CoinsAdapter coinsAdapter;
    private CoinsViewModel coinsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initCoinsList();

        coinsViewModel = ViewModelProviders.of(this).get(CoinsViewModel.class);
        coinsViewModel.setObserver(this).observe(this, new Observer<List<Coin>>() {
            @Override
            public void onChanged(@Nullable List<Coin> coins) {
                updateCoinsList(coins);
            }
        });

        loadCoinsList();
    }

    private void initCoinsList() {
        //TODO setCoinsClickListener

        coinsAdapter = new CoinsAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        coinsList.setLayoutManager(layoutManager);
        coinsList.setAdapter(coinsAdapter);
        setRefreshListener();
    }

/*
    private void loadListCoin() {
        App.getApi(Const.BASE_URL).getListCoin().enqueue(new Callback<CoinResult>() {
            @Override
            public void onResponse(Call<CoinResult> call, Response<CoinResult> response) {
                coinMap = response.body().getCoins();

                for (Coin coinMup : coinMap.values()) {
                    coins.add(coinMup);
                }
                displayData(coins);
            }

            @Override
            public void onFailure(Call<CoinResult> call, Throwable t) {
            }
        });
    }*/
/*
    private void displayData(List<Coin> coinList) {
        coinsList.setLayoutManager(new LinearLayoutManager(this));
        coinsList.setHasFixedSize(true);
        coinsList.setAdapter(initCoinListAdapter(coinList));
        pbCoin.setVisibility(ProgressBar.INVISIBLE);
    }

    private CoinsAdapter initCoinListAdapter(List<Coin> coinList) {
        if (coinsAdapter == null) {
            coinsAdapter = new CoinsAdapter(coinList);
        }
        return coinsAdapter;
    }*/


    private void loadCoinsList() {
        progressBar.setVisibility(View.VISIBLE);
        coinsViewModel.addCoins();
    }

    private void updateCoinsList(List<Coin> coins) {
        coinsAdapter.setCoins(coins);
        /*if (noCoinsText != null) {
            if (games != null && !games.isEmpty()) {
                noGamesText.setVisibility(View.INVISIBLE);
            } else {
                noGamesText.setVisibility(View.VISIBLE);
            }
        }*/

        if (progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }


    private void setRefreshListener() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                progressBar.setVisibility(ProgressBar.VISIBLE);
                refreshLayout.setRefreshing(false);
            }
        });
    }
}
