package liuwenpeng.baway.com.eleteam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;

import base.ShowFragment;
import fragment.DiscountFragment;
import fragment.HomeFragment;
import fragment.MyFragment;
import fragment.ShoppingCarFragment;

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener {
    //获得管理者
    //宋佳南
    FragmentManager manager;
    //开启事物
    FragmentTransaction transaction;
    ArrayList<ShowFragment> list_fragment=new ArrayList<>();
    HomeFragment homeFragment;
    DiscountFragment discountFragment;
    ShoppingCarFragment shoppingCarFragment;
    MyFragment myFragment;
    private LinearLayout ll;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private LinearLayout ll4;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        ll = (LinearLayout) findViewById(R.id.ll);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);
        ll4 = (LinearLayout) findViewById(R.id.ll4);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        ll.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
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
            case R.id.ll:
                addFragment(0);
                iv1.setImageResource(R.mipmap.tab_home_s);
                iv2.setImageResource(R.mipmap.tab_topic);
                iv3.setImageResource(R.mipmap.main_index_cart_normal);
                iv4.setImageResource(R.mipmap.main_index_my_normal);
                tv1.setTextColor(Color.parseColor("#7171fd"));
                tv2.setTextColor(Color.parseColor("#646464"));
                tv3.setTextColor(Color.parseColor("#646464"));
                tv4.setTextColor(Color.parseColor("#646464"));
                break;
            case R.id.ll2:
                addFragment(1);
                iv1.setImageResource(R.mipmap.tab_home);
                iv2.setImageResource(R.mipmap.tab_topic_s);
                iv3.setImageResource(R.mipmap.main_index_cart_normal);
                iv4.setImageResource(R.mipmap.main_index_my_normal);
                tv2.setTextColor(Color.parseColor("#7171fd"));
                tv1.setTextColor(Color.parseColor("#646464"));
                tv3.setTextColor(Color.parseColor("#646464"));
                tv4.setTextColor(Color.parseColor("#646464"));
                break;
            case R.id.ll3:
                addFragment(2);
                iv1.setImageResource(R.mipmap.tab_home);
                iv2.setImageResource(R.mipmap.tab_topic);
                iv3.setImageResource(R.mipmap.main_index_cart_pressed);
                iv4.setImageResource(R.mipmap.main_index_my_normal);
                tv3.setTextColor(Color.parseColor("#7171fd"));
                tv2.setTextColor(Color.parseColor("#646464"));
                tv1.setTextColor(Color.parseColor("#646464"));
                tv4.setTextColor(Color.parseColor("#646464"));
                break;
            case R.id.ll4:
                addFragment(3);
                iv1.setImageResource(R.mipmap.tab_home);
                iv2.setImageResource(R.mipmap.tab_topic);
                iv3.setImageResource(R.mipmap.main_index_cart_normal);
                iv4.setImageResource(R.mipmap.main_index_my_pressed);
                tv4.setTextColor(Color.parseColor("#7171fd"));
                tv2.setTextColor(Color.parseColor("#646464"));
                tv3.setTextColor(Color.parseColor("#646464"));
                tv1.setTextColor(Color.parseColor("#646464"));
                break;
        }
    }
}
