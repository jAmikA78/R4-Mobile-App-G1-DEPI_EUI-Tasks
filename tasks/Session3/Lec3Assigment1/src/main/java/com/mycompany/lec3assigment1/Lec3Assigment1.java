

package com.mycompany.lec3assigment1;


public class Lec3Assigment1 {

    public static void main(String[] args) {
        
        Rectangle r = new Rectangle(9,4);
        Triangle t = new Triangle(5,4);
        Circle c = new Circle(4);
        
        Picture pic = new Picture ();
        double total = pic.sumAreas(r, t, c);
        System.out.println("Total areas = "+ total);
        
    }
}
