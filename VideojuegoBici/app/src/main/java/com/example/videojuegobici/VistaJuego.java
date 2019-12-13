package com.example.videojuegobici;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import java.util.Vector;

public class VistaJuego {
    //Coche
    private Vector<Grafico> Coches;
    private int numCoches=5;
    private int numMotos=3;

    //Bici
    private Grafico bici;
    private int giroBici;
    private float aceleracionBici;
    private static final int PASO_GIRO_BICI=5;
    private static final float PASO_ACELERACION_BICI=0.5f;

    //THREAD Y TIEMPO
    private HiloJuego hiloJuego;
    private static int PERIODO_PROCESO=50;
    private long ultimoProceso=0;

    public VistaJuego(Context contexto, AttributeSet atributos){
        super(contexto,atributos);
        Drawable graficoBici,graficoCoche, graficoRueda;
        graficoCoche=contexto.getResources().getDrawable(R.drawable.coche);
        Coches=new Vector<Grafico>();

        for(int i= 0;i<numCoches; i++){
            Grafico coche=new Grafico(this,graficoCoche);
            coche.setIncX(Math.random()*4-2);
            coche.setIncY(Math.random()*4-2);
            coche.setAngulo((int)(Math.random()*360));
            coche.setRotacion((int)(Math.random()*8-4));
            Coches.add(coche);
        }
        graficoBici=contexto.getResources().getDrawable(R.drawable.moto);
        bici=new Grafico(this,graficoBici);
    }
    @Override
    protected void onSizeChanged(int w,int h, int oldw,int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        for(Grafico coche:Coches){
            do{
                coche.setPosX(Math.random()*(w-coche.getAncho()));
                coche.setPosY(Math.random()*(h-coche.getAlto()));
            }while(coche.distancia(bici)<(w+h)/5);
        }
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(Grafico coche:Coches){
            coche.dibujaGrafico(canvas);
        }
    }

}
