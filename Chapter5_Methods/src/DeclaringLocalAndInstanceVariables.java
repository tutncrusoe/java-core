/**
 * Chapter 5: Methods - Declaring Local And Instance Variables
 */
public class DeclaringLocalAndInstanceVariables { }

class Animal {
    private String name;

    public Animal() {}

    public void setName(String name) { this.name = name; }
}

class Lion {

    int hunger = 4;
    /**
     * hunger is an instance variable and created in every object of
     * the Lion class.
     */

    public int feedZooAnimals() {
        int snack = 10; // Local variable
        if (snack > 4) {
            long dinnerTime = snack++;
            hunger--;
        }
        return snack;
    }
    /**
     * snack and dinnerTime are local variables only accessible within their respective code blocks.
     *
     * The object or value returned by a method may be available outside the method, but the
     * variable reference snack is gone. Keep this in mind while reading this chapter:
     * all local variable references are destroyed after the block is executed, but the objects they point to may
     * still be accessible.
     */

    // Local Variable Modifiers
    public void zooAnimalCheckup(boolean isWeekend) {
        final int REST;
        if(isWeekend) REST = 5; else REST = 20;
        System.out.print(REST);
        final var GIRAFFE = new Animal();
        final int[] FRIENDS = new int[5];

//        REST = 10; // DOES NOT COMPILE
//        GIRAFFE = new Animal(); // DOES NOT COMPILE
//        FRIENDS = null; // DOES NOT COMPILE
    }
    /**
     * As shown with the REST variable, we don’t need to assign a value when a final variable
     * is declared. The rule is only that it must be assigned a value before it can be used. We can
     * even use var and final together.
     */

    public void zooAnimalCheckup1(boolean isWeekend) {
        final int REST;
        if(isWeekend) REST = 5;
//        System.out.print(REST); // DOES NOT COMPILE
    }
    /**
     * The REST variable might not have been assigned a value, such as if isWeekend is false.
     * Since the compiler does not allow the use of local variables that may not have been assigned
     * a value, the code does not compile.
     */

    public void zooAnimalCheckup() {
        final int REST = 5;
        final Animal GIRAFFE = new Animal();
        final int[] FRIENDS = new int[5];

        GIRAFFE.setName("George");
        FRIENDS[2] = 2;
    }
    /**
     * Does using the final modifier mean we can’t modify the data? Nope. The final attribute
     * only refers to the variable reference; the contents can be freely modified (assuming the object
     * isn’t immutable).
     *
     * The REST variable is a primitive, so it’s just a value that can’t be modified. On the other
     * hand, the contents of the GIRAFFE and FRIENDS variables can be freely modified, provided
     * the variables aren’t reassigned.
     */

    // Effectively Final Variables

}
