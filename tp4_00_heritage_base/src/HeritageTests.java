// src/HeritageTests.java
public class HeritageTests {
    public static void main(String[] args) {
        testPersonne();
        testEtudiant();
        testEnseignant();
        testPolymorphisme();
        testValidations();
        System.out.println("Tous les tests sont OK");
    }

    private static void testPersonne() {
        Personne p = new Personne("Alice", 30);
        assertEquals("Alice", p.getNom(), "getNom Personne");
        assertEquals(30, p.getAge(), "getAge Personne");
        assertEquals("Je suis Alice, 30 ans", p.sePresenter(), "sePresenter Personne");
        assertEquals("Aucun detail", p.detail(), "detail Personne");
    }

    private static void testEtudiant() {
        Etudiant e = new Etudiant("Bob", 19, "Reseaux");
        assertEquals("Bob", e.getNom(), "getNom Etudiant");
        assertEquals(19, e.getAge(), "getAge Etudiant");
        assertEquals("Reseaux", e.getFiliere(), "getFiliere Etudiant");
        assertEquals("Filiere: Reseaux", e.detail(), "detail Etudiant");
        assertEquals("Je suis Bob, 19 ans (etudiant)", e.sePresenter(), "sePresenter Etudiant");
    }

    private static void testEnseignant() {
        Enseignant e = new Enseignant("Mme Dupont", 40, "Maths");
        assertEquals("Mme Dupont", e.getNom(), "getNom Enseignant");
        assertEquals(40, e.getAge(), "getAge Enseignant");
        assertEquals("Maths", e.getMatiere(), "getMatiere Enseignant");
        assertEquals("Matiere: Maths", e.detail(), "detail Enseignant");
        assertEquals("Je suis Mme Dupont, 40 ans (enseignant)", e.sePresenter(), "sePresenter Enseignant");
    }

    private static void testPolymorphisme() {
        Personne[] groupe = {
            new Etudiant("Nora", 21, "Securite"),
            new Enseignant("M. Legrand", 50, "Reseaux")
        };

        assertEquals("Filiere: Securite", groupe[0].detail(), "poly detail Etudiant");
        assertEquals("Matiere: Reseaux", groupe[1].detail(), "poly detail Enseignant");
    }

    private static void testValidations() {
        assertThrows(() -> new Personne("  ", 10), "nom vide");
        assertThrows(() -> new Personne("John", -1), "age negatif");
        assertThrows(() -> new Etudiant("A", 18, ""), "filiere vide");
        assertThrows(() -> new Enseignant("B", 36, " "), "matiere vide");
    }

    private static void assertEquals(String attendu, String obtenu, String test) {
        if (!attendu.equals(obtenu)) {
            throw new AssertionError(test + " | attendu: " + attendu + " / obtenu: " + obtenu);
        }
    }

    private static void assertEquals(int attendu, int obtenu, String test) {
        if (attendu != obtenu) {
            throw new AssertionError(test + " | attendu: " + attendu + " / obtenu: " + obtenu);
        }
    }

    private static void assertThrows(Runnable action, String test) {
        try {
            action.run();
            throw new AssertionError(test + " | exception attendue mais absente");
        } catch (IllegalArgumentException expected) {
            // OK
        }
    }
}
