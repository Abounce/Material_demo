package com.example.administrator.materialdesigndemo.coording;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/1.
 */
public class MyBehavior extends CoordinatorLayout.Behavior {

    public MyBehavior() {
    }
//xml中使用
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //是否关心滑动
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }
   //发生滚动
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy<0){
           ViewCompat.animate(child).scaleX(1).scaleY(1).start();
          //  ViewCompat.animate(child).alpha(1).start();
        }else {
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
           // ViewCompat.animate(child).alpha(0).start();
        }
    }



}
