package skrik.lgb.chapter_8.Message;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;

import skrik.lgb.chapter_8.R;

public class MsgActivity extends Activity {

    private TextView sender;
    private TextView content;
    private IntentFilter receiveFilter;
    private MessageReceiver messageReceiver;

    private TextView mSender;
    private TextView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg);

        mSender = (TextView) findViewById(R.id.sender);
        mContent = (TextView) findViewById(R.id.content);

        receiveFilter = new IntentFilter();
        receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        messageReceiver = new MessageReceiver();
        registerReceiver(messageReceiver, receiveFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
    }

    public class MessageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            Object[ ] pdus = (Object[]) bundle.get("pdus");  // 提取短信消息
            SmsMessage[] smsMessages = new SmsMessage[pdus.length];
            for (int i=0;i<smsMessages.length;i++){
                smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            String address = smsMessages[0].getOriginatingAddress();// 获取发送方号码
            String fullMessage = "";
            for (SmsMessage message : smsMessages){
                fullMessage += message.getMessageBody(); // 获取短信内容
            }
            mSender.setText(address);
            mContent.setText(fullMessage);
        }
    }
}
