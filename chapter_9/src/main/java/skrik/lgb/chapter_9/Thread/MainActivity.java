package skrik.lgb.chapter_9.Thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import skrik.lgb.chapter_9.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int UPDATE_TEXT =1 ;
    private Button mChange_text;
    private TextView mText;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                 case UPDATE_TEXT:
                     // 在这里可以进行UI操作
                     mText.setText("Nice to meet you");
                     break;
                 default:
                     break;
                 }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChange_text = (Button) findViewById(R.id.change_text);
        mText = (TextView) findViewById(R.id.text);
        mChange_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what=UPDATE_TEXT;
                        mHandler.sendMessage(message);// 将Message对象发送出去
                    }
                }).start();
                 break;
             default:
                 break;
             }
    }
}
