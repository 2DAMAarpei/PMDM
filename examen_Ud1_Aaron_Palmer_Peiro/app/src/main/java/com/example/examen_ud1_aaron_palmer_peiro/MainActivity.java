package com.example.examen_ud1_aaron_palmer_peiro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*
    * Falta Implementar Boton Menu Acerca De
    * Se Actualice el Precio Al Selecionnar Las Cosas en e editText con Texto $$$$$
    * Se muestre la hora al cambiar de activity
    * La imagen del boton que muestra el logo es muy pequeña
    * */

    Spinner carta_pizzas;
    public static Pizza[] pizzas=new Pizza[]{
            new Pizza("Peperoni","Queso/Peperoni/tomate",10f,0),new Pizza("Cuatro Queso","Queso",12.5f,0),
            new Pizza("Margarita","Queso/Peperoni/tomate",8.5f,0),new Pizza("Peperoni","Queso/Peperoni/tomate",13.75f,0)

    };
    int imagenes[]=new int[]{R.drawable.pizza1,R.drawable.pizza2,R.drawable.pizza3,R.drawable.pizza4,R.drawable.pizza5,R.drawable.pizza6,
            R.drawable.pizza7,R.drawable.pizza8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button total_pedido=findViewById(R.id.button);
        carta_pizzas=findViewById(R.id.spinner_carta);
        for(int i=0;i<pizzas.length;i++){
            pizzas[i].setImagen(imagenes[new Random().nextInt(imagenes.length)]);
        }
        AdaptadorPizzas adaptadorPizzas = new AdaptadorPizzas(this);
        carta_pizzas.setAdapter(adaptadorPizzas);

        carta_pizzas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });

        total_pedido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Pizza pizzaFactura=pizzas[carta_pizzas.getSelectedItemPosition()];
                    int datosfactura[]=getDatosFactura();
                    Factura factura=new Factura(datosfactura[1],datosfactura[0],datosfactura[2],pizzaFactura);
                    Intent intentIncial = new Intent(MainActivity.this,PantallaFactura.class);
                    Bundle datos= new Bundle();
                    datos.putSerializable("factura",factura);
                    intentIncial.putExtras(datos);
                    startActivityForResult(intentIncial,1);
                }
            }
        );

        final EditText resultado=findViewById(R.id.editText);

/*        resultado.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                int datos[]=getDatosFactura();
                if(datos[2]==10){
                    resultado.setText(String.valueOf((pizzas[carta_pizzas.getSelectedItemPosition()].getPrecio()+datos[1])*datos[0]*1.1));
                }else{
                    resultado.setText(String.valueOf((pizzas[carta_pizzas.getSelectedItemPosition()].getPrecio()+datos[1])*datos[0]*1));

                }
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.MnuOpc1){
            Intent intentIncial = new Intent(MainActivity.this,Logo.class);
            startActivity(intentIncial);
        }
        return true;
    }


    public int[] getDatosFactura(){
        int extras[]=new int[4];
        CheckBox[] checkBoxes=new CheckBox[]{findViewById(R.id.checkBox),findViewById(R.id.checkBox2),findViewById(R.id.checkBox3)};
        RadioButton[] radioButtons=new RadioButton[]{findViewById(R.id.radioButton),findViewById(R.id.radioButton2)};
        EditText unidades=findViewById(R.id.editText);
        int total_unidades=Integer.parseInt(unidades.getText().toString());
        extras[0]=total_unidades;
        for(int i=0;i<checkBoxes.length;i++){
            if(checkBoxes[i].isChecked()){
                extras[1]+=1;
            }
        }
        if(radioButtons[1].isChecked()){
            extras[2]+=10;
        }
        return  extras;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("hora");
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            }
        }
        for(int i=0;i<pizzas.length;i++){
            pizzas[i].setImagen(imagenes[new Random().nextInt(imagenes.length)]);
        }
    }

    class AdaptadorPizzas extends ArrayAdapter<Pizza> {
        public Activity miActividad;

        public AdaptadorPizzas(Activity laActividad){
            super(laActividad,R.layout.estructura_pizza,pizzas);
            this.miActividad=laActividad;

        }
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int position,View convertView, ViewGroup Parent){
            LayoutInflater inflater=miActividad.getLayoutInflater();
            View item = inflater.inflate(R.layout.estructura_pizza,null);

            TextView lblNombre= item.findViewById(R.id.campoNombre);
            TextView lblDescripcion= item.findViewById(R.id.campoDescripción);
            TextView lblPrecio= item.findViewById(R.id.campoPrecio);
            ImageView pizzaView=item.findViewById(R.id.fotoPizza);
            lblNombre.setText(pizzas[position].getNombre());
            lblDescripcion.setText(pizzas[position].getDescripcion());
            lblPrecio.setText(String.valueOf(pizzas[position].getPrecio()));
            pizzaView.setImageResource(pizzas[position].getImagen());
            return item;
        }

    }
}
