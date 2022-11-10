public class GenericsClassExtend <T extends Number> {

    private T data;

    public GenericsClassExtend(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }


}
