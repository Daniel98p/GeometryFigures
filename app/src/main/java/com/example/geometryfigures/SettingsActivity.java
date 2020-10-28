package com.example.geometryfigures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    int number;
    int min;
    int max;
    boolean clicked = false;
    EditText numberInput;
    EditText minInput;
    EditText maxInput;
    Button addNewFigure;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        numberInput = (EditText) findViewById(R.id.editTextNumber);
        minInput = (EditText) findViewById(R.id.editTextMin);
        maxInput = (EditText) findViewById(R.id.editTextMax);
        addNewFigure = (Button) findViewById(R.id.addNewFigure);
        submitButton = (Button) findViewById(R.id.submitButton);

        addNewFigure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.parseInt(numberInput.getText().toString());
                min = Integer.parseInt(minInput.getText().toString());
                max = Integer.parseInt(maxInput.getText().toString());
                if (numberInput.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You have an empty value", Toast.LENGTH_SHORT).show();
                }
                else  if (minInput.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You have an empty value", Toast.LENGTH_SHORT).show();
                }
                else  if (maxInput.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "You have an empty value", Toast.LENGTH_SHORT).show();
                }
                else if (min >= max){
                    Toast.makeText(getApplicationContext(), "Min cannot be bigger or equal than max", Toast.LENGTH_SHORT).show();
                }
                else {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("key1",number);
                i.putExtra("key2",min);
                i.putExtra("key3",max);
                i.putExtra("key4",clicked);
                startActivity(i);
                finish();
                }
            }
        });

    }
}