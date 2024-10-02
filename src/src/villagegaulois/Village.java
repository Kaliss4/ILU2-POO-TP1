package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(5);
		
	}
	
	public void villageSansChefException () {
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
		public void utiliserEtal (int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etal[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			
		}
		public int tailleEtal() {
			return etal.length;
		}
		public void dansEtal() {
			System.out.println(etal[0].afficherEtal());
		}
		public int trouverEtalLibre() {
			int taille = etal.length;
			for (int i=0; i<taille ;i++) {
				if (!etal[i].isEtalOccupe()) {
					return i;
				}
			}
			return -1;
		}
		
		public Etal[] trouverEtal(String produit) {
			int nbEtal = 0;
			for (int i = 0; i<etal.length; i++) {
				if (etal[i].isEtalOccupe()&& etal[i].contientProduit(produit)) {
					nbEtal++;
				}
			}
			Etal[] etal1 = new Etal[nbEtal];
			for (int i=0,j = 0; j<etal.length||i<etal1.length;j++) {
				if (etal[j].isEtalOccupe() && etal[j].contientProduit(produit)) {
					etal1[i]=etal[j];
					i++;
					}
			}
			return etal1;
		}
		public Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0; i < etal.length; i++) {
				if (etal[i].getVendeur()==gaulois) {
					return etal[i];
				}
			}
			return null;
		}
		public String afficherMarche(){
			int nbEtalVide = 0;
			StringBuilder chaine = new StringBuilder();
			for (int i = 0; i < etal.length; i++) {
				if (etal[i].isEtalOccupe()) {
					chaine.append("- "+etal[i].afficherEtal());
				}
				else {
					nbEtalVide++;
				}
			}
			chaine.append("\n Il reste " +nbEtalVide + " etals non utilisés dans le marché.\n" );
			return chaine.toString();
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
	
	public String installerVendeur (Gaulois vendeur, String produit, int nbProduits) {
		int numeroEtal = marche.trouverEtalLibre();
		marche.utiliserEtal(numeroEtal, vendeur, produit, nbProduits);
		
		numeroEtal = numeroEtal+1;
		return vendeur.getNom()+" cherche un endroit pour vendre " + nbProduits + " "+ produit+".\n"+"Le vendeur "+ vendeur.getNom()+" vends des "+produit+ " a l'etal n°"+numeroEtal+".";
		
	}
	
	public String rechercherVendeursProduit(String produit) {
		Etal[] etalTrouver = marche.trouverEtal(produit);
		if (etalTrouver.length==0) {
			return "Il n'y a pas de vendeur qui propose des "+ produit+ " au marche";
		}else if (etalTrouver.length==1) {
			return "Seul le vendeur "+ etalTrouver[0].getVendeur().getNom()+ " propose des " + produit+ " au marche.";
			
		} else {
			StringBuilder liste = new StringBuilder();
			liste.append("Les vendeurs qui proposent des "+ produit+ " sont : \n");
			for (int i = 0; i < etalTrouver.length; i++) {
				liste.append("- "+ etalTrouver[i].getVendeur().getNom()+ " \n");
			}	
			return liste.toString();
		}
	}
	
	public Etal rechercherEtal (Gaulois vendeur) {
		return marche.trouverVendeur(vendeur); 
	}
	
	public String partirVendeur(Gaulois vendeur) {
		return rechercherEtal(vendeur).libererEtal();
	}
	
	public String acheterProduit (Gaulois vendeur, Gaulois client, int qte) {
		return marche.trouverVendeur(vendeur).acheterProduit(qte, client);
	}
	
	public String afficherMarche() {
		return marche.afficherMarche();
	}
	
	public int etalLibre() {
		return marche.trouverEtalLibre(); 
		
	}
	public int taille() {
		return marche.tailleEtal();
	}
	public void dansEtal0() {
		marche.dansEtal();
	}
	
	
	
	
		
	
	
	
}
























