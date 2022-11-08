package Relative_grading;

import com.opencsv.CSVWriter;

import javax.sound.sampled.Line;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

import java.io.Writer;


public class StudentService {


    static List<Student_bio> sList = new ArrayList<>();
    static int mu[]=new int[3];
    static double sigma[]=new double[3];
    static double  eqn1[]=new double[3];
    static double  eqn2[]=new double[3];
    static double  eqn3[]=new double[3];
    static double  eqn4[]=new double[3];
    static double  eqn5[]=new double[3];



    public StudentService()
    {
    }

    public void insert() {

        Student_bio ins = new Student_bio();
        Scanner inscan = new Scanner(System.in);
        System.out.println("Enter the roll No:");
        ins.setRollno(inscan.nextLine());
        System.out.println("Enter the Name:");
        ins.setName(inscan.nextLine());
        System.out.println("Enter the department:");
        ins.setDept(inscan.nextLine());
        System.out.println("Enter Mark1:");
        ins.setMark1(inscan.nextInt());
        System.out.println("Enter the Mark2:");
        ins.setMark2(inscan.nextInt());
        System.out.println("Enter the Mark3:");
        ins.setMark3(inscan.nextInt());
        sList.add(ins);

        relative_grade();
        ins = sList.get(sList.size() - 1);
        System.out.println("inserted details:");
        System.out.println("Name: " + ins.name + "\nRollno: " + ins.rollno + "\nDepartment: " + ins.dept + "\nmark 1: " + ins.mark1 + "\nmark 2: " + ins.mark2 + "\nmark 3: " + ins.mark3);
        System.out.println("Grade 1 = "+ins.getGrade1()+"\nGrade 2 = "+ins.getGrade2()+"\nGrade 3 = "+ins.getGrade3());
    }

    public void search() {
        Student_bio ins = new Student_bio();
        Scanner inscan = new Scanner(System.in);
        String rno;
        System.out.println("Enter the rollno to search:");
        rno = inscan.nextLine();
        inscan.nextLine();
        int f=0;
        for (int i = 0; i < sList.size(); i++) {
            ins=sList.get(i);
            if ((ins.getRollno()).equals(rno)) {
                System.out.println("\n********searched query details:********");
                System.out.println("Name: " + ins.name + "\nRollno: " + ins.rollno + "\nDepartment: " + ins.dept + "\nmark 1: " + ins.mark1 + "\nmark 2: " + ins.mark2 + "\nmark 3: " + ins.mark3);
                System.out.println("Grade 1 = "+ins.getGrade1()+"\nGrade 2 = "+ins.getGrade2()+"\nGrade 3 = "+ins.getGrade3());
                f=1;
                break;
            }


        }
        if(f==0)
            System.out.println("searched data not found!!");



    }

    public void delete() {
        Student_bio ins = new Student_bio();
        Scanner inscan = new Scanner(System.in);
        String rno;
        System.out.println("Enter the rollno to search:");
        rno = inscan.nextLine();
        int f=0;
        String ch;
        for (int i = 0; i < sList.size(); i++) {
            ins=sList.get(i);
            if ((ins.getRollno()).equals(rno)) {
                System.out.println("\n********student detail to be deleted:********");
                System.out.println("Name: " + ins.name + "\nRollno: " + ins.rollno + "\nDepartment: " + ins.dept + "\nmark 1: " + ins.mark1 + "\nmark 2: " + ins.mark2 + "\nmark 3: " + ins.mark3);
                System.out.println("Grade 1 = "+ins.getGrade1()+"\nGrade 2 = "+ins.getGrade2()+"\nGrade 3 = "+ins.getGrade3());
                f=1;
                System.out.println("Are you sure to delete the info(Y/N):");
                ch=inscan.nextLine();
                if(ch.equals("Y")||ch.equals("y"))
                    sList.remove(sList.indexOf(ins));
                    System.out.println("\ndata deleted");
                break;
            }


        }
        if(f==0)
            System.out.println("data not found!!");



        relative_grade();
    }

    public void display() {
        relative_grade();
        Student_bio ins = new Student_bio();
        for (int i = 0; i < sList.size(); i++) {
            ins = sList.get(i);
            System.out.println("\n********student "+(i+1)+" ********");
            System.out.println("Name: " + ins.name + "\nRollno: " + ins.rollno + "\nDepartment: " + ins.dept + "\nmark 1: " + ins.mark1 + "\nmark 2: " + ins.mark2 + "\nmark 3: " + ins.mark3);
            System.out.println("Grade 1 = "+ins.getGrade1()+"\nGrade 2 = "+ins.getGrade2()+"\nGrade 3 = "+ins.getGrade3());
        }
    }
    public void show()
    {
        relative_grade();
        for(int i=0;i<3;i++) {
            System.out.println("Subject - "+i+1);
            System.out.println("\nmu "+mu[1]);
            System.out.println(("\nsigma "+sigma[i]));
            System.out.println(("\npass criteria "+eqn1[i]));
            System.out.println(("\ncriteria 1 "+eqn2[i]));
            System.out.println(("\ncriteria 2 "+eqn3[i]));
            System.out.println(("\ncriteria 3 "+eqn4[i]));
            System.out.println(("\ncriteria 4 "+eqn5[i]));
        }

    }

    public void modify()
    {
        Student_bio ins = new Student_bio();
        Scanner in = new Scanner(System.in);
        String rno;
        System.out.println("Enter the rollno to search:");
        rno = in.nextLine();
        int f=0;
        for (int i = 0; i < sList.size(); i++) {
            ins=sList.get(i);
            if ((ins.getRollno()).equals(rno)) {
                System.out.println("\n********student detail modify:********");
                System.out.println("Enter new roll No:");
                ins.setRollno(in.nextLine());
                System.out.println("Enter new Name:");
                ins.setName(in.nextLine());
                System.out.println("Enter new department:");
                ins.setDept(in.nextLine());
                System.out.println("Enter new Mark1:");
                ins.setMark1(in.nextInt());
                System.out.println("Enter new Mark2:");
                ins.setMark2(in.nextInt());
                System.out.println("Enter new Mark3:");
                ins.setMark3(in.nextInt());


                f=1;
                sList.set(i,ins);
                break;
            }


        }
        if(f==0)
            System.out.println("data not found!!");



        relative_grade();
    }



    public void relative_grade() {
        Student_bio ins = new Student_bio();


        for (int i = 0; i < sList.size(); i++) {
            ins = sList.get(i);

            mu[0] = mu[0] + ins.getMark1();

        }
        for (int i = 0; i < sList.size(); i++) {
            ins = sList.get(i);

            mu[1] = mu[1] + ins.getMark2();

        }
        for (int i = 0; i < sList.size(); i++) {
            ins = sList.get(i);

            mu[2] = mu[2] + ins.getMark3();

        }
        for (int i = 0; i < 3; i++)
            mu[i] = mu[i] / sList.size();
        for (int i = 0; i < sList.size(); i++) {
            ins = sList.get(i);
            sigma[0] = sigma[0] + Math.pow((ins.getMark1() - mu[0]), 2);


        }
        for (int i = 0; i < sList.size(); i++) {
            ins = sList.get(i);
            sigma[1] = sigma[1] + Math.pow((ins.getMark2() - mu[1]), 2);


        }
        for (int i = 0; i < sList.size(); i++) {
            ins = sList.get(i);
            sigma[2] = sigma[2] + Math.pow((ins.getMark3() - mu[2]), 2);


        }


        for (int i = 0; i < 3; i++) {
            sigma[i] = sigma[i] / sList.size();
            sigma[i] = Math.sqrt(sigma[i]);
        }
        for (int i = 0; i < 3; i++) {
            eqn1[i] = mu[i] - (1.8 * sigma[i]);
            eqn2[i] = mu[i] + (1.5 * sigma[i]);
            eqn3[i] = mu[i] + (0.52 * sigma[i]);
            eqn4[i] = mu[i] - (0.25 * sigma[i]);
            eqn5[i] = mu[i] - (1.08 * sigma[i]);
        }


        for (int i=0;i< sList.size(); i++)
        {
            ins = sList.get(i);
            if((ins.getMark1()<Math.min(eqn1[0],50)))
            {
                ins.setGrade1("F");
                continue;
            }

            if(ins.getMark1()>=eqn2[0])
            {
                ins.setGrade1("O");
                continue;
            }
            else if((ins.getMark1()<eqn2[0])&&(ins.getMark1()>=eqn3[0]))
            {
                ins.setGrade1("A+");
                continue;
            }
            else if((ins.getMark1()<eqn3[0])&&(ins.getMark1()>=eqn4[0]))
            {
                ins.setGrade1("A");
                continue;
            }
            else if((ins.getMark1()<eqn4[0])&&(ins.getMark1()>=eqn5[0]))
            {
                ins.setGrade1("B+");
                continue;
            }
            else if((ins.getMark1()<eqn5[0]))
            {
                ins.setGrade1("B");
                continue;
            }
        }

        for (int i=0;i< sList.size(); i++)
        {
            ins = sList.get(i);
            if((ins.getMark2()<Math.min(eqn1[1],50)))
            {
                ins.setGrade2("F");
                continue;
            }

            if(ins.getMark2()>=eqn2[1])
            {
                ins.setGrade2("O");
                continue;
            }
            else if((ins.getMark2()<eqn2[1])&&(ins.getMark2()>=eqn3[1]))
            {
                ins.setGrade2("A+");
                continue;
            }
            else if((ins.getMark2()<eqn3[1])&&(ins.getMark2()>=eqn4[1]))
            {
                ins.setGrade2("A");
                continue;
            }
            else if((ins.getMark2()<eqn4[1])&&(ins.getMark2()>=eqn5[1]))
            {
                ins.setGrade2("B+");
                continue;
            }
            else if((ins.getMark2()<eqn5[1]))
            {
                ins.setGrade2("B");
                continue;
            }
        }
        for (int i=0;i< sList.size(); i++)
        {
            ins = sList.get(i);
            if((ins.getMark3()<Math.min(eqn1[2],50)))
            {
                ins.setGrade3("F");
                continue;
            }

            if(ins.getMark3()>=eqn2[2])
            {
                ins.setGrade3("O");
                continue;
            }
            else if((ins.getMark3()<eqn2[2])&&(ins.getMark3()>=eqn3[2]))
            {
                ins.setGrade3("A+");
                continue;
            }
            else if((ins.getMark3()<eqn3[2])&&(ins.getMark3()>=eqn4[2]))
            {
                ins.setGrade3("A");
                continue;
            }
            else if((ins.getMark3()<eqn4[2])&&(ins.getMark1()>=eqn5[2]))
            {
                ins.setGrade3("B+");
                continue;
            }
            else if((ins.getMark3()<eqn5[2]))
            {
                ins.setGrade3("B");
                continue;
            }
        }


    }
}
