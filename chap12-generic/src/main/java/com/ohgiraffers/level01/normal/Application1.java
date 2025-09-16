package com.ohgiraffers.level01.normal;

import java.util.Arrays;

public class Application1 {

    public static void main(String[] args) {
//        두 개의 요소를 교환하는 제네릭 메서드 swap을 작성한다.
//        Application1 클래스 내에 static 메소드로 작성하며 배열과 교환할 인덱스 두 개를 매개변수로 받아 처리한다

        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("swap 전 : " + Arrays.toString(intArray));  // [1, 2, 3, 4, 5]
        swap(intArray, 1, 3);
        System.out.println("swap 후 : " + Arrays.toString(intArray));  // [1, 4, 3, 2, 5]

        String[] strArray = {"A", "B", "C", "D"};
        System.out.println("swap 전 : " + Arrays.toString(strArray));  // [A, B, C, D]
        swap(strArray, 0, 2);
        System.out.println("swap 후 : " + Arrays.toString(strArray));  // [C, B, A, D]
    }

    public static <T> void swap(T[] array,  int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
