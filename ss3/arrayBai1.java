import java.util.*;

public class arrayBai1 {
    public static void main(String[] args) {
        int n;
        System.out.println("mời bạn nhập số lượng phần tử mảng ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        System.out.print("Mảng vừa nhập : ");
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // tìm và in các số nguyên tố trong mảng
        System.out.print("Các số nguyên tố trong mảng: ");
        boolean coNguyenTo = false;
        for (int i = 0; i < n; i++) {
            int x = array[i];
            if (x > 1) {
                boolean isPrime = true;
                for (int j = 2; j * j <= x; j++) {
                    if (x % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime){
                    System.out.print(x + " ");
                    coNguyenTo = true;
                }
            }
        }
        if (!coNguyenTo){
            System.out.print("không có");
        };
        System.out.println();
        // tính tổng các số fibonaci trong mảng
        int sumFibo = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 1;
            while (b < array[i]) {
                int temp = b;
                b = a + b;
                a = temp;
            }
            if (b == array[i]) {
                sumFibo += array[i];
            }
        }
        System.out.println("Tổng các số Fibonacci trong mảng là: " + sumFibo);

        // tìm min max
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Min trong mảng = " + min);
        System.out.println("Max trong mảng = " + max);

        // tính tổng các giai thừa
        int sumFactorial = 0;
        for(int i = 0; i < n; i++){
            if(array[i] == 1|| array[i] == 0){
                sumFactorial += 1;
            }else {
                sumFactorial += array[i] * (array[i] - 1);
            }

        }
        System.out.println("Tổng các giai thừa trong mảng = " + sumFactorial);

    }



}
