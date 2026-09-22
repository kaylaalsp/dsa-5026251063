package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner washes = new Scanner(Main.class.getResourceAsStream("washes.txt"));
        int washCount = washes.nextInt();
        WashService[] washList = new WashService[washCount];

        for (int i=0; i < washCount; i++) {
            String type = washes.next();
            String id = washes.next();
            int days = washes.nextInt();
            int units = washes.nextInt();

            if (type.equals("CAR")) {
                washList[i] = new CarWash(id, days);
            } else if (type.equals("MOTORCYCLE")) {
                washList[i] = new MotorcycleWash(id, days);
            }
        }
        washes.close();

        for (WashService wash : washList) {
            System.out.println(wash.getId() + " | " + wash.label() + " | " + wash.calculateCharge());
        }
    }
}
