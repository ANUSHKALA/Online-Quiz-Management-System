package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.company.Question.end;
import static com.company.Question.start;
import static com.company.Quiz.*;
import static com.company.Student.stu_name;
import static com.company.Student.stu_roll;



abstract class responseMethods{

    abstract void giveQuiz() throws FileNotFoundException;
    static void checkEqual(String string1, String string2) throws InterruptedException {};
    static void calMarks() throws IOException {}
    static void replaceByRemark() {}
}

public class Response extends responseMethods{

    static Scanner sc = new Scanner(System.in);

    static String f = stu_name+stu_roll+".txt";
    static File stu_result_info = new File(f);
    static BufferedWriter bw;

    static {
        try {
            bw = new BufferedWriter(new FileWriter(stu_result_info, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<String> stu_ans = new ArrayList<>();
    static ArrayList<String> ans_list = new ArrayList<>();
    static int x1 = 0;
    static int x2 = 1;
    static int total = 0;

    static String ResponseID =  QuizID+ Student.stu_roll;
    public static String grading;
    public static int x;

    static int mks;
    static int count = 0;
    static int ans_count = 0;
    public static int total_marks;
    static int grade;


    public Response() {
    }

    void giveQuiz() throws FileNotFoundException {
        String line;
        try {
            //to count the number of lines in the file
            // create a new file object

            File file = new File(Quiz.file);
            File ans_file = new File(Quiz.ansFile);

            // create an object of Scanner associated with the file
            Scanner sc = new Scanner(file);
            Scanner ans_sc = new Scanner(ans_file);

            // count number of lines
            while(sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            while(ans_sc.hasNextLine()){
                ans_sc.nextLine();
                ans_count++;
            }
            x = count/5;

            // close scanner
            sc.close();
            ans_sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        Quiz.dltrespFile();
        Scanner input = new Scanner(new File("Quiz_details.txt"));
        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
        try {
            for (int j = 1; j <= ((x + 1) / 2); j++) {
                for (int i = start; i < x + 1; i++) {
                    for (int k = start; k < end; k++) {
                        line = Files.lines(Paths.get(file)).skip(k - 1).findFirst().get();
                        System.out.println(line);
                    }
                    System.out.println("Your answer: ");
                    String stu_answer = sc.nextLine();
                    stu_ans.add(stu_answer);
                    Quiz.writeResponse(stu_answer);

                    BufferedReader reader = new BufferedReader(new FileReader(markFile));

                    for (int p = x1; p < x2; p++) {
                        mks = Integer.parseInt(reader.readLine());
                        String ans = Files.lines(Paths.get(ansFile)).skip(p).findFirst().get();
                        ans_list.add(ans) ;
                        String t = ans_list.get(p);
                        checkEqual(t,stu_answer);

                    }

                    x1+=1;
                    x2+=1;

                    if (end >= count) {
                        break;
                    }
                    else {
                        start = start + 5;
                        end = end + 5;
                    }
                }
            }
            calMarks();
        }
        catch(IOException | InterruptedException e){
            System.out.println(e);
        }
    }



    static void checkEqual(String string1, String string2) throws InterruptedException {

        total = total + mks;

        if((string1.toString().trim()).equals(string2.toString().trim())){
            System.out.println("Correct answer");
            total_marks = total_marks+ mks;

        }
        else{
            System.out.println("Wrong answer");
            System.out.println("Answer: "+string1);
        }
        TimeUnit.SECONDS.sleep(1);

    }

    static void calMarks() throws IOException {
        //System.out.println(total_marks);
        //System.out.println(stu_name + " got " + total_marks +" marks");
try{
    grade = (total_marks*100/total);

}
catch(ArithmeticException e){
    System.out.println("No Results available");
        }

        bw.write("ResponseID: "+ResponseID+"\n");
        bw.write("Student Name: "+stu_name+"\n");
        bw.write("Student Roll Number: "+stu_roll+"\n");
        bw.write("Topic: "+Topic+"\n");

        //System.out.println("Percentage: "+grade+"%");
        bw.write("Percentage: "+grade+"%"+"\n");


        if(grade <= 100 && grade>90){
            grading = "A+";
        }
        else if(90>=grade && 80<grade){
            grading = "A";
        }
        else if(80>=grade && 70<grade){
            grading = "B+";
        }
        else if(70>=grade && 60<grade){
            grading = "B";
        }
        else if(60>=grade && 50<grade){
            grading = "C";
        }
        else if(50>=grade && 40<grade){
            grading = "D";
        }
        else if(40>=grade){
            grading = "FAIL";
        }
        else{
            System.out.println("no grading found");
        }
        //System.out.println("Grade: "+grading);
        bw.write("Grade: "+grading+"\n");
        bw.write(" ");
        bw.close();
    }


    static void replaceByRemark(String remark) throws IOException {

        String temp_name = Teacher.roll_for_remark+Teacher.name_for_remark+".txt";
        File temp_stu_result_info = new File(temp_name);

        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(temp_stu_result_info,true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e){
            System.out.println("No remarks available!");
        }
        bf.write("Remarks: "+remark+"\n");
        bf.close();

    }
}
