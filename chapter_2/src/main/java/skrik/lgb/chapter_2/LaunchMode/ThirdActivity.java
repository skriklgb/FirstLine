package skrik.lgb.chapter_2.LaunchMode;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_2.R;
import skrik.lgb.chapter_2.skill.ActivityCollector;
import skrik.lgb.chapter_2.skill.BaseActivity;

public class ThirdActivity extends BaseActivity {

    private Button mBt_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity返回栈的id","ThirdActivity返回栈的id是："+getTaskId());
        setContentView(R.layout.activity_third2);

        mBt_finish = (Button) findViewById(R.id.bt_finish);

        mBt_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
            }
        });
    }
}
