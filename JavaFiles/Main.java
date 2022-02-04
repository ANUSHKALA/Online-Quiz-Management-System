package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {


        Scanner sc = new Scanner(System.in);

        System.out.println("Are you a teacher or a student ? ");
        System.out.println("For TEACHER enter [t]");
        System.out.println("For STUDENT enter [s]");
        System.out.print("Enter here: ");
        String id = sc.nextLine();
        if (id.equals("s")){
            Student stu = new Student();
            System.out.println("Enter \n(1) For giving a Quiz! \n(2) For viewing results! \n(3) For viewing remarks! ");
            String choice = sc.nextLine();
            System.out.println("                         STUDENT LOGIN");
            TimeUnit.SECONDS.sleep(1);
            stu.stu_login();
            switch (choice){
                case "1" -> {
                    TimeUnit.SECONDS.sleep(1);
                    Quiz.topic();
                    System.out.println("The quiz starts in 5 seconds");
                    TimeUnit.SECONDS.sleep(5);
                    Student.giveExam();
                }

                case "2" -> {
                    Student.checkResult();
                }

                case "3" -> {
                    TimeUnit.SECONDS.sleep(1);
                    Result.viewRemarks(Student.stu_roll,Student.stu_name);
                    System.out.println("\nHave a nice day!");
                }
            }
        }
        else if(id.equals("t")){
            System.out.println("Enter \n(1) For setting a new Quiz! \n(2) For viewing results! \n(3) For giving remarks!");
            String choice = sc.nextLine();
            Teacher tech = new Teacher();
            System.out.println("                         TEACHER LOGIN");
            TimeUnit.SECONDS.sleep(1);

            tech.tech_login();
            switch (choice) {
                case "1" -> {
                    TimeUnit.SECONDS.sleep(2);
                    Quiz.topic();
                    TimeUnit.SECONDS.sleep(2);
                    Teacher.manageQuiz();
                }
                case "2" -> Teacher.declareResult();
                case "3" -> Teacher.giveRemarks();
                default -> System.out.println("This is not a valid choice:/ \nHave a good day:)");
            }
        }
        else{
            System.out.println("Not a valid identity!");
        }
    }
}





