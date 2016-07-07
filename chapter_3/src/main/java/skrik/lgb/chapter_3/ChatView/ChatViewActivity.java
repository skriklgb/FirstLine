package skrik.lgb.chapter_3.ChatView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import skrik.lgb.chapter_3.R;
public class ChatViewActivity extends AppCompatActivity {
    private List<Msg> msglist = new ArrayList<Msg>();
    private MsgAdapter mMsgadapter;
    private ListView mMsg_list_view;
    private EditText mInput_text;
    private Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_view);
        initMsg();
        mMsgadapter = new MsgAdapter(ChatViewActivity.this, R.layout.msg_item,msglist);
        mMsg_list_view = (ListView) findViewById(R.id.msg_list_view);
        mInput_text = (EditText) findViewById(R.id.input_text);
        mSend = (Button) findViewById(R.id.send);
        mMsg_list_view.setAdapter(mMsgadapter);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mInput_text.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msglist.add(msg);
                    mMsgadapter.notifyDataSetChanged();//// 当有新消息时，刷新  ListView中的显示
                    mMsg_list_view.setSelection(msglist.size());  // 将ListView 定位到最后一行
                    mInput_text.setText("");
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1 =new Msg("Hello girl",Msg.TYPE_RECEIVED);
        msglist.add(msg1);

        Msg msg2 =new Msg("请问你是哪位",Msg.TYPE_SENT);
        msglist.add(msg2);

        Msg msg3 =new Msg("我是...........................................",Msg.TYPE_RECEIVED);
        msglist.add(msg3);
    }
}
