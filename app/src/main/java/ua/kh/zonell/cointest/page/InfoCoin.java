package ua.kh.zonell.cointest.page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import ua.kh.zonell.cointest.R;
import ua.kh.zonell.cointest.db.Queries;
import ua.kh.zonell.cointest.model.PriceCoin;
import ua.kh.zonell.cointest.util.Const;

public class InfoCoin extends AppCompatActivity {

    private List<PriceCoin> priceCoinList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_coin);

        initUI();
    }

    private void initUI() {
        priceCoinList = Queries.selectPriceCoin(getName());
    }

    private String getName(){
        Bundle dataBundle = getIntent().getExtras();
        return dataBundle.getString(Const.NAME);
    }
}
