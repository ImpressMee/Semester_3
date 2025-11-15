package binarySearch;

public class Main {
    public static void main(String[] args) {
        Dynamic_Array test = new Dynamic_Array();

        for (int i = 1; i <= 16; i++) {
            test.insert(i);
        }

        test.remove(10);
        test.insert(2);
        test.insert(10);
        test.insert(1);
        System.out.println(test.search(19));
        System.out.println(test.search(1));
        System.out.println(test.searchInterpolant(11));
        System.out.println(test.zuweisungen);
        test.ausgabe();
    }
}
