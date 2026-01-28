package Session4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Session4_bai5 {

        public static void main(String[] args) {
            String log = "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345";

            String regex = "(\\d{4}-\\d{2}-\\d{2})\\s*\\|\\s*User:\\s*([A-Za-z]+)\\s*\\|\\s*Action:\\s*(BORROW|RETURN)\\s*\\|\\s*BookID:\\s*(\\w+)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(log);

            if (matcher.find()) {
                String date = matcher.group(1);
                String user = matcher.group(2);
                String action = matcher.group(3);
                String bookId = matcher.group(4);

                System.out.println("Ngay thang : " + date);
                System.out.println("Nguoi dung : " + user);
                System.out.println("Hanh dong  : " + action);
                System.out.println("Ma sach    : " + bookId);
            } else {
                System.out.println("Dong log khong hop le!");
            }
        }
    }

