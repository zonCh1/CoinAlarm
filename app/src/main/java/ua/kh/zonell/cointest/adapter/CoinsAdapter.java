package ua.kh.zonell.cointest.adapter;


import android.graphics.Color;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evgeniysharafan.utils.L;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.kh.zonell.cointest.R;
import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.util.CircleTransformation;
import ua.kh.zonell.cointest.util.Const;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder> {
    private CoinClickListener listener;
    private List<Coin> coins = new ArrayList<>();

    public CoinsAdapter() {
    }

    public void setCoins(List<Coin> coins) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CoinDiffCallback(this.coins, coins));

        this.coins.clear();
        if (coins != null) {
            this.coins.addAll(coins);
        }

        diffResult.dispatchUpdatesTo(this);
    }

    public void setCoinsClickListener(CoinClickListener listener) {
        this.listener = listener;
    }

    @Override
    public CoinsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_coin, parent, false);
        return new CoinsViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(CoinsViewHolder holder, int position) {
        Coin coin = coins.get(position);
        holder.bind(coin);
    }

    @Override
    public int getItemCount() {
        return coins == null ? 0 : coins.size();
    }

    static class CoinsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgCoin)
        ImageView imgCoin;
        @BindView(R.id.nameCoin)
        TextView nameCoin;
        @BindView(R.id.tvBTC)
        TextView tvBTC;
        @BindView(R.id.tvUSD)
        TextView tvUSD;
        @BindView(R.id.tvEUR)
        TextView tvEUR;
        @BindView(R.id.cvInfoCoin)
        CardView cvInfoCoin;

        private CoinClickListener listener;
        private Coin coin;

        private CoinsViewHolder(View itemView, CoinClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
        }

        @OnClick(R.id.cvInfoCoin)
        void onClickCoinCard() {
            if (listener != null) {
                listener.onCoinClick(coin);
            }
        }

        void bind(Coin coin) {
            this.coin = coin;
            nameCoin.setText(coin.getName());

            Picasso.with(imgCoin.getContext())
                    .load(Const.BASE_URL_IMG + coin.getImageUrl())
                    .transform(new CircleTransformation(Color.BLUE, 1))
                    .into(imgCoin);
            L.d("tux" + coin.getImageUrl());
        }
    }

    public interface CoinClickListener {
        void onCoinClick(Coin coin);
    }

    class CoinDiffCallback extends DiffUtil.Callback {
        private List<Coin> oldCoins;
        private List<Coin> newCoins;

        CoinDiffCallback(List<Coin> oldCoins, List<Coin> newCoins) {
            this.oldCoins = oldCoins;
            this.newCoins = newCoins;
        }

        @Override
        public int getOldListSize() {
            return oldCoins == null ? 0 : oldCoins.size();
        }

        @Override
        public int getNewListSize() {
            return newCoins == null ? 0 : newCoins.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldCoins.get(oldItemPosition).equals(newCoins.get(newItemPosition));
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            // TODO: implement check by content

            return oldCoins.get(oldItemPosition).equals(newCoins.get(newItemPosition));
        }
    }



/*
    private List<Coin> coinList;

    public CoinsAdapter() {
        this.coinList = coinList;
    }

    @Override
    public CoinListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoinListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_coin, parent, false));
    }

    @Override
    public void onBindViewHolder(final CoinListViewHolder holder, int position) {
        holder.nameCoin.setText(coinList.get(position).getName());

        Picasso.with(holder.imgCoin.getContext())
                .load(Const.BASE_URL_IMG + coinList.get(position).getImageUrl())
                .transform(new CircleTransformation(Color.BLUE, 1))
                .into(holder.imgCoin);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }

    public void setCoins(List<Coin> coins) {
    }

    public class CoinListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgCoin)
        ImageView imgCoin;
        @BindView(R.id.nameCoin)
        TextView nameCoin;
        @BindView(R.id.tvBTC)
        TextView tvBTC;
        @BindView(R.id.tvUSD)
        TextView tvUSD;
        @BindView(R.id.tvEUR)
        TextView tvEUR;
        @BindView(R.id.cvInfoCoin)
        CardView cvInfoCoin;

        public CoinListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }*/
}
