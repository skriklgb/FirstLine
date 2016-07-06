package skrik.lgb.chapter_3.ListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import skrik.lgb.chapter_3.R;

public class ListViewActivity extends AppCompatActivity {

    String [ ] data ={"苹果","橘子","栗子","香蕉","水果","苹果","橘子","栗子","香蕉","水果","苹果","橘子","栗子","香蕉","水果"};
    private ListView mLv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mLv_list = (ListView) findViewById(R.id.lv_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_1,data);

        mLv_list.setAdapter(adapter);

    }
}
