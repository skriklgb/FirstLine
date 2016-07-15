package skrik.lgb.chapter_9.Service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_9.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mStart_service;
    private Button mStop_service;
    private Button mBind_service;
    private Button mUnbind_service;

    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        mStart_service = (Button) findViewById(R.id.start_service);
        mStop_service = (Button) findViewById(R.id.stop_service);
        mStart_service.setOnClickListener(this);
        mStop_service.setOnClickListener(this);

        mBind_service = (Button) findViewById(R.id.bind_service);
        mUnbind_service = (Button) findViewById(R.id.unbind_service);
        mBind_service.setOnClickListener(this);
        mUnbind_service.setOnClickListener(this);
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

            case R.id.bind_service:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE); // 绑定服务
                break;
            case R.id.unbind_service:
                unbindService(connection); // 解绑服务
                break;

             default:
                 break;
             }

    }
}
