package ua.kh.zonell.cointest.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.kh.zonell.cointest.R;
import ua.kh.zonell.cointest.db.Queries;
import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.page.InfoCoin;
import ua.kh.zonell.cointest.util.CircleTransformation;
import ua.kh.zonell.cointest.util.Const;

public class CoinListAdapter extends RecyclerView.Adapter<CoinListAdapter.CoinListViewHolder> {

    private List<Coin> coinList;
    private Context context;

    public CoinListAdapter(List<Coin> coinList, Context context) {
        this.coinList = coinList;
        this.context = context;
    }

    @Override
    public CoinListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoinListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_coin, parent, false));
    }

    @Override
    public void onBindViewHolder(final CoinListViewHolder holder, int position) {
        holder.nameCoin.setText(coinList.get(position).getName());
        try {
            Picasso
                    .with(context)
                    .load(Const.BASE_URL_IMG +
                            Queries.getImgCoin(holder.nameCoin.getText().toString()).get(Const.DEFAULT).getImageUrl() +
                            Const.IMG_SIZE)
                    .transform(new CircleTransformation(Color.BLUE, 1))
                    .into(holder.imgCoin);
        } catch (Exception e) {
        }

        try {
            holder.tvBTC.setText(Queries
                    .selectPriceCoin(holder.nameCoin.getText().toString())
                    .getPRICE_BTC()
                    .toString() + Const.BTC);
            holder.tvUSD.setText(Queries
                    .selectPriceCoin(holder.nameCoin.getText().toString())
                    .getPRICE_USD()
                    .toString() + Const.USD);
            holder.tvEUR.setText(Queries
                    .selectPriceCoin(holder.nameCoin.getText().toString())
                    .getPRICE_EUR()
                    .toString() + Const.EUR);
        } catch (Exception e) {
            holder.tvBTC.setText("");
            holder.tvUSD.setText("");
            holder.tvEUR.setText("");
        }

        final int fPosition = position;
        holder.cvInfoCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InfoCoin.class);
                intent.putExtra(Const.NAME, coinList.get(fPosition).getName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coinList.size();
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
    }
}
