package skrik.lgb.chapter_8.Message;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import skrik.lgb.chapter_8.R;

public class MsgActivity extends Activity {

    private TextView sender;
    private TextView content;
    private IntentFilter receiveFilter;
    private MessageReceiver messageReceiver;

    private TextView mSender;
    private TextView mContent;
    private EditText mTo;
    private EditText mMsg_input;
    private Button mSend;
    private SendStatusReceiver mSendStatusReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg);

        mSender = (TextView) findViewById(R.id.sender);
        mContent = (TextView) findViewById(R.id.content);
        mTo = (EditText) findViewById(R.id.to);
        mMsg_input = (EditText) findViewById(R.id.msg_input);
        mSend = (Button) findViewById(R.id.send);

        receiveFilter = new IntentFilter();
        receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        receiveFilter.setPriority(100);
        messageReceiver = new MessageReceiver();
        registerReceiver(messageReceiver, receiveFilter);

        receiveFilter.addAction("SENT_SMS_ACTION");
        mSendStatusReceiver = new SendStatusReceiver();
        registerReceiver(mSendStatusReceiver, receiveFilter);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                Intent sendintent = new Intent("SENT_SMS_ACTION");
                PendingIntent pi = PendingIntent.getActivity(MsgActivity.this, 0, sendintent, 0);
                smsManager.sendTextMessage(mTo.getText().toString(),null,mMsg_input.getText().toString(),pi,null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
        unregisterReceiver(mSendStatusReceiver);
    }

    public  class SendStatusReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (getResultCode() == RESULT_OK){
                // 短信发送成功
                Toast.makeText(context, "Send succeeded",Toast.LENGTH_LONG).show();
            } else{
                // 短信发送失败
                Toast.makeText(context, "Send failed",Toast.LENGTH_LONG).show();
            }
        }
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
            abortBroadcast();
        }
    }

}
