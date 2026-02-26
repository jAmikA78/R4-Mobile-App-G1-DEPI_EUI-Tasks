package com.mycompany.lab2task;

public class Student {
    private String name;
    private int age, id;

    public Student(){}
    
    public Student(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0){
            this.age = age;
        }else{
            System.out.println("Invalid age!!!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }else{
            System.out.println("Invalid ID!!!");
        }
    }
    
    public void printInfo(){
        System.out.println("Student Info:");
        System.out.println("Student name: " + name);
        System.out.println("Student age: " + age);
        System.out.println("Student ID: " + id);
    }
}
