import java.util.ArrayList;
import java.util.Iterator;

public class Bai1 {
    public static void main(String[] args) {
        ArrayList<Double> nhietDo=new ArrayList<>();
        nhietDo.add(36.5);
        nhietDo.add(40.2);
        nhietDo.add(37.0);
        nhietDo.add(12.5);
        nhietDo.add(39.8);
        nhietDo.add(99.9);
        nhietDo.add(36.8);
        System.out.println("Danh sach ban dau: "+nhietDo);

        Iterator<Double> iterator=nhietDo.iterator();
        while(iterator.hasNext()){
            Double temp= iterator.next();
            if(temp<34.0 || temp>42.0){
                iterator.remove();
            }
        }
        System.out.println("Danh sach sau khi loc: "+nhietDo);
        double sum=0;
        for(Double v:nhietDo){
            sum+=v;
        }
        double avg=sum/nhietDo.size();
        System.out.printf("Nhiet do trung binh: %.2f", avg);
    }
}
