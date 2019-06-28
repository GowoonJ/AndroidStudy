package org.gowoon.android_study_hw_0715;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_server extends AppCompatActivity{

    private TextView errtxt1, errtxt2, servetxt;
    private EditText idtxt, pwtxt;
    private ImageButton btnlogin;
    private boolean i, j;
    private ArrayList<String> al;
    private Pattern upperCase = Pattern.compile(".*[A-Z]+.*");
    // ! @ # $ % ^ & * ( ) ~ : < > ,
    private Pattern spacialChars = Pattern.compile(".*[!@#$%\\^\\.&*()';/?\\\\ \\[\\]\\|\\:\"<>,]+.*");
    private Retrofit retrofit;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_server);

        btnlogin = findViewById(R.id.login_btn_serve);
        idtxt = findViewById(R.id.idedittxt);
        pwtxt = findViewById(R.id.pwedittxt);
        errtxt1 = findViewById(R.id.emailerrtxt);
        errtxt2 = findViewById(R.id.pwerrtxt);
        servetxt = findViewById(R.id.txt_login_test);



        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> comment = apiService.getPostComment("2");
        comment.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.v("Test", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


        idtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString();
                Pattern emailptn = Pattern.compile("\\w++@\\w++\\.\\w++");
                Matcher m = emailptn.matcher(email);
                boolean k = m.matches();
                if(k){
                    errtxt1.setVisibility(View.INVISIBLE);
                    return;
                }
                else
                    errtxt1.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        pwtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();
                if (upperCase.matcher(password).matches()) {
                    if(spacialChars.matcher(password).matches()){
                        errtxt2.setVisibility(View.INVISIBLE);
                    }
                    else
                        errtxt2.setVisibility(View.VISIBLE);
                }
                else
                    errtxt2.setVisibility(View.VISIBLE);

                if(password.length()<8)
                    errtxt2.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
