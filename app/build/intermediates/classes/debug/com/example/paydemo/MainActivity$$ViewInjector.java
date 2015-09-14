// Generated code from Butter Knife. Do not modify!
package com.example.paydemo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.paydemo.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361793, "field 'fragment' and method 'submit'");
    target.fragment = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.submit();
        }
      });
    view = finder.findRequiredView(source, 2131361794, "field 'viewpage' and method 'button_fragment'");
    target.viewpage = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.button_fragment();
        }
      });
  }

  public static void reset(com.example.paydemo.MainActivity target) {
    target.fragment = null;
    target.viewpage = null;
  }
}
