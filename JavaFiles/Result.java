package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.company.Response.grade;
import static com.company.Response.grading;

abstract class resultMethods{
    static void viewRemarks(String student_name,String student_roll) throws IOException, InterruptedException {}
}

public class Result extends resultMethods{

    String StuName = Student.stu_name;
    String StuID = Student.stu_id;
    float Marks = grade;
    String Grades = grading;


    static void viewRemarks(String student_name,String student_roll) throws IOException, InterruptedException {

        student_name = Student.stu_name;
        student_roll = Student.stu_roll;

        String temp_n = student_roll+student_name+".txt";
        File r_file = new File(temp_n);
        String lines;
        Scanner r = null;
        try {
            r = new Scanner(r_file);
        }
        catch (FileNotFoundException e) {
            System.out.println("No remarks given yet!");
        }
        catch (NullPointerException e) {
            System.out.println("No file found!");
        }
        while (r.hasNextLine()){
            lines = r.nextLine();
            System.out.println(lines);
        }
        Quiz.askStudent();
    }
}
