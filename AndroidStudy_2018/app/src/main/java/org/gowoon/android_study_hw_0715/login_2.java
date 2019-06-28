package org.gowoon.android_study_hw_0715;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class login_2 extends AppCompatActivity {

    private String id,pw;
    private TextView tvemail,tvpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_2);

        tvemail = findViewById(R.id.txt_login2_email_data);
        tvpw = findViewById(R.id.txt_login2_pw_data);


    }



    public void change_login(View view) {
        Intent intent = new Intent(getApplicationContext(),login.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 2) {
            id = data.getStringExtra("id");
            pw = data.getStringExtra("pw");
            Log.d("test",id+pw);
            tvemail.setText(id);
            tvpw.setText(pw);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
