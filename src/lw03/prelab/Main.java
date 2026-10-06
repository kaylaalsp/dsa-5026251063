    package lw03.prelab;
    import java.util.*;

    public class Main {
        public static void main(String[] args) {
            System.out.println("===== Problem 1 =====");
            List<String> playlist = new ArrayList<>();

            Scanner sc1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

            while (sc1.hasNextLine()) {
                String line = sc1.nextLine();
                String[] parts = line.split(" ",2);

                String operation = parts[0];
                String song = parts[1];

                if(operation.equals("ADD")) {
                    playlist.add(song);
                } else if (operation.equals("INSERT")) {
                    String[] insertData = song.split(" ",2);
                    int index = Integer.parseInt(insertData[0]);
                    String songName = insertData[1];
                    playlist.add(index, songName);
                } else if (operation.equals("REMOVE")) {
                    playlist.remove(song);
                }
            }

            sc1.close();
            System.out.println("Total songs: " + playlist.size());

            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ": " + playlist.get(i));
            }

            System.out.println();

            System.out.println("===== Problem 2 =====");
            Set<String> participants = new LinkedHashSet<>();

            int duplicateRegistrations = 0;

            Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));

            while(sc2.hasNextLine()) {
            String name = sc2.nextLine();

            if (!participants.add(name)) {
                duplicateRegistrations++;
            }
        }

        sc2.close();
        System.out.println("Duplicate registrations: " + duplicateRegistrations);
        }
    }