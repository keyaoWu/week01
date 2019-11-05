package com.bawei.wukeyao20191105.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wukeyao20191105.NetUntil;
import com.bawei.wukeyao20191105.R;
import com.bawei.wukeyao20191105.bean.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：MyAdapter类
 * 作者：武柯耀
 * 当前日期：2019/11/5
 * 当前时间：10:43
 */
public class MyAdapter extends BaseAdapter {
    private Context mcontext;
    private List<Bean.GriddataBean> mlist = new ArrayList<>();

    public MyAdapter(Context mcontext, List<Bean.GriddataBean> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist == null ?0:mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item,null);
            viewHolder = new ViewHolder();
            viewHolder.mimage = view.findViewById(R.id.image);
            viewHolder.mname = view.findViewById(R.id.name);
            viewHolder.mprice = view.findViewById(R.id.price);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mprice.setText(mlist.get(i).getPrice()+"");
        viewHolder.mname.setText(mlist.get(i).getTitle()+"");
        NetUntil.getInstance().doGetPhoto(mlist.get(i).getImageurl(), new NetUntil.myCallBack() {
            @Override
            public void onDoGetSuccess(String json) {

            }

            @Override
            public void onDoGetBitmap(Bitmap bitmap) {
           viewHolder.mimage.setImageBitmap(bitmap);
            }

            @Override
            public void onErrorJson(String error) {

            }

            @Override
            public void onErrorBitmap(String error) {

            }
        });
        return view;
    }
    class ViewHolder{
        ImageView mimage;
        TextView mname;
        TextView mprice;
    }
}
