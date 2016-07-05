package skrik.lgb.chapter_3.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import skrik.lgb.chapter_3.R;

public class WidgetActivity extends Activity implements View.OnClickListener {

    private Button mBt_button;
    private EditText mEt_edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);

        mBt_button = (Button) findViewById(R.id.bt_button);
        mEt_edittext = (EditText) findViewById(R.id.et_edittext);

        mBt_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.bt_button:
                 String inputdata = mEt_edittext.getText().toString();
                 Toast.makeText(WidgetActivity.this,inputdata,Toast.LENGTH_SHORT).show();
        
                 break;
        
             default:
                 break;
             }

    }
}
