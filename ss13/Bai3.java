import java.util.ArrayList;
import java.util.List;

public class Bai3 {
    public static <T> List<T> findCommon(List<T> listA,List<T> listB){
        List<T> result =new ArrayList<>();
        for(T item:listA){
            if(listB.contains(item) && !result.contains(item)){
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> noiKhoaID = new ArrayList<>();
        noiKhoaID.add(101);
        noiKhoaID.add(102);
        noiKhoaID.add(105);

        List<Integer> ngoaiKhoaID = new ArrayList<>();
        ngoaiKhoaID.add(102);
        ngoaiKhoaID.add(105);
        ngoaiKhoaID.add(108);

        List<Integer> ketQua1 = findCommon(noiKhoaID, ngoaiKhoaID);
        System.out.println("Test Case 1 Output: " + ketQua1);


        // ===== Test Case 2: String =====
        List<String> noiKhoaBHYT = new ArrayList<>();
        noiKhoaBHYT.add("DN01");
        noiKhoaBHYT.add("DN02");
        noiKhoaBHYT.add("DN03");

        List<String> ngoaiKhoaBHYT = new ArrayList<>();
        ngoaiKhoaBHYT.add("DN02");
        ngoaiKhoaBHYT.add("DN04");

        List<String> ketQua2 = findCommon(noiKhoaBHYT, ngoaiKhoaBHYT);
        System.out.println("Test Case 2 Output: " + ketQua2);

    }
}
