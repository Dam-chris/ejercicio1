package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Asynctask_caballo extends AppCompatActivity
{
    private ProgressBar barra = null;
    private ImageView imagenCentral = null;
    private TextView texto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_caballo);

        Bundle  bundle = getIntent().getExtras();
        if (!bundle.isEmpty())
        {
            Toast.makeText(getApplicationContext(),
                    bundle.getString("holaa"),Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.activity_asynctask_caballo);
        barra = findViewById(R.id.pbAnimacion);
        imagenCentral = findViewById(R.id.ivAnimacion);
        texto = findViewById(R.id.tvAnimacion);
        //cargamos el array de fotos
        imagenes = getResources().obtainTypedArray(R.array.imagenes);

        //inicializar la barra
        barra.setMax(100);
        barra.setProgress(0);
        barra.setBackgroundColor(Color.GRAY);

        //generar el hilo

        Progressandando hilo = new Progressandando(this);

        //Ejecucion de hilo
        ThreadExecutor executor = new ThreadExecutor();
        executor.execute(hilo);


    }
    public void finalizar()
    {
        //aqui llegara cuando termine el bucle
        finish();
    }
    //getters
    private TypedArray imagenes = null;

    public TypedArray getImagenes()
    {
        return imagenes;
    }

    public ProgressBar getBarra()
    {
        return barra;
    }

    public ImageView getImagenCentral()
    {
        return imagenCentral;
    }

    public TextView getTexto()
    {
        return texto;
    }
}
