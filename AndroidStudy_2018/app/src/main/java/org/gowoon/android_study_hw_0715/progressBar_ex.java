package org.gowoon.android_study_hw_0715;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class progressBar_ex extends AppCompatActivity {
    ProgressDialog dialog;
    private TestAsyncTask task = null;
    private Button mBtn;
    private TextView mTvProgress;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_ex);

        mProgress = (ProgressBar) findViewById(R.id.progress_bar);
        mBtn = findViewById(R.id.button_view);
        mTvProgress = findViewById(R.id.textView);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mBtn.getText().equals("시작")){
                    task = new TestAsyncTask(mProgress, mTvProgress,mBtn);
                    task.execute();
                }
                else {
                    task.cancel(false);
                }
            }
        });
    }
}
