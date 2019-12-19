package com.example.examen_ud1_version_mejorada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/*EN este ejercicio uso RecyclerView el cual debe implmentarse en el archivo build.gradle
en el apartado 'dependencies' --> implementation 'androidx.recyclerview:recyclerview:1.0.0'*/

public class MainActivity extends AppCompatActivity {
    static int imgIconos[] = {R.drawable.bicicleta_icono,R.drawable.patinete_icono,R.drawable.coche_icono};
    private int[] imageViewsIcons;
    private String vehiculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewsIcons=new int[]{R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView7};

        for(int i = 0; i <imageViewsIcons.length;i++){
            int idImagen=imgIconos[randomInt()];
            ImageView imgV=(ImageView) findViewById(imageViewsIcons[i]);
            imgV.setImageResource(idImagen);
            imgV.setOnClickListener(new MiEleccion());
            imgV.setTag(idImagen);
        }

        Button buttonContinuar=findViewById(R.id.btnContinuar);
        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vehiculo!=null){
                    Intent seleccionIntent=new Intent(MainActivity.this,SeleccionActivity.class);
                    Bundle datos= new Bundle();
                    datos.putString("vehiculo",vehiculo);
                    seleccionIntent.putExtras(datos);
                    System.out.println(datos.getString("vehiculo"));
                    startActivity(seleccionIntent);
                }

            }
        });
    }
    class MiEleccion implements View.OnClickListener{
        @Override
        public void onClick(View v){
            ImageView iv = (ImageView) v;
            String opTxt="ALQUILER DE ";

            ImageView imgResul=findViewById(R.id.imageViewSeleccion);
            imgResul.setImageDrawable(iv.getDrawable());

            //Recoge el nombre de la imagen, la imagen debe nombrarse con una barra baja, ejemplo: bicleta_icono
            vehiculo=getResources().getResourceEntryName(Integer.parseInt(iv.getTag().toString())).substring(0,getResources().getResourceEntryName(Integer.parseInt(iv.getTag().toString())).indexOf("_"));
            opTxt+=vehiculo.toUpperCase();

            TextView edT=findViewById(R.id.textView);
            edT.setText(opTxt);

        }
    }
    private int randomInt(){
        Random r=new Random();
        return r.nextInt(imgIconos.length);
    }
}
