package lw02.prelab;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactionLists = new LinkedList<>();
        LinkedList<String[]> custData = new LinkedList<>();
        Queue<String[]> transactionsQueue = new LinkedList<>();
        Stack<String[]> failedTransaction = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        while (sc.hasNext()) {
            String name = sc.next();
            String type = sc.next();
            String amount = sc.next();

            String[] data =  {name, type, amount};
            transactionLists.add(data);
            
            boolean newCust = true;
            for (String[] isNew : custData) {
                if (isNew[0].equals(name)) {
                     newCust = false;
                }
            }

            if (newCust) {
                String[] customer = {name, "0"};
                custData.add(customer);
            }
        }

        for (String[] cust : transactionLists) {
            transactionsQueue.add(cust);
        }

        while (!transactionsQueue.isEmpty()) {
            String[] data = transactionsQueue.poll();
            String name = data[0];
            String type = data[1];
            int amount = Integer.parseInt(data[2]);

            for (String[] elem : custData) {
                if (name.equals(elem[0])) {
                    int balance = Integer.parseInt(elem[1]);
                    if (type.equals("DEPOSIT")) {
                        balance += amount;
                        elem[1] = balance +"";
                    }
                    else {
                        balance -= amount;
                        if (balance >=0) {
                            elem[1] = balance + "";
                        } else {
                            failedTransaction.push(data);
                        }
                    }
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] data : custData) {
            System.out.println(data[0] + " : " + data[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");

        Stack<String[]> temp = new Stack<>();

        while (!failedTransaction.isEmpty()) {
            temp.push(failedTransaction.pop());
        }

        for (String[] data : temp) {
            System.out.println(data[0] + " " + data[1] + " " + data[2]);
        }
    }
}
