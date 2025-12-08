import java.util.Random;

public class Main {
    public static void main(String[] args){
        
        Baum baum = new Baum();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int key = rand.nextInt(10);
            baum.insert(key, i, baum.wurzel);
            System.out.println("key"+i+": "+key);
        }
        
        System.out.println("Pre-Order\n");
        baum.PreOrder(baum.wurzel);
        System.out.println("In-Order\n");
        baum.InOrder(baum.wurzel);
        System.out.println("Post-Order\n");
        baum.PostOrder(baum.wurzel);

    }
}
