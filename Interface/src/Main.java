public class Main {
    public static void main(String[] args) {

        ClassImpl classExtend = new ClassImpl();
        classExtend.printNumber();
        System.out.println("Sum: " + classExtend.getSum(3));
        classExtend.log("Halo");

        System.out.println("isEquals Method: " + GenericsInterfaceExtend.isEquals(7));
        System.out.println("static number: " + GenericsInterface.number + "\n");


        ThirdImpl obj = new ThirdImpl();
        obj.print("");

        obj.isNull("abc");
        // sử dụng Impl
    }
}