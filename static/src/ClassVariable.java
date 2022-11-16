/**
 * Trong Java, khi chúng ta tạo các đối tượng của một lớp, thì mọi đối tượng sẽ có bản sao riêng của tất cả các biến của lớp.
 */
public class ClassVariable {

    // regular variable
    public String username;

    /**
     * Tuy nhiên, nếu chúng ta khai báo một biến tĩnh, tất cả các đối tượng của lớp đều có chung một biến tĩnh.
     * Đó là bởi vì giống như các phương thức tĩnh, các biến tĩnh cũng được liên kết với lớp.
     * Và, chúng ta không cần tạo các đối tượng của lớp để truy cập các biến tĩnh.
     */
    // static variale
    protected static String email;

    public int min = 0;
    public static int max = 100;

    /**
     * phương thức non-static truy cập biến non-static và static
     */
    public void non_static_method() {
        min = 0;
        max = 100;
    }

    /**
     * phương thức static chỉ truy cập biến static
     */
    public static void static_method() {
//        min = 0;
        max = 100;
    }

}
