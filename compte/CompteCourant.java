public class CompteCourant extends Compte {
    private final double decouvertAutorise;

    public CompteCourant(double soldeInitial, double decouvertAutorise) {
        super(soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public boolean retirer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant du retrait doit etre positif.");
        }
        if (solde - montant >= -decouvertAutorise) {
            solde -= montant;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{solde=" + solde + ", decouvertAutorise=" + decouvertAutorise + "}";
    }
}
