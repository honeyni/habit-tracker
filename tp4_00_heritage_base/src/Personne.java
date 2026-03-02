public class Personne {

    protected String nom;
    protected int age;

    public Personne(String nom, int age) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("nom invalide");
        }
        if (age < 0) {
            throw new IllegalArgumentException("age invalide");
        }
        this.nom = nom.trim();
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String sePresenter() {
        return "Je suis " + nom + ", " + age + " ans";
    }

    public String detail() {
        return "Aucun detail";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{nom='" + nom + "', age=" + age + ", detail='" + detail() + "'}";
    }
}
