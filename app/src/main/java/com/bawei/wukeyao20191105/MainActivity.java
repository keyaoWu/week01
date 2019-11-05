package com.bawei.wukeyao20191105;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bawei.wukeyao20191105.adapter.MyAdapter;
import com.bawei.wukeyao20191105.bean.Bean;
import com.bawei.wukeyao20191105.persenter.Presenter;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Cotntats.IView {
    private Cotntats.Persenter mpresenter;
    private String url = "http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
    private XBanner xBanner;
    private GridView gridView;
    private List<Bean.GriddataBean> mlist = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mpresenter = new Presenter();
        mpresenter.onAttach(this);
        mpresenter.onRestquest(url);
        myAdapter = new MyAdapter(MainActivity.this, mlist);
        gridView.setAdapter(myAdapter);
    }

    @Override
    public void onSuccess(String josn) {
        //解析
        final List<Bean.BannerdataBean> bannerdata = new Gson().fromJson(josn, Bean.class).getBannerdata();
       xBanner.setBannerData(bannerdata);
        Log.d("myMessage",""+bannerdata);
       xBanner.loadImage(new XBanner.XBannerAdapter() {
           @Override
           public void loadBanner(XBanner banner, Object model, View view, int position) {
               Glide.with(MainActivity.this).load(bannerdata.get(position).getImageurl()).into((ImageView) view);
           }
       });
        List<Bean.GriddataBean> griddata = new Gson().fromJson(josn, Bean.class).getGriddata();
        Log.d("myMessage",""+griddata);
        mlist.addAll(griddata);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFrild(String error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.onDeattch();
            mpresenter = null;
        }
    }

    private void initView() {
        xBanner = (XBanner) findViewById(R.id.xb);
        gridView = (GridView) findViewById(R.id.grid);
    }
}
