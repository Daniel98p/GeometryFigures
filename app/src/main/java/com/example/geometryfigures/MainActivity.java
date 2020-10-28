package com.example.geometryfigures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import com.example.geometryfigures.figures.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;
import java.util.TreeMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
    View viewClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ln = (LinearLayout) findViewById(R.id.LinearLayout1);
//        TextView tv5 = findViewById(R.id.textView5);
//        registerForContextMenu(ln);
        Button delete = (Button) findViewById(R.id.Delete);


        List<Figure> figures = generateFigures();
        int numberElements = figures.size();
        for (int nr = 0; nr < numberElements; nr = nr + 1) {
//            if (figures[nr] == null) {
//                continue;
//            }
            if (figures.get(nr).name.equals("Kwadrat")) {
                Square square = (Square) figures.get(nr);
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
                registerForContextMenu(layout);


            }
            if (figures.get(nr).name.equals("Kolo")) {
                Circle circle = (Circle) figures.get(nr);
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
                registerForContextMenu(layout);
            }
            if (figures.get(nr).name.equals("Trojkat")) {
                Triangle triangle = (Triangle) figures.get(nr);
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
                registerForContextMenu(layout);
            }
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout ln = (LinearLayout) findViewById(R.id.LinearLayout1);
                    ln.removeAllViews();
                }
            });

        }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        viewClicked = v;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.duplicate:
                duplicateLayout();
                return true;
            case R.id.delete:
                ((ViewGroup) viewClicked.getParent()).removeView(viewClicked);
//                Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.edit:
                Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
//                Intent editIntent = new Intent(getApplicationContext(), EditActivity.class);
//                editIntent.put
//                startActivity(editIntent);
//                Intent intentFromEdit =  getIntent();
//                double ld = intentFromEdit.getDoubleExtra("number", 1.0);
//                TextView tv3FromClickedView = viewClicked.findViewById(R.id.textView7);
//                TextView tv1FromClickedView = viewClicked.findViewById(R.id.textView5);
//                String strLd = Double.toString(ld);
//                TextView tv2FromClickedView = viewClicked.findViewById(R.id.textView6);
//                tv2FromClickedView.setText(strLd);
//                if (tv3FromClickedView.getText() == "Bok"){
//                    Square square = new Square(ld);
//                    double area = square.calculateArea(ld);
//                    String strArea = Double.toString(area);
//                    tv1FromClickedView.setText(strArea);
//                }
//                else if (tv3FromClickedView.getText() == "Bok trojkata"){
//                    Triangle triangle = new Triangle(ld);
//                    double area = triangle.calculateArea(ld);
//                    String strArea = Double.toString(area);
//                    tv1FromClickedView.setText(strArea);
//                }
//                else {
//                    Circle circle = new Circle(ld);
//                    double area = circle.calculateArea(ld);
//                    String strArea = Double.toString(area);
//                    tv1FromClickedView.setText(strArea);
//                }
//                return true;
            default:
                return super.onContextItemSelected(item);
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
            case R.id.item3:
                Intent informationIntent = new Intent(getApplicationContext(), InformationActivity.class);
                startActivity(informationIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public List<Figure> generateFigures() {
        Intent intent = getIntent();
        int number = intent.getIntExtra("key1", 6);
        int min = intent.getIntExtra("key2", 0);
        int max = intent.getIntExtra("key3", 100);
        boolean clicked = intent.getBooleanExtra("key4", false);
        if (clicked){
            number += 1;
        }
//        int n = 10;
        Random generator = new Random();
        int[] numbers = new int[number];
        float[] values = new float[number];
        for (int i = 0; i < number; i += 1) {
            numbers[i] = generator.nextInt(3);
            //values[i] = generator.nextFloat();
            values[i] = (float)(Math.random() * (max - min + 1) + min);
        }
        List<Figure>figures = new ArrayList<Figure>();
        for (int i = 0; i < number; i += 1) {
            if (numbers[i] == 0) {
                figures.add(new Square(values[i]));
            }
            if (numbers[i] == 1) {
                figures.add(new Triangle(values[i]));

            }
            if (numbers[i] == 2) {
                figures.add(new Circle(values[i]));

            }
        }
        return figures;

    }
    public void duplicateLayout(){
        LinearLayout ln = (LinearLayout) findViewById(R.id.LinearLayout1);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.second_layout, ln, false);
        TextView tv = (TextView) layout.findViewById(R.id.textView5);
        TextView tvFromClickedView = viewClicked.findViewById(R.id.textView5);
        tv.setText(tvFromClickedView.getText());
        TextView tv2 = (TextView) layout.findViewById(R.id.textView6);
        TextView tv2FromClickedView = viewClicked.findViewById(R.id.textView6);
        tv2.setText(tv2FromClickedView.getText());
        TextView tv3 = (TextView) layout.findViewById(R.id.textView7);
        TextView tv3FromClickedView = viewClicked.findViewById(R.id.textView7);
        tv3.setText(tv3FromClickedView.getText());
        ImageView iv = (ImageView) layout.findViewById(R.id.imageView);
//        ImageView ivFromClickedView = viewClicked.findViewById(R.id.imageView);
        if (tv3.getText() == "Bok"){
            iv.setImageResource(R.drawable.kwadrat);
        }
        else if (tv3.getText() == "Bok trojkata"){
            iv.setImageResource(R.drawable.trojkat);
        }
        else {
            iv.setImageResource(R.drawable.kolo);
        }

        ln.addView(layout);


    }
}


