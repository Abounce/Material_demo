package com.example.administrator.materialdesigndemo.coording;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.materialdesigndemo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyRCadapter extends RecyclerView.Adapter<MyRCadapter.ViewHolder> {
    private List<String> list;
    private Context context;
    public MyRCadapter(Context context,List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.rc_item,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.rc_tv);
        }
    }
}
