package com.woker.choosehotspot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.woker.choosehotspot.R;
import com.woker.choosehotspot.activity.model.ResonsibleModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_current)
    TextView tvCurrent;

    public ChooseActivity.SelectCityListener selectCityListener = new ChooseActivity.SelectCityListener() {
        @Override
        public void getCoupon(ResonsibleModel.DataBean cityModel) {
            tvCurrent.setText(cityModel.getName());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_current})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_current:
                ChooseActivity.selectCityListener = selectCityListener;
                Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                startActivity(intent);
                break;
        }
    }
}
