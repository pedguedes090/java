import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // menu da cap
        int choice=0;
        do{
            System.out.println("Menu");
            System.out.println("1.Category management");
            System.out.println("2.Book management");
            System.out.println("3.Exit");
            System.out.println("Nhap lua chon cua ban: ");
            choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    int subChoice=0;
                    do{
                        System.out.println("Quan ly danh muc");
                    }while(subChoice!=0);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:

            }
        }while(choice!=3);
    }
}