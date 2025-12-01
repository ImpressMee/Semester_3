import java.util.Scanner;

public class virtualadresstranslator {
    
    public static int vpnTranslator(int adresse, int pagesize){
        int vpn = (int) Math.floor(adresse/pagesize);
        
        return vpn;
    }

    public static int paTranslator(int adresse, int pagesize, int pfn){
        int offset = adresse % pagesize;
        int pa = (pfn * pagesize) + offset;

        return pa;
    }
    public static void main(String[] args) {

        /*int adresse = 70621;
        int pagesize = (int) Math.pow(2, 14);

        int vpn = vpnTranslator(adresse, pagesize);
        System.out.println("VPN = " + vpn);

        int pa = paTranslator(adresse, pagesize, 64);
        System.out.println("Physische Adresse = " + pa);
        */
        Scanner eingabe = new Scanner(System.in);
        while(true){
            System.err.println("\n---------------------------------------------------\nm");
            System.out.println("Gebe eine Adresse ein: ");
            int adresse = eingabe.nextInt();
            System.out.println("Gebe die Pagesize an: ");
            int pagesize = eingabe.nextInt();

            int vpn = vpnTranslator(adresse, pagesize);
            System.out.println("Die VPN ist: "+vpn+", Schaue in der TLB nach!");

            System.out.println("Gebe die PFN an, wenn möglich: ");
            int PFN = eingabe.nextInt();

            int pa = paTranslator(adresse, pagesize, PFN);
            System.out.println("Die Physische Adresse ist: "+pa);
        }


    }
}
