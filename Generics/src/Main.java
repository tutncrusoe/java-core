import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // -----------------------      GenericsClass       -----------------------
        GenericsClass<Integer> integerObj = new GenericsClass<>(5);
        System.out.println("Get Data from Generic Class: " + integerObj.getData());
        integerObj.<Integer>genericsMethod(5);
        // or
        integerObj.genericsMethod(5);
        // initialize generics class with Integer data

        GenericsClass<String> stringObj = new GenericsClass<>("Hello");
        System.out.println("Get Data from Generic Class: " + stringObj.getData());
        stringObj.<String>genericsMethod("Hello");
        // or
        stringObj.genericsMethod("Hello");
        // initialize generics class with String data


        // -----------------------      GenericsClassExtend       -----------------------
        GenericsClassExtend<Integer> gceObj = new GenericsClassExtend<>(5);
        System.out.println("\nsGet Data from Generics Class extend: " + gceObj.getData());

        // Example ArrayList is a Generis Class
        ArrayList<Integer> arrayList = new ArrayList<>(5);
    }
}