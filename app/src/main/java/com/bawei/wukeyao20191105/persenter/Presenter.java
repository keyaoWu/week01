package com.bawei.wukeyao20191105.persenter;

import com.bawei.wukeyao20191105.Cotntats;
import com.bawei.wukeyao20191105.model.ModelImple;

/**
 * 功能：Presenter类
 * 作者：武柯耀
 * 当前日期：2019/11/5
 * 当前时间：10:31
 */
public class Presenter implements Cotntats.Persenter {
    private Cotntats.IModel mModel;
    private Cotntats.IView mView;
    @Override
    public void onAttach(Cotntats.IView iView) {
        this.mView = iView;
        mModel = new ModelImple();
    }

    @Override
    public void onRestquest(String url) {
     mModel.getInfo(url, new Cotntats.iCallBack() {
         @Override
         public void onSuccess(String josn) {
             mView.onSuccess(josn);
         }

         @Override
         public void onFrild(String error) {
          mView.onFrild(error);
         }
     });
    }

    @Override
    public void onDeattch() {
      if (mModel!=null){
          mModel = null;
      }
      if (mView!=null){
          mView=null;
      }
    }
}
