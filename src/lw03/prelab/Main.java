package lw03.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Problem 1 =====");
        List<String> playlist = new ArrayList<>();

        Scanner playlistScanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while (playlistScanner.hasNext()) {
            String command = playlistScanner.next();

            if (command.equals("ADD")) {
                String song = playlistScanner.nextLine().trim();
                playlist.add(song);
            } else if (command.equals("REMOVE")) {
                String song = playlistScanner.nextLine().trim();
                playlist.remove(song);
            } else if (command.equals("INSERT")) {
                int index = playlistScanner.nextInt();
                String song = playlistScanner.nextLine().trim();
                playlist.add(index, song);
            }
        }
        playlistScanner.close();

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        System.out.println("===== Problem 2 =====");
        Set<String> participants = new LinkedHashSet<>();
        int duplicateRegistrations = 0;

        Scanner participantsScanner = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        while (participantsScanner.hasNextLine()) {
            String name = participantsScanner.nextLine().trim();
            if (name.isEmpty()) {
                continue;
            }

            if (participants.contains(name)) {
                duplicateRegistrations++;
            } else {
                participants.add(name);
            }
        }
        participantsScanner.close();

        System.out.println("Unique participants: " + participants.size());
        int number = 1;
        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }
        System.out.println("Duplicate registrations: " + duplicateRegistrations);

        System.out.println("===== Problem 3 =====");
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        Scanner inventoryScanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while (inventoryScanner.hasNext()) {
            String type = inventoryScanner.next();
            String product = inventoryScanner.next();
            int quantity = inventoryScanner.nextInt();

            if (type.equals("ADD")) {
                if (inventory.containsKey(product)) {
                    inventory.put(product, inventory.get(product) + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product, inventory.get(product) - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        inventoryScanner.close();

        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }
        System.out.println("Failed sales: " + failedSales);
    }
}