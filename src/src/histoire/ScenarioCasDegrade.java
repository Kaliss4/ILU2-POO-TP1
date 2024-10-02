package histoire;

import personnages.Gaulois;
import villagegaulois.Etal;

public class ScenarioCasDegrade {
	public static void main	(String[] args){
		Gaulois obelix = new Gaulois("Obélix", 25);
		Etal etal = new Etal();
		etal.occuperEtal(obelix, "Fleurs", 10);
		etal.libererEtal();
		try {
			etal.acheterProduit(2, obelix);
		} catch (NullPointerException e) {
			System.out.println("L'acheteur ne doit pas etre null.");
		}catch (IllegalArgumentException e) {
			System.out.println("La quantite doit etre positive.");
		}catch (IllegalStateException e) {
			System.out.println("L'etalt doit etre occupe.");
		}
		
		System.out.println("Fin du test");
	}

}
