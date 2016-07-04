package skrik.lgb.chapter_2.LifeCycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import skrik.lgb.chapter_2.R;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }
}
