

public class A4 {
    public static void main(String[] args) {
        Student stu1 =  new Student("Mahmoud","Giza",21);
        stu1.get_stu();
    }
}

class Student{
    private String name,address;
    private int age;

    private void set_stu(String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Student(String name, String address, int age){
        if(!(age <= 0)){
            set_stu(name,address,age);
        }
    }

    public void get_stu(){
        System.out.println("Student Name:"+this.name+" Address:"+this.address+" Age:"+this.age);
    }
}