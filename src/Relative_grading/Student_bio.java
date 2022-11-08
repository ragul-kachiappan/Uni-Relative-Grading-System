package Relative_grading;
import java.io.Serializable;


public class Student_bio implements Serializable  {
    String name;
    String rollno;
    String dept;
    int mark1;
    int mark2;
    int mark3;
    String grade1;
    String grade2;
    String grade3;
    //char grades [];
    public Student_bio(){

    }

    public Student_bio(String name, String rollno,String dept,int mark1,int mark2,int mark3) {
        super();
        this.name = name;
        this.rollno = rollno;
        this.dept = dept;
        this.mark1 =  mark1;
        this.mark2 =  mark2;
        this.mark3 =  mark3;


    }
    public String getName() {
        return name     ;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRollno() {
        return rollno;
    }
    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept=dept;
    }
    public int getMark1() {
        return mark1;
    }
    public void setMark1(int mark) {
        this.mark1=mark;
    }
    public int getMark2() {
        return mark2;
    }
    public void setMark2(int mark) {
        this.mark2=mark;
    }
    public int getMark3() {
        return mark3;
    }
    public void setMark3(int mark) {
        this.mark3=mark;
    }
    public String getGrade1() {
        return grade1;
    }
    public void setGrade1(String grade) {
        this.grade1=grade;
    }
    public String getGrade2() {
        return grade2;
    }
    public void setGrade2(String grade) {
        this.grade2=grade;
    }
    public String getGrade3() {
        return grade3;
    }
    public void setGrade3(String grade) {
        this.grade3=grade;
    }

}
