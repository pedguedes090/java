public class ss3_3 {
    public static void maxQuantityOfBooks(String[] names, int[] quantities){
        int max = quantities[0];
        for(int i = 1; i < quantities.length; i++) if (quantities[i] > max) max = quantities[i];
        System.out.println("Sach co so luong nhieu nhat (" + max + "):");
        for(int i = 0; i < quantities.length; i++) if(quantities[i] == max) System.out.println("- " + names[i]);
    }
    public static void minQuantityOfBooks(String[] names, int[] quantities){
        int min = quantities[0];
        for(int i = 1; i < quantities.length; i++) if (quantities[i] < min) min = quantities[i];
        System.out.println("Sach co so luong it nhat (" + min + "):");
        for(int i = 0; i < quantities.length; i++) if(quantities[i] == min) System.out.println("- " + names[i]);
    }

    public static void main(String[] args){
        String[] names = {"Java Basic", "Python Pro", "Web Design", "Data Structure", "Database System"};
        int quantities[] = {30, 50, 50, 5, 5};
        maxQuantityOfBooks(names, quantities);
        System.out.println("---------------------");
        minQuantityOfBooks(names, quantities);
    }
}
