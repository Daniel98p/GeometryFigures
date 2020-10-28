package com.example.geometryfigures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    double number;
    EditText numberInput;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        numberInput = (EditText) findViewById(R.id.editTextNumber);
        submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(numberInput.getText().toString());
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("number", number);
                startActivity(i);
                finish();
            }
        });
    }
}