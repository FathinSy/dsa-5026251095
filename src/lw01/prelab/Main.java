package lw01.prelab;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        List<PrintJob> jobs = new ArrayList<>();

        for (int i=0; i<5; i++) {
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();

            if (type.equals("MONO")) {
                jobs.add(new MonoPrint(id, pages));
            }
            else if (type.equals("COLOUR")) {
                jobs.add(new ColourPrint(id, pages));
            }
        }

        for (int i=0; i<jobs.size(); i++) {
            PrintJob job = jobs.get(i);
            System.out.println(job.summary());
        }
    }   
}
