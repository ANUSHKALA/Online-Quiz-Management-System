package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

abstract class studentMethods{
    void stu_login() throws IOException {}
    static void giveExam() throws IOException, InterruptedException {}
    static void checkResult() throws InterruptedException, IOException {}
}

public class Student extends studentMethods{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String stu_name;
    static String stu_roll;
    static String stu_id;
    String stu_pw;


    public Student() throws FileNotFoundException {
    }

    static void giveExam() throws IOException, InterruptedException {
        Response resp = new Response();
        resp.giveQuiz();
        Quiz.askStudent();

    }

    public void stu_login() throws IOException {

            System.out.print("Enter student name(str): ");
            stu_name  = br.readLine();

            System.out.print("Enter student roll number(int): ");
            stu_roll  = br.readLine();
        try {
            int x = Integer.parseInt(stu_roll);
        }catch(NumberFormatException e) {
            System.out.print("not a valid roll number, enter again ");
            stu_roll  = br.readLine();
        }

        System.out.print("Enter student id(str): ");
            stu_id = br.readLine();
            System.out.print("Enter student password(str): ");
            stu_pw = br.readLine();
            String sd_pw = stu_name +stu_roll+ stu_id;

            if (stu_pw.equals(sd_pw)) {
                System.out.println("                                                                      LOGIN GRANTED                                             ");
            } else {
                while(!stu_pw.equals((sd_pw))){

                    try {
                        throw new Quiz.InvalidPasswordException();
                    } catch (Quiz.InvalidPasswordException e) {
                        System.out.println("Enter password again: ");
                        stu_pw = br.readLine();
                    }

                }
                //error for wrong password
                //password == name+id
            }
        }



        static void checkResult() throws InterruptedException, IOException, FileNotFoundException {

            TimeUnit.SECONDS.sleep(1);
            System.out.println("        YOUR RESULT");
            TimeUnit.SECONDS.sleep(1);
            String lines;
            String name = Student.stu_name+Student.stu_roll+".txt";
            File r_file = new File(name);
            Scanner bfr = null;
            try {
                bfr = new Scanner(r_file);
            } catch (FileNotFoundException e) {
                System.out.println("Quizzes not attended!");;
            }catch(NullPointerException e){
                System.out.println(" ");
            }
            while (bfr.hasNextLine()){
                lines = bfr.nextLine();
                System.out.println(lines);
            }
            Quiz.askStudent();
        }
    }



