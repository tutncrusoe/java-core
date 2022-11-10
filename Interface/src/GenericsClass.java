import java.io.Serializable;
import java.util.Objects;

public interface GenericsClass<I> {

    /**
     * Tất cả các class sử dụng interface này phải implements method getArea().
     * Điều quan trọng cần lưu ý là, tất cả các abstract methods bên trong một interface
     * đều được ngầm định là public và tất cả các thuộc tính đều được ngầm định là public static final.
     */
    public static final Integer number = 7;

    void printNumber();

    /**
     * Với việc phát hành Java 8, các interface giờ đây có thể bao gồm các phương thức tĩnh.
     */
    private int getNumber() {
        return number;
    }

    /**
     * Không thể @Override lại phương thức static, vì nó không cho phép Generics
     * Vì không thể @Override nên chỉ dụng sử dụng.
     */
    static boolean isEquals(Integer data) {
        System.out.println("Interface Equals Check");

        return Objects.equals(data, number);
    }

    default I getData(I data) {
        return data;
    }
}
