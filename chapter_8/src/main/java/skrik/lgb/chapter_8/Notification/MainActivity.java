package skrik.lgb.chapter_8.Notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_8.R;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mSend_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSend_notice = (Button) findViewById(R.id.send_notice);
        mSend_notice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.send_notice:
                 NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                 Notification notification = new Notification(R.mipmap.ic_launcher,"This is ticker text",System.currentTimeMillis());
                 Intent intent =new Intent(this,NotificationActivity.class);
                 PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                 notification.setLatestEventInfo(this, "This is content title","This is content text", pendingIntent);
                 manager.notify(1,notification);

                 break;
        
             default:
                 break;
             }

    }
}
