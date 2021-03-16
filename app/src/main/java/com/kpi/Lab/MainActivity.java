package com.kpi.Lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resultButton = (Button) findViewById(R.id.resultButton);
        resultButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView textView = findViewById(R.id.questionField);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                if (textView.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Your question is empty!" ,
                            Toast.LENGTH_LONG).show();
                }
                else{
                    RadioButton selectedRadioButton  = (RadioButton)
                            findViewById(radioGroup.getCheckedRadioButtonId());
                    Toast.makeText(MainActivity.this, "Your answer for question: \n"
                            + textView.getText().toString() + "\nIs "
                            + selectedRadioButton.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}