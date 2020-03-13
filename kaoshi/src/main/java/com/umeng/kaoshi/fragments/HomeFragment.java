package com.umeng.kaoshi.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.umeng.kaoshi.R;
import com.umeng.kaoshi.adapters.HomeAdapter;
import com.umeng.kaoshi.beans.Food;
import com.umeng.kaoshi.presenter.NetPresenter;
import com.umeng.kaoshi.view.NotView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements NotView {
    private RecyclerView mRecycler;
    private ArrayList<Food.DataBeanX> dataBeanXES;
    private HomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.home_item, null);
        initView(inflate);
        NetPresenter netPresenter = new NetPresenter(this);
        netPresenter.getData();
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        dataBeanXES = new ArrayList<>();
        homeAdapter = new HomeAdapter(dataBeanXES, getActivity());
        mRecycler.setAdapter(homeAdapter);

    }

    @Override
    public void shpwToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(Food food) {
        Food.DataBeanX data = food.getData();
        dataBeanXES.add(data);
        homeAdapter.notifyDataSetChanged();
    }
}
