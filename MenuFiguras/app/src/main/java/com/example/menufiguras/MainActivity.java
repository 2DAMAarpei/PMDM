package com.example.menufiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static android.graphics.Bitmap.Config.ARGB_8888;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.helpButton));

    }
    //Metodos del menú contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.CtxLblOpc1:
                Toast.makeText(this, "Calcula el  area de la figura pasandole los datos necesarios", Toast.LENGTH_LONG).show();
                return true;
            case R.id.CtxLblOpc2:
                Toast.makeText(this, "Dibuja la figura", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    //Metodos del menú desplegable
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        ViewGroup viewGroup = findViewById(R.id.viewGroup);
        viewGroup.removeAllViews();
        ImageView imageView;
        Bitmap bitmap;
        final Canvas canvas;
        final Paint pincel;
        CheckBox checkBoxGray, checkBoxGreen,checkBoxYellow;
        switch (item.getItemId()) {
            //Botones Calcula
            case  R.id.MnuOpc1Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_rectangle,viewGroup);
                Button area_rectangle_calculate=findViewById(R.id.edB1R);
                area_rectangle_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1R);
                        EditText edT2=findViewById(R.id.edT2R);
                        TextView resultado=findViewById(R.id.etV1R_result);
                        resultado.setText(String.valueOf(Float.parseFloat(edT1.getText().toString())*Float.parseFloat(edT2.getText().toString())));
                    }
                });
                break;
            case  R.id.MnuOpc2Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_circle,viewGroup);
                Button area_circle_calculate=findViewById(R.id.edB1C);

                area_circle_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1C);
                        TextView resultado=findViewById(R.id.etV1C_result);
                        resultado.setText(String.valueOf(Math.PI*Math.pow(Float.parseFloat(edT1.getText().toString()),2 )));
                    }
                });
                break;
            case  R.id.MnuOpc3Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_triangle,viewGroup);
                Button area_triangle_calculate=findViewById(R.id.edB1T);
                area_triangle_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1T);
                        EditText edT2=findViewById(R.id.edT2T);
                        TextView resultado=findViewById(R.id.etV1T_result);
                        resultado.setText(String.valueOf((Float.parseFloat(edT1.getText().toString())*Float.parseFloat(edT2.getText().toString()))/2));
                    }
                });
                break;
            case  R.id.MnuOpc4Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_square,viewGroup);
                Button area_square_calculate=findViewById(R.id.edB1S);
                area_square_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1S);
                        TextView resultado=findViewById(R.id.etV1S_result);
                        resultado.setText(String.valueOf(Math.pow(Float.parseFloat(edT1.getText().toString()),2)));
                    }
                });
                break;
            //Botones Dibuja
            case  R.id.MnuOpc1Dibuja:
                //Inflamos el activity_main con el xml donde se ha definido el ImageView en el cual dibujaremos
                getLayoutInflater().inflate(R.layout.lienzo,viewGroup);
                imageView=findViewById(R.id.drawHere);
                bitmap=Bitmap.createBitmap(200,200,ARGB_8888);
                canvas=new Canvas(bitmap);

                imageView.setImageBitmap(bitmap);
                canvas.drawColor(Color.RED);

                pincel=new Paint();
                pincel.setColor(Color.BLUE);
                pincel.setStrokeWidth(15);
                pincel.setStyle(Paint.Style.STROKE);
                canvas.drawRect(50,75,150,125,pincel);
                checkBoxGray=findViewById(R.id.checkboxGray);
                checkBoxGray.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GRAY);
                            canvas.drawRect(50,75,150,125,pincel);
                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawRect(50,75,150,125,pincel);

                        }
                    }
                });
                checkBoxGreen=findViewById(R.id.checkboxGreen);
                checkBoxGreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GREEN);
                            canvas.drawRect(50,75,150,125,pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawRect(50,75,150,125,pincel);

                        }
                    }
                });
                checkBoxYellow=findViewById(R.id.checkboxYellow);
                checkBoxYellow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.YELLOW);
                            canvas.drawRect(50,75,150,125,pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawRect(50,75,150,125,pincel);

                        }
                    }
                });

                break;
            case  R.id.MnuOpc2Dibuja:
                getLayoutInflater().inflate(R.layout.lienzo,viewGroup);
                imageView=findViewById(R.id.drawHere);
                bitmap=Bitmap.createBitmap(200,200,ARGB_8888);
                canvas=new Canvas(bitmap);

                imageView.setImageBitmap(bitmap);
                canvas.drawColor(Color.RED);

                pincel=new Paint();
                pincel.setColor(Color.BLUE);
                pincel.setStrokeWidth(15);
                pincel.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(100,100,90,pincel);
                checkBoxGray=findViewById(R.id.checkboxGray);
                checkBoxGray.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GRAY);
                            canvas.drawCircle(100,100,90,pincel);
                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawCircle(100,100,90,pincel);

                        }
                    }
                });
                checkBoxGreen=findViewById(R.id.checkboxGreen);
                checkBoxGreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GREEN);
                            canvas.drawCircle(100,100,90,pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawCircle(100,100,90,pincel);

                        }
                    }
                });
                checkBoxYellow=findViewById(R.id.checkboxYellow);
                checkBoxYellow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.YELLOW);
                            canvas.drawCircle(100,100,90,pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawCircle(100,100,90,pincel);

                        }
                    }
                });
                break;

            case  R.id.MnuOpc3Dibuja:
                getLayoutInflater().inflate(R.layout.lienzo,viewGroup);
                imageView=findViewById(R.id.drawHere);
                bitmap=Bitmap.createBitmap(200,200,ARGB_8888);
                canvas=new Canvas(bitmap);

                imageView.setImageBitmap(bitmap);
                canvas.drawColor(Color.RED);

                pincel=new Paint();
                pincel.setColor(Color.BLUE);
                pincel.setStrokeWidth(10);
                pincel.setStyle(Paint.Style.STROKE);

                Point point1_draw = new Point(100, 20);
                Point point2_draw = new Point(20, 170);
                Point point3_draw = new Point(170, 170);

                final Path path = new Path();
                path.moveTo(point1_draw.x, point1_draw.y);
                path.lineTo(point2_draw.x, point2_draw.y);
                path.lineTo(point3_draw.x, point3_draw.y);
                path.lineTo(point1_draw.x, point1_draw.y);
                path.close();
                canvas.drawPath(path, pincel);
                checkBoxGray=findViewById(R.id.checkboxGray);
                checkBoxGray.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GRAY);
                            canvas.drawPath(path, pincel);
                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawPath(path, pincel);

                        }
                    }
                });
                checkBoxGreen=findViewById(R.id.checkboxGreen);
                checkBoxGreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GREEN);
                            canvas.drawPath(path, pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawPath(path, pincel);

                        }
                    }
                });
                checkBoxYellow=findViewById(R.id.checkboxYellow);
                checkBoxYellow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.YELLOW);
                            canvas.drawPath(path, pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawPath(path, pincel);

                        }
                    }
                });
                break;
            case  R.id.MnuOpc4Dibuja:
                getLayoutInflater().inflate(R.layout.lienzo,viewGroup);
                imageView=findViewById(R.id.drawHere);
                bitmap=Bitmap.createBitmap(200,200,ARGB_8888);
                canvas=new Canvas(bitmap);

                imageView.setImageBitmap(bitmap);
                canvas.drawColor(Color.RED);

                pincel=new Paint();
                pincel.setColor(Color.BLUE);
                pincel.setStrokeWidth(15);
                pincel.setStyle(Paint.Style.STROKE);
                canvas.drawRect(50,50,150,150,pincel);
                checkBoxGray=findViewById(R.id.checkboxGray);
                checkBoxGray.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GRAY);
                            canvas.drawRect(50,50,150,150,pincel);
                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawRect(50,50,150,150,pincel);

                        }
                    }
                });
                checkBoxGreen=findViewById(R.id.checkboxGreen);
                checkBoxGreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.GREEN);
                            canvas.drawRect(50,50,150,150,pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawRect(50,50,150,150,pincel);

                        }
                    }
                });
                checkBoxYellow=findViewById(R.id.checkboxYellow);
                checkBoxYellow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ( ((CheckBox)v).isChecked() ) {
                            canvas.drawColor(Color.YELLOW);
                            canvas.drawRect(50,50,150,150,pincel);

                        }else{
                            canvas.drawColor(Color.RED);
                            canvas.drawRect(50,50,150,150,pincel);
                        }
                    }
                });
                break;
            default:
                break;

        }
        return true;
    }


}



