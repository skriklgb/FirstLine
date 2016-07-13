package skrik.lgb.chapter_7.ProviderTest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skrik.lgb.chapter_7.R;

public class ProviderTestActivity extends AppCompatActivity {

    private String newId;

    private Button mAdd_data;
    private Button mDelete_data;
    private Button mUpdate_data;
    private Button mQuery_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_test);

        mAdd_data = (Button) findViewById(R.id.add_data);
        mDelete_data = (Button) findViewById(R.id.delete_data);
        mUpdate_data = (Button) findViewById(R.id.update_data);
        mQuery_data = (Button) findViewById(R.id.query_data);

        mAdd_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 添加数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider/Book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "George Martin");
                values.put("pages", 1040);
                values.put("price", 22.85);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });

        mDelete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 删除数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider/Book/" + newId);
                        getContentResolver().delete(uri, null, null);
            }
        });

        mUpdate_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 修改数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider/Book/" + newId);
                        ContentValues values = new ContentValues();
                values.put("name", "A Storm of Swords");
                values.put("pages", 1216);
                values.put("price", 24.05);
                getContentResolver().update(uri, values, null, null);
            }
        });

        mQuery_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider/Book");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "book name is " + name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    }
                    cursor.close();
                }
            }
        });
    }
}
