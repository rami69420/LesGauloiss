package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;

	// Constructeur avec paramètre pour le nombre max de villageois
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum]; // Taille du tableau basée sur nbVilMax
		this.nbVillageois = 0; // zéro car il n'y a pas encore d'habitants
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	// Méthode pour ajouter des habitants au village
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Le village est plein. Impossible d'ajouter plus de villageois.");
		}
	}

	// méthode pour obtenir le nombre de villageois
	public int getNbVillageois() {
		return nbVillageois;
	}

	// méthode trouverHabitant
	public Gaulois trouverHabitant(int numero) {
		// vérifier si le numéro est dans l'intervalle valide des indices du tableau
		if (numero >= 0 && numero < nbVillageois) {
			// retourner la ref du villageois au numéro specifié
			return villageois[numero];
		} else {
			// si le num est en dehors de l'intervalle valide, afficher un msg d'erreur
			// et retourner null
			System.out.println("Il n'y a pas d'habitant correspondant à ce numéro");
			return null;
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30);
		// L'instruction ci-dessus, quand elle n'est pas en commentaire, provoquerait
		// une exception
		// ou afficherait un message d'erreur défini dans trouverHabitant car il n'y a
		// pas d'habitant à l'indice 30.
		// Les indices valides vont de 0 à 29 pour un tableau de 30 éléments. L'indice
		// 30 est hors limite.

		// créer le chef du village Abraracourcix et l'ajouter au village
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);

		// créer et ajouter au village les personnages
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);

		village.afficherVillageois();
		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		// Placer cette instruction en commentaire sinon cela pourrait causer une
		// confusion
		// car Astérix serait à l'indice 0, pas 1, vu que c'est le premier habitant
		// ajouté.
		// Afficherait null ou un message d'erreur car à l'indice 1 il n'y a pas encore
		// d'habitant.

	}

	public void afficherVillageois() {
		// Vérifier d'abord si un chef a été assigné au village
		if (chef != null) {
			System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		} else {
			System.out.println("Dans le village vivent les légendaires gaulois :");
		}

		// Afficher les noms de tous les villageois ajoutés au village
		for (int i = 0; i < nbVillageois; i++) {
			if (villageois[i] != null) { // Cette vérification est pour s'assurer qu'il n'y a pas de valeurs null
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}
}
