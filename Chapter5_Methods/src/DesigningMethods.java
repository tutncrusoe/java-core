/**
 * OCP: Chapter 5: Methods - Designing Methods
 */
public class DesigningMethods {
}

class Bottle {

    private Shape shape;
    Shape shape1;
    protected Shape shape2;
    public Shape shape3;
    /**
     * private: The private modifier means the method can be called only from within the
     * same class.
     *
     * Package Access: With package access, the method can be called only from a class in
     * the same package. This one is tricky because there is no keyword. You simply omit the
     * access modifier. Package access is sometimes referred to as package-­private or default
     * access (even within this book!).
     *
     * protected: The protected modifier means the method can be called only from a class
     * in the same package or a subclass.
     *
     * public The public modifier means the method can be called from anywhere.
     */


    Bottle(Shape shape) {
        this.shape = shape;
    }

    Shape getShape() {
        return this.shape;
    }
    /**
     * Package Access With package access, the method can be called only from a class in
     * the same package. This one is tricky because there is no keyword. You simply omit the
     * access modifier. Package access is sometimes referred to as package-­private or default
     * access (even within this book!).
     */


    public void setShape(Shape shape) {
        // Method body
        this.shape = shape;
    }
    /**
     * setShape: method is a valid declaration with public access.
     * <p>
     * public: Access modifier (private,package-private, protected, public)
     * final: Optional specifier
     * void: Return type
     * setShape: Method name
     * Shape shape: Parameter list, Parentheses
     */

//    default void printBottle(Shape) {} // DOES NOT COMPILE
    /**
     * method doesn’t compile because
     * default is not a valid access modifier.
     */
}

class Shape {

    // Optional Specifiers
    public void bike1() {}
    public final void bike2() {} // Specifies that the method may not be overridden in a sub-class: Chapter 6
    public static final void bike3() {} // Indicates the method is a member of the shared class object: Chapter 5
    public final static void bike4() {}
//    public modifier void bike5() {} // DOES NOT COMPILE
//    public void final bike6() {} // DOES NOT COMPILE
    final public void bike7() {}
    /**
     * The bike1() method is a valid declaration with no optional specifier. This is okay—­it is
     * optional, after all. The bike2() method is a valid declaration, with final as the optional
     * specifier. The bike3() and bike4() methods are valid declarations with both final
     * and static as optional specifiers. The order of these two keywords doesn’t matter.
     * The bike5() method doesn’t compile because modifier is not a valid optional specifier.
     * The bike6() method doesn’t compile because the optional specifier is after the return type.
     * The bike7() method does compile. Java allows the optional specifiers to appear before the
     * access modifier. This is a weird case and not one you need to know for the exam. We are
     * mentioning it so you don’t get confused when practicing.
     */

    // Return Type
//    String hike7(int a) { // DOES NOT COMPILE
//        if (1 < 2) return "orange";
//    }
    /**
     * The hike7() method is a little tricky. There is a return statement, but it doesn’t always get
     * run. Even though 1 is always less than 2, the compiler won’t fully evaluate the if statement
     * and requires a return statement if this condition is false.
     */

    String hike8(int a) {
        if (1 < 2) return "orange";
        return "apple";
    }
    /**
     * The code compiles, although the compiler will produce a warning about unreachable code
     * (or dead code).
     */

    // Method Signature

    public void visitZoo(String name, int waitTime) {}
//    public void visitZoo(String attraction, int rainFall) {} // DOES NOT COMPILE
    /**
     * Despite having different parameter names, these two methods have the same signature
     * and cannot be declared within the same class.
     */

    public void visitZoo1(String name, int waitTime) {}
    public void visitZoo1(int rainFall, String attraction) {}
    /**
     * Changing the order of parameter types does
     * allow the method to compile.
     *
     * We cover these rules in more detail when we get to method overloading later in
     * this chapter.
     */

    // Exception List
    public void zeroExceptions() {}
    public void oneException() throws IllegalArgumentException {}
    public void twoExceptions() throws IllegalArgumentException, InterruptedException {}
    /**
     * While the list of exceptions is optional, it may be required by the compiler, depending on
     * what appears inside the method body. You learn more about this, as well as how methods
     * calling them may be required to handle these exception declarations, in Chapter 11.
     */

    // Method Body
//    public void fly2() // DOES NOT COMPILE
    /**
     * The fly2() method doesn’t compile because it is missing the braces around the empty method body.
     * Methods are required to have a body unless they are declared abstract. We cover
     * abstract methods in Chapter 6, “Class Design.”
     */
}

