package skrik.lgb.chapter_5.LocalBroadcastManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import skrik.lgb.chapter_5.R;

public class LocalBroadcastManagerActivity extends Activity {

    private Button mBt_sendlocal;
    private LocalBroadcastManager mLocalBroadcastManager;
    private LocalReceiver mLocalReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast_manager);
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this); // 获取实例
        mBt_sendlocal = (Button) findViewById(R.id.bt_sendlocal);
        mBt_sendlocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent("com.example.broadcasttest. LOCAL_BROADCAST");
                mLocalBroadcastManager.sendBroadcast(intent);// 发送本地广播
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest. LOCAL_BROADCAST");
        mLocalReceiver = new LocalReceiver();

        mLocalBroadcastManager.registerReceiver(mLocalReceiver,intentFilter);// 注册本地广播监听器
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mLocalReceiver);
    }

    private class LocalReceiver  extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
