package liuwenpeng.baway.com.eleteam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import java.util.ArrayList;

import base.ShowFragment;
import fragment.DiscountFragment;
import fragment.HomeFragment;
import fragment.MyFragment;
import fragment.ShoppingCarFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //获得管理者
    //我是刘文鹏a
    //宋佳南
    FragmentManager manager;
    //开启事物
    FragmentTransaction transaction;
    ArrayList<ShowFragment> list_fragment=new ArrayList<>();
    HomeFragment homeFragment;
    DiscountFragment discountFragment;
    ShoppingCarFragment shoppingCarFragment;
    MyFragment myFragment;
    private RadioButton home_image;
    private RadioButton disc_image;
    private RadioButton car_image;
    private RadioButton my_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        home_image = (RadioButton) findViewById(R.id.home_image);
        disc_image = (RadioButton) findViewById(R.id.disc_image);
        car_image = (RadioButton) findViewById(R.id.car_image);
        my_image = (RadioButton) findViewById(R.id.my_image);
        home_image.setOnClickListener(this);
        disc_image.setOnClickListener(this);
        car_image.setOnClickListener(this);
        my_image.setOnClickListener(this);
    }

    private void initData() {
        //实例化管理者
        manager=getSupportFragmentManager();
        homeFragment=new HomeFragment();
        discountFragment=new DiscountFragment();
        shoppingCarFragment=new ShoppingCarFragment();
        myFragment=new MyFragment();
        //添加到集合中
        addList();
        addFragment(0);
    }
    public void addFragment(int position){
        transaction = manager.beginTransaction();
        //将fragment 加载进来
        for(int i=0;i<list_fragment.size();i++){
            if(i != position){
                transaction.hide(list_fragment.get(i).fragment);
            }
        }
        if(list_fragment.get(position).statue == 0){
            transaction.add(R.id.fram,list_fragment.get(position).fragment);
            list_fragment.get(position).statue = 1;
            transaction.show(list_fragment.get(position).fragment);
        }else {
            transaction.show(list_fragment.get(position).fragment);
        }
        transaction.commit();

    }
    private void addList() {
        for(int i=0;i<4;i++){
            ShowFragment showFragment = new ShowFragment();
            switch (i){
                case 0:
                    showFragment.fragment = homeFragment;
                    break;
                case 1:
                    showFragment.fragment = discountFragment;
                    break;
                case 2:
                    showFragment.fragment = shoppingCarFragment;
                    break;
                case 3:
                    showFragment.fragment = myFragment;
                    break;
            }
            list_fragment.add(showFragment);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_image:
                addFragment(0);
                home_image.setTextColor(Color.parseColor("#7171fd"));
                disc_image.setTextColor(Color.parseColor("#646464"));
                car_image.setTextColor(Color.parseColor("#646464"));
                my_image.setTextColor(Color.parseColor("#646464"));
                break;
            case R.id.disc_image:
                addFragment(1);
                disc_image.setTextColor(Color.parseColor("#7171fd"));
                home_image.setTextColor(Color.parseColor("#646464"));
                car_image.setTextColor(Color.parseColor("#646464"));
                my_image.setTextColor(Color.parseColor("#646464"));
                break;
            case R.id.car_image:
                addFragment(2);
                car_image.setTextColor(Color.parseColor("#7171fd"));
                disc_image.setTextColor(Color.parseColor("#646464"));
                home_image.setTextColor(Color.parseColor("#646464"));
                my_image.setTextColor(Color.parseColor("#646464"));
                break;
            case R.id.my_image:
                addFragment(3);
                my_image.setTextColor(Color.parseColor("#7171fd"));
                disc_image.setTextColor(Color.parseColor("#646464"));
                car_image.setTextColor(Color.parseColor("#646464"));
                home_image.setTextColor(Color.parseColor("#646464"));
                break;
        }
    }
}
