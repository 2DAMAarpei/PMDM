package com.example.fragmentosdiversos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    public static MyDialogFragment newInstance(String valor){
        MyDialogFragment frag=new MyDialogFragment();
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        LayoutInflater inflater=(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup dlgview=(ViewGroup) inflater.inflate(R.layout.fragment_my_dialog,null);
        Button buttonShow=(Button) dlgview.findViewById(R.id.newFragment);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).addFragment();
            }
        });

        Button buttonCancel=(Button) dlgview.findViewById(R.id.cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button buttonBack=(Button) dlgview.findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        return new AlertDialog.Builder(getActivity()).setView(dlgview).create();

    }

}
