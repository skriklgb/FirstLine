package skrik.lgb.chapter_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends Activity implements View.OnClickListener {

    private Button mBt_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);

        mBt_button = (Button) findViewById(R.id.bt_button);

        mBt_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.bt_button:
                 Toast.makeText(getApplicationContext(),"点击了",Toast.LENGTH_SHORT).show();
        
                 break;
        
             default:
                 break;
             }

    }
}
