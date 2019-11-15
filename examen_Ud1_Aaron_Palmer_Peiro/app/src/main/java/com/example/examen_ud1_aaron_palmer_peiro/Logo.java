package com.example.examen_ud1_aaron_palmer_peiro;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

public class Logo extends Activity {
    private BitmapDrawable logo;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(new ViewVista(this));
    }
    public class ViewVista extends View {
        public ViewVista(Context context){
            super(context);
            Resources res=context.getResources();
            logo=(BitmapDrawable)res.getDrawable(R.drawable.pizzadepepperoni2);
            logo.setBounds(new Rect(30,50,200,200));

        }
        @Override
        protected void onDraw(Canvas canvas){
            logo.draw(canvas);
        }
    }
}
