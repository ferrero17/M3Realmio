package com.example.dani.m3_realmio.ui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dani.m3_realmio.AdapterDatos;
import com.example.dani.m3_realmio.AdapterProfesores;
import com.example.dani.m3_realmio.R;
import com.example.dani.m3_realmio.crud.CRUDProfesor;
import com.example.dani.m3_realmio.model.Profesor;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity {


    //Pruebas para implementar RecyclerView

    ArrayList<String> listDatos;
    RecyclerView recycler;

    //RV de Profesores
    ArrayList<Profesor> profesorsList;
    RecyclerView recyclerProfesors;


    private EditText nombreEt, emailEt, idEt,ageEt,sexeEt, casatEt,materiaET;
    private Button saveBt, leerTodoBt, leerbyName, leerById, updateBt, deleteByIdBt, deleteAllBt;
    private Profesor profesor;
    private Realm realm;

    private TextView registroTv;

    //Declarem camp nou del ET
    private EditText cognomET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();

    }

    private void configView(){

        profesor = new Profesor();
        nombreEt = findViewById(R.id.mainActivityEtNombre);
        emailEt = findViewById(R.id.mainActivityEtEmail);
        idEt = findViewById(R.id.mainActivityEtID);
        ageEt = findViewById(R.id.mainActivityEtEdad);
        sexeEt = findViewById(R.id.mainActivityEtSexe);
        casatEt = findViewById(R.id.mainActivityEtCasado);
        materiaET = findViewById(R.id.mainActivityEtMateria);

        //Bindeiem el camp migrat amb el layout
        cognomET = findViewById(R.id.mainActivityEtApellido);


        saveBt = findViewById(R.id.mainActivityBtSave);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesor.setName(nombreEt.getText().toString());
                profesor.setEmail(emailEt.getText().toString());
                profesor.setAge(Integer.valueOf(ageEt.getText().toString()));
                profesor.setSexe(Integer.valueOf(sexeEt.getText().toString()));
                profesor.setCasat(casatEt.getText().toString());
                profesor.setSubject(materiaET.getText().toString());
                //seteig de la variable amb el que introdueix el usuari
                profesor.setSubject(cognomET.getText().toString());
                CRUDProfesor.addProfesor(profesor);
            }
        });

        leerTodoBt = findViewById(R.id.mainActivityBtReadAll);
        leerTodoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg ="";
                CRUDProfesor.getAllProfesor();
                RealmResults<Profesor> newList = (RealmResults<Profesor>) CRUDProfesor.getAllProfesor();
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                for (int i = 0; i < newList.size(); i++) {
                    //Afegim el nou camp cognom que s'ha de mostrar a partir de la nova versió
                    msg += (newList.get(i).getId()+" - "+ newList.get(i).getName()+ " " +newList.get(i).getCognom()+ " - " + newList.get(i).getEmail() + " - " + newList.get(i).getAge() + " - " + newList.get(i).getSexe() + newList.get(i).getSubject() +"\n");
                }
                dialog.setMessage(msg);
                dialog.setTitle("RESULTS: ");
                dialog.create();
                dialog.show();


            }
        });


        leerbyName = findViewById(R.id.mainActivityBtReadByName);
        leerbyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg ="";
                Profesor profe = new Profesor();
                CRUDProfesor.getProfesorByName(nombreEt.getText().toString());

                profe = CRUDProfesor.getProfesorByName(nombreEt.getText().toString());
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                    msg += (profe.getId()+" - "+ profe.getName()+" - "+ profe.getEmail() + "\n");

                dialog.setMessage(msg);
                dialog.setTitle("RESULTS: ");
                dialog.create();
                dialog.show();



            }
        });

        leerById = findViewById(R.id.mainActivityBtReadById);
        leerById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg ="";
                Profesor profe = new Profesor();
                CRUDProfesor.getProfesorById(Integer.parseInt(idEt.getText().toString()));

                profe = CRUDProfesor.getProfesorById(Integer.valueOf(idEt.getText().toString()));
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                if (profe != null){

                    msg += (profe.getId()+" - "+ profe.getName()+" - "+ profe.getEmail() + "\n");
                    dialog.setMessage(msg);
                    dialog.setTitle("RESULTS: ");
                    dialog.create();
                    dialog.show();

                }else{

                    dialog.setMessage("No hay coincidencias");
                    dialog.setTitle("RESULTS: ");
                    dialog.create();
                    dialog.show();

                }




            }
        });

        updateBt = findViewById(R.id.mainActivityUpdateById);
        updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.updateProfesorById(Integer.parseInt(idEt.getText().toString()), nombreEt.getText().toString());
            }
        });


        deleteByIdBt = findViewById(R.id.mainActivityDeleteById);
        deleteByIdBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.deleteProfesorById(Integer.parseInt(idEt.getText().toString()));
            }
        });


        deleteAllBt = findViewById(R.id.mainActivityDeleteAll);
        deleteAllBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CRUDProfesor.deleteAllProfesor();
            }
        });

    }



}
