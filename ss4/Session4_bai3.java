package Session4;

public class Session4_bai3 {
    public static void main(String[] args) {

        String[] transactions = {
                "BK001-20/01",
                "BK005-21/01",
                "BK099-22/01"
        };

        long startSB = System.currentTimeMillis();

        StringBuilder report = new StringBuilder();
        report.append("--- BAO CAO MUON SACH ---\n");
        report.append("Ngay tao: 24/01/2026\n");

        for (int i = 0; i < transactions.length; i++) {
            report.append("Giao dich: ")
                    .append(transactions[i])
                    .append("\n");
        }


        long endSB = System.currentTimeMillis();

        long startS = System.currentTimeMillis();

        String report2 = "--- BAO CAO MUON SACH ---\n";
        report2 += "Ngay tao: 24/01/2026\n";

        for (int i = 0; i < transactions.length; i++) {
            report2 += "Giao dich: " + transactions[i] + "\n";
        }

        long endS = System.currentTimeMillis();
        System.out.println(report.toString());
        System.out.println("So thoi gian thuc thi doi voi StringBuilder: " + (endSB - startSB));
        System.out.println("So thoi gian thuc thi doi voi String: " + (endS - startS));
    }
}
