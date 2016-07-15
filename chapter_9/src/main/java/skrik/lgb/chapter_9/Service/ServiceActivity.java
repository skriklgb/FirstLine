package skrik.lgb.chapter_9.Service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_9.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mStart_service;
    private Button mStop_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        mStart_service = (Button) findViewById(R.id.start_service);
        mStop_service = (Button) findViewById(R.id.stop_service);
        mStart_service.setOnClickListener(this);
        mStop_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.start_service:
                 Intent startintent = new Intent(this,MyService.class);
                 startService(startintent);

                 break;

            case R.id.stop_service:
                Intent stopintent = new Intent(this,MyService.class);
                stopService(stopintent);

                break;

             default:
                 break;
             }

    }
}
