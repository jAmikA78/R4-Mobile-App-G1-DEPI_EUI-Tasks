
package com.mycompany.lec2assigment1;
import java.util.Scanner ;


public class Lec2Assigment1 {

    public static void main(String[] args) {
        
        Student st1 = new Student();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student name : ");
        st1.setName(input.nextLine());
        System.out.println("Enter student track : ");
        st1.setTrack(input.nextLine());
        System.out.println("Enter student age : ");
        st1.setAge(input.nextInt());

        System.out.println("================================");
        System.out.println("Student name is "+ st1.getName());
        System.out.println("Student age is "+ st1.getAge());
        System.out.println("Student Track is "+ st1.getTrack());
    }
}
