package com.example.dani.m3_realmio.ui;

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

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {


    //Pruebas para implementar RecyclerView

    ArrayList<String> listDatos;
    RecyclerView recycler;

    //RV de Profesores
    ArrayList<Profesor> profesorsList;
    RecyclerView recyclerProfesors;


    private EditText nombreEt, emailEt, idEt;
    private Button saveBt, leerTodoBt, leerbyName, leerById, updateBt, deleteByIdBt, deleteAllBt;
    private Profesor profesor;
    private Realm realm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        configView();

        recyclerProfesors = (RecyclerView) findViewById(R.id.recyclerId);
        recyclerProfesors.setLayoutManager(new LinearLayoutManager(this));
        profesorsList = new ArrayList<>();

        for (int i = 0; i < profesorsList.size(); i++) {

            profesorsList.add(profesor);

        }

        AdapterProfesores adapterProfesores = new AdapterProfesores(profesorsList);
        recyclerProfesors.setAdapter(adapterProfesores);



       /* recycler = (RecyclerView) findViewById(R.id.recyclerId);
       recycler.setLayoutManager(new LinearLayoutManager(this));
        listDatos = new ArrayList<>();


        for (int i = 0; i <50 ; i++) {
           listDatos.add("Dato # "+ i+ " ");
        }

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);
*/
    }

    private void configView(){

        profesor = new Profesor();
        nombreEt = findViewById(R.id.mainActivityEtNombre);
        emailEt = findViewById(R.id.mainActivityEtEmail);
        idEt = findViewById(R.id.mainActivityEtID);

        saveBt = findViewById(R.id.mainActivityBtSave);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesor.setName(nombreEt.getText().toString());
                profesor.setEmail(emailEt.getText().toString());
                CRUDProfesor.addProfesor(profesor);
            }
        });

        leerTodoBt = findViewById(R.id.mainActivityBtReadAll);
        leerTodoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getAllProfesor();
            }
        });


        leerbyName = findViewById(R.id.mainActivityBtReadByName);
        leerbyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getProfesorByName(nombreEt.getText().toString());
            }
        });

        leerById = findViewById(R.id.mainActivityBtReadById);
        leerById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getProfesorById(Integer.parseInt(nombreEt.getText().toString()));
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
