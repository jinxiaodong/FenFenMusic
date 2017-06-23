package com.project.jinxiaodong.fenfenmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.jinxiaodong.fenfenmusic.bean.grankApi;
import com.project.jinxiaodong.fenfenmusic.network.Api;
import com.project.jinxiaodong.fenfenmusic.network.RetrofitRequest;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.project.jinxiaodong.fenfenmusic.R.id.tv_result;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_requet)
    Button btnRequet;
    @InjectView(tv_result)
    TextView tvResult;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


    }

    @OnClick({R.id.btn_requet, tv_result, R.id.activity_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_requet:
                String url = "http://gank.io/";
                Retrofit retrofit = RetrofitRequest.getRetrofit(url);

                retrofit.create(Api.class).getAndroidInfo().enqueue(new Callback<grankApi>() {
                    @Override
                    public void onResponse(Call<grankApi> call, Response<grankApi> response) {
                        grankApi.ResultsBean bean = response.body().getResults().get(0);
                        tvResult.setText(
                                "_id:" + bean.get_id() + "\n"
                                        + "createdAt：" + bean.getCreatedAt() + "\n"
                                        + "desc：" + bean.getDesc() + "\n"
                                        + "images:" + bean.getImages() + "\n"
                                        + "publishedAt:" + bean.getPublishedAt() + "\n"
                                        + "source" + bean.getSource() + "\n"
                                        + "type:" + bean.getType() + "\n"
                                        + "url: " + bean.getUrl() + "\n"
                                        + "who:" + bean.getWho());
                    }

                    @Override
                    public void onFailure(Call<grankApi> call, Throwable t) {

                    }
                });
                break;
            case tv_result:
                break;
            case R.id.activity_main:
                break;
        }
    }


}
