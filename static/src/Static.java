public class Static {

    /**
     * Khối tĩnh chỉ được thực hiện một lần khi lớp được sử dụng trong bộ nhớ.
     * Lớp được sử dụng nếu đối tượng của lớp được yêu cầu trong mã hoặc các thành viên tĩnh được yêu cầu trong code.
     * <p>
     * Một lớp có thể có nhiều khối tĩnh và mỗi khối tĩnh được thực hiện theo cùng một chuỗi trong đó chúng đã được viết trong một chương trình.
     * <p>
     * <p>
     * <p>
     * Trong chương trình trên. ngay khi lớp Main được tải,
     * <p>
     * Giá trị của a được đặt thành 23.
     * Khối tĩnh đầu tiên được thực thi. Do đó, chuỗi First Static blockđược in và giá trị của b được đặt thành a * 4.
     * Khối tĩnh thứ hai được thực thi. Do đó, chuỗi Second Static blockđược in và giá trị của max đặt thành 30.
     * Và cuối cùng, các câu lệnh in bên trong phương thức display()được thực thi.
     */
    // static variables
    static int a = 23;
    static int b;
    static int max;
    public int i;

    // static blocks
    static {
        System.out.println("First Static block.");
        b = a * 4;
    }

    static {
        System.out.println("Second Static block.");
        max = 30;
    }

    /**
     * Constructor khởi tạo chạy sau static block.
     */
    public Static(int i) {
        System.out.println("Third Constructor Block");
        this.i = i;
    }

    // static method
    static void display() {

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("max = " + max);
    }
}
