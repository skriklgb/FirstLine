package skrik.lgb.chapter_7.Contacts;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import skrik.lgb.chapter_7.R;

public class MainActivity extends Activity {

    private ListView mLv_contact;
    ArrayAdapter<String> adapter;
    List<String> contactslist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLv_contact = (ListView) findViewById(R.id.lv_contact);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, contactslist);
        mLv_contact.setAdapter(adapter);
        readContacts();
    }

    private void readContacts() {
        Cursor cursor =null;
        try {
            // 查询联系人数据
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            while (cursor.moveToNext()){
                // 获取联系人姓名
                String displayname = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                // 获取联系人手机号
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactslist.add(displayname+"\n"+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null){
                cursor.close();
            }
        }

    }
}
