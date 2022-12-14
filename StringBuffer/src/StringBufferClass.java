/**
 * https://loda.me/articles/jav2-bien-phm-vi-kiu-d-liu-ton-t-trong-java
 * https://loda.me/articles/vi-sao-nen-su-dung-stringbuffer
 */
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
    /**
     * Bản chất của biến (Nói thêm)
     * Khi các bạn khai báo một biến int trong chương trình của mình và sử dụng lung tung khắp mọi nơi, thì bạn có biết cái biến int ý ở đâu lòi ra không :))
     *
     * Về bản chất, Biến sẽ là một vùng nhớ trong thiết bị vật lý mà dễ nhất là để trong ram. và khi bạn cho nó một giá trị, nó sẽ lưu trữ số đó vào ram, và cần thì lấy lên.
     *
     * Vậy để ram biết bạn muốn lưu cái gì thì bạn phải khai báo cho nó. Ví dụ bạn bảo tôi cần một số nguyên int. Thì máy tính hiểu là mình cần lưu trữ một số nguyên bình thường, không quá lớn, nó sẽ cho bạn 4 byte trong Ram thích lưu gì thì lưu. nhưng không được vượt quá 4 byte.
     *
     * 4 byte = 32 bit, bỏ đi 1 bit đầu tiên để đánh dấu là số âm hay dương, thì còn 31 bit => số lớn nhất mà biến int lưu trữ được là 2^31 - 1 = 2147483647
     * Từ đây, bạn sẽ hiểu vì sao có số long, vì nhu cầu lưu số lớn hơn thì long được cấp tận 8 byte.
     *
     * Còn trường hợp đặc biệt như String thì tuỳ giá trị của nó có bao nhiêu ký tự, mà Ram sẽ cấp tương ứng bấy nhiêu byte
     */
}