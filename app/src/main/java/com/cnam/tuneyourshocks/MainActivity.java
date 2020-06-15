package com.cnam.tuneyourshocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView resultViewer;
    private String result = "";
    private RadioButton jumpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /*
     * This is the main button that will generate the result.
     *
     */
    public void continueButton(View mainView) {
        Log.i("Info", "Continue button pressed.");

        Map<Integer, Integer> weightChart = WeightChartInitializer.initChart();


        try {

            EditText weightData = (EditText) findViewById(R.id.weightGetter);
            int weightInD = Integer.parseInt(weightData.getText().toString());
            Log.i("ENTERED WEIGHT : ", Integer.toString(weightInD));

            result = getPsiFromChart(weightInD, weightChart);
            resultViewer = (TextView) findViewById(R.id.resultViewer);

            resultViewer.setText(result);

        } catch (Exception e) {
            Log.e("ERR", e.getMessage());
        }

    }


    /*
     * This method checks the entered value from the user, and checks in a Map for the
     * corresponding value.
     *
     * If the user enters a weight that is not a multiple of 10, we will get the higher rounded
     * tenth.
     *
     * (Ex: entered weight = 67, rounded weight will be 70)
     *
     * We then return a String to display on the view with the result of the
     * recommended PSI setting.
     */
    private String getPsiFromChart(int weight, Map<Integer, Integer> chart) {


        jumpButton = (RadioButton) findViewById(R.id.jumpTrackRadio);


        // We check the type of track the user wants to ride
        // For jumps, we add 10 kgs to the actual weight to get a stiffer
        // suspension setting.
        // For Downhill/Rocky we substract 5kg of the rider's weight for a
        // softer suspension setting.
        if (jumpButton.isChecked()) {
            weight = weight + 20;
        } else {
            weight = weight -5;
        }


        // Remove odd numbers tor espect the chart values.
        if ( weight % 2 != 0 ) {
            weight = weight +1;
        }


        int nearestWeight;

        if (weight % 10 == 0) {
            nearestWeight = weight;
        } else {
            nearestWeight = (int) (Math.round((weight+5)/10.0) * 10);
        }


        String msg = "";


        for (Integer entry : chart.keySet()) {
            if (chart.containsKey(nearestWeight)) {
                msg = chart.get(nearestWeight) + " PSI is the recommended air pressure for your weight.";
                Log.i("NEAREST WEIGHT : ", String.valueOf(nearestWeight));
                Log.i("MATCH FOUND FOR : ", String.valueOf(nearestWeight));
                Log.i("KEY VALUE : ", String.valueOf(entry));
            }
            else {
                msg = "No settings found for the given weight";
                Log.i("NEAREST WEIGHT : ", String.valueOf(nearestWeight));
                Log.i("NO MATCH FOR : ", String.valueOf(nearestWeight));
                Log.i("KEY VALUE : ", String.valueOf(entry));
            }
        }



        return msg;
    }

}