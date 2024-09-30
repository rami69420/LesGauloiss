package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1; // Attribut effetPotion initialisé à 1

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}

	public void frapper(Romain romain) {
		int forceCoup = (force / 3) * effetPotion;
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom() + " avec une force de "
				+ forceCoup);
		romain.recevoirCoup(forceCoup);
	}

	public void parler(String texte) {
		System.out.println(nom + " : " + texte);
	}

	// Autres méthodes (comme getNom) et main pour tester
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		asterix.boirePotion(3); // Test avec un effet potion de 3
		// Supposons la présence d'un objet Romain pour tester frapper
		Romain romain = new Romain("Caius", 5); // Vous devez avoir la classe Romain définie
		asterix.frapper(romain);
	}

	public Object getNom() {
		// TODO Auto-generated method stub
		return null;
	}
}
