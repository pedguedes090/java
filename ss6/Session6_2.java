package Session6;

import java.util.Scanner;

class Account {
    private String userName;
    private String password;
    private String email;

    public Account(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public void display() {
        System.out.println("Email: " + email);
        System.out.println("Username: " + userName);
    }

    public void changePassword() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mật khẩu mới: ");
        String pass1 = sc.nextLine();

        System.out.print("Nhập lại mật khẩu: ");
        String pass2 = sc.nextLine();

        if (pass1.trim().isEmpty() || pass2.trim().isEmpty()) {
            System.out.println("Mật khẩu không được để trống");
            return;
        }

        if (pass1.equals(pass2)) {
            password = pass1;
            System.out.println("Đổi mật khẩu thành công");
        } else {
            System.out.println("Hai mật khẩu không khớp");
        }
    }
}

public class Session6_2 {
    public static void main(String[] args) {
        Account acc1 = new Account("phuongvy@gmail.com", "PhuongVy", "123456"
        );

        acc1.display();
        acc1.changePassword();
    }
}
