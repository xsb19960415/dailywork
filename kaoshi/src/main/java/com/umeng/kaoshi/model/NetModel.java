package com.umeng.kaoshi.model;

import com.umeng.kaoshi.ApiService;
import com.umeng.kaoshi.NotCallBack;
import com.umeng.kaoshi.beans.Food;
import com.umeng.kaoshi.presenter.NetPresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetModel {
    public void getData(final NotCallBack notCallBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<Food> data = apiService.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Food>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Food food) {
                        notCallBack.onSuesscess(food);
                    }

                    @Override
                    public void onError(Throwable e) {
                        notCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
