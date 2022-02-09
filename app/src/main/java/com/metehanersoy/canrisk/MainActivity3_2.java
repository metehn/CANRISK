package com.metehanersoy.canrisk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity3_2 extends AppCompatActivity {

    Button button4;

    RadioGroup Main3_2_RadioGroup1, Main3_2_RadioGroup2;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_2);

        button4  =findViewById(R.id.button4);

        Main3_2_RadioGroup1 = findViewById(R.id.Main3_2_RadioGroup1);
        Main3_2_RadioGroup2 = findViewById(R.id.Main3_2_RadioGroup2);



        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle =getIntent().getExtras();

                if(bundle != null){

                    point = bundle.getInt("point");

                }

                int selectedRadioButtonId = Main3_2_RadioGroup1.getCheckedRadioButtonId();
                int selectedRadioButtonId2 = Main3_2_RadioGroup2.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1 && selectedRadioButtonId2 != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    RadioButton selectedRadioButton2 = findViewById(selectedRadioButtonId2);
                    String selectedRbText = selectedRadioButton.getText().toString();
                    String selectedRbText2 = selectedRadioButton2.getText().toString();

                    if(selectedRbText.equals("Less than 80 cm")){

                        // add 0, that means do nothing

                    }else if(selectedRbText.equals("Between 80 - 88 cm")){

                        point += 4;

                    }else if(selectedRbText.equals("Over 88 cm")){

                        point += 6;

                    }

                    if(selectedRbText2.equals("Yes")){

                        // add 0, that means do nothing
                    }else {
                        point += 1;
                    }

                    Intent intent = new Intent(MainActivity3_2.this,MainActivity4.class);
                    intent.putExtra("point",point);
                    startActivity(intent);

                }else {
                    Toast.makeText(MainActivity3_2.this, "You must fill every question!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}