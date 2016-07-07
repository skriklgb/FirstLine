package skrik.lgb.chapter_3.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import skrik.lgb.chapter_3.R;

public class FruitAdapter extends ArrayAdapter<Fruit>{
    private int mResourceId;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);

       mResourceId =  resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);  // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(mResourceId,null);
        ImageView fruit_image = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruit_name = (TextView) view.findViewById(R.id.fruit_name);
        fruit_image.setImageResource(fruit.getImageId());
        fruit_name.setText(fruit.getName());
        return view;

    }
}
