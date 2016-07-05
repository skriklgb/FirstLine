package skrik.lgb.chapter_3.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import skrik.lgb.chapter_3.R;

public class WidgetActivity extends Activity implements View.OnClickListener {

    private Button mBt_button;
    private EditText mEt_edittext;
    private ImageView mIv_image;
    private Button mBt_button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);

        mBt_button = (Button) findViewById(R.id.bt_button);
        mEt_edittext = (EditText) findViewById(R.id.et_edittext);
        mIv_image = (ImageView) findViewById(R.id.iv_image);
         mBt_button2 = (Button) findViewById(R.id.bt_button2);

        mBt_button.setOnClickListener(this);
        mBt_button2.setOnClickListener(this);

        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.bt_button:
                 String inputdata = mEt_edittext.getText().toString();
                 Toast.makeText(WidgetActivity.this,inputdata,Toast.LENGTH_SHORT).show();
        
                 break;
            case R.id.bt_button2:
                mIv_image.setImageResource(R.mipmap.jelly_bean);
                break;
        
             default:
                 break;
             }

    }
}
