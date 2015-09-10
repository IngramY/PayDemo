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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        bottomItem = SingtonMenu.getInstance();

        findView();
    }

    private void findView() {
        //底部初始化
        for (int i = 0; i < bottomItem.num; i++) {
            bottomItem.linears[i] = (LinearLayout) findViewById(bottomItem.linear_id[i]);
            bottomItem.linears[i].setOnClickListener(this);
            bottomItem.images[i] = (ImageView) findViewById(bottomItem.image_id[i]);

            bottomItem.texts[i] = (TextView) findViewById(bottomItem.text_id[i]);
            bottomItem.texts[i].setText(bottomItem.tabstr[i]);
        }

        image_goback.setVisibility(View.VISIBLE);
        image_gonext.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
        title.setText(bottomItem.tabstr[0]);
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < bottomItem.num; i++) {
            if (view.getId() == bottomItem.linear_id[i]) {
                //点击的Linear背景设置为selector状态
                bottomItem.images[i].setImageResource(bottomItem.image_selected[i]);
                title.setText(bottomItem.tabstr[i]);
//                setView(i);
            } else {
                bottomItem.images[i].setImageResource(bottomItem.image_unselected[i]);
            }
        }
    }

    private void setView(int i) {

    }

}
