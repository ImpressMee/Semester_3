package binarySearch;

public class Main {
    public static void main(String[] args) {
        Dynamic_Array test = new Dynamic_Array();

        for (int i = 1; i <= 16; i++) {
            test.insert(i);
        }
        test.ausgabe();
        test.remove(1);
        test.insert(2);
        test.insert(10);
        test.insert(0);
        test.insert(32);
        test.ausgabe();
        System.out.println(test.search(19));
        System.out.println(test.search(1));
        System.out.println(test.searchInterpolant(11));
        System.out.println(test.zuweisungen);
        test.ausgabe();

        System.out.println("\n\n----------------\n 2test 2: ");
        Dynamic_Array test2 = new Dynamic_Array();
        for(int i = 1; i <= 128; i = i*2){
            test2.insert(i);
        }
        test2.ausgabe();
        for(int i = 1; i <= 128; i = i*4){
            test2.remove(i);
        }
        test2.ausgabe();
        test2.insert(3);
        test2.ausgabe();
        System.err.println("----------------\n2, 12");
        System.out.println("zw "+test2.zuweisungen);
        System.out.println("s  "+test2.search(2));
        System.out.println("s  "+test2.search(12));
        System.out.println("zw "+test2.zuweisungen);
        System.out.println("sI "+test2.searchInterpolant(2));
        System.out.println("sI "+test2.searchInterpolant(12));
        System.out.println("zw "+test2.zuweisungen);


    }
}
