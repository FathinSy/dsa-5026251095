package lw04.unguided;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        int N = sc.nextInt();
        int[] parcelsWeight = new int[N];
        for (int i = 0; i < parcelsWeight.length; i++) {
            parcelsWeight[i] = sc.nextInt();
        }

        int length = parcelsWeight.length;
        for (int i = 0; i < length-1; i++) {
            boolean swapped = false;

            for (int j = 0; j < length-1; j++) {
                if (parcelsWeight[j] < parcelsWeight[j+1]) {
                    int temp = parcelsWeight[j];
                    parcelsWeight[j] = parcelsWeight[j+1];
                    parcelsWeight[j+1] = temp;
                    swapped = true;
                }
            }

            if (i == 1) {
                System.out.println("==== After 2 Passes ====");
                for (int j = 0; j < parcelsWeight.length; j++) {
                    System.out.print(parcelsWeight[j] + " ");
                }
            }

            if (!swapped) {
                System.out.println();
                System.out.println("\n==== Fully Sorted ====");
                for (int j = 0; j < parcelsWeight.length; j++) {
                    System.out.print(parcelsWeight[j] + " ");
                }
                break;
            }
        }

        int M = sc.nextInt();
        int[] targetWeight = new int[M];
        for (int i = 0; i < targetWeight.length; i++) {
            targetWeight[i] = sc.nextInt();
        }
        
        System.out.println();
        System.out.println("\n==== Search Results ====");
        for (int i = 0; i < targetWeight.length; i++) {
            int target = targetWeight[i];
            int low = 0;
            int high = parcelsWeight.length-1;
            int steps = 0;
            int index = 0;
            boolean found = false;

            while (low <= high) {
                steps++;
                int mid = (low + high) / 2;

                if (target == parcelsWeight[mid]) {
                    found = true;
                    index = mid;
                    break;
                } else if (target > parcelsWeight[mid]) {
                    high = mid-1;
                } else {
                    low = mid + 1;
                }
            }
            if (found) {
                System.out.println(target + ": FOUND at index " + index + " (Steps: " + steps + ")");
            } else {
                System.out.println(target + ": NOT FOUND (Steps: " + steps + ")");
            }
        }

    }
}
