/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Problem1;

/**
 *
 * @author Hp
 */
public class main {

    public static void main(String[] args) {
        Shape r = new Rectangle(4, 5);
        Shape t = new Triangle(6, 3);
        Shape c = new Circle(2);
        Picture pic = new Picture();
        double totalArea = pic.sumAreas(r, t, c);

        System.out.println("Total Area = " + totalArea);
    }
}
