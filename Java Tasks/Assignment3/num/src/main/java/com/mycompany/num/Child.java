
package com.mycompany.num;

import com.mycompany.num.Parent;


public class Child extends Parent {
    
    int num3 ;

    public Child(int num1, int num2 ,int num3) {
        super(num1, num2);
        this.num3 = num3 ;
    }

    @Override
    public int sum() {
        return super.sum() + num3;
    }
    
    
    
    
}
