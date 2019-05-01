package com.example.dani.m3_realmio;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;


public class BaseApplication extends Application {

@Override
    public void onCreate(){
    super.onCreate();
    Realm.init(this);
    RealmConfiguration configuration = new RealmConfiguration.Builder()
            .name(Realm.DEFAULT_REALM_NAME)
            .schemaVersion(0)
            .deleteRealmIfMigrationNeeded()
            .build();

    Realm.setDefaultConfiguration(configuration);
}

}