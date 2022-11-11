import java.util.Objects;

/**
 * Trong Java, tính đa kế thừa là không khả thi bằng cách mở rộng các class.
 * Tuy nhiên, một class có thể triển khai nhiều interface.
 * Điều này cho phép chúng ta có được tính năng của tính đa kế thừa trong Java.
 * <p>
 * Tương tự như các class, interface có thể mở rộng các interface khác.
 * Các từ khóa extends được sử dụng để mở rộng interface.
 * <p>
 * Lưu ý rằng một interface có thể mở rộng nhiều interface tương tự như một class triển khai nhiều interface.
 */
public interface GenericsInterfaceExtend extends GenericsInterface<Integer> {

    Integer printNumber();

    Integer getData(Integer data);

    /**
     * Không thể @Override lại phương thức static, vì nó không cho phép Generics
     * Vì không thể @Override nên chỉ dụng sử dụng.
     * Phương thức static giúp chúng ta bảo mật, không cho phép class implements từ nó có thể override
     * <p>
     * Phương thức static rất hữu ích trong việc cung cấp các phương thức tiện ích,
     * ví dụ như là kiểm tra null, sắp xếp tập hợp, v.v…
     */
    static boolean isEquals(Integer data) {
        System.out.println("GenericsInterfaceExtend Equals Check: " + Objects.equals(data, number));

        return Objects.equals(data, number);
    }

    /**
     * Khi một class được implements từ FirstInterface nó không bắt buộc phải implement phương thức default.
     * Tính năng này sẽ giúp chúng ta mở rộng các phương thức bổ sung phát sinh sau này mà không ảnh hưởng đến các class liên quan,
     * chúng ta chỉ cần viết thêm các phương thức default trong interface.
     */
    default Integer getSum(Integer data) {
        return number + data;
    }

    default void log(String string) {
        System.out.println("This method is default in GenericsInterfaceExtend: " + string);
    }
}

/**
 * Giống như các class trừu tượng, chúng ta không thể khởi tạo các đối tượng của interface.
 * Tuy nhiên, chúng ta có thể thực thi các interface trong các class khác.
 * Trong Java, chúng ta sử dụng từ khóa implements để thực thi các interface.
 * <p>
 * Lưu ý rằng một interface có thể mở rộng nhiều interface tương tự như một class triển khai nhiều interface.
 *
 * Chỉ cần một Class/Interface public
 */
class ClassImpl implements GenericsInterfaceExtend, Interface {

    @Override
    public Integer printNumber() {
        System.out.println("Number: " + getData(number));
        return number;
    }

    @Override
    public Integer getData(Integer data) {
        return data;
    }

    @Override
    public Integer getSum(Integer data) {
        return GenericsInterfaceExtend.super.getSum(data);
    }

    /**
     * Nếu bất kỳ class nào kế thừa những phương thức default giống nhau, thì nó sẽ không còn hiệu lực.
     * Ở đây chúng ta chỉ có thể @Override 1 trong 2 method log.
     */
//    @Override
//    public void log(String string) {
//        Interface.super.log(string);
//    }

    @Override
    public void log(String string) {
        System.out.println("ClassImpl: " + string);
    }

    /**
     * Một điều tương tự, một phương thức default sẽ không thể override một phương thức từ java.lang.Object.
     * Lý do rất đơn giản là bởi vì Object là base class của tất cả các class trong Java.
     * Vì vậy nếu chúng ta có các phương thức của class Object được định nghĩa là phương thức default trong interface,
     * nó sẽ không dùng được bởi vì các phương thức của Object luôn luôn được sử dụng.
     * Đây lý do tại sao chúng ta sẽ không có bất cứ phương thức default nào override các phương thức của class Object.
     */
}
