package lw04.prelab;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int N = sc.nextInt();
        int[] Nval = new int[N];
        
        for (int i = 0; i < N; i++) {
            Nval[i] = sc.nextInt();
        }

        for (int i = 1; i <= 3; i++){
            int key = Nval[i];
            int j = i-1;

            while (j >= 0 && Nval[j] < key) {
                Nval[j+1] = Nval[j];
                j = j-1;
            }
            Nval[j+1] = key;
        }
    
        for (int i = 0; i < Nval.length; i++) {
            System.out.print(Nval[i] + " ");
        }
        System.out.println();

        int M = sc.nextInt();
        int[] Mval = new int[M];
        for (int i = 0; i < M; i++) {
            Mval[i] = sc.nextInt();
        }

        for (int i = 0; i < Mval.length; i++) {
            int index = i;
            boolean found = false;
            for (int j = 0; j < Nval.length; j++) {
                if (Mval[i] == Nval[j]) {
                    index = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println(Mval[i] + ": FOUND at index " + index);
            } else {
                System.out.println(Mval[i] + ": NOT FOUND");
            }
        }
        sc.close();
    }
}
