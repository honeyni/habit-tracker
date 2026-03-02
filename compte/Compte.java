public class Compte {
    protected double solde;

    public Compte(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public double getSolde() {
        return solde;
    }

    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant du depot doit etre positif.");
        }
        solde += montant;
    }

    public boolean retirer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant du retrait doit etre positif.");
        }
        if (solde >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public static boolean virement(Compte source, Compte destination, double montant) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Les comptes ne doivent pas etre nuls.");
        }
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant du virement doit etre positif.");
        }

        if (source.retirer(montant)) {
            destination.deposer(montant);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{solde=" + solde + "}";
    }
}
