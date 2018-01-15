package com.example.bwei.mycartinfo.view;

import com.example.bwei.mycartinfo.bean.CartShopBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by QinQinBaoBei on 2018/1/6.
 */

public interface IapiService {
    @GET("product/getCarts")
    Observable<CartShopBean> getNews(@Query("uid")String uid,@Query("source")String source);
}
