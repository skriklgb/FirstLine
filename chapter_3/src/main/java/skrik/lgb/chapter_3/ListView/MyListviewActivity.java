package skrik.lgb.chapter_3.ListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import skrik.lgb.chapter_3.R;

public class MyListviewActivity extends AppCompatActivity {

    private List<Fruit> mFruitList = new ArrayList<Fruit>();
    private ListView mLv_fruitmy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listview);
        initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(MyListviewActivity.this,R.layout.fruit_item,mFruitList);

        mLv_fruitmy = (ListView) findViewById(R.id.lv_fruitmy);

        mLv_fruitmy.setAdapter(fruitAdapter);

        mLv_fruitmy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(MyListviewActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruits() {
        Fruit apple = new Fruit("apple",R.drawable.apple_pic);
        mFruitList.add(apple);
        Fruit banana = new Fruit("banana",R.drawable.banana_pic);
        mFruitList.add(banana);
        Fruit cherry = new Fruit("cherry",R.drawable.cherry_pic);
        mFruitList.add(cherry);
        Fruit grape = new Fruit("grape",R.drawable.grape_pic);
        mFruitList.add(grape);
        Fruit mango = new Fruit("mango",R.drawable.mango_pic);
        mFruitList.add(mango);
        Fruit orange = new Fruit("orange",R.drawable.orange_pic);
        mFruitList.add(orange);
        Fruit pear = new Fruit("pear",R.drawable.pear_pic);
        mFruitList.add(pear);
        Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple_pic);
        mFruitList.add(pineapple);
        Fruit strawberry = new Fruit("strawberry",R.drawable.strawberry_pic);
        mFruitList.add(strawberry);
        Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon_pic);
        mFruitList.add(watermelon);

    }
}
