public class GenericsClass<T> {

    private T data;

    public GenericsClass(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method with data: " + data);
    }
}
