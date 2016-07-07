package skrik.lgb.chapter_3.ChatView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import skrik.lgb.chapter_3.R;

public class MsgAdapter extends ArrayAdapter<Msg> {

    private  int mResourceId;

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        mResourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(mResourceId,null);
        }else {
            view = convertView;
        }
        LinearLayout left_layout = (LinearLayout) view.findViewById(R.id.left_layout);
        LinearLayout right_layout = (LinearLayout) view.findViewById(R.id.right_layout);
        TextView left_msg = (TextView) view.findViewById(R.id.left_msg);
        TextView right_msg = (TextView) view.findViewById(R.id.right_msg);

        if (msg.getType() == Msg.TYPE_RECEIVED) {
            // 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            left_layout.setVisibility(View.VISIBLE);
            right_layout.setVisibility(View.GONE);
            left_msg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SENT){
            // 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
            left_layout.setVisibility(View.GONE);
            right_layout.setVisibility(View.VISIBLE);
            right_msg.setText(msg.getContent());
        }

        return view;
    }
}
