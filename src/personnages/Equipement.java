package personnages;

public enum Equipement {
    CASQUE("casque"),
    BOUCLIER("bouclier");

    private final String nom;

    // Constructeur privé de l'énumération
    Equipement(String nom) {
        this.nom = nom;
    }

    // Redéfinition de la méthode toString pour retourner le nom de l'équipement
    @Override
    public String toString() {
        return nom;
    }
}
