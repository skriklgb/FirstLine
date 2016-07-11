package skrik.lgb.chapter_6.SharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_6.R;

public class SharedPreferencesActivity extends Activity {

    private Button mSave_data;
    private Button mRestore_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mSave_data = (Button) findViewById(R.id.save_data);
        mRestore_data = (Button) findViewById(R.id.restore_data);

        mSave_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.commit();
            }
        });

        mRestore_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pre = getSharedPreferences("data", MODE_PRIVATE);
                String name = pre.getString("name", "");
                int age = pre.getInt("age", 0);
                boolean married = pre.getBoolean("married", false);
                Log.d("从SharedPreferences中读取数","name is"+name);
                Log.d("从SharedPreferences中读取数","age is"+age);
                Log.d("从SharedPreferences中读取数","married is"+married);
            }
        });

    }
}
