package com.example.dani.m3_realmio;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<String> listDatosR;

    public AdapterDatos(ArrayList<String> listDatos) {
        this.listDatosR = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null, false);


        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {

        viewHolderDatos.asignarDatos(listDatosR.get(i));

    }

    @Override
    public int getItemCount() {
        return listDatosR.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView dato;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {

            dato.setText(datos);

        }
    }
}
