package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}
	private static class Marche {
		private Etal[] etal;
		public Marche(int nbEtal) {
			etal = new Etal[nbEtal];
			for (int i = 0; i<nbEtal;i++) {
				etal[i]=new Etal();
			}
		}
		void utiliserEtal (int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etal[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			
		}
		int trouverEtalLibre() {
			int taille = etal.length;
			for (int i=0; i<taille ;i++) {
				if (etal[i]==null) {
					return i;
				}
			}
			return -1;
		}
		
		Etal[] trouverEtal(String produit) {
			int nbEtal = 0;
			for (int i = 0; i<etal.length; i++) {
				if (etal[i].contientProduit(produit)) {
					nbEtal++;
				}
			}
			Etal[] etal1 = new Etal[nbEtal];
			for (int i=0,j = 0; j<etal.length||i<etal1.length;j++) {
				if (etal[j].contientProduit(produit)) {
					etal1[i]=etal[j];
					i++;
					}
			}
			return etal1;
		}
		Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0; i < etal.length; i++) {
				if (etal[i].getVendeur()==gaulois) {
					return etal[i];
				}
			}
			return null;
		}
		void afficherMarche(){
			int nbEtalVide = 0;
			for (int i = 0; i < etal.length; i++) {
				if (etal[i].isEtalOccupe()) {
					etal[i].afficherEtal();
				}
				else {
					nbEtalVide++;
				}
			}
			System.out.println("Il reste " +nbEtalVide + " etals non utilisés dans le marché.\n" );
		}
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
}