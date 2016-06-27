package skrik.lgb.chapter_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
//Activity 是Android 系统提供的一个活动基类，我们项目中所有的活动都必须要继承它才能拥有活动的特性
    @Override
    //onCreate()方法是一个活动被创建时必定要执行的方法
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Android 程序的设计讲究逻辑和视图分离，因此是不推荐在活动中直接编写界面的,setContentView()方法引入进来在布局文件中编写的界面
        setContentView(R.layout.activity_main);

        //在代码中通过R.string.hello_world 可以获得该字符串的引用;  在XML 中通过@string/hello_world 可以获得该字符串的引用。
        Toast.makeText(this,R.string.app_name,Toast.LENGTH_SHORT).show();
    }
}
