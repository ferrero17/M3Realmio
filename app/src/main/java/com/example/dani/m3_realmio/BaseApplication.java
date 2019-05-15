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
            .name("Professors")
            //Aquí introduim el número de la versió que s'actualitzará
            .schemaVersion(6)
            .migration(new Migration())
            //.deleteRealmIfMigrationNeeded()
            .build();

    Realm.setDefaultConfiguration(configuration);

}

}
