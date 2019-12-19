package com.example.examen_ud1_version_mejorada;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeleccionActivity extends AppCompatActivity {
    private List<Vehiculo> vehiculos;
    private float precioVehiculo=0.0f;
    private int idImg=0;
    private String modelo;
    private RecyclerView recyclerViewVehiculos;
    private RadioGroup rGSeguro;
    private CheckBox cBCasco,cBGPS,cBExtras;
    private EditText eTCantidad;
    private TextView tVTotalPRecio;
    private Factura factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        rGSeguro=findViewById(R.id.rGSeguro);
        cBCasco=findViewById(R.id.checkBoxGuantes);
        cBGPS=findViewById(R.id.checkBoxGPS);
        cBExtras=findViewById(R.id.checkBoxExtras);
        eTCantidad=findViewById(R.id.edTCantidad);
        tVTotalPRecio=findViewById(R.id.edTtotalPrecio);
        recyclerViewVehiculos=findViewById(R.id.rvVehiculo);
        rGSeguro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setPrice();
            }

        });
        cBCasco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrice();
            }

        });
        cBExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrice();
            }

        });

        cBGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrice();
            }

        });
        eTCantidad.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if(eTCantidad.getText().toString().length()!=0)
                    setPrice();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!TextUtils.isDigitsOnly(eTCantidad.getText()) && eTCantidad.getText().toString().length()!=0){
                        eTCantidad.setText("1");
                }
            }
        });


        String tipoVehiculo=getIntent().getExtras().getString("vehiculo");
        String[] precios=new String[]{"15","20","25"};
        String[] tipos= new String[]{"Montaña","Paseo","Ciudad"};
        Map<String, String[]> modelos_Vehiculos=new HashMap<String, String[]>() {{
            put("coche", new String[]{"Todoterreno","Sport","Ciudad"});
            put("bicicleta", new String[]{"BMX","Carretera","Ciudad"});
            put("patinete", new String[]{"Sport","Carretera","Urban"});
        }};
        Vehiculo vehiculo;
        vehiculos=new ArrayList<Vehiculo>();
        for(int i=0;i<tipos.length;i++){
            String pictureName=tipoVehiculo+(i+1);
            int imagen=getResources().getIdentifier(pictureName, "drawable", getPackageName());
            vehiculo=new Vehiculo(tipos[i],modelos_Vehiculos.get(tipoVehiculo)[i],precios[i],imagen);
            vehiculos.add(vehiculo);
        }

        //Se debe poner si el recycled view va a tener un tamaño fijo para mejorar la perfomance
        recyclerViewVehiculos.setHasFixedSize(true);

        recyclerViewVehiculos.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(vehiculos);
        recyclerViewVehiculos.setAdapter(adapter);

        Button buttonFactura=findViewById(R.id.btnFactura);
        buttonFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idImg!=0){
                    Intent seleccionIntent=new Intent(SeleccionActivity.this,FacturaActivity.class);
                    Bundle datos= new Bundle();
                    datos.putSerializable("factura",factura);
                    seleccionIntent.putExtras(datos);
                    startActivity(seleccionIntent);
                }

            }
        });
    }

    private void setPrice(){
        float totalExtras=0.0f;
        float costeTotal=0.0f;
        String cantidad="0";
        String seguro="0";
        if(eTCantidad.getText().toString().equals("Cantidad"))
            eTCantidad.setText("1");
        if(cBCasco.isChecked()) {
            costeTotal += 4.5f;
            totalExtras+=4.5f;
        }

        if(cBGPS.isChecked()) {
            costeTotal += 3.0f;
            totalExtras+=3.0f;
        }
        if(cBExtras.isChecked()) {
            costeTotal += 6.5f;
            totalExtras+=6.5f;
        }

        if(eTCantidad.getText().toString().length()!=0) {
            costeTotal += Integer.parseInt(eTCantidad.getText().toString()) * precioVehiculo;
            cantidad=eTCantidad.getText().toString();
        }
        else
            costeTotal+=1*precioVehiculo;
        if(rGSeguro.getCheckedRadioButtonId()==R.id.radioButtonSeguro) {
            costeTotal += costeTotal * 0.2f;
            seguro=Float.toString(costeTotal*0.2f);
        }

        tVTotalPRecio.setText(Float.toString(costeTotal));
        factura=new Factura(idImg,modelo,Float.toString(precioVehiculo),Float.toString(totalExtras),cantidad,Float.toString(costeTotal),seguro);
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private List<Vehiculo> vehiculos;

        public RecyclerViewAdapter(List<Vehiculo> vehiculos) {
            this.vehiculos = vehiculos;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_content, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = recyclerViewVehiculos.getChildLayoutPosition(v);
                    precioVehiculo= Float.parseFloat(vehiculos.get(itemPosition).getPrecio());
                    idImg=vehiculos.get(itemPosition).getImagen();
                    modelo=vehiculos.get(itemPosition).getModelo();
                    setPrice();
                }

            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.modelo.setText(vehiculos.get(position).getModelo());
            holder.imagen.setImageResource(vehiculos.get(position).getImagen());
            holder.precio.setText(vehiculos.get(position).getPrecio());
            holder.tipo.setText(vehiculos.get(position).getTipo());

        }

        @Override
        public int getItemCount() {
            return this.vehiculos.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tipo;
            private TextView modelo;
            private TextView precio;
            private ImageView imagen;

            public ViewHolder(View v) {
                super(v);
                tipo = v.findViewById(R.id.tVTipo);
                modelo = v.findViewById(R.id.tVModelo);
                precio = v.findViewById(R.id.tVPrecio);
                imagen= v.findViewById(R.id.imageViewModeloSeleccion);

            }
        }

    }
}
