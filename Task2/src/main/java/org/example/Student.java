package org.example;

public class Student { private String name;
    private int age;
    private String track;

    public Student(String n, int a, String t){
        name = n;
        age = a;
        track = t;
    }
    public void setName(String n){ name = n; }
    public void setAge(int a){ age = a; }
    public void setTrack(String t){ track = t; }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getTrack() { return track; }

    public void studentInfo(){
        System.out.println("student name is " + name);
        System.out.println("student age is " + age);
        System.out.println("student track is " + track);
    }
}
