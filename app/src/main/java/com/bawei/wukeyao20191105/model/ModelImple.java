package com.bawei.wukeyao20191105.model;

import android.graphics.Bitmap;

import com.bawei.wukeyao20191105.Cotntats;
import com.bawei.wukeyao20191105.NetUntil;

/**
 * 功能：ModelImple类
 * 作者：武柯耀
 * 当前日期：2019/11/5
 * 当前时间：10:30
 */
public class ModelImple implements Cotntats.IModel {
    @Override
    public void getInfo(String url, final Cotntats.iCallBack iCallBack) {
        NetUntil.getInstance().doGet(url, new NetUntil.myCallBack() {
            @Override
            public void onDoGetSuccess(String json) {
                iCallBack.onSuccess(json);
            }

            @Override
            public void onDoGetBitmap(Bitmap bitmap) {

            }

            @Override
            public void onErrorJson(String error) {
              iCallBack.onFrild(error);
            }

            @Override
            public void onErrorBitmap(String error) {

            }
        });
    }

    @Override
    public void postInfo(String URL, Cotntats.iCallBack iCallBack) {

    }
}
