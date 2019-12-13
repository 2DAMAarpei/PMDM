package com.example.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Fragmento extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mi, container, false);
    }

    public class MainActivity extends AppCompatActivity {
        public View mFrg;
        public CheckBox mChk;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mFrg = (View) findViewById(R.id.miFrg);
            /* RECUERDA: el fragmento se infla como una vista*/
            mChk = (CheckBox) findViewById(R.id.aparece);
            mChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (mChk.isChecked()) mFrg.setVisibility(View.VISIBLE);
                    else mFrg.setVisibility(View.INVISIBLE);
                }
            });
        }
    }
}