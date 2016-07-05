package skrik.lgb.chapter_2.LaunchMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import skrik.lgb.chapter_2.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity返回栈的id","ThirdActivity返回栈的id是："+getTaskId());
        setContentView(R.layout.activity_third2);


    }
}
