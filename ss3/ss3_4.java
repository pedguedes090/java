public class ss3_4 {
    public static void sortBooks(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) for(int j = 0; j < arr.length - i - 1; j++) if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
    public static void displayBooks(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        int books[] = {105, 102, 109, 101, 103};
        System.out.print("Truoc khi sap xep: ");
        displayBooks(books);
        sortBooks(books);
        System.out.print("Sau khi sap xep: ");
        displayBooks(books);
    }
}
