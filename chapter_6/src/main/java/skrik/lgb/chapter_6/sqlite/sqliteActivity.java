package skrik.lgb.chapter_6.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_6.R;

public class sqliteActivity extends AppCompatActivity {

    private MyDatabaseHelper mMyDatabaseHelper;
    private Button mCreate_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);

        mMyDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        mCreate_database = (Button) findViewById(R.id.create_database);

        mCreate_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyDatabaseHelper.getWritableDatabase();
            }
        });
    }
}
