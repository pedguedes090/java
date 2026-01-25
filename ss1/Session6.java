import java.util.Scanner;
public class Session6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int stt;
        int ke;
        int viTri;
        String khu;
        System.out.print("Nhap so thu tu cua sach trong he thong (>0): ");
        stt=sc.nextInt();
        if(stt==0){
            System.out.println("STT sach khong hop le");
            return;
        }
        ke=(stt-1)/25 +1;
        viTri=(stt%25) == 0? 25: stt%25;
        khu= ke<=10 ? "Khu Can" :"Khu Vien";

        // in ra man hinh
        System.out.println("--- THONG TIN DINH VI ---");
        System.out.println("Sach so: "+ stt);
        System.out.printf("Dia chi: Ke %d - Vi tri %d \n",ke,viTri);
        System.out.println("Phan khu: "+khu);

    }
}
