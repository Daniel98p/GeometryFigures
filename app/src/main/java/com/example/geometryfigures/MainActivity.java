package com.example.geometryfigures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.geometryfigures.figures.*;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ln = (LinearLayout) findViewById(R.id.LinearLayout1);

        Figure[] figures = generateFigures();
        int numberElements = figures.length;
        for (int nr = 0; nr < numberElements; nr = nr + 1){
            if (figures[nr].name.equals("Kwadrat")){
                Square square = (Square) figures[nr];
                String strArea = Double.toString(square.calculateArea(square.getLinearDimension()));
                String linearDimension = Double.toString(square.getLinearDimension());
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.second_layout, ln, false);
                TextView tv = (TextView) layout.findViewById(R.id.textView5);
                tv.setText(strArea);
                ImageView iv = (ImageView) layout.findViewById(R.id.imageView);
                iv.setImageResource(R.drawable.kwadrat);
                TextView tv2 = (TextView) layout.findViewById(R.id.textView6);
                tv2.setText(linearDimension);
                TextView tv3 = (TextView) layout.findViewById(R.id.textView7);
                tv3.setText(square.feature);
                ln.addView(layout);

            }
            if (figures[nr].name.equals("Kolo")){
                Circle circle = (Circle) figures[nr];
                String strArea = Double.toString(circle.calculateArea(circle.getLinearDimension()));
                String linearDimension = Double.toString(circle.getLinearDimension());
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.second_layout, ln, false);
                TextView tv = (TextView) layout.findViewById(R.id.textView5);
                tv.setText(strArea);
                ImageView iv = (ImageView) layout.findViewById(R.id.imageView);
                iv.setImageResource(R.drawable.kolo);
                TextView tv2 = (TextView) layout.findViewById(R.id.textView6);
                tv2.setText(linearDimension);
                TextView tv3 = (TextView) layout.findViewById(R.id.textView7);
                tv3.setText(circle.feature);
                ln.addView(layout);
            }
            if (figures[nr].name.equals("Trojkat")){
                Triangle triangle = (Triangle) figures[nr];
                String strArea = Double.toString(triangle.calculateArea(triangle.getLinearDimension()));
                String linearDimension = Double.toString(triangle.getLinearDimension());
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.second_layout, ln, false);
                TextView tv = (TextView) layout.findViewById(R.id.textView5);
                tv.setText(strArea);
                ImageView iv = (ImageView) layout.findViewById(R.id.imageView);
                iv.setImageResource(R.drawable.trojkat);
                TextView tv2 = (TextView) layout.findViewById(R.id.textView6);
                tv2.setText(linearDimension);
                TextView tv3 = (TextView) layout.findViewById(R.id.textView7);
                tv3.setText(triangle.feature);
                ln.addView(layout);
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    public Figure [] generateFigures(){
        int n = 10;
        Random generator = new Random();
        int[] numbers = new int[n];
        float[] values = new float[n];
        for (int i = 0; i < n; i += 1) {
            numbers[i] = generator.nextInt(3);
            values[i] = generator.nextFloat();
        }
        Figure[] figures = new Figure[n];
        for (int i = 0; i < n; i += 1) {
            if (numbers[i] == 0) {
                figures[i] = new Square(values[i]);
            }
            if (numbers[i] == 1) {
                figures[i] = new Triangle(values[i]);

            }
            if (numbers[i] == 2) {
                figures[i] = new Circle(values[i]);

            }
        }
        return figures;
    }
}


