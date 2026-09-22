package lw01.prelab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner jobs = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        List<PrintJob> printList = new ArrayList<>();

        while (jobs.hasNext()) {
            String type = jobs.next();
            String id = jobs.next();
            int pages = jobs.nextInt();

            if (type.equals("MONO")) {
                printList.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                printList.add(new ColourPrint(id, pages));
            }
        }
        jobs.close();

        for (PrintJob job : printList) {
            System.out.println(job.summary());
        }
    }
}