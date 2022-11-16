/**
 * Trong Java, chúng ta cũng có thể định nghĩa một lớp static bên trong một lớp khác.
 * Lớp như vậy được gọi là static nested class.
 * Các lớp lồng nhau tĩnh không được gọi là các lớp bên trong tĩnh.
 * <p>
 * Không giống như lớp bên trong, một lớp lồng tĩnh không thể truy cập các biến thành viên của lớp bên ngoài.
 * Đó là bởi vì lớp lồng tĩnh không yêu cầu bạn tạo một thể hiện của lớp bên ngoài.
 */
public class OuterClass_MotherBoard {

    String model;

    public OuterClass_MotherBoard(String model) {
        this.model = model;
    }

    // static nested class
    static class StaticNestedClass_USB {
        int usb2 = 2;
        int usb3 = 1;

        /**
         * Khi chúng ta cố gắng chạy chương trình, chúng ta sẽ gặp lỗi:
         * <p>
         * error: non-static variable this cannot be referenced from a static context
         * Điều này là do chúng ta không sử dụng đối tượng của lớp bên ngoài để tạo một đối tượng của lớp bên trong.
         * Do đó, không có tham chiếu đến lớp bên ngoài Motherboardđược lưu trữ trong Motherboard.this.
         */
        int getTotalPorts() {
            // accessing the variable model of the outer-class
            if (OuterClass_MotherBoard.this.model.equals("MSI")) {
                return 4;
            } else {
                return usb2 + usb3;
            }
        }
    }

    /**
     * Java coi lớp bên trong như một thành viên thông thường của một lớp.
     * Chúng giống như các phương thức và các biến được khai báo bên trong một lớp.
     * Vì các lớp bên trong là thành viên của lớp bên ngoài, bạn có thể áp dụng bất kỳ quyền sửa đổi truy cập nào như private, protected cho lớp bên trong của bạn, điều không thể có trong các lớp bình thường.
     * Vì lớp lồng nhau là một thành viên của lớp bên ngoài kèm theo, nên bạn có thể sử dụng ký hiệu dấu chấm "." để truy cập lớp lồng và các thành viên của lớp.
     * Sử dụng lớp lồng nhau sẽ làm cho code của bạn dễ đọc hơn và cung cấp đóng gói tốt hơn.
     * Các lớp lồng nhau không tĩnh (các lớp bên trong) có quyền truy cập vào các thành viên khác của lớp bên ngoài / lớp kèm theo, ngay cả khi chúng được khai báo là riêng tư.
     */


}
