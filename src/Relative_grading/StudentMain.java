package Relative_grading;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentMain {

    static StudentService sserv = new StudentService();

    public static void main(String[] args) throws IOException {
        // open file input stream
        BufferedReader reader = new BufferedReader(new FileReader("student.csv"));

        // read file line by line

        String line = null;
        Scanner scanner = null;
        int index = 0;


        while ((line = reader.readLine()) != null) {
            Student_bio s = new Student_bio();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    s.setRollno(data);
                else if (index == 1)
                    s.setName(data);
                else if (index == 2)
                    s.setDept(data);
                else if (index == 3)
                    s.setMark1(Integer.parseInt(data));
                else if (index == 4)

                    s.setMark2(Integer.parseInt(data));
                else if (index == 5)
                    s.setMark3(Integer.parseInt(data));
                else
                    System.out.println("invalid data::" + data);
                index++;
            }
            index = 0;
            sserv.sList.add(s);
        }

        //close reader
        reader.close();
        sserv.relative_grade();
        Scanner in = new Scanner(System.in);
        int ch;
        int choice;
        do {
            System.out.println("STUDENT REPORT MENU:");
            System.out.println("\n1.insert student details \n2.search student details");
            System.out.println("3.delete student details \n4.display all student details \n5.modify \n6.relative grade range \n7.save changes to CSV file");
            System.out.println("Enter your choice(1-7):");
            ch = in.nextInt();

            switch (ch) {
                case 1: {
                    sserv.insert();

                    break;
                }
                case 2: {
                    sserv.search();

                    break;
                }

                case 3: {
                    sserv.delete();

                    break;
                }
                case 4: {
                    sserv.display();

                    break;
                }
                case 5: {
                    sserv.modify();

                    break;
                }
                case 6: {
                    sserv.show();

                    break;
                }
                case 7: {
                    Student_bio ins = new Student_bio();
                    String csv = "C:\\Users\\Kachayappan\\Desktop\\relative grading system\\output.csv";
                    CSVWriter writer = new CSVWriter(new FileWriter(csv));
                    List<String[]> data = new ArrayList<String[]>();
                    for (int i = 0; i < sserv.sList.size(); i++) {
                        ins = sserv.sList.get(i);
                        data.add(new String[]{ins.getRollno(), ins.getName(), ins.getDept(), Integer.toString(ins.getMark1()), Integer.toString(ins.getMark2()), Integer.toString(ins.getMark3()), ins.getGrade1(), ins.getGrade2(), ins.getGrade3()});
                    }
                    writer.writeAll(data);
                    System.out.println("\n Data saved successfully to csv file");
                    writer.close();


                    break;
                }

                default:
                    System.out.println("\nInvalid case:");
            }
            System.out.println("\nDo you want to continue(1-yes,0-no): ");
            choice = in.nextInt();
        } while (choice == 1);


    }

}
