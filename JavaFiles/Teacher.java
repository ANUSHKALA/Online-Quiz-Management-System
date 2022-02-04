package com.company;

import java.io.*;
import java.util.Scanner;

import static com.company.Quiz.dltInfoFile;

abstract class teacherMethods{

    static void manageQuiz() {}
    static void declareResults(){}
    static void giveRemarks(){}
}


public class Teacher{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String t_name;
    static String t_id;
    String t_pw;
    static File remark_file;

    static String name_for_remark;
    static String roll_for_remark;

    void tech_login() throws IOException {

        //Logging in
        dltInfoFile();

        System.out.print("Enter teacher name(str): ");
            t_name = br.readLine();
            System.out.print("Enter teacher id(str): ");
            t_id =br.readLine();
            System.out.print("Enter teacher password(str): ");
            t_pw = br.readLine();
            String sd_pw = t_name + t_id;
        if (t_pw.equals(sd_pw)) {
            System.out.println("                                                                      LOGIN GRANTED                                             ");
        } else {
            while(!t_pw.equals((sd_pw))){

                try {
                    throw new Quiz.InvalidPasswordException();
                } catch (Quiz.InvalidPasswordException e) {
                    System.out.println("Enter password again: ");
                    t_pw = br.readLine();
                }

            }
            //error for wrong password
            //password == name+id
        }
    }

    static void manageQuiz() throws IOException, InterruptedException {
        Question q = new Question();
        Quiz quiz = new Quiz();
        quiz.setQuiz();
        q.addQuiz();
        Quiz.askTeacher();
    }

    static void declareResult() throws IOException, InterruptedException {
        String name;
            System.out.println("Enter the name of the student whose result you wish to see \nOr type [exit] to quit ");
            System.out.print("Enter here: ");
            name = br.readLine();
            if(name.equals("exit")){
                System.exit(1);
            }
            else{
                System.out.print("Enter the roll number of the student: ");
                String sr = br.readLine();
                try{
                    File n_file = new File(name+sr+".txt");
                    String entry;
                    Scanner reader = new Scanner(n_file);
                    while (reader.hasNextLine()) {
                        entry = reader.nextLine();
                        System.out.println(entry);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(name+" did not give this quiz!");
                }
            }
        Quiz.askTeacher();
    }

    static void giveRemarks() throws IOException, InterruptedException {
        System.out.println("Enter the name of the student whom you want to give remarks! ");
        name_for_remark = br.readLine();
        System.out.println("Enter the id of the student: ");
        roll_for_remark = br.readLine();
        String temp_string = name_for_remark+roll_for_remark+".txt";
        remark_file = new File(temp_string);

        String lines;
        Scanner bfr = new Scanner(remark_file);
        while (bfr.hasNextLine()){
            lines = bfr.nextLine();
            System.out.println(lines);
        }

        System.out.println("Enter remarks: ");
        String remark = br.readLine();
        Response.replaceByRemark(remark);

        Quiz.askTeacher();
    }
}
