import java.util.Objects;

/**
 * Trong Java, tính đa kế thừa là không khả thi bằng cách mở rộng các class.
 * Tuy nhiên, một class có thể triển khai nhiều interface.
 * Điều này cho phép chúng ta có được tính năng của tính đa kế thừa trong Java.
 *
 * Tương tự như các class, interface có thể mở rộng các interface khác.
 * Các từ khóa extends được sử dụng để mở rộng interface.
 *
 * Lưu ý rằng một interface có thể mở rộng nhiều interface tương tự như một class triển khai nhiều interface.
 */
public interface GenericsInterfaceExtend extends GenericsInterface<Integer> {

    Integer printNumber();

    Integer getData(Integer data);

    /**
     * Không thể @Override lại phương thức static, vì nó không cho phép Generics
     * Vì không thể @Override nên chỉ dụng sử dụng.
     */
    static boolean isEquals(Integer data) {
        System.out.println("Interface Equals Check: ");

        return Objects.equals(data, number);
    }
}

/**
 * Giống như các class trừu tượng, chúng ta không thể khởi tạo các đối tượng của interface.
 * Tuy nhiên, chúng ta có thể thực thi các interface trong các class khác.
 * Trong Java, chúng ta sử dụng từ khóa implements để thực thi các interface.
 *
 * Các interface cung cấp các specification mà một class (class thực thi nó) phải tuân theo.
 */
class ClassImpl implements GenericsInterfaceExtend {

    @Override
    public Integer printNumber() {
        System.out.println("Number: " + getData(number));
        return number;
    }

    @Override
    public Integer getData(Integer data) {
        return data;
    }



}
