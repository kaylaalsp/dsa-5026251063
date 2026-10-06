package lw03.unguided;

import java.util.*;

public class Main {
        public static void main(String[] args) {
            Set<String> registrations = new LinkedHashSet<>();
            
            Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));

            while(sc1.hasNextLine()) {
            String student_id = sc1.nextLine();

            registrations.add(student_id);
        }

        sc1.close();

        List<String> checkins = new ArrayList<>();
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        System.out.println("===== Event Check-In Results =====");
        int rejectedStudent = 0;

        while(sc2.hasNextLine()) {
            String line = sc2.nextLine();
            String student_id = line.trim();

            if(!checkins.contains(student_id) && registrations.contains(student_id)) {
                checkins.add(student_id);
                System.out.println(line + " : Checked in");
            } else if (checkins.contains(student_id)) {
                System.out.println(line + " : Rejected (already checked in)");
                rejectedStudent++;
            } else {
                System.out.println(line + " : Rejected (not registered)");
                rejectedStudent++;
            }
        }
        System.out.println();

        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered Students: " + registrations.size());
        System.out.println("Checked-ins Students: " + checkins.size());
        System.out.println("Absent Students: " + (registrations.size() - checkins.size()));
        System.out.println("Rejected Attempts: " + rejectedStudent);

        sc2.close();
    }
}