/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mohammedtaysser
 */
public class Assi1 {
    
    public static void main(String[] args){
        Student s1 = new Student("Mohammed", 19, 2453, "Computer Sceince" );
        s1.print();
        }
}
class Student{
        
        private String name;
        private int age;
        private int id;
        private String track;
        
        public Student (String name, int age, int id, String track){
            this.name = name;
            this.age = age;
            this.id = id;
            this.track = track;
        }
        
        public void print() {
            System.out.println("Student Name: " + name );
            System.out.println("Student Age: " + age);
            System.out.println("Student Id: " + id);
            System.out.println("Student Track: " + track);
                
        }
    }

