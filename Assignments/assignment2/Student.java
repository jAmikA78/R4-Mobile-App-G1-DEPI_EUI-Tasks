package com.mycompany.assignment2;

public class Student {
    
    private String name;
    private int age;
    private String id;
    private String track;
    private String email;
    private double gpa;

    public Student(String name, int age, String id, String track, String email, double gpa) {
        setName(name);
        setAge(age);
        setId(id);
        setTrack(track);
        setEmail(email);
        setGpa(gpa);
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getId() { return id; }
    public String getTrack() { return track; }
    public String getEmail() { return email; }
    public double getGpa() { return gpa; }

    public void setName(String name) { 
        if(name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name");
        }
    }

    public void setAge(int age) { 
        if(age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive");
        }
    }

    public void setId(String id) { 
        if(id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Invalid ID");
        }
    }

    public void setTrack(String track) { 
        if(track != null && !track.isEmpty()) {
            this.track = track;
        } else {
            System.out.println("Invalid track");
        }
    }

    public void setEmail(String email) { 
        if(email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email");
        }
    }

    public void setGpa(double gpa) { 
        if(gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA must be between 0.0 and 4.0");
        }
    }


    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
        System.out.println("Track: " + track);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
    }

    public static void main(String[] args) {
        Student s1 = new Student(
            "Nouran", 20, "123456", "Computer Science",
            "nouran@example.com", 3.8
        );
        s1.printInfo();

        Student s2 = new Student(
            "", -5, "", "", "nnnnnnn", 5.0
        );
        s2.printInfo();
    }
}
