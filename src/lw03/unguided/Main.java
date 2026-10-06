package lw03.unguided;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> regist = new HashSet<>();
        Set<String> checkIns = new LinkedHashSet<>();
        int rejectCount = 0;

        while (sc1.hasNextLine()) {
            String idRegist = sc1.nextLine();
            regist.add(idRegist);
        }

        System.out.println("===== Event Check-In Results =====");
        while (sc2.hasNextLine()) {
            String idCheckins = sc2.nextLine();
            if (checkIns.contains(idCheckins)) {
                System.out.println(idCheckins + ": Rejected (already checked in)");
                rejectCount++;
            } else if (!regist.contains(idCheckins)) {
                System.out.println(idCheckins + ": Rejected (not registered)");
                rejectCount++;
            } else {
                checkIns.add(idCheckins);
                System.out.println(idCheckins + ": Checked in");
            }
        }

        int absentCount = regist.size()-checkIns.size();
        
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered Students: " + regist.size());
        System.out.println("Successful check-ins: " + checkIns.size());
        System.out.println("Absent Students: " + absentCount);
        System.out.println("Rejected attempts: " + rejectCount);

        sc1.close();
        sc2.close();
    }
}
