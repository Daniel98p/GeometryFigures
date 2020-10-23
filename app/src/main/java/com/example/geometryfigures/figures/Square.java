package com.example.geometryfigures.figures;

public class Square extends Figure {
    public Square(double linearDimension) {
        this.linearDimension = linearDimension;
        this.feature = "Bok";
        this.name = "Kwadrat";
    }

    @Override
    public double calculateArea(double linearDimension) {
        return Math.round((linearDimension * linearDimension / 2) * 100) / 100.0;
    }


}

