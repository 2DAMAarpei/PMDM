package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox checkBox=findViewById(R.id.aparece);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View fragmento = findViewById(R.id.miFrg);
                if(!checkBox.isChecked()) {
                    fragmento.setVisibility(View.INVISIBLE);
                }else{
                    fragmento.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
