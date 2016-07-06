package skrik.lgb.chapter_3.custormwidget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import skrik.lgb.chapter_3.R;

public class TitleLayout  extends LinearLayout{

    private final Button mTitle_back;
    private final Button mTitle_edit;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        mTitle_back = (Button) findViewById(R.id.title_back);
        mTitle_edit = (Button) findViewById(R.id.title_edit);

        mTitle_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();  //销毁掉当前的活动
            }
        });

        mTitle_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked Edit button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
