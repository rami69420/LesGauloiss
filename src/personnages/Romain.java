package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2]; // tableau de taille 2
	private int nbEquipements = 0;

	public Romain(String nom, int force) {
		assert force > 0 : "La force d'un Romain doit être positive";
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force>0 : "La force d'un Romain est positive"; // précondition
		int forceInitiale = force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !!");
		} else {
			parler("J'abandonne...");
		}
		
		//postcondition : la force diminue après avoir reçu un coup^
		assert force < forceInitiale : "La force d'un Romain diminue après avoir reçu un coup";
	}
	
	private boolean possedeDejaEquipement(Equipement equipement) {
		for(int i=0; i<nbEquipements; i++) {
			if(equipements[i] == equipement) {
				return true;
			}
		}
		return false;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipements) {
		case 2:
			parler("est déjà bien protégé !");
			break;
		case 1:
			if (possedeDejaEquipement(equipement)) {
				parler("possède déjà un" + equipement + "!");
			} else {
				equipements[nbEquipements++] = equipement;
				parler("s'équipe avec un" + equipement + ".");
			}
			break;
		case 0 :
			equipements[nbEquipements++] = equipement;
			parler("s'équipe avec un" + equipement + ".");
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain romain = new Romain("Minus", 6);
		
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.CASQUE);
		
		
		// Vérification de la méthode prendreParole
				System.out.println(romain.prendreParole());

				// Vérification de la méthode parler
				romain.parler("Pour l'Empire Romain !");

				// Vérification de la méthode recevoirCoup
				romain.recevoirCoup(5);
	}
}
