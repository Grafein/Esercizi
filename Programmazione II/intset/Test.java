package intset;

import java.lang.*;


public class Test {

    public static void main(String[] args) throws EmptyException {

        IntSet set= new IntSet();
        System.out.println(set.toString());

        try{set.remove(4);}
        catch(EmptyException e1){
    
            System.out.println(e1.toString());
        }

        IntSet set2= new IntSet(3);
        System.out.println(set2.toString());

        set2.insert(4);
        System.out.println(set2.toString());

        System.out.println(Integer.toString(set2.get(4)));

        set2.insert(22);
        System.out.println(set2.toString());
        System.out.println(Boolean.toString(set2.contains(22)));

        set2.insert(4);
        System.out.println(set2.toString());
        
        set2.remove(22);
        System.out.println(set2.toString());
        System.out.println(Boolean.toString((set2.contains(22))));

        System.out.println(Boolean.toString(set.isEmpty()));

        System.out.println(Integer.toString(set2.choose()));
        System.out.println(set2.size());

    }

}
