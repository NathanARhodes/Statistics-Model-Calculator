package com.example.rhodesn.majorfinalproject;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;


public class normalHFragment extends Fragment {


   private static View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_normal_h, container, false);


        Switch twoTailedSwitch = view.findViewById(R.id.twoTailedSwitch);

        final TextView lowerTailedTextView = view.findViewById(R.id.lowerTailedTextView);
        final TextView upperTailedTextView = view.findViewById(R.id.upperTailedTextView);
        final Switch upLowSwitch = view.findViewById(R.id.upLowSwitch);

        twoTailedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    lowerTailedTextView.setVisibility(View.INVISIBLE);
                    upperTailedTextView.setVisibility(View.INVISIBLE);
                    upLowSwitch.setVisibility(View.INVISIBLE);
                }else{
                    lowerTailedTextView.setVisibility(View.VISIBLE);
                    upperTailedTextView.setVisibility(View.VISIBLE);
                    upLowSwitch.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }



    public static void calculate(){



        boolean twoTailed;
        boolean upperTailed;
        double probibility;
        double alpha;
        int sampleSize;
        double nullHypothesis;


        EditText hNullHypothesis = view.findViewById(R.id.hNullHypothesis);
        EditText hSampleProb = view.findViewById(R.id.hSampleProb);
        EditText hSampleSize = view.findViewById(R.id.hSampleSize);
        EditText aplhaLevel = view.findViewById(R.id.hAplhaLevel);
        Switch twoTailedSwitch = view.findViewById(R.id.twoTailedSwitch);
        Switch upLowSwitch = view.findViewById(R.id.upLowSwitch);


        nullHypothesis = Double.parseDouble(hNullHypothesis.getText().toString()) + 0;
        probibility = Double.parseDouble(hSampleProb.getText().toString()) + 0;
        alpha = Double.parseDouble(aplhaLevel.getText().toString()) + 0;
        sampleSize = Integer.parseInt(hSampleSize.getText().toString()) + 0;

        if(twoTailedSwitch.isChecked()){
            twoTailed = true;
        }else{
            twoTailed = false;
        }


        // check is lower tailed

        if(upLowSwitch.isChecked()){
            upperTailed = false;
        }else{
            upperTailed = true;
        }




        TextView solution = view.findViewById(R.id.normalHSolution);



        Normal1 n = new Normal1(twoTailed,upperTailed,nullHypothesis,probibility,alpha,sampleSize);

        solution.setVisibility(View.VISIBLE);

        String output = "The z-score is " + n.zscore() + "\nThe p-value is " +n.pvalue() + "\n" + n.conclusion();
        System.out.println(output);
        solution.setText(output);




    }
}
