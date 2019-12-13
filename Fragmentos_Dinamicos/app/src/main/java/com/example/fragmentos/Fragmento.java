package com.example.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fragmento extends Fragment {
    int mNum;
    List<Integer> imagenes=new ArrayList<>(Arrays.asList(R.drawable.coche,R.drawable.coche2,R.drawable.coche3));

    static Fragmento newInstance(int number) {
        Fragmento f = new Fragmento();
        // Mantenemos el nÃºmero para usarlo en cualquier momento.
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        // obtenemos el nÃºmero que se habia pasado como argumento en
        // la creaciÃ³n de la instancia
        try{
            if(bundle.getInt("num")>0) {
                mNum = bundle.getInt("num");
                System.out.println(mNum);
            }
        }catch(Exception e){}


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = null;
        View tv;
        ImageView imgV;
        // dependiendo de si es par o impar mostramos distintos layouts
        if (mNum % 2 == 0){
            v = inflater.inflate(R.layout.fragment, container, false);
            tv = v.findViewById(R.id.text);
            System.out.println("PAR #########");


        }
        else{
            v = inflater.inflate(R.layout.fragment2 , container, false);
            tv = v.findViewById(R.id.text2);
            imgV=v.findViewById(R.id.image);
            imgV.setImageResource(randomInt());

        }

        ((TextView)tv).setText("Fragmento número #" + mNum);
        return v;
    }
    public int randomInt(){
        Random n=new Random();
        return imagenes.get(n.nextInt(imagenes.size()));
    }
}