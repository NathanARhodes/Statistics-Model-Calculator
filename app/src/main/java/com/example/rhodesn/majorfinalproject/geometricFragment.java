package com.example.rhodesn.majorfinalproject;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class geometricFragment extends Fragment {


    private static View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_geometric, container, false);
        return v;
    }



    public static void calculate() {

        TextView solutionText = (TextView) v.findViewById(R.id.geoSolution);


            EditText geoProb = (EditText) v.findViewById(R.id.hSampleProb);
            EditText geoTrial = (EditText) v.findViewById(R.id.norConfidence);

            double prob = Double.parseDouble(geoProb.getText().toString());
            int trial = Integer.parseInt(geoTrial.getText().toString());



            Switch cumExactSwitch = (Switch) v.findViewById(R.id.geoCumExactSwitch);



            // Exact
            if(cumExactSwitch.isChecked()){

                solutionText.setVisibility(View.VISIBLE);
                Geometric g = new Geometric(prob, trial);

                solutionText.setText("The expected value is: "+g.expectedValue()+ "\n");
                solutionText.append("The standard deviation is: "+g.standardDeviation()+ "\n");
                solutionText.append("The probability of seeing your first success in "+trial+" trials is: "+g.prob() + "\n");

                // Cumulative
            }else {
                solutionText.setVisibility(View.VISIBLE);
                Geometric g = new Geometric(prob, trial);

                solutionText.setText("The expected value is: "+g.expectedValue()+ "\n");
                solutionText.append("The standard deviation is: "+g.standardDeviation()+ "\n");
                solutionText.append("The probability of seeing your first success in "+trial+" trials is: "+g.probc() + "\n");


            }

    }
}
