public class ss3_6 {
    public static int[] mergeBooks(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] merge = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            int value;
            if (a[i] < b[j]) value = a[i++];
            else if (a[i] > b[j]) value = b[j++];
            else {
                value = a[i];
                i++;
                j++;
            }
            if(k == 0 || merge[k - 1] != value) merge[k++] = value;
        }
        while (i < a.length) merge[k++] = a[i++];
        while (j < b.length) merge[k++] = b[j++];
        int[] result = new int[k];
        for (int t = 0; t < k; t++) result[t] = merge[t];
        return result;
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
        int[] books1 = {1, 3, 5, 7, 9};
        int[] book2 = {2, 3, 5, 6, 8, 9, 10};

        System.out.print("Kho cu: ");
        displayBooks(books1);
        System.out.print("Lo moi: ");
        displayBooks(book2);
        int[] mergeBooks = mergeBooks(books1, book2);
        System.out.print("Kho tong (da gop & loc trung): ");
        displayBooks(mergeBooks);
    }
}
