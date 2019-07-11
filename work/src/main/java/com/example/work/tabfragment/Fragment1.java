package com.example.work.tabfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.work.R;
import com.example.work.adapter.RlvMyAdapter;
import com.example.work.api.MyService;
import com.example.work.bean.ArtBean;
import com.example.work.bean.ListBean;
import com.example.work.utils.DbUtils;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements RlvMyAdapter.A {


    private View view;
    private RecyclerView mRe;
    private ArrayList<ArtBean.DataBean.DatasBean> list;
    private RlvMyAdapter adapter;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<ArtBean> art = retrofit.create(MyService.class).art();
        art.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArtBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArtBean artBean) {
                        if (artBean != null) {
                            list.addAll(artBean.getData().getDatas());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Fragment1", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mRe = (RecyclerView) inflate.findViewById(R.id.re);

        list = new ArrayList<>();
        adapter = new RlvMyAdapter(getActivity(), list);
        mRe.setAdapter(adapter);
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setA(this);
    }

    @Override
    public void onClick(int pos, ArtBean.DataBean.DatasBean bean) {
        ListBean listBean = new ListBean();
        listBean.setId(null);
        listBean.setTitle(bean.getTitle());
        listBean.setDesc(bean.getDesc());
        listBean.setEnvelopePic(bean.getEnvelopePic());
        DbUtils.getDbUtils().insert(listBean);
        Toast.makeText(getActivity(), "添加数据库成功", Toast.LENGTH_SHORT).show();
    }
}
