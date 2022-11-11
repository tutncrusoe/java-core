/**
 * Functional Interface là cách gọi khác của SAM(Single Abstract Method) interface,
 * tức là những interface chỉ có duy nhất một method, ví dụ như Runnable, Callable, Comparator, ActionListener, ...
 * Từ Java8, một annotation mới @FunctionalInterface cũng đã được giới thiệu để đánh dấu một interface nào đó là Functional Interface.
 * @FunctionalInterface annotation là tiện ích để tránh việc vô tình thêm vào các phương thức trong Functional Interface.
 */
@FunctionalInterface
public interface FunctionalInterfaces {

    void print();
}
