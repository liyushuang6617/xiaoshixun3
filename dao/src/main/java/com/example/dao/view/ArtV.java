package com.example.dao.view;

import com.example.dao.bean.ArtBean;

public interface ArtV {

    void onSuccess(ArtBean artBean);

    void onFail(String msg);
}
