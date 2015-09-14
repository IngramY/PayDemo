package com.example.paydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import com.example.paydemo.basefragment.FragmentActivity;
import com.example.paydemo.viewfragment.ViewPageActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * fragment 使用  fragment 与viewpage 使用
 */
public class MainActivity extends Activity {

    @InjectView(R.id.fragment)
    Button fragment;
    @InjectView(R.id.viewpage)
    Button viewpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick(R.id.fragment)
    public void submit() {
        Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.viewpage)
    public void button_fragment() {
        Intent intent = new Intent(MainActivity.this, ViewPageActivity.class);
        startActivity(intent);

    }

}
