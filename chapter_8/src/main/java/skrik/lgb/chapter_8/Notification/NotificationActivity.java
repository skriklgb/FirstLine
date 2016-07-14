package skrik.lgb.chapter_8.Notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

import skrik.lgb.chapter_8.R;

public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);
    }
}
