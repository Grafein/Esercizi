package poly;

import java.lang.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        Poly p1= new Poly();//0
        Poly p2= new Poly(3,4); //3x^4
        Poly p3= new Poly(6,5); //6x^5

        System.out.println(Integer.toString(p2.degree())); //4

        System.out.println(p2.toString()+"/"+p3.toString()); 

        System.out.println((p2.add(p3)).toString()); //6x^5+3x^4
        

        System.out.println((p2.sub(p3)).toString()); //3x^4-6x^5

        System.out.println((p2.mul(p3)).toString()); //18x^9

        System.out.println(((p2.sub(p3).minus())).toString()); //+6x^5-3x^4


    }
}
