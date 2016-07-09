package skrik.lgb.chapter_5.practice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector  {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity1:activities){   //activity1是遍历后赋值的变量，activities是要遍历的list。
            if (!activity1.isFinishing()) {
                activity1.finish();
            }
        }
    }
}
