package com.example.fragment_spinner_persona;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragmento extends Fragment {
    Persona persona;
    static Fragmento newInstance(Persona persona) {
        Fragmento f = new Fragmento();
        Bundle args = new Bundle();
        args.putSerializable("persona", persona);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        try{
            persona = (Persona)bundle.getSerializable("persona");
        }catch(Exception e){}


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = null;
        View tVNombre, tVApellidos,tVTrabajos,tVEstudios,tVEdad,imgVFoto;

        v = inflater.inflate(R.layout.fragment_persona, container, false);

        tVNombre = v.findViewById(R.id.tVNombre);
        tVApellidos = v.findViewById(R.id.tVApellidos);
        tVEdad = v.findViewById(R.id.tVEdad);
        tVTrabajos = v.findViewById(R.id.tVTrabajos);
        tVEstudios = v.findViewById(R.id.tVEstudios);
        imgVFoto =v.findViewById(R.id.imgVPersona);

        ((TextView)tVNombre).setText(persona.getNombre());
        ((TextView)tVApellidos).setText(persona.getApellido());
        ((TextView)tVEdad).setText(String.valueOf(persona.getEdad()));
        ((TextView)tVTrabajos).setText(persona.getTrabajos());
        ((TextView)tVEstudios).setText(persona.getEstudios());
        ((ImageView)imgVFoto).setImageResource(persona.getFoto());

        return v;
    }

}