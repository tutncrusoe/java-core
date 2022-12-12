public class StringBufferClass {

    public static void main(String[] args) {
        /**
         * hẳn những ai biết tới Java thì không còn xa lạ gì với việc ghép các String với nhau.
         * Đây là một kiến thức cực kì cực kì cơ bản.
         * Tuy nhiên, nếu chúng ta tăng số lượng phép nối xâu này lên thì sẽ có hệ quả gì.
         *
         * Có một điều ít bạn học lập trình Java để ý, đó là String là immutable.
         * Tức nội dung trong String là không được quyền thay đổi.
         *
         * Nhiều bạn lầm tưởng rằng việc nối xâu là bạn thay đổi nội dung của String,
         * nhưng thực chất bạn đang tạo ra một đối tượng hoàn toàn mới:
         */
        long start = System.nanoTime();

        String s = "Hello";
        for (int i = 0; i < 1000; i++) {
            s += " world";
        }

        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start) * (Math.pow(10, -6)));
        // Milliseconds
        // Vì vậy khi nối xâu trong Java, việc bạn thực hiện nó liên tục,
        // sẽ tương đương với việc khởi tạo liên tục và nối 2 xâu lại rồi trả về đối tượng String mới dẫn tới chi phí lớn.

        /**
         * Bây giờ, vẫn là chương trình tương tự, mình sử sụng String Buffer
         */
        long start_ = System.nanoTime();

        StringBuffer stringBuffer = new StringBuffer("Hello");
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(" world");
        }
        String string = stringBuffer.toString();
        long end_ = System.nanoTime();
        System.out.println("Total time: " + (end_ - start_) * Math.pow(10, -6));
        System.out.println("StringBuffer " + (end - start) / (end_ - start_) + " times");
        // StringBuffer cho phép chúng ta thao tác trên một đối tượng duy nhất và thay đổi được nội dung trong nó.
        // Nếu ban đầu nội dung là "A", bạn muốn nối thêm "B" vào.
        // Thì nó chỉ cần gắn chuỗi bytes của "B" vào liền kề ngay sau "A" là xong.
        // (Vì nó có thể thay đổi, khác với String là immutable).
    }
}