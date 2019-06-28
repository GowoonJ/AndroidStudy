package org.gowoon.androidstudy_2019.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.gowoon.androidstudy_2019.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView btn_1,btn_2,btn_3,btn_4, btn_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = findViewById(R.id.btn_week_1);
        btn_3 = findViewById(R.id.btn_week_3_java);
        btn_4 = findViewById(R.id.btn_week_3_kot);
        btn_5 = findViewById(R.id.btn_week_4_java);

        btn_1.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_week_1:
                Intent intent_1 = new Intent(getApplicationContext(),Week1.class);
                startActivity(intent_1);
                break;
            case R.id.btn_week_2:
                break;
            case R.id.btn_week_3_java:
                Intent intent_3 = new Intent(getApplicationContext(),Week3Java.class);
                startActivity(intent_3);
                break;
            case R.id.btn_week_3_kot:
                Intent intent_kot = new Intent(getApplicationContext(),Week3Kotlin.class);
                startActivity(intent_kot);
                break;
            case R.id.btn_week_4_java:
                Intent intent_4 = new Intent(getApplicationContext(),Week4Java.class);
                startActivity(intent_4);
                break;
        }
    }
}
