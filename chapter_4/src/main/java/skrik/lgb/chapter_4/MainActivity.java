package skrik.lgb.chapter_4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
//        mButton.setOnClickListener(this);
    }

   /** public void onClick(View v) {
        switch (v.getId()){
             case R.id.button:
                 AnotherRightFragment fragment = new AnotherRightFragment();
                 FragmentManager fragmentManager =getFragmentManager();
                 FragmentTransaction Transaction = fragmentManager.beginTransaction();
                 Transaction.replace(R.id.right_layout,fragment);
                 Transaction.addToBackStack(null);//点击back键返回上一个界面，不退出
                 Transaction.commit();
                 break;
             default:
                 break;
             }

    } **/
}
