public class Etudiant extends Personne {

    private String filiere;

    public Etudiant(String nom, int age, String filiere) {
        super(nom, age);
        if (filiere == null || filiere.trim().isEmpty()) {
            throw new IllegalArgumentException("filiere invalide");
        }
        this.filiere = filiere.trim();
    }

    public String getFiliere() {
        return filiere;
    }

    @Override
    public String detail() {
        return "Filiere: " + filiere;
    }

    @Override
    public String sePresenter() {
        return super.sePresenter() + " (etudiant)";
    }
}
