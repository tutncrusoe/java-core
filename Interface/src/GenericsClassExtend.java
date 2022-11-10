import java.util.Objects;

/**
 * Trong Java, tính đa kế thừa là không khả thi bằng cách mở rộng các class.
 * Tuy nhiên, một class có thể triển khai nhiều interface.
 * Điều này cho phép chúng ta có được tính năng của tính đa kế thừa trong Java.
 */
public interface GenericsClassExtend extends GenericsClass<Integer> {


    void printNumber();

    Integer getData(Integer data);

}

/**
 * Giống như các class trừu tượng, chúng ta không thể khởi tạo các đối tượng của interface.
 * Tuy nhiên, chúng ta có thể thực thi các interface trong các class khác.
 * Trong Java, chúng ta sử dụng từ khóa implements để thực thi các interface.
 *
 * Các interface cung cấp các specification mà một class (class thực thi nó) phải tuân theo.
 */
class GenericsClassExtendImpl implements GenericsClassExtend {

    @Override
    public void printNumber() {
        System.out.println("Number: " + getData(number));
    }

    @Override
    public Integer getData(Integer data) {
        return data;
    }

    public boolean isEquals(Integer data) {
        System.out.println("Impl Equals Check");

        return Objects.equals(data, number);
    }
}
