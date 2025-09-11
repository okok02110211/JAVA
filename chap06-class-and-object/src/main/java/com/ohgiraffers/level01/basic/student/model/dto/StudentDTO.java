package com.ohgiraffers.level01.basic.student.model.dto;

public class StudentDTO {
    private int grade;
    private int classroom;
    private String Name;
    private int kor;
    private int eng;
    private int math;

    public StudentDTO() {}
    public StudentDTO(int grade, int classroom, String Name, int kor, int eng, int math) {
        this.grade = grade;
        this.classroom = classroom;
        this.Name = Name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getGrade() {
        return grade;
    }
    public int getClassroom(){
        return classroom;
    }
    public String getName(){
        return Name;
    }
    public int getKor(){
        return kor;
    }
    public int getEng(){
        return eng;
    }
    public int getMath(){
        return math;
    }
    public int average(){
        return (kor + eng + math) / 3;
    }

    public String getInformation(){
        return "학년 : " + grade + ", 반 : " + classroom + ", 이름 : " + Name + ", 국어점수 : "
                + kor + ", 영어점수 : " + eng + ", 수학점수 : " + math + " 평균 : " + this.average();
    }
}
