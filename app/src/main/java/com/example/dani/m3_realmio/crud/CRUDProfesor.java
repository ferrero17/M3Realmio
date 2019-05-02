package com.example.dani.m3_realmio.crud;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.example.dani.m3_realmio.model.Profesor;
import com.example.dani.m3_realmio.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class CRUDProfesor {

    private final static int calculateIndex(){

        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Profesor.class).max("id");
        int nextId;
        if (currentIdNum == null){
            nextId = 0;
        }else {
            nextId = currentIdNum.intValue()+1;
        }
            return nextId;

    }

    public final static void addProfesor(final Profesor profesor){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CRUDProfesor.calculateIndex();
                Profesor realmProfesor = realm.createObject(Profesor.class, index);
                realmProfesor.setName(profesor.getName());
                realmProfesor.setEmail(profesor.getEmail());
            }
        });
    }


     public final static List<Profesor> getAllProfesor(){

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();

        for(Profesor profesor: profesors){
            Log.d("TAG", "id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());

        }

         return profesors;

     }

     public final static Profesor getProfesorByName(String name){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("name", name).findFirst();
        if (profesor != null){
            Log.d("TAG", "id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }else {
            Log.d("TAG", "No se han encontrado coincidencias");
        }

        return  profesor;
     }

     public final static Profesor getProfesorById(int id){
         Realm realm = Realm.getDefaultInstance();
         Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
         if (profesor != null){
             Log.d("TAG", "id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
         }else {
             Log.d("TAG", "No se han encontrado coincidencias");
         }

         return  profesor;

     }

     public final static void updateProfesorById(int id, String nom){

        EditText etId;

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();

        profesor.setName(nom); //Añadir ET para que se modifique desde el
        realm.insertOrUpdate(profesor);
        realm.commitTransaction();
         if (profesor != null){
             Log.d("TAG", "id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
         }else {
             Log.d("TAG", "No se han encontrado coincidencias");
         }

     }


     public final static void deleteProfesorById(int id){

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
        profesor.deleteFromRealm();
        realm.commitTransaction();


     }


     public final static void deleteAllProfesor(){

         Realm realm = Realm.getDefaultInstance();
         realm.beginTransaction();
         RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();
         realm.deleteAll();
         realm.commitTransaction();

     }


}
