package Accessing_static_Data;

public class Designing_static_Methods_and_Variables {
}

class Penguin extends Designing_static_Methods_and_Variables {

    /*
    - You can think of a static variable as being a member of the single class object that exists independently of any instances of that class.
    - The nameOfTallestPenguin field is static and therefore shared, though
    , so anytime it is updated, it impacts all instances of the class.
     */

    String name;
    static String nameOfTallestPenguin;

    {
        var p1 = new Penguin();
        p1.name = "Lilly";
        p1.nameOfTallestPenguin = "Lilly";
        var p2 = new Penguin();
        p2.name = "Willy";
        p2.nameOfTallestPenguin = "Willy";
    }


}

class Koala extends Designing_static_Methods_and_Variables {
    public static int count = 0;                // static variable

    public static void main(String[] args) {    // static method
        System.out.println(count);
    }
}

class KoalaTester {
    /*
    Here the JVM basically calls Koala.main() to get the program started.

    When we run KoalaTester, it makes a call
to the main() method of Koala, which prints the value of count. The purpose of all these
examples is to show that main() can be called just like any other static method.
     */
    public static void main(String[] args) {
        Koala.main(new String[0]); // call static method
    }

    /*
    In addition to main() methods, static methods have two main purposes:
■ For utility or helper methods that don’t require any object state. Since there is no need
to access instance variables, having static methods eliminates the need for the caller to
instantiate an object just to call the method.
■ For state that is shared by all instances of a class, like a counter. All instances must share
the same state. Methods that merely use that state should be static as well.
     */
}




