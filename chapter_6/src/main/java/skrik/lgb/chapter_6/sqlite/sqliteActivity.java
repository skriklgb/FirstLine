package skrik.lgb.chapter_6.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_6.R;

public class sqliteActivity extends AppCompatActivity {

    private MyDatabaseHelper mMyDatabaseHelper;
    private Button mCreate_database;
    private Button mAdd_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);

        mMyDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);
        mCreate_database = (Button) findViewById(R.id.create_database);
        mAdd_data = (Button) findViewById(R.id.add_data);

        mCreate_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyDatabaseHelper.getWritableDatabase();
            }
        });

        mAdd_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mMyDatabaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // 开始组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book",null,values);  // 插入第一条数据
                // 开始组装第二条数据
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book", null, values); // 插入第二条数据
            }
        });
    }
}
