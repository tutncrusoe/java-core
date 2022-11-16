public class Main {
    public static void main(String[] args) {

        /**
         * Trong Java, nếu chúng ta muốn truy cập các thành viên của lớp, trước tiên chúng ta phải tạo một thể hiện của lớp.
         * Nhưng sẽ có những tình huống chúng ta muốn truy cập các thành viên của lớp mà không tạo ra bất kỳ biến nào.
         * Trong những tình huống đó, chúng ta có thể sử dụng từ khóa static trong Java.
         * Nếu chúng ta muốn truy cập các thành viên của lớp mà không tạo một thể hiện của lớp, chúng ta cần khai báo các thành viên của lớp tĩnh.
         * Các lớp Math trong Java có hầu hết tất cả các thành viên tĩnh của nó.
         * Vì vậy, chúng ta có thể truy cập các thành viên của nó mà không cần tạo các thể hiện của lớp Math.
         */

        // Accessing the methods of the Math class
        System.out.println("Absolute value of -12 = " + Math.abs(-12));
        System.out.println("Value of PI = " + Math.PI);
        System.out.println("Value of E = " + Math.E);
        System.out.println("2^2 = " + Math.pow(2, 2));


        // create an instance of the StaticTest class
        Class aClass = new Class();

        // call the non-static method
        System.out.println(" 2 * 2 = " + aClass.non_static_method(2, 2));

        // call the static method
        System.out.println(" 2 + 3 = " + Class.static_method(2, 3));


        // create instances of ClassVariable
        /**
         * Ở đây, cả hai đối tượng classVariable và classVariable_2 sẽ có các bản sao riêng biệt của tuổi thay đổi.
         * Và, chúng khác nhau.
         */
        ClassVariable classVariable = new ClassVariable();
        ClassVariable classVariable_2 = new ClassVariable();

        /**
         * Ở đây, chúng ta có thể thấy rằng chúng ta đang truy cập vào biến tĩnh từ lớp khác bằng cách sử dụng tên lớp.
         */
        // access the static variable
        ClassVariable.email = "huy@email";

        /**
         * Trong chương trình trên, chúng ta đã khai báo một biến không tĩnh có tên min và một biến tĩnh có tên max trong lớp Kiểm tra.
         *
         * Bên trong lớp main, chúng ta có thể thấy rằng chúng ta đang gọi biến không tĩnh bằng cách sử dụng đối tượng của lớp ( obj.min + 1).
         * Tuy nhiên, chúng ta đang gọi biến tĩnh bằng cách sử dụng tên lớp ( Test.max + 1).
         */
        // access the non-static variable
        System.out.println("min + 1 = " + (classVariable.min + 1));
        // access the static variable
        System.out.println("max + 1 = " + (ClassVariable.max + 1));


        // calling the static method
        Static aStatic = new Static(5);
        Static.display();
    }
}