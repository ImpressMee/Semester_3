import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /**
         *         Random rnd = new Random(42);
        for (int i = 0; i < values.length; i++) {
            values[i] = rnd.nextInt(100);
        }

         */

        //int size = 11;
        int[] values = {10,5,20,3,9,15,25,4,13,18,26,17,19};


        // Array ausgeben
        System.out.println("Zufälliges Array:");
        System.out.println(Arrays.toString(values));

        // =================================================
        // BST
        // =================================================
        System.out.println("\n===== BST =====");
        Baum bst = new Baum();
        for (int v : values) {
            bst.insert(v, v * 10, bst.wurzel);
        }

        System.out.println("\nPreOrder:");
        bst.PreOrder(bst.wurzel);
        System.out.println("\nInOrder:");
        bst.InOrder(bst.wurzel);
        System.out.println("\nPostOrder:");
        bst.PostOrder(bst.wurzel);



        // =================================================
        // AVL
        // =================================================
        System.out.println("\n===== AVL =====");
        AVLBaum avl = new AVLBaum();
        for (int v : values) {
            avl.insert(v, v * 10, avl.wurzel);
        }

        avl.remove(5, avl.wurzel);
        //avl.remove(26, avl.wurzel);
        //Rueckgabe rueckgabe = new Rueckgabe();
        //avl.search(17, rueckgabe);
        //System.out.println("r"+rueckgabe.value);
        //avl.insert(7, 9, avl.wurzel);
        //avl.remove(7, avl.wurzel);

        System.out.println("\nPreOrder:");
        avl.PreOrder(avl.wurzel);
        System.out.println("\nInOrder:");
        avl.InOrder(avl.wurzel);
        System.out.println("\nPostOrder:");
        avl.PostOrder(avl.wurzel);

        // =================================================
        // Aufräumen
        // =================================================
        bst.clear();
        avl.clear();

        System.out.println("\nAlle Bäume wurden abgebaut.");
    }
}
