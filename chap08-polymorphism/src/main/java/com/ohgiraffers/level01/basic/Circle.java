package com.ohgiraffers.level01.basic;

import static java.lang.Math.PI;

public class Circle extends Shape implements Resizable{
    double radius;
    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double factor) {
        this.radius = factor * radius;
    }

    @Override
    public String toString(){
        return "Shape: Circle \nArea: " + calculateArea() + "\nPerimeter: " + calculatePerimeter();
    }

    @Override
    double calculateArea() {
        return PI*(radius*radius);
    }

    @Override
    double calculatePerimeter() {
        return PI*(2*radius);
    }
}
