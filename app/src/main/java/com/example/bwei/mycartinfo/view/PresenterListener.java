package com.example.bwei.mycartinfo.view;

import com.example.bwei.mycartinfo.bean.CartShopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QinQinBaoBei on 2018/1/6.
 */

public interface PresenterListener {

    void success(List<CartShopBean.DataBean> group,List<List<CartShopBean.DataBean.ListBean>> child);

}
