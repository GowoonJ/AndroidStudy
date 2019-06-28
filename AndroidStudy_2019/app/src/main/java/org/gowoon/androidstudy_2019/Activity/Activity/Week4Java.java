package org.gowoon.androidstudy_2019.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.gowoon.androidstudy_2019.Activity.model.ResultRetrofitTest;
import org.gowoon.androidstudy_2019.Activity.util.Config;
import org.gowoon.androidstudy_2019.Activity.util.RetrofitService;
import org.gowoon.androidstudy_2019.Activity.util.Singleton;
import org.gowoon.androidstudy_2019.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Week4Java extends AppCompatActivity {
    TextView tv;
    Button btn;
    public static final RetrofitService retrofit = new Retrofit.Builder()
            .baseUrl(Config.serverUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4_java);

        tv = findViewById(R.id.tv_week4);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singleton.retrofit.examplePostModel().enqueue(new Callback<ResultRetrofitTest>() {
                    @Override
                    public void onResponse(Call<ResultRetrofitTest> call, Response<ResultRetrofitTest> response) {
                        if (response.isSuccessful()){


                        }
                    }

                    @Override
                    public void onFailure(Call<ResultRetrofitTest> call, Throwable t) {

                    }
                });

                Singleton.retrofit.exampleGet().enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });

                Singleton.retrofit.examplePost().enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            JsonObject result = response.body();
                            String resultUserId = String.valueOf(result.get("userid"));
                            result.get("userId");
                            tv.setText(resultUserId);
                        }
                        else{
                            Toast.makeText();
                            Log.d("retrofit err", "에러뜸");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });

            }
        });
    }
}
