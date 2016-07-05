package skrik.lgb.chapter_2.LaunchMode;

import android.os.Bundle;
import android.util.Log;

import skrik.lgb.chapter_2.R;
import skrik.lgb.chapter_2.skill.BaseActivity;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity返回栈的id","ThirdActivity返回栈的id是："+getTaskId());
        setContentView(R.layout.activity_third2);


    }
}
