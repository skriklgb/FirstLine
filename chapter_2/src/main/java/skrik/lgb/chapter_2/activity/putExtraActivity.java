package skrik.lgb.chapter_2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import skrik.lgb.chapter_2.R;

public class putExtraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_extra);

        Intent intent = getIntent();  //通过getIntent() 方法获取到用于启动SecondActivity 的Intent ，
       String data = intent.getStringExtra("Extra_data"); //getStringExtra()方法来获取传递的数据，如果传递的是整型数据，则使用
        //getIntExtra()方法，传递的是布尔型数据，则使用getBooleanExtra()方法，以此类推
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();

    }
}
