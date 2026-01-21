package com.mycompany.assignment2;


public class Student {
    
    String name;
    int age ;
    String track;
    
    Student(String name , int age , String track){    //constructor
        this.name = name;
        this.age = age;  
        this.track = track ;
    }
    
    
    void printInfo(){
        System.out.println("the student name is :"+ name );
        System.out.println("the student age is :"+ age );
        System.out.println("the student track is :"+ track );
    }
    
    
    
}
