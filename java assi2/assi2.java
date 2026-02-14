public class assi2 { 

   
    public static class Student {
        String name;
        int age;
        String track; 
        public Student(String name, int age, String track) {
            this.name = name;
            this.age = age;
            this.track = track;
        }

        public void disp() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Track: " + track);
        }
    }

  
    public static class ComplexNum {
        int real;
        int imag;


        public ComplexNum(int r, int i) {
            real = r;
            imag = i;
        }

     

        public void disp() {
            System.out.println(real + " + " + imag + "i");
        }
    }

    public static void main(String[] args) {
       
        Student st = new Student("Ahmed", 19, "Android Developer");
        st.disp();

    
      
        ComplexNum comp = new ComplexNum(5, 6); 
        
        comp.disp();

    
    }
}