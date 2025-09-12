package com.ohgiraffers.level01.basic;

import java.util.Arrays;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index;

    public void addShape(Shape shape) {
        if (index == shapes.length) {
            Shape[] newShapes = Arrays.copyOf(shapes, shapes.length*2);
            shapes = newShapes;
        }
        shapes[index] = shape;
        index++;
        /* 배열에 전달 된 Shape를 추가. 단, 배열의 크기가 부족할 경우 2배로 늘려서 추가. */
    }

    public void removeShape(Shape shape) {
        for (int i = 0 ; i < index ; i++){
            if (shapes[i] == shape){
                shapes[i] = null;
                for (int j = i; j < index - 1; j++) {
                    shapes[j] = shapes[j + 1];
                }
                shapes[--index] = null;
                break;
            }
        }
        /* 배열에서 전달 된 Shape를 찾아 제거. 단, 제거 된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
    }

    public void printAllShapes() {
        for (int i = 0 ; i < index ; i++){
            if (shapes[i] != null){
                System.out.println(shapes[i].toString());
            }
        }
        /* 배열에 저장 된 모든 도형의 이름, 넓이, 둘레를 출력 */
    }

    public double getTotalArea() {
        double area = 0;
        /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
        for (int i = 0 ; i < index ; i++){
            if (shapes[i] != null){
                area += shapes[i].calculateArea();
            }
        }
        return area;
    }

    public double getTotalPerimeter() {
        double perimeter = 0;
        /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
        for (int i = 0 ; i < index ; i++){
            if (shapes[i] != null){
                perimeter += shapes[i].calculatePerimeter();
            }
        }
        return perimeter;
    }
}
