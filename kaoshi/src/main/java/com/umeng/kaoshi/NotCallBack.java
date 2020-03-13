package com.umeng.kaoshi;

import com.umeng.kaoshi.beans.Food;

import java.util.List;

public interface NotCallBack {
    void onSuesscess(Food food);
    void onFail(String str);
}
