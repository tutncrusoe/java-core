public interface Interface {

    default void log(String string){
        System.out.println("This method is default in Interface: " + string);
    }

}
