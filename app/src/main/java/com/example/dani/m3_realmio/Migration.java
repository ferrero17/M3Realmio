package com.example.dani.m3_realmio;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

class Migration implements RealmMigration {
    @Override
    public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();

        if (oldVersion == 0) {
            Log.d("Migration", "actualizando a la versión 1");
            RealmObjectSchema profesorSchema = schema.get("Profesor");
            profesorSchema.addField("age", String.class);
            oldVersion++;
        }


        if (oldVersion == 1) {
            Log.d("Migration", "actualizando a la versión 2");
            RealmObjectSchema profesorSchema = schema.get("Profesor");
            profesorSchema.addField("sexe", String.class);
            oldVersion++;


        }

        if (oldVersion == 2) {
            Log.d("Migration", "actualizando a la versión 3");
            RealmObjectSchema profesorSchema = schema.get("Profesor");
            profesorSchema.addField("casat", String.class);
            oldVersion++;

        }

        if (oldVersion == 3) {
            Log.d("Migration", "actualizando a la versión 4");
            schema.get("Profesor").addField("sexo", int.class).transform(new RealmObjectSchema.Function() {
                @Override
                public void apply(DynamicRealmObject obj) {
                }
            })
                    .removeField("sexe")
                    .renameField("sexo", "sexe");
            oldVersion++;

        }


        if (oldVersion == 4){
            Log.d("Migration", "actualizando a la versión 5");
            RealmObjectSchema profesorSchema = schema.get("Professors");

           schema.get("Profesor")
                    .addField("subject", String.class)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {

                        }
                    });
            oldVersion++;

        }

        //Nova migració a la versió6
        if (oldVersion == 5){
            //Això indicarà per consola que la migració s'ha realitzat
            Log.d("Migration", "actualizando a la versión 6");
            RealmObjectSchema profesorSchema = schema.get("Professors");
            schema.get("Profesor")
                    .addField("cognom", String.class)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {

                        }
                    });
            oldVersion++;

        }
    }
}
