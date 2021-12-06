package com.example.barberiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.security.PrivateKey;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {


    private EditText user, pass;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador(); // instacio el obj administrador
    private Insumos in = new Insumos();//instacio el obj

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btn);

        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aqui la tarea asincrona

                new Task().execute();
            }
        });
    }

    // tarea asincrona
    class Task extends AsyncTask<String, Void, String> {
        //definir la configuracion incial
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        //correo el procreso en segundo plano
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        //finaliza mi tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            {
                String usuario = user.getText().toString().trim();
                String contrasena = pass.getText().toString().trim();

                String userObj = adm.getUser().trim();
                String userPass = adm.getPass().trim();

                switch (usuario) {
                    case "Edison":
                        if (usuario.equals(userObj) && contrasena.equals(userPass)) {
                            msj.setVisibility(View.INVISIBLE);
                            //inicio sesion
                            Intent i = new Intent(getBaseContext(), Home_act.class);

                            //preparo los extras
                            Bundle bun = new Bundle();//necesario para enviar arreglos.
                            bun.putStringArray("insumos", in.getInsumos());//preparo mi bundle.
                            i.putExtras(bun);//Envio el paquete a traves del intent.
                            startActivity(i);
                        }
                        break;
                    case "":
                        if (usuario.equals("") && contrasena.equals("")) {
                            //Campos vacios

                            msj.setVisibility(View.VISIBLE);
                            msj.setText("los campos estan vacios");

                        }
                        break;
                    default:
                        if (!usuario.equals(userObj) && !contrasena.equals(userPass)) {
                            //campos incorrectos
                            msj.setVisibility(View.VISIBLE);
                            msj.setText("los campos estan incorrectos");
                        }

                        break;

                }
                barra.setVisibility(View.INVISIBLE);
            }
        }

    }
    public void Info(View view) {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Facebook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);//accion que abre un sitio web
        i.setData(Uri.parse("https://www.facebook.com"));//le paso mi direccion
        startActivity(i);
    }

    public void Youtube(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);//accion que abre un sitio web
        i.setData(Uri.parse("https://www.youtube.com"));//le paso mi direccion
        startActivity(i);
    }

    public void Twitter(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);//accion que abre un sitio web
        i.setData(Uri.parse("https://www.twitter.com"));//le paso mi direccion
        startActivity(i);
    }

}