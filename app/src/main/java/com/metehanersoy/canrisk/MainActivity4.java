package com.metehanersoy.canrisk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    Button button5;

    RadioGroup Main4_RadioGroup1, Main4_RadioGroup2, Main4_RadioGroup3;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        button5 = findViewById(R.id.button5);

        Main4_RadioGroup1 = findViewById(R.id.Main4_RadioGroup1);
        Main4_RadioGroup2 = findViewById(R.id.Main4_RadioGroup2);
        Main4_RadioGroup3 = findViewById(R.id.Main4_RadioGroup3);



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle =getIntent().getExtras();

                if(bundle != null){

                    point = bundle.getInt("point");

                }

                int selectedRadioButtonId = Main4_RadioGroup1.getCheckedRadioButtonId();
                int selectedRadioButtonId2 = Main4_RadioGroup2.getCheckedRadioButtonId();
                int selectedRadioButtonId3 = Main4_RadioGroup3.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1 && selectedRadioButtonId2 != -1 && selectedRadioButtonId3 != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    RadioButton selectedRadioButton2 = findViewById(selectedRadioButtonId2);
                    RadioButton selectedRadioButton3 = findViewById(selectedRadioButtonId3);
                    String selectedRbText = selectedRadioButton.getText().toString();
                    String selectedRbText2 = selectedRadioButton2.getText().toString();
                    String selectedRbText3 = selectedRadioButton3.getText().toString();


                    if(selectedRbText.equals("Every Day")){
                        // add 0, that means do nothing
                    }else{

                        point += 2;
                    }

                    if(selectedRbText2.equals("Yes")){

                        point += 4;

                    }else{
                        // add 0, that means do nothing
                    }

                    if(selectedRbText3.equals("Yes")){

                        point += 14;

                    }else{
                        // add 0, that means do nothing
                    }
                    Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                    intent.putExtra("point",point);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity4.this, "You must fill every question!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}