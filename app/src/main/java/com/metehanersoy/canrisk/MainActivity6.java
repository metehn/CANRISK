package com.metehanersoy.canrisk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    Button button7;

    RadioGroup Main6_RadioGroup1, Main6_RadioGroup2, Main6_RadioGroup3;

    int group1 =0, group2 = 0;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        button7 = findViewById(R.id.button7);

        Main6_RadioGroup1 = findViewById(R.id.Main6_RadioGroup1);
        Main6_RadioGroup2 = findViewById(R.id.Main6_RadioGroup2);
        Main6_RadioGroup3 = findViewById(R.id.Main6_RadioGroup3);



        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();

                if(bundle != null){

                    point = bundle.getInt("point");

                }

                int selectedRadioButtonId = Main6_RadioGroup1.getCheckedRadioButtonId();
                int selectedRadioButtonId2 = Main6_RadioGroup2.getCheckedRadioButtonId();
                int selectedRadioButtonId3 = Main6_RadioGroup3.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1 && selectedRadioButtonId2 != -1 && selectedRadioButtonId3 != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    RadioButton selectedRadioButton2 = findViewById(selectedRadioButtonId2);
                    RadioButton selectedRadioButton3 = findViewById(selectedRadioButtonId3);

                    if(selectedRadioButton == findViewById(R.id.radioButton31)){
                        group2 = 0;

                    }else if(selectedRadioButton == findViewById(R.id.radioButton32)){
                        group2 = 3;

                    }else if(selectedRadioButton == findViewById(R.id.radioButton33)){
                        group2 = 5;

                    }else if(selectedRadioButton == findViewById(R.id.radioButton34)){
                        group2 = 10;

                    }else if(selectedRadioButton == findViewById(R.id.radioButton35)){
                        group2 = 11;

                    }else if(selectedRadioButton == findViewById(R.id.radioButton36)){
                        group2 = 3;

                    }


                    if(selectedRadioButton2 == findViewById(R.id.radioButton37)){
                        group2 = 0;

                    }else if(selectedRadioButton2 == findViewById(R.id.radioButton38)){
                        group2 = 3;

                    }else if(selectedRadioButton2 == findViewById(R.id.radioButton39)){
                        group2 = 5;

                    }else if(selectedRadioButton2 == findViewById(R.id.radioButton40)){
                        group2 = 10;

                    }else if(selectedRadioButton2 == findViewById(R.id.radioButton41)){
                        group2 = 11;

                    }else if(selectedRadioButton2 == findViewById(R.id.radioButton42)){
                        group2 = 3;

                    }

                    if(selectedRadioButton3 == findViewById(R.id.radioButton43)){

                        point += 5;

                    }else if(selectedRadioButton3 == findViewById(R.id.radioButton44)){

                        point += 1;

                    }else if(selectedRadioButton3 == findViewById(R.id.radioButton45)){
                        // add 0, that means do nothing

                    }else if(selectedRadioButton3 == findViewById(R.id.radioButton46)){
                        // add 0, that means do nothing

                    }

                    point += Math.max(group1,group2);
                    Intent intent = new Intent(MainActivity6.this,MainActivity7.class);
                    intent.putExtra("point",point);
                    startActivity(intent);



                }else {
                    Toast.makeText(MainActivity6.this, "You must fill every question!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}