//https://viblo.asia/p/interface-trong-java-8-gioi-thieu-default-method-va-static-method-PDOkqLqjejx
public interface ThirdInterface {

    default void print(String string) {
        if (!isNull(string))
            System.out.println("ThirdInterface Print: " + string);
    }

    /**
     * static được dùng cho default
     *
     * Nếu static đổi thành default, thì print sẽ sử dụng isNull trong ThirdImpl
     *
     * Static không thể gọi trực tiếp từ obj, chỉ có thể sử dụng trực tiếp từ Interface.
     */
    static boolean isNull(String string) {
        System.out.println("Interface Null Check");

        return string == null ? true : "".equals(string) ? true : false;
    }

    // Or

    /**
     * default được dùng cho default
     */
//    default boolean isNull(String string) {
//        System.out.println("Interface Null Check");
//
//        return string == null ? true : "".equals(string) ? true : false;
//    }
}

class ThirdImpl implements ThirdInterface {

    public boolean isNull(String string) {
        System.out.println("Impl Null Check");

        return string == null ? true : false;
    }
}