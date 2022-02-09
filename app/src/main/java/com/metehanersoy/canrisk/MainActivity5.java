package com.metehanersoy.canrisk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    Button button6;

    RadioGroup Main5_RadioGroup1;
    RadioButton radioButton25, radioButton26, radioButton27, radioButton28, radioButton29, radioButton30;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        button6 = findViewById(R.id.button6);

        Main5_RadioGroup1 = findViewById(R.id.Main5_RadioGroup1);

        radioButton25 = findViewById(R.id.radioButton25);
        radioButton26 = findViewById(R.id.radioButton26);
        radioButton27 = findViewById(R.id.radioButton27);
        radioButton28 = findViewById(R.id.radioButton28);
        radioButton29 = findViewById(R.id.radioButton29);
        radioButton30 = findViewById(R.id.radioButton30);



        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle =getIntent().getExtras();

                if(bundle != null){

                    point = bundle.getInt("point");

                }

                int selectedRadioButtonId = Main5_RadioGroup1.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedRbText = selectedRadioButton.getText().toString();

                    if(radioButton25.isChecked() ||radioButton26.isChecked() || radioButton27.isChecked() || radioButton28.isChecked() || radioButton29.isChecked() || radioButton30.isChecked() ){

                        if(selectedRbText.equals("Yes")){

                            point += 1;

                        }else{
                            // add 0, that means do nothing
                        }

                        if(radioButton25.isChecked()){
                            point += 2;
                        }
                        if(radioButton26.isChecked()){
                            point += 2;
                        }
                        if(radioButton27.isChecked()){
                            point += 2;
                        }
                        if(radioButton28.isChecked()){
                            point += 2;
                        }
                        if(radioButton29.isChecked()){
                            // add 0, that means do nothing
                        }
                        if(radioButton30.isChecked()){
                            // add 0, that means do nothing
                        }

                        Intent intent = new Intent(MainActivity5.this,MainActivity6.class);
                        intent.putExtra("point",point);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity5.this, "You must fill every question!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }
}