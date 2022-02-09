package com.metehanersoy.canrisk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainActivity2 extends AppCompatActivity {

    int point=0;
    Button button2;

    TextView editTexWeight, editTextHeight;

    RadioGroup Main2_RadioGroup1, Main2_RadioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button2 = findViewById(R.id.button2);

        Main2_RadioGroup1 = findViewById(R.id.Main2_RadioGroup1);
        Main2_RadioGroup2 = findViewById(R.id.Main2_RadioGroup2);

        editTexWeight = findViewById(R.id.editTexWeight);
        editTextHeight = findViewById(R.id.editTextHeight);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedRadioButtonId = Main2_RadioGroup1.getCheckedRadioButtonId();
                int selectedRadioButtonId2 = Main2_RadioGroup2.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1 && selectedRadioButtonId2 != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    RadioButton selectedRadioButton2 = findViewById(selectedRadioButtonId2);
                    String selectedRbText = selectedRadioButton.getText().toString();
                    String selectedRbText2 = selectedRadioButton2.getText().toString();

                    if(selectedRbText.equals("40 - 44 years")){
                        // add 0, that means do nothing
                    }else if(selectedRbText.equals("45 - 54 years")){
                        point += 7;
                    }else if(selectedRbText.equals("55 - 64 years")){
                        point += 13;
                    }else if(selectedRbText.equals("65 - 74 years")){
                        point += 15;
                    }

                    try {
                        Double weight = Double.parseDouble(editTexWeight.getText().toString());
                        Double Height = Double.parseDouble(editTextHeight.getText().toString());
                        Double bmi = weight / ((Height/ 100) * (Height/ 100) );

                        if(bmi < 25){

                            // add 0, that means do nothing

                        }else if(bmi >= 25 && bmi <= 29){

                            point += 4;

                        }else if(bmi >= 30 && bmi <= 34){

                            point += 9;

                        }else if(bmi >= 35){

                            point += 14;

                        }
                        if(selectedRbText2.equals("Male")){
                            point += 6;
                            //Go Male Screen
                            Intent intent2 = new Intent(MainActivity2.this,MainActivity3.class);
                            intent2.putExtra("point",point);
                            startActivity(intent2);
                        }else{
                            // add 0, that means do nothing
                            //Go Female Screen
                            Intent intent = new Intent(MainActivity2.this,MainActivity3_2.class);
                            intent.putExtra("point",point);
                            startActivity(intent);
                        }

                    }catch (Exception e){
                        Toast.makeText(MainActivity2.this, "You must write number to weight and height!", Toast.LENGTH_SHORT).show();
                    }



                } else {
                    Toast.makeText(MainActivity2.this, "You must fill every question!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}