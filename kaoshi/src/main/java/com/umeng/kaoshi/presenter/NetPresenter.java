package com.umeng.kaoshi.presenter;

import com.umeng.kaoshi.NotCallBack;
import com.umeng.kaoshi.beans.Food;
import com.umeng.kaoshi.model.NetModel;
import com.umeng.kaoshi.view.NotView;

import java.util.List;

public class NetPresenter implements NotCallBack {
    private NotView mNotView;
    private NetModel mNetModel;

    public NetPresenter(NotView mNotView) {
        this.mNotView = mNotView;
        mNetModel=new NetModel();
    }

    public void getData(){
        mNetModel.getData(this);
    }



    @Override
    public void onSuesscess(Food food) {
        mNotView.setData(food);
    }

    @Override
    public void onFail(String str) {
        mNotView.shpwToast(str);
    }
}
