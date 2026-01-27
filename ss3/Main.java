//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arrayInt;
        Object[] arrayObject;
        arrayInt = new int[10];
        arrayObject = new Object[10];

        arrayInt[0] = 10;
        arrayInt[1] = 20;
        arrayInt[2] = 30;

        arrayObject[0] = "Hello";
        arrayObject[1] = 3.14;

        String[] arrayStr = {"java","C++"};

        //kiểm tra độ dài mảng
        System.out.println(arrayStr.length);

        //duyệt mảng : thuật toán tuần tự
        // fori : duyệt mảng theo chỉ số
        //duệt mảng arrayInt tìm ra số lớn nhất
        int max = arrayInt[0];
        for(int i = 1; i < arrayInt.length; i++){
            if(arrayInt[i] > max) max = arrayInt[i];
        }
        // foreach duyệt mảng theo gi trị
        for(int element : arrayInt){
            System.out.println(element);
        }

        // kỹ thutaaj lập trình
        // count sum multi, avg , min max, flag,search
        // đếm số lượng phần tử trong 1 danh sách cho trước
        // tính tổng của các phần tử teong mảng số
        //tính min max trong 1 danh sách
        // khi bài toán yêu cầu kiểm tra kết quả có hay không mà cần





























    }
}