package com.example.geometryfigures.figures;

public abstract class Figure {
    public double linearDimension;
    public String feature;
    public String name;

    public double getLinearDimension() {
        return Math.round(linearDimension * 100) /100.0;
    }

    public abstract double calculateArea(double linearDimension);
}
