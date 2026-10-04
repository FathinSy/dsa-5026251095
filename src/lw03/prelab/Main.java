package lw03.prelab;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        List<String> playlist = new ArrayList<>();
        Set<String> participants = new LinkedHashSet<>();
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int dupParticipant = 0;
        int failedSales = 0;
        
        while (sc1.hasNext()) {
            String operation = sc1.next();
            String song;
            int index = playlist.size();

            switch (operation) {
                case "ADD":
                    song = sc1.nextLine();
                    playlist.add(index, song);
                    break;
                case "INSERT":
                    index = sc1.nextInt();
                    song = sc1.nextLine();
                    playlist.add(index, song);
                    break;
                case "REMOVE":
                    song = sc1.nextLine();
                    playlist.remove(song);
                    break;
            }
        }


        while (sc2.hasNext()) {
            String newParticipant = sc2.next();

            for (String p : participants) {
                if (newParticipant.equals(p)) {
                    dupParticipant++;
                }
            }
            participants.add(newParticipant);
        }

        while (sc3.hasNext()) {
            String type = sc3.next();
            String product = sc3.next();
            int quantity = sc3.nextInt();
            int avail = 0;

            if (inventory.containsKey(product)) {
                avail = inventory.get(product);
            }

            switch (type) {
                case "ADD":
                    inventory.put(product, avail + quantity);
                    break;
                default:
                    if (quantity > avail) {
                        failedSales++;
                    } else {
                        inventory.put(product, avail - quantity);
                    }
                    break;
            }
        }
        
        System.out.println("===== Problem 1 =====");
        System.out.println("Total Songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i+1 + ": " + playlist.get(i));
        }

        System.out.println();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique Participants: " + participants.size());
        int counter = 1;
        for (String n : participants) {
            System.out.println(counter + ". " + n);
            counter++;
        }
        System.out.println("Duplicate Registrations: " + dupParticipant);

        System.out.println();
        System.out.println("===== Problem 3 =====");
        inventory.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
        System.out.println("Failed sales: " + failedSales);

        sc1.close();
        sc2.close();
        sc3.close();
    }
}
