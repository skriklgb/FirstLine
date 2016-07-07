package skrik.lgb.chapter_5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    private IntentFilter mIntentFilter;
    private NetvorkChangeReceive mNetvorkChangeReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetvorkChangeReceive = new NetvorkChangeReceive();
        registerReceiver(mNetvorkChangeReceive,mIntentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetvorkChangeReceive);
    }

    class NetvorkChangeReceive extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager connectionManager  = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is可用", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(context, "network is 不可用", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
