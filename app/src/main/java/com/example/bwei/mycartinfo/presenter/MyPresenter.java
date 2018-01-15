package com.example.bwei.mycartinfo.presenter;

import com.example.bwei.mycartinfo.bean.CartShopBean;
import com.example.bwei.mycartinfo.model.MyModule;
import com.example.bwei.mycartinfo.view.ModelListener;
import com.example.bwei.mycartinfo.view.PresenterListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QinQinBaoBei on 2018/1/6.
 */

public class MyPresenter {

    PresenterListener presenterListener;
    private final MyModule myModule;

    public MyPresenter(PresenterListener presenterListener) {
        this.presenterListener = presenterListener;
        myModule = new MyModule();
    }

    public void getData(String uid){
        myModule.getData(uid, new ModelListener() {
            @Override
            public void success(CartShopBean cartShopBean) {
                List<CartShopBean.DataBean> group = cartShopBean.getData();
                List<List<CartShopBean.DataBean.ListBean>> child = new ArrayList<>();
                for (int i=0;i<group.size();i++){
                    List<CartShopBean.DataBean.ListBean> list = group.get(i).getList();
                    child.add(list);
                }
                if(presenterListener!=null){
                    presenterListener.success(group,child);
                }
            }
        });
    }
    public void detach(){
        presenterListener=null;
    }

}
