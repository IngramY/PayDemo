package com.example.paydemo.basefragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.paydemo.R;
import com.example.paydemo.SingtonMenu;
import com.example.paydemo.fragmentview.BaseFragment;
import com.example.paydemo.fragmentview.ContactsFragment;
import com.example.paydemo.fragmentview.MessageFragment;
import com.example.paydemo.fragmentview.NewsFragment;
import com.example.paydemo.fragmentview.SettingFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FragmentActivity extends android.support.v4.app.FragmentActivity implements View.OnClickListener {

    @InjectView(R.id.left_image_function)
    ImageButton image_goback;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.right_image_function)
    ImageButton image_gonext;

    private SingtonMenu bottomItem;
    private int currentIndex = 0;

    FragmentManager fm;// 管理Fragment队列  事务的回退栈
    FragmentTransaction transaction; // 事务的回退栈
    BaseFragment baseFragment;
    Bundle bundle = new Bundle();

    MessageFragment messageFragment;
    ContactsFragment contactsFragment;
    NewsFragment newsFragment;
    SettingFragment settingFragment;

    Map<Integer, BaseFragment> fragmentMap = new HashMap<Integer, BaseFragment>();

    List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment);
        ButterKnife.inject(this);
        bottomItem = SingtonMenu.getInstance();
        fm = getSupportFragmentManager();

        titleShow();
        findView();
        setTabselector(currentIndex);
    }

    /**
     * 标题 显示
     */
    private void titleShow() {
        image_goback.setVisibility(View.VISIBLE);
        image_gonext.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);

        messageFragment = new MessageFragment();
        contactsFragment = new ContactsFragment();
        newsFragment = new NewsFragment();
        settingFragment = new SettingFragment();

        list.add(messageFragment);
        list.add(contactsFragment);
        list.add(newsFragment);
        list.add(settingFragment);
    }

    /**
     * @param index tab 位置
     */
    @SuppressLint("CommitTransaction")
    private void setTabselector(int index) {
        clearTabselector();
        bottomItem.images[index].setImageResource(bottomItem.image_selected[index]);
        bottomItem.texts[index].setTextColor(getResColorbyId(R.color.white));
        title.setText(bottomItem.text_str[index]);
        transaction = fm.beginTransaction();

        hideFragments(transaction);

//        if (fragmentMap.get(index) == null) {
//            baseFragment = new BaseFragment();
//            bundle.putInt("layout_id", bottomItem.layout_id[index]);
//            fragmentMap.put(index, baseFragment);
//            fragmentMap.get(index).setArguments(bundle);
//            transaction.add(R.id.content, fragmentMap.get(index));
//        } else {
//            transaction.show(fragmentMap.get(index));
//        }

        if (!list.get(index).isAdded()) {
            transaction.add(R.id.content, list.get(index));
        }
            transaction.show(list.get(index));
        transaction.commit();
    }

    /**
     * 清除 tab的 选中 状态
     */
    private void clearTabselector() {
        for (int i = 0; i < bottomItem.num; i++) {
            bottomItem.images[i].setImageResource(bottomItem.image_unselected[i]);
            bottomItem.texts[i].setTextColor(getResColorbyId(R.color.textColor_deful));
        }
    }

    private int getResColorbyId(int colorId) {
        return getResources().getColor(colorId);
    }

    /**
     * 初始化 底部 视图
     */
    private void findView() {
        //底部初始化
        for (int i = 0; i < bottomItem.num; i++) {
            bottomItem.linears[i] = (LinearLayout) findViewById(bottomItem.linear_id[i]);
            bottomItem.linears[i].setOnClickListener(this);
            bottomItem.images[i] = (ImageView) findViewById(bottomItem.image_id[i]);
            bottomItem.texts[i] = (TextView) findViewById(bottomItem.text_id[i]);
        }
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < bottomItem.num; i++) {
            if (view.getId() == bottomItem.linear_id[i]) {
                //点击的Linear背景设置为selector状态
                setTabselector(i);
                currentIndex = i;
            }
        }
    }

    /**
     * @param transaction
     *            隐藏所有非空fragment
     */
    private void hideFragments(FragmentTransaction transaction) {
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) != null) {
                transaction.hide(list.get(i));
            }
        }
    }

//    /**
//     * @param transaction
//     *            隐藏所有非空fragment
//     */
//    private void hideFragments(FragmentTransaction transaction) {
//        for (int i = 0; i < fragmentMap.size(); i++){
//            if (fragmentMap.get(i) != null) {
//                transaction.hide(fragmentMap.get(i));
//            }
//        }
//    }

}
