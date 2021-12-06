package com.example.barberiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private  Insumos in = new Insumos();//instancio
    private Spinner insumos;
    private TextView result;
    private RatingBar estrella;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos= findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        estrella = findViewById(R.id.rt);


        //recibo los extras
        Bundle bun = getIntent().getExtras();//los guardos en bundle
        String[] listado = bun.getStringArray("insumos");

        ArrayAdapter adapInsumos= new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        insumos.setAdapter(adapInsumos);
    }

    public void Calcular(View view)
    {

        String opcion = insumos.getSelectedItem().toString();//obtener la seleccion
        int precio = 0;

        for(int i = 0; i <=10; i++)
        {
            if(opcion.equals(in.getInsumos()[i]))//segun el insumo seleccionado
            {
                //precio = in.getPrecios()[i]; //obtener los precios
                precio= in.anadirAdicional(in.getPrecios()[i],350);
                estrella.setRating(i+1);
                break;
            }

        }
        result.setText("la opcion es: "+opcion+" el precio es: "+precio);
    }


}