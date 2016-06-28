package skrik.lgb.chapter_2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_2.R;

public class setResultActivity extends AppCompatActivity {

    private Button mBt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_result);

        mBt_result = (Button) findViewById(R.id.bt_result);
        mBt_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();   //这个Intent 仅仅是用于传递数据而已，它没有指定任何的“意图”
                intent.putExtra("data_return","返回数据给上一个活动");  //紧接着把要传递的数据存放在Intent 中
                setResult(RESULT_OK,intent);//是专门用于向上一个活动返回数据的。setResult()方法接收两个
                //参数， 第一个参数用于向上一个活动返回处理结果， 一般只使用RESULT_OK 或RESULT_CANCELED 这两个值，第二个参数则是把带有数据的Intent 传递回去
                finish();   //finish()方法来销毁当前活动。
            }
        });
    }


    /**
     * 用户按下Back 键，就会去执行onBackPressed()方法中的代码，
     * 解决通过按下Back 键回到FirstActivity，这样数据不就没法返回的问题
     */
    @Override
    public void onBackPressed() {
        Intent intent =new Intent();   //这个Intent 仅仅是用于传递数据而已，它没有指定任何的“意图”
        intent.putExtra("data_return","返回数据给上一个活动");  //紧接着把要传递的数据存放在Intent 中
        setResult(RESULT_OK,intent);//是专门用于向上一个活动返回数据的。setResult()方法接收两个
        //参数， 第一个参数用于向上一个活动返回处理结果， 一般只使用RESULT_OK 或RESULT_CANCELED 这两个值，第二个参数则是把带有数据的Intent 传递回去
        finish();   //finish()方法来销毁当前活动。
    }
}
