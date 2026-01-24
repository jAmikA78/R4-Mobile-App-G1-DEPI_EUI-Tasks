/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.students;

/**
 *
 * @author Amir Fahmy 7
 */
class Student{
private String name , track;
private int age;
public Student(){}

public Student(String name ,String track , int age){
this.name=name;
this.age=age;
this.track=track;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0)
        this.age = age;
    }

public void print(){
    System.out.println("Name: "+name+"\nage: "+age+"\nTrack: "+track);

}

}
public class Students {

    public static void main(String[] args) {
Student s1=new Student("Amir","Mobile Application",21);
s1.print();
    }
}
