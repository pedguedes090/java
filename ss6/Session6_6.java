package Session6;
class User {
    private int id;
    private String userName;
    private String passWord;
    private String email;

    public User(int id, String userName, String passWord, String email) {
        this.id = id;
        this.userName = userName;
        setPassWord(passWord);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setPassWord(String passWord) {
        if (passWord != null && !passWord.trim().isEmpty()) {
            this.passWord = passWord;
        } else {
            System.out.println("Password khong duoc de trong!");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[\\w.-] + @[\\w.-] + \\.[a-zA-Z]{2,}$")) {
            this.email = email;
        } else {
            System.out.println("Email khong hop le!");
        }
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("--------------------------");
    }

}
public class Session6_6 {
    public static void main(String[] args) {
        User u1 = new User(1, "nguyenvana", "123456", "vana@gmail.com");
        u1.displayInfo();
        User u2 = new User(2, "tranthib", "abcdef", "email-sai");
        u2.displayInfo();
        User u3 = new User(3, "lequangc", "", "c@gmail.com");
        u3.displayInfo();
        System.out.println("Thu cap nhat du lieu sai:");
        u1.setEmail("sai-email");
        u1.setPassWord("");
        u1.displayInfo();
    }
}
