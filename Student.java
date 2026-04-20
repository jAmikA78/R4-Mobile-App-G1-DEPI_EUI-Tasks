package com.mycompany.student;

 public class Student {
    String name;
    int age;
    String track;

    void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Track: " + track);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Lamiaa";
        s1.age = 22;
        s1.track = "mobile app dev";

        s1.printInfo();
    }
}
