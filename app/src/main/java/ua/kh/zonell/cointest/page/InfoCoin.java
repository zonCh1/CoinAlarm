package ua.kh.zonell.cointest.page;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.kh.zonell.cointest.R;
import ua.kh.zonell.cointest.db.Queries;
import ua.kh.zonell.cointest.model.Coin;
import ua.kh.zonell.cointest.util.CircleTransformation;
import ua.kh.zonell.cointest.util.Const;

public class InfoCoin extends AppCompatActivity {

    @BindView(R.id.imgInfoCoin)
    ImageView imgInfoCoin;
    @BindView(R.id.tvNameInfoCoin)
    TextView tvNameInfoCoin;
    @BindView(R.id.fabInfoCoin)
    FloatingActionButton fabInfoCoin;
    @BindView(R.id.etHashPower)
    EditText etHashPower;
    @BindView(R.id.etPowerConsumption)
    EditText etPowerConsumption;
    @BindView(R.id.etCostPerKw)
    EditText etCostPerKw;
    @BindView(R.id.btnCalculate)
    Button btnCalculate;
    @BindView(R.id.includeMiningProfit)
    RelativeLayout includeMiningProfit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_coin);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
        Picasso
                .with(getApplicationContext())
                .load(Const.BASE_URL_IMG + getCoin().getImageUrl() + Const.IMG_SIZE)
                .transform(new CircleTransformation(Color.WHITE, 1))
                .into(imgInfoCoin);

        tvNameInfoCoin.setText(getCoin().getCoinName() + "(" + getCoin().getName() + ")");

        setVisibleCalculate();
    }

    private void setVisibleCalculate(){
        includeMiningProfit.setVisibility(Const.listCalculator.contains(getName()) ?
                View.VISIBLE : View.INVISIBLE);
    }

    private Coin getCoin() {
        return Queries.selectAllCoin(getName());
    }

    private String getName() {
        Bundle dataBundle = getIntent().getExtras();
        return dataBundle.getString(Const.NAME);
    }

    @OnClick(R.id.btnCalculate)
    public void btnCalculateClicked() {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.URL_CALC);
        sb.append(getName().toLowerCase());
        sb.append("?HashingPower=");
        sb.append(etHashPower.getText().toString());
        sb.append("&PowerConsumption=");
        sb.append(etPowerConsumption.getText().toString());
        sb.append("&CostPerkWh=");
        sb.append(etCostPerKw.getText().toString());
        sb.append("&HashingUnit=");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(sb.toString()));
        startActivity(intent);
    }

    @OnClick(R.id.fabInfoCoin)
    public void fabInfoCoinClicked() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(Const.BASE_URL_IMG + getCoin().getUrl()));
        startActivity(intent);
    }
}
