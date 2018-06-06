package com.example.rhodesn.majorfinalproject;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class normalFragment extends Fragment {

    private static View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_normal, container, false);
        return view;
    }


    public static void calculate(){


        EditText probField = (EditText) view.findViewById(R.id.hSampleProb);
        Spinner norConfidence = (Spinner) view.findViewById(R.id.norConfidence);
        EditText norSampleSize = (EditText) view.findViewById(R.id.hSampleSize);

        TextView textView5 = (TextView) view.findViewById(R.id.textView5);




     double prob = Double.parseDouble(probField.getText().toString());
     int con = Integer.parseInt(norConfidence.getSelectedItem().toString());
     int sam = Integer.parseInt(norSampleSize.getText().toString());

     Normal n=new Normal(prob, con, sam);

     textView5.setVisibility(View.VISIBLE);
        textView5.setText("Your confidence interval is: ("+n.lower()+","+n.upper()+")");

    }

}
