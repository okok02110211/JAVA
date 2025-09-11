package com.ohgiraffers.level01.basic.student.run;

import com.ohgiraffers.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] student = new StudentDTO[10];
        int i = 0;
        while(i < 10){
            student[i] = new StudentDTO();
            System.out.print("학년 : ");
            student[i].setGrade(sc.nextInt());
            System.out.print("반 : ");
            student[i].setClassroom(sc.nextInt());
            sc.nextLine();
            System.out.print("이름 : ");
            student[i].setName(sc.nextLine());
            System.out.print("국어점수 : ");
            student[i].setKor(sc.nextInt());
            System.out.print("영어점수 : ");
            student[i].setEng(sc.nextInt());
            System.out.print("수학점수 : ");
            student[i].setMath(sc.nextInt());
            i++;
            System.out.print("계속 추가할 겁니까? (y/n) : ");
            sc.nextLine();
            if (sc.next().charAt(0) == 'y') {
                continue;
            } else {
                break;
            }
        }
        for(StudentDTO person : student){
            if (person != null){
                System.out.println(person.getInformation());
            }
        }
    }

}
