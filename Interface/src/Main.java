public class Main {
    public static void main(String[] args) {

        ClassImpl classExtend = new ClassImpl();
        classExtend.printNumber();

        System.out.println("isEquals Method: " + GenericsInterfaceExtend.isEquals(7));
        System.out.println("static number: " + GenericsInterface.number);

        System.out.println("Sum: " + classExtend.getSum(3));

    }
}