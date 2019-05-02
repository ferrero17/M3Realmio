package com.example.dani.m3_realmio;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dani.m3_realmio.model.Profesor;

import java.util.ArrayList;

public class AdapterProfesores extends RecyclerView.Adapter<AdapterProfesores.ViewHolderProfesores> {


    ArrayList<Profesor> listaProfesores;

    public AdapterProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    @NonNull
    @Override
    public ViewHolderProfesores onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_profesor,null,false);


        return new ViewHolderProfesores(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProfesores viewHolderProfesores, int i) {

        viewHolderProfesores.asignarProfesores(listaProfesores.get(i));


    }

    @Override
    public int getItemCount() {
        return listaProfesores.size();
    }

    public class ViewHolderProfesores extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        TextView email;


        public ViewHolderProfesores(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.idProfesorTv);
            name = (TextView) itemView.findViewById(R.id.nomProfesorTv);
            email = (TextView) itemView.findViewById(R.id.emailProfesorTv);


        }

        public void asignarProfesores(Profesor profesor) {

            id.setText(profesor.getId());
            name.setText(profesor.getName());
            email.setText(profesor.getEmail());


        }
    }
}
