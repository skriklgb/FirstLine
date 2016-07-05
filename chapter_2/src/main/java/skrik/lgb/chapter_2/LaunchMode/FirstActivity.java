package skrik.lgb.chapter_2.LaunchMode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_2.R;
import skrik.lgb.chapter_2.skill.BaseActivity;

public class FirstActivity extends BaseActivity {

    private Button mBt_singleTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity返回栈的id","FirstActivity返回栈的id是："+getTaskId());
        setContentView(R.layout.activity_single_top);

        mBt_singleTop = (Button) findViewById(R.id.bt_singleTop);
        mBt_singleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("重新启动FirstActivity","onRestart()");
    }
}
