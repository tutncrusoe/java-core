import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@SuppressWarnings("deprecation")
@Deprecated
public class AnnotationBottle {
    private String name;

    public AnnotationBottle() {
    }

    public AnnotationBottle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnnotationBottle{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        /**
         * Lấy ra Annotation trên Field, Method, Class
         * Đúng vậy, đây cũng chính là một trong những phần quan trọng bậc nhất của Java Reflection.
         * Cho phép chúng ta kiểm tra Class hiện tại đang được chú thích bởi những Annotation nào.
         */
        Class<AnnotationBottle> aClass = AnnotationBottle.class;
        // Lấy ra tên Class
        System.out.println("Class: " + aClass.getSimpleName());
        //        Class: AnnotationBottle

        for (Annotation annotation : aClass.getDeclaredAnnotations()) {
            // Lấy ra tên các Annatation trên class này
            System.out.println("Annotation: " + annotation.annotationType());
            //        Annotation: interface java.lang.Deprecated
        }

        // Lấy ra các method của class
        for (Method method : aClass.getMethods()) {
            //Tên method
            System.out.println("\nMethod: " + method.getName());
            for (Annotation annotation : method.getAnnotations()) {
                // Lấy ra tên các Annatation trên method này
                System.out.println("Annotation: " + annotation.annotationType());
            }
        }

        //        Method: getName
        //
        //        Method: main
        //
        //        Method: toString
        //
        //        Method: setName
        //
        //        Method: wait
        //
        //        Method: wait
        //
        //        Method: wait
        //
        //        Method: equals
        //
        //        Method: hashCode
        //        Annotation: interface jdk.internal.vm.annotation.IntrinsicCandidate
        //
        //        Method: getClass
        //        Annotation: interface jdk.internal.vm.annotation.IntrinsicCandidate
        //
        //        Method: notify
        //        Annotation: interface jdk.internal.vm.annotation.IntrinsicCandidate
        //
        //        Method: notifyAll
        //        Annotation: interface jdk.internal.vm.annotation.IntrinsicCandidate
    }
}
