package com.example.geometryfigures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Intent statisticsIntent = getIntent();
        int squareSum = statisticsIntent.getIntExtra("squareSum", 0);
        double areaSquareSum = statisticsIntent.getDoubleExtra("areaSquareSum",0.0);
        double linearDimensionSquareSum = statisticsIntent.getDoubleExtra("linearDimensionSquareSum",0.0);
        int circleSum = statisticsIntent.getIntExtra("circleSum", 0);
        double areaCircleSum = statisticsIntent.getDoubleExtra("areaCircleSum",0.0);
        double linearDimensionCircleSum = statisticsIntent.getDoubleExtra("linearDimensionCircleSum",0.0);
        int triangleSum = statisticsIntent.getIntExtra("triangleSum", 0);
        double areaTriangleSum = statisticsIntent.getDoubleExtra("areaTriangleSum",0.0);
        double linearDimensionTriangleSum =  statisticsIntent.getDoubleExtra("linearDimensionTriangleSum",0.0);
        String strSquareSum = Integer.toString(squareSum);
        String strAreaSquareSum = Double.toString(areaSquareSum);
        String strLinearDimensionSquareSum = Double.toString(linearDimensionSquareSum);
        String strCircleSum = Integer.toString(circleSum);
        String strAreaCircleSum = Double.toString(areaCircleSum);
        String strLinearDimensionCircleSum = Double.toString(linearDimensionCircleSum);
        String strTriangleSum = Integer.toString(triangleSum);
        String strAreaTriangleSum = Double.toString(areaTriangleSum);
        String strLinearDimensionTriangleSum = Double.toString(linearDimensionTriangleSum);
        String resultStringSquare = "Square      " + strSquareSum + "                           " + strAreaSquareSum + "                       " + strLinearDimensionSquareSum;
        String resultStringCircle = "Circle      " + strCircleSum + "                           " + strAreaCircleSum + "                       " + strLinearDimensionCircleSum;
        String resultStringTriangle = "Triangle      " + strTriangleSum + "                         " + strAreaTriangleSum + "                       " + strLinearDimensionTriangleSum;

        TextView tv8 = (TextView) findViewById(R.id.textView8);
        TextView tv9 = (TextView) findViewById(R.id.textView9);
        TextView tv10 = (TextView) findViewById(R.id.textView10);

        tv8.setText(resultStringSquare);
        tv9.setText(resultStringCircle);
        tv10.setText(resultStringTriangle);


    }
}