package skrik.lgb.chapter_2.LifeCycle;

import android.app.Activity;
import android.os.Bundle;

import skrik.lgb.chapter_2.R;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}
