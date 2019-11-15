package com.example.menufiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.helpButton));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        ViewGroup viewGroup = findViewById(R.id.viewGroup);
        viewGroup.removeAllViews();
        switch (item.getItemId()) {
            case  R.id.MnuOpc1Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_rectangle,viewGroup);

                break;
            case  R.id.MnuOpc2Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_circle,viewGroup);
                break;
            case  R.id.MnuOpc3Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_triangle,viewGroup);
                break;
            case  R.id.MnuOpc4Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_square,viewGroup);
                break;
            default:
                break;

        }
        return true;
    }
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

}
