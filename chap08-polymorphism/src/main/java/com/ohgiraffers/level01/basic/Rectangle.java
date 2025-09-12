package com.ohgiraffers.level01.basic;

public class Rectangle extends Shape implements Resizable{
    int width;
    int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public String toString(){
        return "Shape: Rectangle \nArea: " + calculateArea() + "\nPerimeter:" + calculatePerimeter();
    }

    @Override
    public void resize(double factor) {
        this.width = (int) (factor * width);
        this.height = (int) (factor * height);
    }
    @Override
    double calculateArea() {

        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return 2*width+2*height;
    }
}
