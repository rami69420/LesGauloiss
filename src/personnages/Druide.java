package personnages;

import java.util.Random;

import personnages.Gaulois;

public class Druide {
    private String nom;
    private int effetPotionMin;
    private int effetPotionMax;
    private int forcePotion = 1;

    public Druide(String nom, int effetPotionMin, int effetPotionMax) {
        this.nom = nom;
        this.effetPotionMin = effetPotionMin;
        this.effetPotionMax = effetPotionMax;
    }

    public void preparerPotion() {
        Random random = new Random();
        forcePotion = random.nextInt((effetPotionMax - effetPotionMin) + 1) + effetPotionMin;
        if (forcePotion > 7) {
            parler("J'ai préparé une super potion de force " + forcePotion + ".");
        } else {
            parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion + ".");
        }
    }

    public void booster(Gaulois gaulois) {
        if ("Obélix".equals(gaulois.getNom())) {
            parler("Non, Obélix !... Tu n’auras pas de potion magique !");
        } else {
            gaulois.boirePotion(forcePotion);
        }
    }

    public void parler(String texte) {
        System.out.println(nom + " : " + texte);
    }

    // Méthode main pour tester la classe Druide
    public static void main(String[] args) {
        Druide panoramix = new Druide("Panoramix", 5, 10);
        panoramix.preparerPotion();
        
        Gaulois asterix = new Gaulois("Astérix", 8);
        Gaulois obelix = new Gaulois("Obélix", 10);
        
        panoramix.booster(asterix);
        panoramix.booster(obelix);
    }
}
