public class User {

    String name;
    String password;
    boolean isAdmin;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password +  " isAdmin=" + isAdmin + '}';
    }
}
