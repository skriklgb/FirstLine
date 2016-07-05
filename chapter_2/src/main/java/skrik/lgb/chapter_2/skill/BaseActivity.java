package skrik.lgb.chapter_2.skill;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("当前的活动为：",getClass().getSimpleName());

        ActivityCollector.addActivity(this);  //将当前正在创建的活动添加到活动管理器里
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);   //将一个马上要销毁的活动从活动管 理器里移除。

    }
}
