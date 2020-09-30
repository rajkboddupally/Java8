package helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class IkmTest {
    public IkmTest() {
        this(10);
    }
    public IkmTest(int data) {
        this.data = data;
    }
    public void display() {
        class Decrementer {
            public void decrement () {
                data--;
            }    
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data = " + data);
    }
   
    private int data;
   
    public static void main (String [] args) {
        int data = 0;
        IkmTest t = new IkmTest();
        t.display();
        System.out.println("data = " + data);
        
        List<String> letters = new ArrayList(Arrays.asList("D","B","A","C","F","G"));
        Predicate<String> p1 = s -> s.compareTo("C") > 0;
        Predicate<String> p2 = s -> s.equals("B");
        
        System.out.println(p1.test("C"));
        
        //letters.removeIf(p1.negate().or(p2));
        //letters.sort((s1,s2) -> s1.compareTo(s2));
        System.out.println(letters);
    }
}

class MainClassA {
    public static void main(String[] args) {        
        System.out.println("Class A " + args[0]);
    }    
}
class MainClassB {
    public static void main(String[] args) {        
        System.out.println("Class B");
        MainClassA.main(args);
    }
}