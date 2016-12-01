package com.example.administrator.materialdesigndemo.coording;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/1.
 */
public class MyFabBehavior extends FloatingActionButton.Behavior {
    public MyFabBehavior() {
    }

    public MyFabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy<0){
            //ViewCompat.animate(child).scaleX(1).scaleY(1).start();
            //  ViewCompat.animate(child).alpha(1).start();
            child.show();
        }else {
            //ViewCompat.animate(child).scaleX(0).scaleY(0).start();
            // ViewCompat.animate(child).alpha(0).start();
            child.hide();
        }
    }
}
