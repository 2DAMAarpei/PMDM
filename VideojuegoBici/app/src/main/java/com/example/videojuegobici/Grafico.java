package com.example.videojuegobici;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
    private Drawable drawable;
    private double posX, posY;
    private double incX, incY;
    private int angulo, rotacion, ancho, alto, radioColision;
    private View view;
    public static final int MAX_VELOCIDAD=20;

    public Grafico(View view, Drawable drawable){
        this.view=view;
        this.drawable=drawable;
        alto=drawable.getIntrinsicHeight();
        ancho=drawable.getIntrinsicWidth();
        radioColision=(alto+ancho);
    }

    public void dibujaGrafico(Canvas canvas){
        canvas.save();
        int x=(int)(posY+ancho/2);
        int y=(int)(posX+alto/2);
        canvas.rotate((float)angulo,(float)x,(float)y);
        drawable.setBounds((int)posX,(int)posY,(int)posX+ancho,(int)posY+alto);
        drawable.draw(canvas);
        canvas.restore();
        int rInval=(int)distanciaE(0,0,ancho,alto)/2+MAX_VELOCIDAD;
        view.invalidate(x-rInval,y-rInval,x+rInval,y+rInval);
    }
    public void incrementPos(){

    }
    public double distancia(Grafico g){
        return distanciaE(posX,posY,g.posX,g.posY);
    }
    public boolean vereficaColision(Grafico g){
        return (distancia(g) < (radioColision+g.radioColision));
    }
    public static double distanciaE(double x,double y, double x2, double y2){
        return Math.sqrt((x-x2)*(x-x2)+(y-y2)*(y-y2));
    }
}
