package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;

    public void submitQuiz(View view) {



        CheckBox continentAsia = (CheckBox) findViewById(R.id.continent_asia);
        boolean isAsia = continentAsia.isChecked();

        CheckBox continentEurope = (CheckBox) findViewById(R.id.continent_europe);
        boolean isEurope = continentEurope.isChecked();

        CheckBox notContinentGermany = (CheckBox) findViewById(R.id.continent_germany);
        boolean isGermany = notContinentGermany.isChecked();

        TextView longestRiverAns = (TextView) findViewById(R.id.longest_river);
        if(longestRiverAns.toString() == "Nile"){
            score = score + 1;
        }

        if(isAsia && isEurope && !isGermany){
            score = score + 1;
        } else if(isGermany){
            score = score - 1;
        }

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.qu_one);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        String selectedValue = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

        displayScore();
        

    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//
//        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.qu_one);
//        int selectedId = radioGroup.getCheckedRadioButtonId();
//        String selectedValue = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
//
//        Log.v("MainActivity","Price Message is: \n" + selectedValue);
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.aa_bb:
//                if (checked)
//                    incrementCount();
//                    Log.v("MainActivity","Yessss is: \n");
//                    break;
//            case R.id.cc_dd:
//                if (checked)
//                    Log.v("MainActivity","NOOOOO is: \n" );
//                    break;
//        }
//    }

    public void incrementCount(View view) {
        score = score + 1;
        Log.v("MainActivity","Count: " + score);
    }

    public void decrementCount(View view) {

        score = score - 1;
        Log.v("MainActivity","Count: " + score);
    }

    /**
     * Displays the given score
     */
    public void displayScore() {
        TextView scoreView = (TextView) findViewById(R.id.quiz_score);
        scoreView.setText(String.valueOf(score));
    }



}
