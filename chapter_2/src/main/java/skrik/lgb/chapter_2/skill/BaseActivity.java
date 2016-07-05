package skrik.lgb.chapter_2.skill;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("当前的活动为：",getClass().getSimpleName());
    }

}
