package algorithmen;

public class uebung {

    public static void main(String[] args) {
        System.out.println(pot(2, 4));
    }

    static double pot(double x, int n){
        if(n <= 0) return 1;
        System.out.println(n);
        if(n == 1) return x;
        System.out.println("vor dem rekursionsaufruf");
        double p = pot(x, n/2);
        System.out.println("nach dem rekursionsaufruf " + n);
        if (n % 2 == 1) return x*p*p;
        else return p*p;
    }
}