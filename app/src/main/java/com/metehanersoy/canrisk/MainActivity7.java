package com.metehanersoy.canrisk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {
    TextView tv;

    int point;

    Button  button8 ;

   // ImageView go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        button8 = findViewById(R.id.button8);
        tv = findViewById(R.id.textView36);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            point = bundle.getInt("point",point);
            String str = Integer.toString(point);

            tv.setText(str);
        }


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity7.this,MainActivity.class);
                startActivity(intent);

            }
        });




    }
}