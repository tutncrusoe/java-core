import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Dat van de:
 * khi chúng ta muốn gọi tên thuộc tính,
 * mà lại không muốn gõ "." và nhớ ra tên thuộc tính, thì làm như nào?
 * <p>
 * Bây giờ, chúng ta phải tiếp cận từ góc nhìn khác.
 * Chúng ta sẽ ước mình có thể duyệt hết tất cả các thuộc tính của 1 class bằng vòng lặp.
 * Rồi check xem thuộc tính có là String không? nếu có thì gán giá trị mới.
 * <p>
 * Để làm được điều này, chúng ta cần đào sâu vào Class và phá vỡ giới hạn của java truyền thống. Đây là lúc Java Reflection vào trận.
 * <p>
 * Java Reflecion cho phép bạn đánh giá,
 * sửa đổi cấu trúc và hành vi của một đối tượng tại thời gian chạy (runtime) của chương trình.
 * Đồng thời nó cho phép bạn truy cập vào các thành viên private (private member) tại mọi nơi trong ứng dụng,
 * điều này không được phép với cách tiếp cận truyền thống.
 *
 * https://viblo.asia/p/javahuong-dan-java-reflection-djeZ1bMglWz
 */
public class ReBottle {

    private String name;
    private int number; // wrapper of int is Integer, not int

    public ReBottle() {
    }

    public ReBottle(String name, int number) {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BottleGetField{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        /**
         * Quay trở lại ví dụ trên, Chúng ta sẽ lấy ra toàn bộ thuộc tính của Bottle.
         * Tìm xem cái nào tên name và bổ sung giá trị mới cho nó.
         */
        ReBottle reBottleRefl = new ReBottle();
        reBottleRefl.setName("Coca-Cola");
        reBottleRefl.setNumber(1);

        // Lấy ra Thuộc tính (Field)
        for (Field field : reBottleRefl.getClass().getDeclaredFields()) {
            System.out.println();
            System.out.println("Field: " + field.getName());
            System.out.println("Type: " + field.getType());
        }
        // BottleGetField{name='Coca-Cola', number=1}
        System.out.println(reBottleRefl.toString());

        // PHẦN CHÍNH Lấy ra Thuộc tính (Field)
        // Lấy ra field có tên "name" (nếu không tìm thấy, nó sẽ bắn NoSuchFieldException)
        Field nameField = reBottleRefl.getClass().getDeclaredField("name");
        // Cho phép truy cập tạm thời. (Vì nó đang là Private mà)
        nameField.setAccessible(true);
        // Bây giờ cái "nameField" đại diện cho thuộc tính "name" của mọi object có class Girl.
        nameField.set(reBottleRefl, "Pepsi"); // thay giá trị mới của `bottle` bằng nameField.
        // BottleGetField{name='Pepsi', number=1}
        System.out.println(reBottleRefl);

        Field numberField = reBottleRefl.getClass().getDeclaredField("number");
        numberField.setAccessible(true);
        numberField.set(reBottleRefl, 2); // thay giá trị mới của `girl` bằng nameField.
        // BottleGetField{name='Pepsi', number=2}
        System.out.println(reBottleRefl);

        //        Field: name
        //        Type: class java.lang.String
        //
        //        Field: number
        //        Type: int
        //        BottleGetField{name='Coca-Cola', number=1}
        //        BottleGetField{name='Pepsi', number=1}
        //        BottleGetField{name='Pepsi', number=2}

        /**
         * Lấy ra Hàm (Method)
         * Vấn đề đặt ra, giống với field.
         * Chúng ta cũng sẽ có nhu cầu duyệt tìm một method nào đó và sử dụng nó:
         */
        Class<ReBottle> reflectionClass = ReBottle.class;
        // Su dung getDeclaredMethods de lay ra nhung method cua class va cha no.
        Method[] methods = reflectionClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println();
            System.out.println("Method: " + method.getName());
            System.out.println("Parameters: " + Arrays.toString(method.getParameters()));
        }

        //        Method: main
        //        Parameters: [java.lang.String[] arg0]
        //
        //        Method: toString
        //        Parameters: []
        //
        //        Method: setName
        //        Parameters: [java.lang.String arg0]
        //
        //        Method: setNumber
        //        Parameters: [int arg0]

        // Lay ra method ten la setName va co 1 tham so truyen vao ->
        // => chính là: setName(String name)
        Method methodSetName = reflectionClass.getMethod("setName", String.class);
        Method methodSetNumber = reflectionClass.getMethod("setNumber", int.class);

        // Bây giờ methodSetName sẽ đại diện cho method setName(String name) của mọi object có class là BottleReflection

        // Tiep tuc
        // Tạo ra đối tượng bottleReflection1
        ReBottle reBottle1 = new ReBottle();
        // Thực hiện hàm setName() trên đối tượng bottleReflection1, giá trị truyền vào là "Beer"
        methodSetName.invoke(reBottle1, "Beer");
        methodSetNumber.invoke(reBottle1, 0);
        System.out.println(reBottle1);
        //        BottleGetField{name='Beer', number=0}

        /**
         * Lấy ra Constructor
         * Lấy ra hàm khởi tạo của một class.
         * Từ đó cho phép chúng ta cách tạo ra đối tượng từ theo một cách khác,
         * thay vì new Class() như bình thường
         */

        System.out.println("Class " + reflectionClass.getSimpleName());
        //        Class Bottle

        // Lấy ra toàn bộ Constructor của class này
        System.out.println("Constructors: " + Arrays.toString(reflectionClass.getConstructors()));
        //        Constructors: [public Bottle(), public Bottle(java.lang.String,java.lang.Integer)]
        try {
            // Tạo ra một object Bottle từ class. (Khởi tạo không tham số)
            ReBottle reBottle = reflectionClass.newInstance();
            System.out.println("Bottle " + reBottle);
            //            Bottle BottleGetField{name='null', number=null}

            // Lấy ra hàm constructor với tham số là 2 String, and Integer
            // Chính là -> public Bottle(String name) {}
            Constructor<ReBottle> constructor = reflectionClass.getConstructor(String.class, int.class);
            ReBottle reBottle2 = constructor.newInstance("Heineken", 1);
            System.out.println("Bottle2: " + reBottle2);
            //            Bottle2: BottleGetField{name='null', number=null}
        } catch (Exception e) {
            // Exception xay ra khi constructor khong ton tai hoac tham so truyen vao khong dung
            e.printStackTrace();
        }
    }
}
