package ua.kh.zonell.cointest.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import ua.kh.zonell.cointest.R;
import ua.kh.zonell.cointest.db.Queries;
import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.page.InfoCoin;
import ua.kh.zonell.cointest.util.Const;

public class CoinListAdapter extends RecyclerView.Adapter<CoinListAdapter.CoinListViewHolder>{

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
        holder.tvName.setText(coinList.get(position).getName());
        try {
            Picasso
                    .with(context)
                    .load(Const.BASE_URL_IMG +
                            Queries.getImgCoin(holder.tvName.getText().toString()).get(Const.DEFAULT).getImageUrl() +
                            Const.IMG_SIZE)
                    .into(holder.imgCoin);

            holder.tvBTC.setText(Queries
                    .selectPriceCoin(holder.tvName.getText().toString()).get(Const.DEFAULT)
                    .getPRICE_BTC()
                    .toString() + Const.BTC);
            holder.tvUSD.setText(Queries
                    .selectPriceCoin(holder.tvName.getText().toString()).get(Const.DEFAULT)
                    .getPRICE_USD()
                    .toString() + Const.USD);
            holder.tvEUR.setText(Queries
                    .selectPriceCoin(holder.tvName.getText().toString()).get(Const.DEFAULT)
                    .getPRICE_EUR()
                    .toString() + Const.EUR);
        } catch (Exception e){
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

    public class CoinListViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private CircleImageView imgCoin;

        private TextView tvBTC;
        private TextView tvUSD;
        private TextView tvEUR;

        private CardView cvInfoCoin;

        public CoinListViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.nameCoin);
            imgCoin = itemView.findViewById(R.id.imgCoin);

            tvBTC = itemView.findViewById(R.id.BTC);
            tvUSD = itemView.findViewById(R.id.USD);
            tvEUR = itemView.findViewById(R.id.EUR);

            cvInfoCoin = itemView.findViewById(R.id.cvInfoCoin);
        }
    }
}
