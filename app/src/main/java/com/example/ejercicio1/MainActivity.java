package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnToast = findViewById(R.id.btnNuevo);

        final int duracion= Toast.LENGTH_SHORT;
        LayoutInflater inflater=getLayoutInflater();

        //layaout para mostrar una imegen de toast con texto
        final View miToast=inflater.inflate(R.layout.toast_perl,(ViewGroup)
                findViewById(R.id.layoutToast));
        final Toast toast=new Toast(getApplicationContext());
        //modificamos la foto del toast
        ImageView fotoToast= miToast.findViewById(R.id.ivToast);
        fotoToast.setImageResource(R.drawable.prueba_toast);
        //accion del boton
       btnToast.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //texto anterior a la imagen
               /* Toast.makeText(getApplicationContext(),
                        "pepe", Toast.LENGTH_SHORT).show();*/
                //para la imagen
                toast.setView(miToast);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.setDuration(duracion);
                toast.show();
            }
        });
        /// enlace con asyntask
        ImageButton btnAsyntask=findViewById(R.id.btnCaballo);
        btnAsyntask.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Bundle bundle=new Bundle();
                bundle.putString("saludo","Hola Curso Dam");
                Intent intent=
                        new Intent(getApplicationContext(), Asynctask_caballo.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}