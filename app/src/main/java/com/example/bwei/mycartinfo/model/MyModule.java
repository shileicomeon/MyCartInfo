package com.example.bwei.mycartinfo.model;

import com.example.bwei.mycartinfo.bean.CartShopBean;
import com.example.bwei.mycartinfo.retrofit.RetrofitUtils;
import com.example.bwei.mycartinfo.view.IapiService;
import com.example.bwei.mycartinfo.view.ModelListener;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by QinQinBaoBei on 2018/1/6.
 */

public class MyModule {

    public void getData(String uid, final ModelListener modelListener){
        Retrofit retrofit = RetrofitUtils.getInstance().getRetrofit();

        IapiService iapiService = retrofit.create(IapiService.class);

        Observable<CartShopBean> observable = iapiService.getNews(uid,"android");
         observable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<CartShopBean>() {
                     @Override
                     public void accept(CartShopBean cartShopBean) throws Exception {
                             if(modelListener!=null){
                                 modelListener.success(cartShopBean);
                             }
                     }
                 });
    }
}
