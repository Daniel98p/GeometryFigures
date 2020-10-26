package com.example.geometryfigures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.geometryfigures.figures.*;

import java.util.Random;
import java.lang.Math;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int triangleSum = 0;
    int squareSum = 0;
    int circleSum = 0;
    double areaTriangleSum = 0;
    double areaSquareSum = 0;
    double areaCircleSum = 0;
    double linearDimensionTriangleSum = 0;
    double linearDimensionSquareSum = 0;
    double linearDimensionCircleSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ln = (LinearLayout) findViewById(R.id.LinearLayout1);


        Figure[] figures = generateFigures();
        int numberElements = figures.length;
        for (int nr = 0; nr < numberElements; nr = nr + 1) {
//            if (figures[nr] == null) {
//                continue;
//            }
            if (figures[nr].name.equals("Kwadrat")) {
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
                squareSum += 1;
                areaSquareSum += square.calculateArea(square.getLinearDimension());
                linearDimensionSquareSum += square.getLinearDimension();


            }
            if (figures[nr].name.equals("Kolo")) {
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
                circleSum += 1;
                areaCircleSum += circle.calculateArea(circle.getLinearDimension());
                linearDimensionCircleSum += circle.getLinearDimension();
            }
            if (figures[nr].name.equals("Trojkat")) {
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
                triangleSum += 1;
                areaTriangleSum += triangle.calculateArea(triangle.getLinearDimension());
                linearDimensionTriangleSum += triangle.getLinearDimension();
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent startIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(startIntent);
                return true;
            case R.id.item2:
                Intent statisticsIntent = new Intent(getApplicationContext(), StatisticsActivity.class);
                statisticsIntent.putExtra("squareSum",squareSum);
                statisticsIntent.putExtra("areaSquareSum",areaSquareSum);
                statisticsIntent.putExtra("linearDimensionSquareSum",linearDimensionSquareSum);
                statisticsIntent.putExtra("circleSum",circleSum);
                statisticsIntent.putExtra("areaCircleSum",areaCircleSum);
                statisticsIntent.putExtra("linearDimensionCircleSum",linearDimensionCircleSum);
                statisticsIntent.putExtra("triangleSum",triangleSum);
                statisticsIntent.putExtra("areaTriangleSum",areaTriangleSum);
                statisticsIntent.putExtra("linearDimensionTriangleSum",linearDimensionTriangleSum);
                startActivity(statisticsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public Figure[] generateFigures() {
        Intent intent = getIntent();
        int number = intent.getIntExtra("key1", 6);
        int min = intent.getIntExtra("key2", 0);
        int max = intent.getIntExtra("key3", 100);
//        int n = 10;
        Random generator = new Random();
        int[] numbers = new int[number];
        float[] values = new float[number];
        for (int i = 0; i < number; i += 1) {
            numbers[i] = generator.nextInt(3);
            //values[i] = generator.nextFloat();
            values[i] = (float)(Math.random() * (max - min + 1) + min);
        }
        Figure[] figures = new Figure[number];
        for (int i = 0; i < number; i += 1) {
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


