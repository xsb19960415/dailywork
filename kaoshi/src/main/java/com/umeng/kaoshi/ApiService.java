package com.umeng.kaoshi;

import com.umeng.kaoshi.beans.Food;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String BASE_URL="https://cdwan.cn/api/";
    @GET("topic/list")
    Observable<Food> getData();
}
