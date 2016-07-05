package skrik.lgb.chapter_2.LaunchMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_2.R;

public class SecondActivity extends AppCompatActivity {

    private Button mBt_singleTop_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity返回栈的id","SecondActivity返回栈的id是："+getTaskId());
        setContentView(R.layout.activity_single_top_second);

        mBt_singleTop_second = (Button) findViewById(R.id.bt_singleTop_second);

        mBt_singleTop_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("销毁secondActivity","onDestroy() ");
    }
}
