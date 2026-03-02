public class Enseignant extends Personne {

    private String matiere;

    public Enseignant(String nom, int age, String matiere) {
        super(nom, age);
        if (matiere == null || matiere.trim().isEmpty()) {
            throw new IllegalArgumentException("matiere invalide");
        }
        this.matiere = matiere.trim();
    }

    public String getMatiere() {
        return matiere;
    }

    @Override
    public String detail() {
        return "Matiere: " + matiere;
    }

    @Override
    public String sePresenter() {
        return super.sePresenter() + " (enseignant)";
    }
}
