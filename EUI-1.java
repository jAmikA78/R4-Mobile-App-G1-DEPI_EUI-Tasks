
package eui;

import java.util.Scanner;

class student{
private String name,track;
private int age;
   
public void setAge(int num){
    if(num<=0){
        System.out.println("Error in Age!");
    }
    else{
    age=num;
    }

}
public void setName(String N){
name=N;
}
public int getAge(){
return age;
}
public String getName(){
return name;
}
public String getTrack(){
return track;
}

public void setTrack(String T){
track=T;
}
 public void print(){
        System.out.println("Name : "+name +"  Age : "+age +"  Track : "+track);
}


}

public class EUI {

    public static void main(String[] args) {
    
        student S=new student();
        S.setAge(20);
        S.setName("Ehab");
        S.setTrack("App dev");
       S.print();
        
}
}
