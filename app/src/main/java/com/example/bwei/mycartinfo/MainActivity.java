package com.example.bwei.mycartinfo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bwei.mycartinfo.adapter.MyAdapter;
import com.example.bwei.mycartinfo.bean.CartShopBean;
import com.example.bwei.mycartinfo.presenter.MyPresenter;
import com.example.bwei.mycartinfo.view.PresenterListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements PresenterListener {

    @BindView(R.id.expandView)
    ExpandableListView expandView;
    @BindView(R.id.checkAll)
    CheckBox mCheckAll;
    @BindView(R.id.zprice)
    TextView mZprice;
    @BindView(R.id.zcount)
    Button mZcount;
    @BindView(R.id.linear)
    RelativeLayout mLinear;
    @BindView(R.id.bianji)
    TextView mBianji;
    private MyAdapter myAdapter;
    private String edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.getData("1701");


    }

    @OnClick({R.id.checkAll, R.id.bianji,R.id.zcount})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.checkAll:
                myAdapter.checkedAll(mCheckAll.isChecked());
                break;

            case R.id.bianji:

                break;
            case R.id.zcount:


                break;
        }
    }

    @Override
    public void success(List<CartShopBean.DataBean> group, List<List<CartShopBean.DataBean.ListBean>> child) {
        myAdapter = new MyAdapter(MainActivity.this, group, child);
        myAdapter.setChangeListener(new MyAdapter.ChangeListener() {
            @Override
            public void setState(boolean flag) {

                mCheckAll.setChecked(flag);
            }

            @Override
            public void setText(String price, String count) {

                    mZcount.setText("结算(" + count + ")");
                    mZprice.setText("总计:" + price + "¥");

            }
        });
        expandView.setAdapter(myAdapter);

        //默认展开
        for (int i = 0; i < group.size(); i++) {
            expandView.expandGroup(i);
        }
    }
}