package com.example.paydemo.viewfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.paydemo.fragmentview.ContactsFragment;
import com.example.paydemo.fragmentview.MessageFragment;
import com.example.paydemo.fragmentview.NewsFragment;
import com.example.paydemo.R;
import com.example.paydemo.fragmentview.SettingFragment;
import com.example.paydemo.SingtonMenu;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    List<Fragment> list = new ArrayList<Fragment>();
    LinearLayout tab1, tab2, tab3, tab4;
    ViewPager viewPager;
    SingtonMenu bottomItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        bottomItem = SingtonMenu.getInstance();

        viewPager = (ViewPager) findViewById(R.id.viewpage);

        findview();


        MessageFragment messageFragment = new MessageFragment();
        ContactsFragment contactsFragment = new ContactsFragment();
        NewsFragment newsFragment = new NewsFragment();
        SettingFragment settingFragment = new SettingFragment();

        list.add(messageFragment);
        list.add(contactsFragment);
        list.add(newsFragment);
        list.add(settingFragment);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        setTabselector(0);

    }

    /**
     * 初始化 底部 视图
     */
    private void findview() {
        //底部初始化
        for (int i = 0; i < bottomItem.num; i++) {
            bottomItem.linears[i] = (LinearLayout) findViewById(bottomItem.linear_id[i]);
            bottomItem.linears[i].setOnClickListener(this);
            bottomItem.images[i] = (ImageView) findViewById(bottomItem.image_id[i]);
            bottomItem.texts[i] = (TextView) findViewById(bottomItem.text_id[i]);
        }
    }


    /**
     * 清除 tab的 选中 状态
     */
    private void clearTabselector() {
        for (int i = 0; i < bottomItem.num; i++) {
            bottomItem.images[i].setImageResource(bottomItem.image_unselected[i]);
            bottomItem.texts[i].setTextColor(getResources().getColor(R.color.textColor_deful));
        }
    }


    private void setTabselector(int index) {
        clearTabselector();
        viewPager.setCurrentItem(index);
        bottomItem.images[index].setImageResource(bottomItem.image_selected[index]);
        bottomItem.texts[index].setTextColor(getResources().getColor(R.color.white));
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab1:
                setTabselector(0);
                break;

            case R.id.tab2:
                setTabselector(1);
                break;

            case R.id.tab3:
                setTabselector(2);
                break;

            case R.id.tab4:
                setTabselector(3);
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTabselector(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
