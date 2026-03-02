public class CompteEpargne extends Compte {
    private final double tauxInteret;

    public CompteEpargne(double soldeInitial, double tauxInteret) {
        super(soldeInitial);
        this.tauxInteret = tauxInteret;
    }

    public void appliquerInterets() {
        if (tauxInteret < 0) {
            throw new IllegalStateException("Le taux d'interet ne peut pas etre negatif.");
        }
        solde += solde * tauxInteret;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{solde=" + solde + ", tauxInteret=" + tauxInteret + "}";
    }
}
