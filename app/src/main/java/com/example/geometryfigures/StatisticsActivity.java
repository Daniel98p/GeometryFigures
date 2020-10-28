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
        String strAreaSquareSum = Double.toString(Math.round(areaSquareSum * 100)/100.0);
        String strLinearDimensionSquareSum = Double.toString(Math.round(linearDimensionSquareSum * 100)/100.0);
        String strCircleSum = Integer.toString(circleSum);
        String strAreaCircleSum = Double.toString(Math.round(areaCircleSum * 100)/100.0);
        String strLinearDimensionCircleSum = Double.toString(Math.round(linearDimensionCircleSum * 100)/100.0);
        String strTriangleSum = Integer.toString(triangleSum);
        String strAreaTriangleSum = Double.toString(Math.round(areaTriangleSum * 100)/100.0);
        String strLinearDimensionTriangleSum = Double.toString(Math.round(linearDimensionTriangleSum * 100)/100.0);
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