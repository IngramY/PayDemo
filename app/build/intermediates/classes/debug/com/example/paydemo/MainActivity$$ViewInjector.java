// Generated code from Butter Knife. Do not modify!
package com.example.paydemo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.paydemo.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296271, "field 'image_goback'");
    target.image_goback = (android.widget.ImageButton) view;
    view = finder.findRequiredView(source, 2131296274, "field 'title'");
    target.title = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296278, "field 'image_gonext'");
    target.image_gonext = (android.widget.ImageButton) view;
  }

  public static void reset(com.example.paydemo.MainActivity target) {
    target.image_goback = null;
    target.title = null;
    target.image_gonext = null;
  }
}
