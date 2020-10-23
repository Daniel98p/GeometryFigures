package com.example.geometryfigures.figures;


public class Triangle extends Figure {
    public Triangle(double linearDimension) {
        this.linearDimension = linearDimension;
        this.feature = "Bok";
        this.name = "Trojkat";
    }


    @Override
    public double calculateArea(double linearDimension) {
        return Math.round((linearDimension * Math.sqrt(3) / 4) * 100) / 100.0;
    }


}
