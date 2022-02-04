package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

abstract  class questionMethods{
    void addQuiz() throws IOException {}
}

public class Question extends questionMethods{

Scanner sc = new Scanner(System.in);

    int total ;
    public static int start = 1;
    public static int end = 6;
    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> op1 = new ArrayList<>();
    ArrayList<String> op2 = new ArrayList<>();
    ArrayList<String> op3 = new ArrayList<>();
    ArrayList<String> op4 = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();
    ArrayList<Integer> Qmarks = new ArrayList<>();
    static int n;

    void addQuiz() throws IOException {
        System.out.print("Enter number of questions: ");
        n = sc.nextInt();
        Quiz.dltFile();
        Quiz.dltansFile();
        Quiz.dltmarkFile();

        //Response.readInfo();

        for (int i =0;i<n;i++){

            sc.nextLine();
            System.out.print("Enter question "+(i+1)+":");
            String que = sc.nextLine();
            question.add(que);
            Quiz.writeFile("Q"+(i+1)+que);

            System.out.print("(a) ");
            String option1 = sc.nextLine();
            op1.add(option1);
            Quiz.writeFile("(a) "+option1);

            System.out.print("(b) ");
            String option2 = sc.nextLine();
            op2.add(option2);
            Quiz.writeFile("(b) "+option2);

            System.out.print("(c) ");
            String option3 = sc.nextLine();
            op3.add(option3);
            Quiz.writeFile("(c) "+option3);

            System.out.print("(d) ");
            String option4 = sc.nextLine();
            op4.add(option4);
            Quiz.writeFile("(d) "+option4);

            System.out.print("answer ");
            String ans = sc.nextLine();
            System.out.print("Marks: ");
            int m = sc.nextInt();
            answer.add("ans"+(i+1)+ans);
            Qmarks.add(m);
            Quiz.writeAnsFile(ans+"\t");
            Quiz.writeMarkFile(m);

            int mark = Qmarks.get(i);

                total = total+mark;
        }

        System.out.println("Total is: "+total);
    }
}
