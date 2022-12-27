public class UnderstandingInheritance {}

// Declaring a Subclass
class BigCat { // Superclass
    protected double size;
}

class Jaguar extends BigCat { // Subclass
    public Jaguar() {
        size = 10.2;
    }
    public void printDetails() {
        System.out.print(size);
    }
}

class Spider {
    public void printDetails() {
//        System.out.println(size); // DOES NOT COMPILE
    }
}
/**
 * Jaguar is a subclass or child of BigCat, making BigCat a superclass or parent of
 * Jaguar. In the Jaguar class, size is accessible because it is marked protected. Via inher-
 * itance, the Jaguar subclass can read or write size as if it were its own member. Contrast
 * this with the Spider class, which has no access to size since it is not inherited.
 */