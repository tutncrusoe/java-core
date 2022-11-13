public class Main {
    public static void main(String[] args) {

        // create an object of the outer class User
        User user = new User("Huy", "huy@vn");
        // create an object of inner class using the outer class
        User.Address address = user.new Address();

        System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail());
        address.setNationality();
        System.out.println("Nationality: " + address.getNationality());

    }
}