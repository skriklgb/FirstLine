package skrik.lgb.chapter_2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import skrik.lgb.chapter_2.R;

public class FirstActivity extends Activity{

    private Button mBt_first;

    @Override
    //项目中的任何活动都应该重写Activity 的onCreate()方法，
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate()方法非常简单，就是调用了父类的onCreate()方法。当然这只是默认的实现，后面我们还需要在里面加入很多自己的逻辑。
        super.onCreate(savedInstanceState);

        //自己的逻辑
        //2.2.4 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //2.2.2 创建和加载布局
        setContentView(R.layout.activity_first);

        //2.2.5 在活动中使用Toast
        mBt_first = (Button) findViewById(R.id.bt_first);
        mBt_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"the button1 is onclick",Toast.LENGTH_SHORT).show();
            }
        });
    }
}