public class Main {
    public static void main(String[] args) {

        Student st = new Student();

        st.name = "Ahmed";
        st.age = 19;
        st.track = "Mobile APP";

        st.printkk();
    }
}

class Student {

    String name;
    int age;
    String track;

    void printkk() {

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Track: " + track);
    }
}