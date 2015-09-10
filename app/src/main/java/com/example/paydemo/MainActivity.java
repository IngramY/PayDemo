package com.example.paydemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    @InjectView(R.id.left_image_function)
    ImageButton image_goback;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.right_image_function)
    ImageButton image_gonext;

    private SingtonMenu bottomItem;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        bottomItem = SingtonMenu.getInstance();

        image_goback.setVisibility(View.VISIBLE);
        image_gonext.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);

        findView();
        setTabselector(currentIndex);
    }

    /**
     * @param index
     */
    private void setTabselector(int index) {
        clearTabselector();
        bottomItem.images[index].setImageResource(bottomItem.image_selected[index]);
        bottomItem.texts[index].setTextColor(R.color.white);
        title.setText(bottomItem.tabstr[index]);
    }

    /**
     * 清除 选中 状态
     */
    private void clearTabselector(){
        for (int i = 0; i< bottomItem.num; i++){
            bottomItem.images[i].setImageResource(bottomItem.image_unselected[i]);
            bottomItem.texts[i].setTextColor(R.color.textColor_deful);
        }
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
}
