package org.gowoon.android_study_hw_0715;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {
    private TextView errtxt1, errtxt2;
    private EditText idtxt, pwtxt;
    private boolean i, j;
    private ArrayList<String> al;
    private Pattern upperCase = Pattern.compile(".*[A-Z]+.*");
    // ! @ # $ % ^ & * ( ) ~ : < > ,
    private Pattern spacialChars = Pattern.compile(".*[!@#$%\\^\\.&*()';/?\\\\ \\[\\]\\|\\:\"<>,]+.*");
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idtxt = findViewById(R.id.idedittxt);
        pwtxt = findViewById(R.id.pwedittxt);
        errtxt1 = findViewById(R.id.emailerrtxt);
        errtxt2 = findViewById(R.id.pwerrtxt);

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

    public void change_login2_activity(View view) {
        Intent intent = new Intent(getApplicationContext(),login_2.class);
        intent.putExtra("id",idtxt.getText().toString());
        intent.putExtra("pw",pwtxt.getText().toString());
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

}
