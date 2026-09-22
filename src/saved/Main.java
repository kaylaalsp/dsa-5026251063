import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        int total = sc.nextInt();
        Rental[] rentalList = new Rental[total];

        for (int i = 0; i < total; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

            if (type.equals("LAPTOP")) {
                rentalList[i] = new LaptopRental(id, days);
            } else if (type.equals("PROJECTOR")) {
                rentalList[i] = new ProjectorRental(id, days);
            }
        }
        sc.close();

        for (Rental rental : rentalList) {
            System.out.println(rental.summary());
        }
    }
}