package com.example.geometryfigures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class SettingsActivity extends AppCompatActivity {
    int number;
    int min;
    int max;
    EditText numberInput;
    EditText minInput;
    EditText maxInput;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        numberInput = (EditText) findViewById(R.id.editTextNumber);
        minInput = (EditText) findViewById(R.id.editTextMin);
        maxInput = (EditText) findViewById(R.id.editTextMax);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.parseInt(numberInput.getText().toString());
                min = Integer.parseInt(minInput.getText().toString());
                max = Integer.parseInt(maxInput.getText().toString());
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("key1",number);
                i.putExtra("key2",min);
                i.putExtra("key3",max);
                startActivity(i);
                finish();
            }
        });

    }
}