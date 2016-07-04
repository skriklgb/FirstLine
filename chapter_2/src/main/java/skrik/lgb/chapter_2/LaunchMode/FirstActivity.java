package skrik.lgb.chapter_2.LaunchMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_2.R;

public class FirstActivity extends AppCompatActivity {

    private Button mBt_singleTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("singleTop 模式",this.toString());
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
