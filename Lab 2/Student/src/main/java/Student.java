public class Student {
    private String name;
    private int age;
    private String track;

    public Student() {
    }

    public Student(String name, int age, String track) {
        this.name = name;
        this.age = age;
        this.track = track;
    }

    public void display(){
        System.out.println("Student: " + "[Name: " + this.name +",age: " + this.age
                            + ",track: " + this.track + "]");
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
        if (age <= 0){
            System.out.println("Invalid Age!!");
            return;
        }
        this.age = age;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
