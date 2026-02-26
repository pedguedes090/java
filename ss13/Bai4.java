import java.util.LinkedList;

public class Bai4 {
    static class EmergencyRoom{
        private LinkedList<String> queue=new LinkedList<>();

        public void emergencyCheckIn(String name){
            queue.addLast(name);
        }
        public void patientCheckIn(String name){
            queue.addFirst(name);
        }
        public void treatPatient(){
            if(queue.isEmpty()){
                System.out.println("Het benh nhan");
                return;
            }
            String patient=queue.removeFirst();
            System.out.println("Dang kham: "+patient);
        }
    }
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        System.out.println("\n--- Bắt đầu điều trị ---");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}
