package com.example.barberiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Home_act extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoView = findViewById(R.id.vw);

        //obtengo la ruta

        String ruta = "android.resource://" + getPackageName()+"/"+ R.raw.barberiavideo;
        Uri uri = Uri.parse(ruta);//parseo la ruta
        videoView.setVideoURI(uri); //le paso la ruta a mi videoview

        //controles para el video.
        MediaController media = new MediaController(this);//controles para el video
        videoView.setMediaController(media);

    }


    public void Task(View view)
    {
        try{
            for(int i = 0; 1<= 10; i++)
            {
                Thread.sleep(2200);//duerme un proceso
            }

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public void MisInsumos(View view) {
        Intent i = new Intent(this, Insumos_act.class);
        startActivity(i);
    }


}