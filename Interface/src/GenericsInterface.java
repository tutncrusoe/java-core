public interface GenericsInterface<I> {

    /**
     * Tất cả các class sử dụng interface này phải implements method getArea().
     * Điều quan trọng cần lưu ý là, tất cả các abstract methods bên trong một interface
     * đều được ngầm định là public và tất cả các thuộc tính đều được ngầm định là public static final.
     */
    Integer number = 7; // public static final

    /**
     * abstract method
     */
    I printNumber();

    /**
     * Với việc phát hành Java 8,
     * các interface giờ đây có thể bao gồm các phương thức private and private static.
     */
    private I getNumber(I number) {
        return number;
    }

    /**
     * Chúng ta có thể thêm phương thức trong interface của mình một cách dễ dàng mà không cần thực hiện.
     * Tuy nhiên, câu chuyện chưa kết thúc ở đó.
     * Tất cả các class của chúng ta triển khai interface đó phải thực thi phương thức mới thêm vào đó.
     *
     * Nếu có nhiều class đang thực hiện interface này, chúng ta cần theo dõi tất cả các class này
     * và thực hiện các thay đổi trong chúng hoặc có class không cần phương thức mới đó mà bắt nó phải kế thừa thì rất dư code.
     * Điều này không chỉ tẻ nhạt mà còn dễ bị lỗi.
     *
     * Để giải quyết điều này, Java đã giới thiệu phương thức default.
     * Các phương thức default được kế thừa như các phương thức thông thường và nó sẽ không bắt buộc phải kể thừa.
     */
    default I getData(I data) {
        return getNumber(data);
    }

    default Integer getSum(Integer data) {
        return number + data;
    }

}
