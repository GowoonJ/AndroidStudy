package org.gowoon.android_study_hw_0715;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login_btn,recyclerviewbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_test_btn = findViewById(R.id.btn_main_login_test);
        Button login_btn = findViewById(R.id.btn_main_login);
        Button recyclerviewbtn = findViewById(R.id.btn_main_recycler);

        login_btn.setOnClickListener(this);
        recyclerviewbtn.setOnClickListener(this);
        login_test_btn.setOnClickListener(this);
        findViewById(R.id.btn_main_progressBar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        switch(view.getId()){
            case R.id.btn_main_login:{
                Intent intent_login = new Intent(getApplicationContext(),login_2.class);
                startActivity(intent_login);
                break;
            }

            case R.id.btn_main_recycler: {
                Intent intent_recycler = new Intent(getApplicationContext(),recyclerview_practice.class);
                startActivity(intent_recycler);
                break;
            }

            case R.id.btn_main_login_test:
                {
                Intent intent_login_test = new Intent(getApplicationContext(),Login_server.class);
                startActivity(intent_login_test);
                break;
            }
            case R.id.btn_main_progressBar:{
                Intent intent_progressBar = new Intent(getApplicationContext(),progressBar_ex.class);
                startActivity(intent_progressBar);
                break;
            }
        }
    }


}
