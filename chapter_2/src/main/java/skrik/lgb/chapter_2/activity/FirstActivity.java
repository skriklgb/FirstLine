package skrik.lgb.chapter_2.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import skrik.lgb.chapter_2.R;

public class FirstActivity extends Activity{

    private Button mBt_first;
    private Button mBt_sec;
    private Button mBt_intent;
    private Button mBt_third;
    private Button mBt_four;
    private Button mBt_dial;
    private Button mBt_put;
    private Button mBt_setResult;

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

//        2.2.7 销毁一个活动
        mBt_sec = (Button) findViewById(R.id.bt_sec);
        mBt_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //2.3.1 使用显式Intent
        mBt_intent = (Button) findViewById(R.id.bt_intent);
        mBt_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        //2.3.2　使用隐式Intent
        mBt_third = (Button) findViewById(R.id.bt_third);
        mBt_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent("skrik.lgb.chapter_2.ACTION_THIRD");
                    intent.addCategory("skrik.lgb.chapter_2.MY_CATGORY");
                    startActivity(intent);
            }
        });

        //2.3.3　更多隐式Intent的用法-调用系统浏览器打开一个网页
        mBt_four = (Button) findViewById(R.id.bt_four);
        mBt_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://baidu.com"));
                startActivity(intent);
            }
        });

        //2.3.3　更多隐式Intent的用法-调用系统拨号盘
        mBt_dial = (Button) findViewById(R.id.bt_dial);
        mBt_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        //2.3.4　向下一个活动传递数据
        mBt_put = (Button) findViewById(R.id.bt_put);
        mBt_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "向下一个活动传递数据";
                Intent intent = new Intent(FirstActivity.this,putExtraActivity.class);
                intent.putExtra("Extra_data",data);  //putExtra()方法接收两个参数，第一个参数是键，用于后面从Intent中取值，第二个参数才是真正要传递的数据。
                startActivity(intent);
            }
        });

        //2.3.5　返回数据给上一个活动
        mBt_setResult = (Button) findViewById(R.id.bt_setResult);
        mBt_setResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,setResultActivity.class);
                startActivityForResult(intent,1);  //第一个参数还是Intent，第二个参数是请求码，用于在之后的回调中判断数据的来源请求码只要是一个唯一值就可以了，这里传入了1

            }
        });



    }

    /**
     * 由于我们是使用startActivityForResult()方法来启动SecondActivity 的，在setResultActivity被销毁之后会回调上一个活动的onActivityResult()方法，
     * 因此我们需要在FirstActivity 中重写这个方法来得到返回的数据，
     * @param requestCode  我们在启动活动时传入的请求码。
     *                     由于在一个活动中有可能调用startActivityForResult()方法去启动很多不同的活动，每一个活动返回的数据都会回调到onActivityResult()这个方法中，因此
     *                     我们首先要做的就是通过检查requestCode 的值来判断数据来源.
     * @param resultCode   我们在返回数据时传入的处理结果
     *       确定数据是从SecondActivity 返回的之后，我们再通过resultCode 的值来判断处理结果是否成功。
     * @param data    携带着返回数据的Intent
     *                最后从data 中取值并打印出来，这样就完成了向上一个活动返回数据的工作。
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
             case 1:
                        if (resultCode == RESULT_OK){
                                String returnData = data.getStringExtra("data_return");
                               Toast.makeText(FirstActivity.this,returnData,Toast.LENGTH_SHORT).show();
                        }
                 break;


             default:
                 break;
             }
    }

    //    2.2.6 在活动中使用Menu，只在点击menu按键的时候才会显示
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
             case R.id.add_item:
                 Toast.makeText(FirstActivity.this,"You clicked Add",Toast.LENGTH_SHORT).show();
                 break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
             default:
                 break;
             }
        return true;
    }
}