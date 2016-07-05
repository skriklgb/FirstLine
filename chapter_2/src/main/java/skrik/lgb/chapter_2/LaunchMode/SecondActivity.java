package skrik.lgb.chapter_2.LaunchMode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_2.R;
import skrik.lgb.chapter_2.skill.BaseActivity;

public class SecondActivity extends BaseActivity {

    private Button mBt_singleTop_second;

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity返回栈的id","SecondActivity返回栈的id是："+getTaskId());
        setContentView(R.layout.activity_single_top_second);

        mBt_singleTop_second = (Button) findViewById(R.id.bt_singleTop_second);

        mBt_singleTop_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.actionStart(getApplicationContext(),"data1","data2");
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("销毁secondActivity","onDestroy() ");
    }
}
