package Accessing_static_Data;

public class Accessing_a_static_Variable_or_Method {

}

class Snake {
    public static long hiss = 2;

    {
        // Usually, accessing a static member is easy.
        // You just put the class name before the method or variable.
        System.out.println(Snake.hiss);
    }

    {
        /*
        - You can use an instance of the object to call a static method.
        - The compiler checks for the type of the reference and uses that
instead of the object—which is sneaky of Java. This code is perfectly legal:
         */
        Snake s = new Snake(); // s is an instance of the object
        System.out.println(s.hiss); // s is a Snake
        s = null;
        System.out.println(s.hiss); // s is still a Snake

        /*
        Believe it or not, this code outputs 2 twice. Line 6 sees that s is a Snake and hiss
is a static variable, so it reads that static variable. Line 8 does the same thing. Java
doesn’t care that s happens to be null. Since we are looking for a static variable, it
doesn’t matter.
         */
    }

    {
        Snake.hiss = 4;
        Snake snake1 = new Snake();
        Snake snake2 = new Snake();
        snake1.hiss = 6;
        snake2.hiss = 5;
        System.out.println(Snake.hiss); // All the Snake variables are just distractions. Answer is 5.
    }
}