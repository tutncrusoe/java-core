/**
 * Một lớp lồng không tĩnh là một lớp trong một lớp khác.
 * Nó có quyền truy cập vào các thành viên của lớp kèm theo (lớp ngoài).
 * Nó thường được gọi là inner class.
 */
public class User {

    // Instance variables
    String username;
    String email;

    // assign values using constructor
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // private getter, setter
    protected String getUsername() {
        return this.username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getEmail() {
        return this.email = email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    class Address {

        // Instance variables
        protected String nationality;

        // getter, setter methods
        public void setNationality() {

            // Accessing the email property of User
            if (User.this.username.equals("Huy")) {

                if (User.this.getEmail().equals("huy@vn")) {
                    this.nationality = "Viet Nam";
                } else {
                    this.nationality = "US";
                }
            }
        }

        public String getNationality() {
            return this.nationality;
        }
    }
}
