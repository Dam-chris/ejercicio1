package com.example.ejercicio1;

import android.widget.ImageView;
import android.widget.ProgressBar;

public class Progressandando implements Runnable
{
    private Asynctask_caballo miActividad = null;
    public Progressandando(Asynctask_caballo asyntask_caballo)
    {
        miActividad = asyntask_caballo;
    }
    @Override
    public void run()
    {
        int numFoto =0;
        ProgressBar barra=miActividad.getBarra();
        ImageView foto = miActividad.getImagenCentral();


        miActividad.getTexto().setText("0%");
        for (int i=0;i<100;i++)
        {

            try
            {
                Thread.sleep(100);
                miActividad.getTexto().setText(i + "%");
                if (numFoto >= 7)
                {
                    numFoto = 0;
                }
                else
                {
                    numFoto++;
                }
                barra.setProgress(i);
                foto.setImageResource(
                        miActividad.getImagenes().getResourceId(numFoto, -1)
                );
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        miActividad.finalizar();
    }
}
