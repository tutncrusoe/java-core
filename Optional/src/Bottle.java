import java.util.Optional;

/**
 * Chắc hẳn trong chúng ta ai cũng một lần bị ám ảnh bởi NullPointerException huhu.
 * Mặc dù tới nay, các ngôn ngữ mới đều đã kiểm soát null để đảm bảo những dòng code được an toàn (Scala, Kotlin).
 * Tuy nhiên, Java chưa nằm trong số đó.
 * <p>
 * Java 8 ra đời cùng với một class mới tên là Optional.
 * Nhiệm vụ của nó là kiểm soát null hộ chúng ta.
 * <p>
 * Tới đây mình đã giới thiệu xong với các bạn các tính năng khá hay ho của Optional.
 * Ngoài việc giúp chúng ta kiểm soát NullException thì còn giúp code của chúng ta sáng sủa hơn rất nhiều và thuận tiện hơn trong nhiều trường hợp yêu cầu điều kiện phức tạp.
 */
class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

public class Bottle {

    private Shape shape;

    public Shape getShape() {
        return shape;
    }

    public Bottle(Shape shape) {
        this.shape = shape;
    }

    /**
     * map() giúp chúng ta biến đổi đối tượng bên trong Optional.
     */
    public static String mapShapeName(Bottle bottle) {
        return Optional.ofNullable(bottle) // Tạo ra Optional wrap lấy bottle
                .map(Bottle::getShape) // nếu bottle != null thì lấy shape ra xem, ngược lại trả ra Optional.empty()
                .map(Shape::getName)// nếu shape != null thì lấy ra xem name của nó
                .orElse("Nothing"); // Nếu cuối cùng là Optional.empty() thì trả ra ngoài Nothing
    }

    /**
     * filter() giúp chúng ta kiểm tra giá trị trong Optional nếu không thỏa mãn điều kiện, trả về empty()
     */
    public static String filterShapeName(Bottle bottle) {
        return Optional.ofNullable(bottle)
                .map(Bottle::getShape)
                .map(Shape::getName)
                .filter(s -> s.contains("rectangle")) // Nó chỉ chấp nhận giá trị Pepsi, còn lại dù khác null thì vẫn trả ra ngoài là Optiional.empty()
                .orElse("Nothing");
    }

    public static void main(String[] args) {

        /**
         * Optional<T> là một đối tượng Generic, nhiệm vụ chính của nó là bọc hay wrapper lấy một object khác.
         * Nó chỉ chứa được một object duy nhất bên trong.
         * <p>
         * Việc bạn lấy giá trị của object bây giờ sẽ thông qua Optional và nếu object đó null cũng không sao,
         * vì thằng Optional kiểm soát nó chặt chẽ hơn là if else.
         */
        // Basic
        String name = null;
        // Tạo ra một đối tượng Optional
        Optional<String> optional = Optional.ofNullable(name);
        optional.ifPresent(nameString -> System.out.println(nameString));
        // Bây giờ Optional đã wrap lấy cái str.

        /**
         * ifPresent nhận vào một Consumer,
         * nó cũng chỉ là Functional Interface thôi các bạn.
         * Nhận vào một đối tượng và thao tác trên nó, không return gì cả.
         */
        // ifPresent
        String nameString = "Coca-Cola";
        Optional<String> optional1 = Optional.ofNullable(nameString);
        if (optional1.isPresent()) {
            System.out.println(optional1.get());
            // Coca-Cola
        }

        /**
         * orElse() lấy ra object trong Optional.
         * Nếu null, trả về giá trị mặc định do bạn quy định
         */
        // orElse()
        String name_orElse = optional1.orElse("name");
        System.out.println(name_orElse);
        // Coca-Cola
        /**
         * orElseGet() Tương tự orElse() nhưng trả ra bằng Supplier interface.
         */
        // orElseGet()
        String string = optional1.orElseGet(() -> {
            StringBuilder stringBuilder = new StringBuilder();
            // Thao tác phức tạp
            return stringBuilder.toString();
        });
        System.out.println(string);
        // Coca-Cola

        /**
         * map() giúp chúng ta biến đổi đối tượng bên trong Optional.
         */
        // map()
        Shape shape = new Shape("square");
        Bottle bottle = new Bottle(shape);
        mapShapeName(bottle);
        System.out.println(bottle.shape.getName());

        /**
         * filter() giúp chúng ta kiểm tra giá trị trong Optional nếu không thỏa mãn điều kiện, trả về empty()
         */
        Bottle filter = new Bottle(new Shape("rectangle"));
        filterShapeName(filter);
        System.out.println(filter.shape.getName());
    }
}


