package Accessing_static_Data;

public class Class_vs_Instance_Membership {
}

class MantaRay extends Class_vs_Instance_Membership {
    private String name = "Sammy";  // instance variable.

    public static void first() {    // static method
    }

    public static void second() {   // static method
    }

    public void third() {
        System.out.print(name);     // third() is referring to an instance variable 'name'.
    }

    public static void main(String[] args) {    // static method
        // all theses are instance method.
        first();
        second();
        third();    // DOES NOT COMPILE. The compiler will give you an error about making a static reference to an instance method.

        // => There are two ways we could fix this.
        // 1. The first solution would have been to call third() as an instance method and not use
        //static for the method or the variable.
        var ray = new MantaRay();
        ray.third();    // third() in this situation is an instance method.
    }

    /*
    2. The second is to add static to the name variable as well.*/
    private static String name_ = "Sammy";

    public static void third_() {
        System.out.print(name_);
    }

    /*
    The exam creators like this topic—a lot. A static method or instance method can call a
static method because static methods don’t require an object to use.
    Only an instance method
can call another instance method on the same class without using a reference variable, because instance methods do require an object.
    Similar logic applies for instance and
static variables.
     */

}

class Giraffe extends Designing_static_Methods_and_Variables {
    // static method vs instance method calls
    public void eat(Giraffe g) {    // instance method
        allGiraffeGoHome(g);
        allGiraffeComeOut();
        drink();
        g.eat(g);
    }

    public void drink() {   // instance method
    }

    public static void allGiraffeGoHome(Giraffe g) {    // static method
        allGiraffeComeOut();
        g.eat(g);
    }

    public static void allGiraffeComeOut() {    // static method
    }
}

class Gorilla extends Class_vs_Instance_Membership {
    public static int count;

    public static void addGorilla() {   // static method
        count++;    //  both static and instance methods can refer to a static variable.
        // static method => static variable.
    }

    public void babyGorilla() {         // instance method
        count++; //  both static and instance methods can refer to a static variable.
        // instance method => static variable.
    }

    public void announceBabies() {      // an instance method can call a static method.
        addGorilla();                   // static method
        babyGorilla();                  // instance method
        // instance method => static and instance method.
    }

    public static void announceBabiesToEveryone() {
        addGorilla();                   // static method
        babyGorilla();  // DOES NOT COMPILE because a static method cannot call an instance method.
        // static method =/=> instance method.
    }

    public int total;
    public static double average = total / count;   // DOES NOT COMPILE because a static variable is trying to use an instance variable.
    // static variable =/=> instance variable.

}

class Counter {
    private static int count;

    public Counter() {
        count++;
    }

    public static void main(String[] args) {

        /*
        Each time the constructor is called, it increments count by one. This example relies on
the fact that static (and instance) variables are automatically initialized to the default
value for that type, which is 0 for int. See Chapter 1 to review the default values.

         */
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        System.out.println(count);  // 3
    }

    /**
     * we discuss interfaces in Chapter 7. For example, a static interface method cannot call a
     * default interface method without a reference, much the same way that
     * within a class, a static method cannot call an instance method without
     * a reference.
     */
}