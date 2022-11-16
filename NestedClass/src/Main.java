/**
 * Bên trong lớp Main,
 * Đầu tiên chúng ta tạo một thể hiện của một lớp bên ngoài CPU được đặt tên CPU.
 * Sử dụng thể hiện của lớp bên ngoài, sau đó chúng ta đã tạo các đối tượng của các lớp bên trong:
 */
public class Main {
    public static void main(String[] args) {

        // create object of Outer class CPU
        OuterClass_CPU cpu = new OuterClass_CPU();

        /**
         * Lưu ý : Chúng ta sử dụng .toán tử dot để tạo một thể hiện của lớp bên trong bằng cách sử dụng lớp bên ngoài.
         */
        // create an object of inner class Processor using outer class
        OuterClass_CPU.NestedClass_Processor processor = cpu.new NestedClass_Processor();

        /**
         * Ở đây, chúng ta đang tạo một đối tượng của lớp lồng tĩnh bằng cách sử dụng tên lớp của lớp bên ngoài.
         * Do đó, lớp bên ngoài không thể được tham chiếu bằng cách sử dụng OuterClass.this.
         */
        // create an object of inner class RAM using outer class CPU
        OuterClass_CPU.NestedClass_RAM ram = cpu.new NestedClass_RAM();
        System.out.println("Processor Cache = " + processor.getCache());
        System.out.println("Ram Clock speed = " + ram.getClockSpeed());


        /**
         * Đây là sự khác biệt của việc khởi tạo object giữa non-static-class và static-class
         */
        // create an object of the static nested class
        // using the name of the outer class
        OuterClass_MotherBoard.StaticNestedClass_USB usb = new OuterClass_MotherBoard.StaticNestedClass_USB();
        System.out.println("Total Ports = " + usb.getTotalPorts());
    }
}