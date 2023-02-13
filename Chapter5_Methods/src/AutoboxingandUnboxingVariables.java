public class AutoboxingandUnboxingVariables {

    /*
    - Autoboxing is the process of converting a primitive into its equivalent wrapper class,
    while unboxing is the process of converting a wrapper class into its equivalent primitive.
    - Java will automatically cast or autobox the int value to long or Integer.
     */
    int quack = 5;
    Integer quackquack = Integer.valueOf(quack); // Convert int to Integer - Autoboxing
    int quackquackquack = quackquack.intValue(); // Convert Integer to int - Unboxing

    /*
    - We store null in a Character reference.
    This is legal because a null reference can be assigned to any reference variable.
     */
    Character elephant = null;
    char badElephant = elephant; // NullPointerException

    /*
    -
     */
    public void climb(long t) {
    } // climb() compiles because the int value can be implicitly cast to a long.

    {
        climb(123); // int to long
    }

    public void swing(Integer u) {
    } // swing() also is permitted, because the int value is autoboxed to an Integer.

    {
        swing(123); // int => Integer
    }

    public void jump(int v) {
    } // jump() results in a compiler error because a long must be explicitly cast to an int.

    {
        jump(123L); // DOES NOT COMPILE long to int
    }

    public void rest(Long x) {
        System.out.print("long");
    }

    {
        rest(8); // DOES NOT COMPILE int to Long
    }

    /*
    - Java will cast or autobox the value automatically, but not both at the same time.
     */

}
