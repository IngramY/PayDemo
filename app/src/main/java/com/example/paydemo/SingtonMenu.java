package com.example.paydemo;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/9/9.
 */
public class SingtonMenu {
    private static SingtonMenu instance;

    public static SingtonMenu getInstance() {
        if (instance == null) {
            instance = new SingtonMenu();
        }
        return instance;
    }

    public int num = 4;

    public LinearLayout[] linears = new LinearLayout[num];
    public TextView[] texts = new TextView[num];
    public ImageView[] images = new ImageView[num];

    public int[] image_selected = new int[]{R.drawable.message_selected, R.drawable.contacts_selected,
            R.drawable.news_selected, R.drawable.setting_selected};
    public int[] image_unselected = new int[]{R.drawable.message_unselected, R.drawable.contacts_unselected,
            R.drawable.news_unselected, R.drawable.setting_unselected};

    public int[] text_str = new int[]{R.string.message, R.string.contacts, R.string.news, R.string.setting};
    public int[] layout_id = new int[]{R.layout.fragment_message, R.layout.fragment_contacts, R.layout.fragment_news, R.layout.fragment_setting};

    public int[] linear_id = new int[]{R.id.tab1, R.id.tab2, R.id.tab3, R.id.tab4};
    public int[] image_id = new int[]{R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4};
    public int[] text_id = new int[]{R.id.text1, R.id.text2, R.id.text3, R.id.text4};

}
