package com.example.fragmentosdiversos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fragmento extends Fragment {
    int mNum;
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
        try{
            if(bundle.getInt("num")>0) {
                mNum = bundle.getInt("num");
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
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            tv = v.findViewById(R.id.text);

        }
        else{
            v = inflater.inflate(R.layout.fragment_simple2 , container, false);
            tv = v.findViewById(R.id.text2);

        }

        ((TextView)tv).setText("Fragmento número #" + mNum);
        return v;
    }

}