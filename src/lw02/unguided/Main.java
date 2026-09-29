package lw02.unguided;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foodStock = new LinkedList<>();
        LinkedList<String[]> drinkStock = new LinkedList<>();
        LinkedList<String[]> processedOrder = new LinkedList<>();
        Queue<String[]> arrivedOrder = new LinkedList<>();
        Stack<String[]> outOfStock = new Stack<>();
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));
        while (sc.hasNext()) {
            String name = sc.next();
            String sideDish = sc.next();
            String drink = sc.next();
            String table = sc.next();
            
            String data[] = {name, sideDish, drink, table};
            orders.add(data);
        }

        sc.close();

        foodStock.add(new String[] {"Bakso", "2"});
        foodStock.add(new String[] {"Sate", "1"});
        foodStock.add(new String[] {"Soto", "2"});

        drinkStock.add(new String[] {"EsTeh", "4"});
        drinkStock.add(new String[] {"EsJeruk", "2"});

        for (String[] order : orders) {
            arrivedOrder.add(order);
        }

        while (!arrivedOrder.isEmpty()) {
            String[] orderData = arrivedOrder.poll();
            String foodName = orderData[1];
            String drinkName = orderData[2];
            
            boolean foodAvail = true;
            String[] foodChose = null;
            if (!foodName.equals("-")) {
                for (String[] food : foodStock) {
                    if (food[0].equals(foodName)) {
                        foodChose = food;
                        if (Integer.parseInt(food[1]) <= 0) {
                            foodAvail = false;
                        }
                    }
                }
            }

            boolean drinkAvail = true;
            String[] drinkChose = null;
            if (!drinkName.equals("-")) {
                for (String[] drink : drinkStock) {
                    if (drink[0].equals(drinkName)) {
                        drinkChose = drink;
                        if (Integer.parseInt(drink[1]) <= 0) {
                            drinkAvail = false;
                        }
                    }
                }
            }

            if (foodAvail && drinkAvail) {
                if (foodChose != null) {
                    int currFoodStock = Integer.parseInt(foodChose[1]);
                    foodChose[1] = String.valueOf(currFoodStock - 1);
                }

                if (drinkChose != null) {
                    int currDrinkStock = Integer.parseInt(drinkChose[1]);
                    drinkChose[1] = String.valueOf(currDrinkStock - 1);
                }
                processedOrder.add(orderData);
            } else {
                outOfStock.push(orderData);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for(String[] order : processedOrder) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for(String[] food : foodStock) {
            System.out.println(food[0] + " : " + food[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] drink : drinkStock) {
            System.out.println(drink[0] + " : " + drink[1]);
        }

        System.out.println();
        System.out.println("=== Failed Orders ===");
        while (!outOfStock.isEmpty()) {
            String[]failed = outOfStock.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2] + " " + failed[3]);
        }
    }
}
