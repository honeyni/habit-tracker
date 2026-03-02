public class HeritageDemo {
    public static void main(String[] args) {
        Personne[] personnes = {
            new Personne("Alex", 28),
            new Etudiant("Lina", 20, "Informatique"),
            new Enseignant("M. Martin", 45, "Java")
        };

        for (Personne p : personnes) {
            System.out.println(p.sePresenter());
            System.out.println("Detail: " + p.detail());
            System.out.println(p);
            System.out.println();
        }
    }
}
