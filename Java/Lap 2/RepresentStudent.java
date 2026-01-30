class Student{
    String name;
    int age;
    String track;
    
    Student(String name, int age, String track){
        this.name = name;
        this.age = age;
        this.track = track;
    }

}


public class RepresentStudent {
    public static void main(String[] args) {
        Student student1 = new Student("Abdulrahman", 22, "Computer Science");
        Student student2 = new Student("Ahmed", 38, "Mathematics");
        
        System.out.println("Student 1: " + student1.name + ", Age: " + student1.age + ", Track: " + student1.track);
        System.out.println("Student 2: " + student2.name + ", Age: " + student2.age + ", Track: " + student2.track);
    }
}