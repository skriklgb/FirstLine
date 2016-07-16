package skrik.lgb.chapter_9.IntentService;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_9.R;

public class IntentServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mStart_intent_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        mStart_intent_service = (Button) findViewById(R.id.start_intent_service);
        mStart_intent_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.start_intent_service:
                 // 打印主线程的id
                 Log.d("MainActivity", "Thread id is " + Thread.currentThread().getId());
                 Intent intentService = new Intent(this, MyIntentService.class);
                 startService(intentService);

                 break;

             default:
                 break;
             }
    }
}
