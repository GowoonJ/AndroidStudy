package org.gowoon.androidstudy_2019.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.gowoon.androidstudy_2019.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_1,btn_2,btn_3,btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week1);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login:
                break;
        }
    }
}
