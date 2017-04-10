package com.songdehuai.viewdata.base;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by songd on 2017/4/10.
 */

public class ViewData extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .name("ViewData")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
