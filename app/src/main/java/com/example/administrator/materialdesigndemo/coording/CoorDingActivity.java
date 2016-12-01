package com.example.administrator.materialdesigndemo.coording;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.materialdesigndemo.R;

import java.util.ArrayList;
import java.util.List;

public class CoorDingActivity extends AppCompatActivity {
    private TextView tv;
    private RecyclerView recyclerView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor_ding);
        tv= (TextView) findViewById(R.id.coor_tv);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        list=new ArrayList<>();
        for (int i=0;i<50;i++){
           list.add("这是--------------------"+i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyRCadapter(this,list));

        CoordinatorLayout.LayoutParams parms= (CoordinatorLayout.LayoutParams) tv.getLayoutParams();
        //系统自带的behavior，效果是滑动删除。 sankerbar就是因为有这个behavior才能够滑动删除的
//        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
//        behavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
//            //消失的时候
//            @Override
//            public void onDismiss(final View view) {
//                view.setVisibility(View.GONE);
//                Snackbar.make(view,"delete",Snackbar.LENGTH_LONG).setAction("还原", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                       view.setVisibility(View.VISIBLE);
//                        ViewCompat.animate(view).alpha(1).start();
//                    }
//                }).show();
//
//            }
//             //不滑动，滑动，滑动完成
//            @Override
//            public void onDragStateChanged(int state) {
//
//            }
//        });
//        MyBehavior behavior=new MyBehavior();
//        parms.setBehavior(behavior);
        Toolbar toolbar = (Toolbar) findViewById(R.id.coor_toolbar);
        setSupportActionBar(toolbar);
       CollapsingToolbarLayout ctl= (CollapsingToolbarLayout) findViewById(R.id.ctl);
        ctl.setTitle("我来了");
      FloatingActionButton fab=  (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"float",Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
