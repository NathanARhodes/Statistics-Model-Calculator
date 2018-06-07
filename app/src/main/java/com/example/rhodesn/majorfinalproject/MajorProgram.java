package com.example.rhodesn.majorfinalproject;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MajorProgram extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    public int currentFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        final Spinner modelSpinnerV = (Spinner) findViewById(R.id.modelPicker);
        final TextView modelChooseError = (TextView) findViewById(R.id.modelChooseError);


        ArrayAdapter<String> adapter;
        List<String> list= new ArrayList<String>();
        list.add("Binomial");
        list.add("Geometric");
        list.add("Normal for Proportions (Confidence)");
        list.add("Normal for Proportions (Hypothesis)");
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinnerV.setAdapter(adapter);


        modelSpinnerV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(modelSpinnerV.getSelectedItem().toString() == "Binomial"){
                    modelChooseError.setVisibility(View.INVISIBLE);
                    changeFragment(view, 1);

                }else if(modelSpinnerV.getSelectedItem().toString() == "Normal for Proportions (Confidence)"){
                    modelChooseError.setVisibility(View.INVISIBLE);
                    changeFragment(view, 2);

                } else if(modelSpinnerV.getSelectedItem().toString() == "Geometric"){
                    modelChooseError.setVisibility(View.INVISIBLE);
                    changeFragment(view, 3);

                }else if(modelSpinnerV.getSelectedItem().toString() == "Normal for Proportions (Hypothesis)"){

                    modelChooseError.setVisibility(View.INVISIBLE);
                    changeFragment(view, 5);

                }else{
                    modelChooseError.setVisibility(View.VISIBLE);
                    changeFragment(view, 4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void changeFragment(View view, int frag){
        Fragment gfragment = new geometricFragment();
        Fragment bfragment = new binomialFragment();
        Fragment nfragment = new normalFragment();
        Fragment nfragmentH = new normalHFragment();

        Fragment blankfragment = new choose();
        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(gfragment);
        fragmentTransaction.remove(bfragment);
        fragmentTransaction.remove(nfragment);
        fragmentTransaction.commit();

        if(frag ==1){

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentWrapper, bfragment);
            ft.commit();
            currentFrag = 1;
        }else if(frag == 2){

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentWrapper, nfragment);
            ft.commit();
            currentFrag = 2;
        }else if(frag ==3){

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentWrapper, gfragment);
            ft.commit();
            currentFrag = 3;
        }else if(frag ==5){

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentWrapper, nfragmentH);
            ft.commit();
            currentFrag = 5;

        }else{
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentWrapper, blankfragment);
            ft.commit();
            currentFrag = 4;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calc(View view) {

        // Binomial
        if(currentFrag == 1) {

            binomialFragment.calc();

            //Normal Confidence
        }else if(currentFrag == 2){

            normalFragment.calculate();

            // Geometeric
        }else if(currentFrag ==3){
            geometricFragment.calculate();

        // Normal Hypothesis
        }else if(currentFrag == 5){
            normalHFragment.calculate();


        }
    }

}
