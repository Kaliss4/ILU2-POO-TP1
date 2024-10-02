package histoire;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class Scenario {

	public static void main(String[] args) {
		Village village = new Village("le village des irréductibles", 10);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Druide druide = new Druide("Panoramix", 2, 5, 10);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois assurancetourix = new Gaulois("Assurancetourix", 2);
		Gaulois bonemine = new Gaulois("Bonemine", 7);
		Gaulois panoramix = new Gaulois("Panoramix",3);
		
		System.out.println(village.rechercherVendeursProduit("Fleurs"));
		System.out.println(village.installerVendeur(bonemine,"Fleurs", 20));
		System.out.println(village.rechercherVendeursProduit("Fleurs"));
		
		System.out.println(" \n");
		System.out.println(village.installerVendeur(assurancetourix,"Lyres", 5));
		System.out.println(village.installerVendeur(obelix,"Menhirs", 2));
		System.out.println(village.installerVendeur(panoramix,"Fleurs", 10));
		
		System.out.println(" \n");
		System.out.println(village.rechercherVendeursProduit("Fleurs"));
		
		try {
		System.out.println(village.acheterProduit(bonemine, abraracourcix, 10));
		System.out.println(village.acheterProduit(bonemine, obelix, 15));
		System.out.println(village.acheterProduit(bonemine, assurancetourix, 15));
		}catch(NullPointerException e) {
			System.out.println("L'acheteur ne doit pas etre null.");
		}catch (IllegalArgumentException e) {
			System.out.println("La quantite doit etre positive.");
		}catch (IllegalStateException e) {
			System.out.println("L'etalt doit etre occupe.");
		}
		
		System.out.println(" \n");
		System.out.println(village.partirVendeur(bonemine));
		System.out.println(village.afficherMarche());
		
		
		
//		village.ajouterHabitant(bonemine);
//		village.ajouterHabitant(assurancetourix);
//		village.ajouterHabitant(asterix);
//		village.ajouterHabitant(obelix);
//		village.ajouterHabitant(druide);
//		village.ajouterHabitant(abraracourcix);
//		village.afficherVillageois();

//		System.out.println(village.installerVendeur(bonemine, "fleurs", 20));
//		System.out
//				.println(village.installerVendeur(assurancetourix, "lyres", 5));
//		System.out.println(village.installerVendeur(obelix, "menhirs", 2));
//		System.out.println(village.installerVendeur(druide, "fleurs", 10));

//		System.out.println(village.rechercherVendeursProduit("fleurs"));
//		Etal etalFleur = village.rechercherEtal(bonemine);
//		System.out.println(etalFleur.acheterProduit(10, abraracourcix));
//		System.out.println(etalFleur.acheterProduit(15, obelix));
//		System.out.println(etalFleur.acheterProduit(15, assurancetourix));
//		System.out.println(village.partirVendeur(bonemine));
//		System.out.println(village.afficherMarche());
	}

}
