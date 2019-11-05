package com.bawei.wukeyao20191105;

/**
 * 功能：Cotntats类
 * 作者：武柯耀
 * 当前日期：2019/11/5
 * 当前时间：10:26
 */
public interface Cotntats {
    interface  IModel{
        void getInfo(String url,iCallBack iCallBack);
        void postInfo(String URL,iCallBack iCallBack);
    }

    interface  IView{
        void onSuccess(String josn);
        void onFrild(String error);
    }

    interface  Persenter{
        void onAttach(IView iView);
        void onRestquest(String url);
        void onDeattch();
    }
    interface iCallBack{
        void onSuccess(String josn);
        void onFrild(String error);
    }
}
