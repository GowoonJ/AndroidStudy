package org.gowoon.android_study_hw_0715;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TestAsyncTask extends AsyncTask<Void, Integer , Void>{

    private ProgressBar mProgressBar;
    private TextView mTvProgressText;
    private Button mBtn;
    public TestAsyncTask(ProgressBar progressBar , TextView textView , Button button){
        mProgressBar = progressBar;
        mTvProgressText = textView;
        mBtn = button;
    }

    //새로운 쓰레드임
    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 1; i < 100; i++) {
            try {

                publishProgress(i);
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        releaseViews();
        super.onPostExecute(aVoid);
    }


    /// ...values  가변인자이기때문 . 배열이지만 크기지정 ㄴ 원한ㄴ만큼 넣을수있음
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int progress = values[0];
        mProgressBar.setProgress(progress);
        mTvProgressText.setText(""+ progress);
    }

    @Override
    protected void onCancelled() {
        releaseViews();
        super.onCancelled();
    }
    private void releaseViews(){
        mBtn.setText("시작");
        mTvProgressText = null;
        mProgressBar =null;
        mBtn = null;
    }
}
