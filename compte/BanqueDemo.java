import java.util.List;

public class BanqueDemo {

    public static void main(String[] args) {
        Compte c1 = new CompteCourant(100.0, 200.0);
        Compte c2 = new CompteEpargne(300.0, 0.02);
        Compte c3 = new Compte(50.0);

        List<Compte> comptes = List.of(c1, c2, c3);

        // 1) Parcours polymorphe
        for (Compte c : comptes) {
            System.out.println(c); // toString polymorphe via getClass()
        }

        // 2) Virement polymorphe (règles de retrait dépendront du type concret)
        Compte.virement(c1, c2, 250.0); // c1 peut aller à -200 => OK si 100-250 = -150

        // 3) Actions spécifiques (si nécessaire) : instanceof propre
        for (Compte c : comptes) {
            if (c instanceof CompteEpargne e) {
                e.appliquerInterets();
            }
        }

        System.out.println("Après opérations :");
        for (Compte c : comptes) System.out.println(c);
    }
}