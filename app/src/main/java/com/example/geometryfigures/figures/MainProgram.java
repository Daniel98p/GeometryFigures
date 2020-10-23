package com.example.geometryfigures.figures;

import java.util.Random;


public class MainProgram {
    public static void main(String[] args) {
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
                System.out.printf("Kwadrat o polu %.4f i boku %.4f %n", figures[i].calculateArea(figures[i].getLinearDimension()), figures[i].getLinearDimension());
            }
            if (numbers[i] == 1) {
                figures[i] = new Triangle(values[i]);
                System.out.printf("Trojkat o polu %.4f i boku %.4f %n", figures[i].calculateArea(figures[i].getLinearDimension()), figures[i].getLinearDimension());

            }
            if (numbers[i] == 2) {
                figures[i] = new Circle(values[i]);
                System.out.printf("Kolo o polu %.4f i promieniu %.4f %n", figures[i].calculateArea(figures[i].getLinearDimension()), figures[i].getLinearDimension());
            }
        }


    }
}
