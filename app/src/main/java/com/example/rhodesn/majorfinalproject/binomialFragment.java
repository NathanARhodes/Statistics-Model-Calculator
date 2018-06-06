package com.example.rhodesn.majorfinalproject;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class binomialFragment extends Fragment {



   private static View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_binomial, container, false);

        return view;
    }

    public static void calc(){


            EditText binomialProb = view.findViewById(R.id.binomialProbabilityValue);
            EditText binomialSucc = view.findViewById(R.id.binomialSuccesses);
            EditText binomialTrial = view.findViewById(R.id.binomialTrials);
            TextView solutionText = view.findViewById(R.id.biSolution);
            Switch cumExactSwitch = view.findViewById(R.id.biCumExactSwitch);


         //   if(binomialProb.getText().toString() == "" || binomialSucc.getText().toString() == "" || binomialTrial.getText().toString() == "" || solutionText.getText().toString() == ""){



           // }else{
                double prob = Double.parseDouble(binomialProb.getText().toString()) + 0;
                int succ = Integer.parseInt(binomialSucc.getText().toString()) + 0;
                int trial = Integer.parseInt(binomialTrial.getText().toString())+ 0;



                // Exact
                if(cumExactSwitch.isChecked()){

                    solutionText.setVisibility(View.VISIBLE);
                    Binomial b=new Binomial(trial, succ, prob, 2);
                    solutionText.setText("The expected value is: "+b.expectedValue()+ "\n");
                    solutionText.append("The standard deviation is: "+b.standardDeviation()+ "\n");
                    solutionText.append("The probability of seeing "+succ+" successes is: "+b.prob()+ "\n");

                    // Cumulative
                }else {
                    solutionText.setVisibility(View.VISIBLE);
                    Binomial b = new Binomial(trial, succ, prob, 1);
                    solutionText.setText("The expected value is: " + b.expectedValue() + "\n");
                    solutionText.append("The standard deviation is: " + b.standardDeviation() + "\n");
                    solutionText.append("The probability of seeing " + succ + " or fewer successes is: " + b.helper() + "\n");

                }
        //    }



    }

}
