package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

abstract class quizMethods{

    void setQuiz(){}
    static void dltInfoFile(){}
    static void writeInfoFile(String s){}
    static void dltFile(){}
    static void writeFile(){}
    static void dltansFile(){}
    static void writeAnsFile(){}
    static void dltrespFile(){}
    static void writeResponse(){}
    static void dltmarkFile(){}
    static void writeMarkFile(){}
    static void topic(){}
    static void askTeacher() throws InterruptedException, IOException {}
    static void askStudent() throws InterruptedException, IOException {}
}

public class Quiz extends quizMethods{

    public Quiz() {
    }

    static Scanner sc = new Scanner(System.in);
    static File info_file = new File("Quiz_details.txt");

    public static String QuizID  ;
    public static String QuizName;
    public static String Duration;
    public static int NoOfQuestions;
    static String Topic;

    public static String file;
    public static String ansFile;
    public static String responseFile;
    public static String markFile;


    void setQuiz() {
        System.out.print("Give quiz name: ");
        QuizName = sc.nextLine();
        writeInfoFile("Quiz name: "+QuizName);

        NoOfQuestions = Question.n;
        writeInfoFile("No of questions: "+NoOfQuestions);

        System.out.print("Give the duration of this quiz in hrs(write as a string (eg. two hrs)): ");
        Duration = sc.nextLine();
        writeInfoFile("Duration: "+Duration);

        QuizID = QuizName+NoOfQuestions;
        writeInfoFile("Quiz Id: "+QuizID+Teacher.t_id);
    }

    static void dltInfoFile() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(info_file,false)));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void writeInfoFile(String s){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(info_file, true)));
            out.println(s);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void dltFile() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file,false)));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void dltansFile() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ansFile,false)));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void dltrespFile() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(responseFile,false)));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void dltmarkFile() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(markFile,false)));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void writeFile(String s) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.println(s);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void writeAnsFile(String s) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ansFile, true)));
            out.println(s);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void writeResponse(String s) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(responseFile, true)));
            out.println(s);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void writeMarkFile(int s) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(markFile, true)));
            out.println(s);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static class InvalidPasswordException extends Throwable {
        public InvalidPasswordException() {
        }
    }

    public static void topic() {

        System.out.println("Select a topic:\n Input/Output(IO)\n Flow Control(fc)\n Operators(op)\n String(string)\n Arrays(array)\n OOP Concepts(oopc)\n Inheritance(inher)\n Abstraction(abs)\n Encapsulation(encap)\n Polymorphism(poly)\n Construction(con)\n Methods(mth)\n Interfaces(inter)\n ");
        Topic = sc.nextLine();
        switch (Topic) {
            case "IO":
                file = "io.txt";
                ansFile = "io_ans.txt";
                responseFile = "io_resp.txt";
                markFile = "io_mark.txt";

                break;
            case "fc":
                file = "flow_control.txt";
                ansFile = "flow_control_ans.txt";
                responseFile = "flow_control_resp.txt";
                markFile = "flow_control_mark.txt";

                break;
            case "op":
                file = "operators.txt";
                ansFile = "operators_ans.txt";
                responseFile = "operators_resp.txt";
                markFile = "operators_mark.txt";

                break;
            case "string":
                file = "strings.txt";
                ansFile = "strings_ans.txt";
                responseFile = "strings_resp.txt";
                markFile = "strings_mark.txt";

                break;
            case "array":
                file = "arrays.txt";
                ansFile = "arrays_ans.txt";
                responseFile = "arrays_resp.txt";
                markFile = "arrays_mark.txt";

                break;
            case "oopc":
                file = "OOP_Concepts.txt";
                ansFile = "OOP_Concepts_ans.txt";
                responseFile = "OOP_Concepts_resp.txt";
                markFile = "OOP_Concepts_mark.txt";

                break;
            case "inher":
                file = "inheritance.txt";
                ansFile = "inheritance_ans.txt";
                responseFile = "inheritance_resp.txt";
                markFile = "inheritance_mark.txt";

                break;
            case "abs":
                file = "abstraction.txt";
                ansFile = "abstraction_ans.txt";
                responseFile = "abstraction_resp.txt";
                markFile = "abstraction_mark.txt";

                break;
            case "encap":
                file = "encapsulation.txt";
                ansFile = "encapsulation_ans.txt";
                responseFile = "encapsulation_resp.txt";
                markFile = "encapsulation_mark.txt";

                break;
            case "poly":
                file = "polymorphism.txt";
                ansFile = "polymorphism_ans.txt";
                responseFile = "polymorphism_resp.txt";
                markFile = "polymorphism_mark.txt";

                break;
            case "con":
                file = "constructors.txt";
                ansFile = "constructors_ans.txt";
                responseFile = "constructors_resp.txt";
                markFile = "constructors_mark.txt";

                break;
            case "mth":
                file = "methods.txt";
                ansFile = "methods_ans.txt";
                responseFile = "methods_resp.txt";
                markFile = "methods_mark.txt";

                break;
            case "inter":
                file = "interfaces.txt";
                ansFile = "interfaces_ans.txt";
                responseFile = "interfaces_resp.txt";
                markFile = "interfaces_mark.txt";

                break;
            default:
                try {
                    throw new InvalidTopicException();
                } catch (InvalidTopicException e) {
                    e.printStackTrace();
                    System.exit(1);

                }
        }
    }

    static void askTeacher() throws InterruptedException, IOException {
        System.out.println("Do you want to set another quiz [q]? \nDo you want to check more results [c]? \nDo you want to give more remarks [r]? \nFor exiting [exit]");
        String a = sc.nextLine();
        switch(a){
            case("q") ->{
                TimeUnit.SECONDS.sleep(1);
                Quiz.topic();
                TimeUnit.SECONDS.sleep(1);
                Teacher.manageQuiz();
            }
            case("c") ->{
                TimeUnit.SECONDS.sleep(1);
                Teacher.declareResult();
            }
            case("r") ->{
                TimeUnit.SECONDS.sleep(1);
                Teacher.giveRemarks();
            }
            case ("exit") ->{
                TimeUnit.SECONDS.sleep(1);
                System.exit(1);
            }
            default -> {
                System.out.println("That means you chose to exit!");
                TimeUnit.SECONDS.sleep(1);
                System.exit(1);
            }
        }
    }


    static void askStudent() throws InterruptedException, IOException {

        System.out.println("Do you want to give another quiz [q]? \nDo you want to check results [c]? \nDo you want to see remarks [r]? \nFor exiting [exit]");
        String a = sc.nextLine();
        switch(a){
            case("q") ->{
                TimeUnit.SECONDS.sleep(1);
                Quiz.topic();
                System.out.println("The quiz starts in 5 seconds");
                TimeUnit.SECONDS.sleep(5);
                Student.giveExam();
            }

            case("c") ->{
                Student.checkResult();
            }

            case("r") ->{
                TimeUnit.SECONDS.sleep(1);
                Result.viewRemarks(Student.stu_roll,Student.stu_name);
                System.out.println("\nHave a nice day!");
            }

            case ("exit") ->{
                System.out.println("You chose to exit");
                TimeUnit.SECONDS.sleep(1);
                System.exit(1);
            }

            default -> {
                System.out.println("That means you chose to exit!");
                TimeUnit.SECONDS.sleep(1);
                System.exit(1);
            }
        }
    }


    public static class InvalidTopicException extends Throwable {
        public InvalidTopicException() {
        }
    }
}
