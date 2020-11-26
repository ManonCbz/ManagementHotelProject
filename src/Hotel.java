import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Hotel {
	
	// Attributs

	private String nom;
	private double chiffreAffaire;
	private ArrayList <Chambre> listeChambre = new ArrayList<Chambre>();
	private ArrayList<Reservation> listeReservation = new ArrayList<Reservation>();
	private ArrayList<Client> listeClient = new ArrayList<Client>();
	
	// Constructeur
	
	public Hotel(String nom) {
		String str = nom;
		String uppercase = str.substring(0, 1).toUpperCase() + str.substring(1);
		this.nom = uppercase;
		initialize();
	}
	
	// Get & Set
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Chambre> getListeChambre() {
		return listeChambre;
	}

	public void setListeChambre(ArrayList<Chambre> listeChambre) {
		this.listeChambre = listeChambre;
	}

	public double getChiffreAffaire() {
		return chiffreAffaire;
	}
	
	public void setChiffreAffaire(double chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}
	
	public ArrayList<Reservation> getHistorique() {
		return listeReservation;
	}

	public ArrayList<Client> getListeClient() {
		return listeClient;
	}
	
	// To String
	
	public String toString() {
		return "Hotel [nom=" + nom + ", chiffreAffaire=" + chiffreAffaire + ", listeChambre=" + listeChambre
				+ "]";
	}

	// Méthodes
	
	// Ajoute des chambres automatiquement à la création d'un hotel
	public void initialize() {
				
		Chambre simple1 = new Chambre("Simple", 2, 55);
		Chambre double1 = new Chambre("Double", 1, 60);
		Chambre jumeaux1 = new Chambre("Jumeaux", 2, 55);
		Chambre suite1 = new Chambre("Suite", 1, 135);
		Chambre simple2 = new Chambre("Simple", 1, 55);
		Chambre double2 = new Chambre("Double", 1, 60);
		Chambre jumeaux2 = new Chambre("Jumeaux", 2, 55);
		Chambre suite2 = new Chambre("Suite", 1, 135);
		
		listeChambre.add(simple1);
		listeChambre.add(double1);
		listeChambre.add(jumeaux1);
		listeChambre.add(suite1);
		listeChambre.add(simple2);
		listeChambre.add(double2);
		listeChambre.add(jumeaux2);
		listeChambre.add(suite2);
		
		Client client = new Client("Particulier", "Random", "Max");
		
		for(int i = 0; i < listeChambre.size(); i++) {
		
			// Random pour aléatoirement réserver (ou non) les chambres créées
			// Les chambres réservées initialement auront toutes les mêmes dates et le même client (Pour l'exercice)
			
			int nbRandom = (int)(Math.random() * (1 - 0 + 1) + 1);
			listeChambre.get(i).setEtatReservation(nbRandom-1);

	        String[] dateArrivee = {"4", "11", "2020"};
	        String[] dateDepart = {"11", "11", "2020"};
	        
	        int jourArrivee = Integer.valueOf(dateArrivee[0]);
	        int moisArrivee = Integer.valueOf(dateArrivee[1]) - 1;
	        int anneeArrivee = Integer.valueOf(dateArrivee[2]) - 1900;
	        
	        // - 1 & - 1900 pour supprimer l'ecart et  enregistrer la date précise des tableaux 98 / 99
	        
	        int jourDepart = Integer.valueOf(dateDepart[0]);
	        int moisDepart = Integer.valueOf(dateDepart[1]) - 1;
	        int anneeDepart = Integer.valueOf(dateDepart[2]) - 1900;
	        
	        Date arrivee = new Date(anneeArrivee, moisArrivee, jourArrivee);
			Date depart = new Date(anneeDepart, moisDepart, jourDepart);
			
			
			if(listeChambre.get(i).getEtatReservation() == 1) {
				
				listeClient.add(client);
				
				Reservation reservation = new Reservation(arrivee, depart, listeChambre.get(i).getNumChambre(), client);
				
				listeReservation.add(reservation);
				
				client.setNbReservation(client.getNbReservation() + 1);
			}
			
		}
	}
	
	public void etat() {
		
		System.out.println("      Bienvenue à l'hotel " + this.nom + ",\n"
						 + "      Il y a " + this.listeChambre.size() + " chambres");
	
	}
	
	public void afficherChbReserv() {
		
		boolean minimumUneChambreReservee = false;
		
		for (int i = 0; i < this.listeChambre.size(); i++) {
			
			if(this.listeChambre.get(i).getEtatReservation() == 1) {
				
				minimumUneChambreReservee = true;
				System.out.println(this.listeChambre.get(i));	
				
			}
		}
		
		if(minimumUneChambreReservee == false) {
			System.out.println("Il n'y a aucune chambre réservée");
		}
	}
	
	public void afficherChbLibre() {
		
		boolean minimumUneChambreLibre = false;
		
		for (int i = 0; i < this.listeChambre.size(); i++) {
			
			if(this.listeChambre.get(i).getEtatReservation() == 0) {
				
				minimumUneChambreLibre = true;
				System.out.println(this.listeChambre.get(i));	
				
			}
		}
		
		if(minimumUneChambreLibre == false) {
			System.out.println("Il n'y a aucune chambre libre");
		}
	}

	public void afficher1erChbLibre() {
		
		boolean minimumUneChambreLibre = false;
		
		for (int i = 0; i < this.listeChambre.size(); i++) {
		
			if(this.listeChambre.get(i).getEtatReservation() == 0) {
				
				minimumUneChambreLibre = true;
				System.out.println(this.listeChambre.get(i));
				break;
				
			}
		}
		
		if(minimumUneChambreLibre == false) {
			System.out.println("Il n'y a aucune chambre libre");
		}
	}
	
	public void afficherDerniereChbLibre() {
		
		boolean minimumUneChambreLibre = false;
		
		for (int i = listeChambre.size()-1; i >= 0; i--) {
		
			if(this.listeChambre.get(i).getEtatReservation() == 0) {
				
				minimumUneChambreLibre = true;
				System.out.println(this.listeChambre.get(i));
				break;
				
			}
		}
		
		if(minimumUneChambreLibre == false) {
			System.out.println("Il n'y a aucune chambre libre");
		}
		
	}
	
	public void reservation() {
		
		boolean chambreLibre = false;
		Scanner scanReservation = new Scanner(System.in);
		
		// Demande info Client
		
		System.out.println("Particulier ou Societe ?");
		String typeClient = scanReservation.nextLine().toLowerCase();
				
		System.out.println("Entrez le nom du client : ");
		String nomClient = scanReservation.nextLine().toLowerCase();
		
		System.out.println("Prénom : ");
		String prenomClient = scanReservation.nextLine().toLowerCase();
		
		// Demande info Chambre
		
		System.out.println("Entrez le type de chambre : ");
		String typeChambre = scanReservation.nextLine().toLowerCase();
				
		// Demande info Dates
		// Arrivée
		
		System.out.println("Saisir une date d'arrivée : (DD/MM/AAAA)");
        String[] dateSaisie = scanReservation.nextLine().split("/");
        
        int jour = Integer.valueOf(dateSaisie[0]);
        int mois = Integer.valueOf(dateSaisie[1]) - 1;
        int annee = Integer.valueOf(dateSaisie[2]) - 1900;
        
        Date arrivee = new Date(annee, mois, jour);
        
        // Départ 
        
		System.out.println("Saisir une date de départ : (DD/MM/AAAA)");
        dateSaisie = scanReservation.nextLine().split("/");
        
        jour = Integer.valueOf(dateSaisie[0]);
        mois = Integer.valueOf(dateSaisie[1]) - 1;
        annee = Integer.valueOf(dateSaisie[2]) - 1900;
        
        Date depart = new Date(annee, mois, jour);
        
        // Vérification
		
		for (int i = 0; i < this.listeChambre.size(); i++) {
			
			// Si une chambre est libre && du type demandé
		
			if(this.listeChambre.get(i).getEtatReservation() == 0 && typeChambre.equals(this.listeChambre.get(i).getTypeChambre().toLowerCase())) {
				
				// Il y a bien une chambre libre du même type
				chambreLibre = true;

				// Vérifie si la liste de client est vide -> new Client
				
				Client client = null;
				boolean doublon = true;
				
				if(this.listeClient.size() > 0) {
									
					for (int j = 0; j < this.listeClient.size(); j++) {
						
						// Variables pour conditions
						
						String nomListeClient = this.listeClient.get(j).getNom().toLowerCase();
						String prenomListeClient = this.listeClient.get(j).getPrenom().toLowerCase();
						String typeListeClient = this.listeClient.get(j).getType().toLowerCase();
						
						// Si un client a exactement les mêmes informations, récupère le client, sinon -> new Client
						
						if(nomListeClient.equals(nomClient) && prenomListeClient.equals(prenomClient) && typeListeClient.equals(typeClient)) {
							
							doublon = true;							
							client = this.listeClient.get(j);
							// Ajoute 1 au nombre de réservation totale du client
							this.listeClient.get(j).setNbReservation(this.listeClient.get(j).getNbReservation() + 1);
							break;	
							
						}
						else {
							// Pas de client déjà existant avec les informations données
							doublon = false;
						}
					}
				}
				else {
					// La liste client est vide, il n'y a donc pas de doublon
					doublon = false;
				}
				
				if (doublon == false) {
					// Nouveau client
					client = new Client(typeClient, nomClient, prenomClient);
					client.setNbReservation(1);
					listeClient.add(client);
				}
				
				// Crée la réservation 
				Reservation reservation = new Reservation(arrivee, depart, this.listeChambre.get(i).getNumChambre(), client);
				listeReservation.add(reservation);

				// Change l'état de la chambre -> Réservée
				this.listeChambre.get(i).setEtatReservation(1);
				
				System.out.println("\n" + reservation);
				break;
			}
			else {
				// Aucune chambre libre du type demandé
				chambreLibre = false;
			}
		}
		
		if (chambreLibre == false) {
			System.out.println("\nIl n'y a pas de chambre libre de ce type");
		}
	}
	
	public void libererChambre() {
		
		System.out.println("    Numéro de chambre : ");
		
		Scanner scan = new Scanner(System.in);
		int numChambre = scan.nextInt();
		
		boolean dejaLibre = true;
		
		if(numChambre <= this.listeChambre.size()) {
			
			for (int i = 0; i < this.listeChambre.size(); i++) {
			
				if(numChambre == this.listeChambre.get(i).getNumChambre() && this.listeChambre.get(i).getEtatReservation() == 1) {
					dejaLibre = false;
					this.listeChambre.get(i).setEtatReservation(0);
					System.out.println("    La chambre n°" + numChambre + " est maintenant libre");
					break;
				}
				else {
					dejaLibre = true;
				}
			
			}
			
		}
		else {
			dejaLibre = false;
			System.out.println("    La chambre n°" + numChambre + " n'existe pas");
		}
		
		if(dejaLibre == true) {
			System.out.println("    Cette chambre est déjà libérée");
		}
		
	}
	
	public void chiffreAffaire() {
		
		Scanner scan = new Scanner(System.in);
		 
		Date date1 = new Date();
		Date date2 = new Date();
		
		System.out.println("Entre le : ");
		System.out.println("    Jour : ");
		date1.setDate(scan.nextInt());

		System.out.println("    Mois : ");
		date1.setMonth(scan.nextInt());

		System.out.println("Et le : ");
		System.out.println("    Jour : ");
		date2.setDate(scan.nextInt());

		System.out.println("    Mois : ");
		date2.setMonth(scan.nextInt());
		
		double total = 0;
		
		for(int i = 0; i < this.listeReservation.size(); i++) {
			
			Date arrivee = this.listeReservation.get(i).getArrive();
			Date depart = this.listeReservation.get(i).getDepart();
			
			if(arrivee.compareTo(date1) > 0 && depart.compareTo(date2) < 0) {

				for (int j = 0; j < this.listeChambre.size(); j++) {
					
					if(this.listeReservation.get(i).getNumChambre() == this.listeChambre.get(j).getNumChambre() && this.listeChambre.get(j).getEtatReservation() == 1) {
						total += this.listeChambre.get(j).getTarif();
					}					
				}
			}
		}
		
		System.out.println("    Chiffre d'affaire : " + total + " €");
	}
	
	public void chiffreAffaireAnnuel() {
		
		int total = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Quelle année ? ");
		int annee = scan.nextInt();
				
		for(int i = 0; i < this.listeReservation.size(); i++) {
			
			Date arrivee = this.listeReservation.get(i).getArrive();
			Date depart = this.listeReservation.get(i).getDepart();
			
			int differenceJour = (int) (depart.getTime() - arrivee.getTime());
			int nbJour = (differenceJour / (1000 * 60 * 60 * 24));
						
			if((depart.getYear() + 1900) == annee) {

				for (int j = 0; j < this.listeChambre.size(); j++) {
					
					if(this.listeReservation.get(i).getNumChambre() == this.listeChambre.get(j).getNumChambre() && this.listeChambre.get(j).getEtatReservation() == 1) {
						
						total += this.listeChambre.get(j).getTarif() * nbJour;
					
					}
				}
			}
			
		}
		
		System.out.println("    Le chiffre d'affaire de l'année " + annee + " est de " + total + " €");
		
	}
		
	public void loyerJournalier() {
		
		Scanner scan = new Scanner(System.in);
		
		Date date = new Date();
		
		System.out.println("    Mois : ");
		date.setMonth(scan.nextInt());
		
		System.out.println("    Jour : ");
		date.setDate(scan.nextInt());
		
		double total = 0;
		
		for(int i = 0; i < this.listeReservation.size(); i++) {
			
			if(this.listeReservation.get(i).getDepart().compareTo(date) > 0 && this.listeReservation.get(i).getArrive().compareTo(date) < 0) {

				for (int j = 0; j < this.listeChambre.size(); j++) {
					
					if(this.listeReservation.get(i).getNumChambre() == this.listeChambre.get(j).getNumChambre() && this.listeChambre.get(j).getEtatReservation() == 1) {
						total += this.listeChambre.get(j).getTarif();
					}					
				}
			}
		}
		
		System.out.println("    Le total des loyer du jour : " + total + " €");
	}

	public void annulerReservation() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("   Quel est le numero de la chambre ?");
		
		int numChambre = scan.nextInt();
		
		for (int i = 0; i < this.listeReservation.size(); i++) {
			
			if(numChambre == this.listeReservation.get(i).getNumChambre()) {
				this.listeReservation.get(i).setAnnulation();
				this.listeChambre.get(numChambre-1).setEtatReservation(0);
				this.chiffreAffaire -= this.listeChambre.get(numChambre).getTarif();
				System.out.println("     La reservation de la chambre n°" + numChambre + " est annulée");
			}
		}
	}
	
	public void supprimerReservation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("   Quel est le numero de la chambre ?");
		
		int numChambre = scan.nextInt();
		
		for (int i = 0; i < this.listeReservation.size(); i++) {
			
			if(numChambre == this.listeReservation.get(i).getNumChambre()) {
				this.listeChambre.get(numChambre-1).setEtatReservation(0);
				this.listeReservation.remove(this.listeReservation.get(i));
				System.out.println("     La reservation de la chambre n°" + numChambre + " est supprimé");
			}
		}
	}
	
	public void modifierReservation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("   Quel est le numero de la chambre ?");
		int numChambre = scan.nextInt();
		
		System.out.println("   Modifier :\n     || A - la date d'arrivée \n     || B - la date de départ \n     || C - Le type de chambre");
		String choix = scan.next().toUpperCase();
		
		for (int i = 0; i < this.listeReservation.size(); i++) {
			
			if(numChambre == this.listeReservation.get(i).getNumChambre()) {
				
				switch (choix) {
					
					case "A" :
						
						Date date = new Date();
						
						System.out.println("    Mois : ");
						date.setMonth(scan.nextInt()-1);
						
						System.out.println("    Jour : ");
						date.setDate(scan.nextInt());
				        
				        this.listeReservation.get(i).setArrive(date);
				        
						System.out.println("La réservation à bien été modifiée : \n");
				        System.out.println(this.listeReservation.get(i));
				        
				        break;
					
					case "B" :
						
						date = new Date();
						
						System.out.println("    Mois : ");
						date.setMonth(scan.nextInt()-1);
						
						System.out.println("    Jour : ");
						date.setDate(scan.nextInt());
				        
				        this.listeReservation.get(i).setDepart(date);
				        
						System.out.println("La réservation à bien été modifiée : \n");
				        System.out.println(this.listeReservation.get(i));
				        
				        break;
					
					case "C" :
						
						Scanner test = new Scanner(System.in);
						
						System.out.println("Entrez le type de chambre : ");
						String typeChambre = test.nextLine();
												
						for (int j = 0; j < listeChambre.size(); j++) {
															
							if(this.listeChambre.get(j).getEtatReservation() == 0 && typeChambre.equals(this.listeChambre.get(j).getTypeChambre().toLowerCase())) {
									
								System.out.println("La réservation à bien été modifiée : \n");
								
								this.listeChambre.get(numChambre).setEtatReservation(0);
																
								Client client = this.listeReservation.get(i).getClient();
								Date arrivee = this.listeReservation.get(i).getArrive();
								Date depart = this.listeReservation.get(i).getDepart();
								
								this.listeReservation.remove(this.listeReservation.get(i));
									
								Reservation reservation = new Reservation(arrivee, depart, this.listeChambre.get(j).getNumChambre(), client);
									
								listeReservation.add(reservation);
								
								this.listeChambre.get(i).setEtatReservation(1);

								System.out.println("\n" + reservation);
								
								break;
							}
						}
						break;
					}
				}
			}
		}
	}