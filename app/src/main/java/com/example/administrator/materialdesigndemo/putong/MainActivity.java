package com.example.administrator.materialdesigndemo.putong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.materialdesigndemo.R;
import com.example.administrator.materialdesigndemo.coording.CoorDingActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout input_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager pager= (ViewPager) findViewById(R.id.pager);
        final TabLayout tab= (TabLayout) findViewById(R.id.tab);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        final DrawerLayout drawer= (DrawerLayout) findViewById(R.id.drawer);

        setDrawerLeftEdgeSize(this,drawer,1.0f);
        NavigationView  navigation = (NavigationView) findViewById(R.id.navigation);
        View head =View.inflate(this,R.layout.head,null);
        navigation.addHeaderView(head);
        ImageView iv= (ImageView) head.findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了头像", Toast.LENGTH_SHORT).show();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        List<String> list=new ArrayList<>();
        for (int i=0;i<4;i++){
            list.add(String.format(Locale.CHINA,"第%02d页",i));
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tab.setupWithViewPager(pager);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.sing_1:
                    case R.id.sing_2:
                    case R.id.item_1:
                    case R.id.item_2:
                    case R.id.item_3:
                    case R.id.item_4:
                        //关闭navigationView
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.item_5:
                        finish();
                        break;

                }
                return true;
            }
        });

        input_text = (TextInputLayout) findViewById(R.id.text_input);
        input_text.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()<6){
                    input_text.setError("用户名必须为6位以上");
                    input_text.setErrorEnabled(true);
                }else {
                    input_text.setErrorEnabled(false);
                }
            }
        });
    }
    //利用反射设置drawlyaout是否全屏滑动
    public static void setDrawerLeftEdgeSize(Activity activity, DrawerLayout drawerLayout, float displayWidthPercentage) {
        if (activity == null || drawerLayout == null) return;
        try {
            Field leftDraggerField = drawerLayout.getClass().getDeclaredField("mLeftDragger");
            leftDraggerField.setAccessible(true);
            ViewDragHelper leftDragger = (ViewDragHelper) leftDraggerField.get(drawerLayout);
            Field edgeSizeField = leftDragger.getClass().getDeclaredField("mEdgeSize");
            edgeSizeField.setAccessible(true);
            int edgeSize = edgeSizeField.getInt(leftDragger);
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            edgeSizeField.setInt(leftDragger, Math.max(edgeSize, (int) (dm.widthPixels * displayWidthPercentage)));
        } catch (Exception e) {
        }
    }
    public void start(View v){
        Snackbar.make(v,"这是snackerbar",Snackbar.LENGTH_LONG).setAction("点击进入第coordinglayotu", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CoorDingActivity.class));
            }
        }).show();
    }
}
