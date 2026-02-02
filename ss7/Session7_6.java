package Session7;
import java.util.ArrayList;
import java.util.List;

class User {
    private final int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void display() {
        System.out.println("User{id=" + id + ", username='" + username + "'}");
    }
}

class UserManager {
    private static final List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        if (findById(user.getId()) != null) {
            System.out.println("ID da ton tai: " + user.getId());
            return;
        }
        users.add(user);
        System.out.println("Them user thanh cong: " + user.getUsername());
    }

    public static User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public static User findByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) return u;
        }
        return null;
    }

    public static void displayAll() {
        for (User u : users) {
            u.display();
        }
    }
}

public class Session7_6 {
    public static void main(String[] args) {
        User u1 = new User(1, "trung", "123");
        User u2 = new User(2, "anh", "456");

        UserManager.addUser(u1);
        UserManager.addUser(u2);

        UserManager.addUser(new User(1, "dup", "999"));

        User found1 = UserManager.findById(2);
        System.out.println(found1 != null ? found1.getUsername() : "Khong tim thay");

        User found2 = UserManager.findByUsername("trung");
        System.out.println(found2 != null ? found2.getId() : "Khong tim thay");

        UserManager.displayAll();
    }
}
