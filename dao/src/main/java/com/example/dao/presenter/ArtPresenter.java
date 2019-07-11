package com.example.dao.presenter;

import com.example.dao.bean.ArtBean;
import com.example.dao.callback.ArtCallBack;
import com.example.dao.model.ArtM;
import com.example.dao.view.ArtV;

public class ArtPresenter implements ArtP, ArtCallBack {

    private ArtM artM;
    private ArtV artV;

    public ArtPresenter(ArtM artM, ArtV artV) {
        this.artM = artM;
        this.artV = artV;
    }

    @Override
    public void getData() {
        if(artM!=null){
            artM.getData(this);
        }
    }

    @Override
    public void onSuccess(ArtBean artBean) {
        artV.onSuccess(artBean);
    }

    @Override
    public void onFail(String msg) {
        artV.onFail(msg);
    }
}
