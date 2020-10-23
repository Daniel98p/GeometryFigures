package com.example.geometryfigures.figures;

import static java.lang.Math.*;

public class Circle extends Figure {
    public Circle(double linearDimension) {
        this.linearDimension = linearDimension;
        this.feature = "Promien";
        this.name = "Kolo";
    }

    @Override
    public double calculateArea(double linearDimension) {
        return Math.round(( PI * linearDimension * linearDimension) * 100) / 100.0;
    }
}
