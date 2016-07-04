package skrik.lgb.chapter_2.LaunchMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_2.R;

public class standardActivity extends AppCompatActivity {

    private Button mBt_standard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("standard 模式",this.toString());
        setContentView(R.layout.activity_standard);

        mBt_standard = (Button) findViewById(R.id.bt_standard);

        mBt_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(standardActivity.this,standardActivity.class);
                startActivity(intent);
            }
        });


    }
}
