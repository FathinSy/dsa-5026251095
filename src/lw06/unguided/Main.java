package lw06.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here
        String firstLine = read.nextLine();
        String[] value = firstLine.split(" ");
        int target = read.nextInt();
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = null;
        for (int i = 0; i < value.length; i++) {
            bst.insert(Integer.parseInt(value[i]));
        }

        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder : ");
        bst.postOrder();
        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Nodes : " + bst.countNodes());
        System.out.println("Leaves : " + bst.countLeaves());
        read.close();
    }
}