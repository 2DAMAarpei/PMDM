package com.example.seleccionsobredoslistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public ListView listaMain_Activity;
    public ListView listView;
    private String[] nombres;
    private Persona[] personas=new Persona[]{
            new Persona("Angeles","Campos",21),new Persona("Consuelo","Martin",20),new Persona("Fernando","Molina",26)

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombres=new String[personas.length];
        for(int i =0;i<personas.length;i++){
            nombres[i]=personas[i].getNombre();
        }
        listaMain_Activity=findViewById(R.id.LstPersonas);
        ArrayAdapter<String> miAdaptador = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nombres);
        listaMain_Activity.setAdapter(miAdaptador);
        listView=findViewById(R.id.LstDatos);
        listaMain_Activity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persona p=personas[position];
                final AdaptadorLista miAdaptador2 = new AdaptadorLista(MainActivity.this,new Persona[]{p});
                listView.setAdapter(miAdaptador2);
            }

        });

    }
    class AdaptadorLista extends ArrayAdapter<Persona> {
        Activity context;
        private Persona[] persona;
        AdaptadorLista(Activity context, Persona[] f){
            super(context,R.layout.lista,f);

            this.context=context;
            persona=f;
            System.out.println(persona[0].getNombre());
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position,convertView,parent);
            return vistaDesplegada;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater=context.getLayoutInflater();
            View item=inflater.inflate(R.layout.lista,null);

            TextView lblNombre= item.findViewById(R.id.campoNombre);
            TextView lblApellido= item.findViewById(R.id.campoApellido);
            TextView lblEdad= item.findViewById(R.id.campoEdad);

            lblNombre.setText(persona[0].getNombre());
            lblApellido.setText(persona[0].getApellido());
            lblEdad.setText(String.valueOf(persona[0].getEdad()));


            return (item);
        }

    }
}
