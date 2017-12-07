package com.woker.choosehotspot.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.woker.choosehotspot.R;
import com.woker.choosehotspot.activity.adapter.CityListAdapter;
import com.woker.choosehotspot.activity.model.ResonsibleModel;
import com.woker.choosehotspot.activity.util.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class ChooseActivity extends AppCompatActivity {

    @BindView(R.id.grid_view_hot)
    GridView gridViewHot;

    private CityListAdapter hotCityAdapter;
    private List<ResonsibleModel.DataBean> hotData = new ArrayList<>();
    private List<ResonsibleModel.DataBean> carCityList;
    public static SelectCityListener selectCityListener;

    private static final String TAG = "ChooseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        hotCityAdapter = new CityListAdapter(this);
        gridViewHot.setAdapter(hotCityAdapter);
        initGridView();
        sendChooseRequest();
    }

    private void sendChooseRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("resDept", "国土局");
        String address = "http://112.74.127.156/gis-webapps/api/project/getUsersByDept ";
        HttpUtil.sendOkHttpPostRequest(address, map, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//得到服务器返回的具体内容
                final String responseData = response.body().string();
                Log.d(TAG, "可选责任人======" + responseData);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        ResonsibleModel getCarCityModel = gson.fromJson(responseData, ResonsibleModel.class);
                        carCityList = getCarCityModel.getData();
                        for (ResonsibleModel.DataBean data : carCityList) {
                            hotData.add(data);
                        }
                        hotCityAdapter.setModels(carCityList);
                    }
                });
            }
        });
    }

    public interface SelectCityListener {
        void getCoupon(ResonsibleModel.DataBean cityModel);
    }

    private void initGridView() {

        gridViewHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (selectCityListener != null) {
                    selectCityListener.getCoupon(hotData.get(i));
                    finish();
                }

            }
        });
    }
}
