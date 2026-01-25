public class Main {
    public static void main(String[] args){
        Parent parent = new Parent(5,5);
        System.out.println("Parent: " + parent.sum());
        Parent child = new Child(5,5,5);
        System.out.println("Child: " + child.sum());

    }
}
