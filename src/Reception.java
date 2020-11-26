import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Reception {

	public static void main(String[] args) {
		
		Hotel hotel = new Hotel("Overlook");
		
		clearScreen();
		Scanner scan = new Scanner(System.in);	
		String choice = "";
		
		do {	
			menu(hotel);
			choice = scan.next().toUpperCase();
			
			switch (choice) {
				case "A" : 
					menuEtatHotel(scan, hotel);
					clearScreen();
					break;
					
				case "B" : 
					menuNbChambreReserve(scan, hotel);
					clearScreen();
					break;
					
				case "C" :
					menuNbChambreLibre(scan, hotel);
					clearScreen();
					break;
					
				case "D" :
					menuNumPremiereChambreVide(scan, hotel);
					clearScreen();
					break;
					
				case "E" :
					menuNumDerniereChambreVide(scan, hotel);
					clearScreen();
					break;
					
				case "F":
					menuReservation(scan, hotel);
					clearScreen();
					break;
					
				case "G" :
					menuLibererChambre(scan, hotel);
					clearScreen();
					break;
					
				case "H" :
					menuLoyerJournalier(scan, hotel);
					clearScreen();
					break;
					
				case "I" :
					menuChiffreAffaire(scan, hotel);
					clearScreen();
					break;
					
				case "J" :
					menuAnnulerReservation(scan, hotel);
					clearScreen();
					break;
					
				case "K" :
					menuSupprimerReservation(scan, hotel);
					clearScreen();
					break;
					
				case "L" :
					menuModifierReservation(scan, hotel);
					clearScreen();
					break;
			}
		}
		while (!choice.equals("Q"));
		
		clearScreen();
		System.out.println("Au revoir");
		timedSleep(2);
		clearScreen();
		scan.close();
		
		System.out.println(hotel.getChiffreAffaire());
		
	}
	
	public static void menu(Hotel hotel) {
				
			System.out.println(""
					+ "+--------------------------------------------------------+\n"
					+ "|                    Hotel "+ hotel.getNom() +"                      |\n"
					+ "+--------------------------------------------------------+\n"
					+ "|                                                        |\n"
					+ "|   A - Afficher l'etat de l'hotel                       |\n"
					+ "|                                                        |\n"
					+ "|   B - Afficher le nombre de chambres réservées         |\n"
					+ "|                                                        |\n"
					+ "|   C - Afficher le nombre de chambres libres            |\n"
					+ "|                                                        |\n"
					+ "|   D - Afficher le numéro de la premiere chambre vide   |\n"
					+ "|                                                        |\n"
					+ "|   E - Afficher le numéro de la derniere chambre vide   |\n"
					+ "|                                                        |\n"
					+ "|   F - Réserver une chambre                             |\n"
					+ "|                                                        |\n"
					+ "|   G - Libérer une chambre                              |\n"
					+ "|                                                        |\n"
					+ "|   H - Consulter le loyer journalier                    |\n"
					+ "|                                                        |\n"
					+ "|   I - Consulter le chiffre d'affaire annuel            |\n"
					+ "|                                                        |\n"
					+ "|   J - Annuler la réservation d'une chambre             |\n"	
					+ "|                                                        |\n"
					+ "|   K - Supprimer la réservation d'une chambre           |\n"
					+ "|                                                        |\n"
					+ "|   L - Modifier la réservation d'une chambre            |\n"
					+ "|                                                        |\n"
					+ "|                                                        |\n"
					+ "|   Q - Quitter                                          |\n"
					+ "|                                                        |\n"
					+ "+--------------------------------------------------------+\n"
					+ "\n"
					+ "taper: ");
		
	}
	
	public static void menuEtatHotel(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+--------------------------------------------+\n"
				+ "|              Etat de l'hotel               |\n"
				+ "+--------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.etat();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+--------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
				
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuNbChambreLibre(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------------+\n"
				+ "|                           Liste des chambres libre                           |\n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.afficherChbLibre();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}

	public static void menuNumPremiereChambreVide(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------------+\n"
				+ "|                            Premiere chambre libre                            |\n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.afficher1erChbLibre();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}

	public static void menuNumDerniereChambreVide(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------------+\n"
				+ "|                             Derniere chambre libre                           |\n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.afficherDerniereChbLibre();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuNbChambreReserve(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------------+\n"
				+ "|                          Liste des chambres reservés                         |\n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.afficherChbReserv();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuReservation(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------------+\n"
				+ "|                                  Reservation                                 |\n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.reservation();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuLibererChambre(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------+\n"
				+ "|                          Liberer une chambre                           |\n"
				+ "+------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.libererChambre();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuLoyerJournalier(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+---------------------------------------------+\n"
				+ "|              Loyer journalier               |\n"
				+ "+---------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.loyerJournalier();;
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+--------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
				
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuChiffreAffaire(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------+\n"
				+ "|                          Chiffre d'affaire annuel                      |\n"
				+ "+------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.chiffreAffaireAnnuel();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
				
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuAnnulerReservation(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------+\n"
				+ "|                        Annuler une réservation                         |\n"
				+ "+------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.annulerReservation();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuSupprimerReservation(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------+\n"
				+ "|                       Supprimer une réservation                        |\n"
				+ "+------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.supprimerReservation();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
	public static void menuModifierReservation(Scanner scan, Hotel hotel) {
		clearScreen();
		
		System.out.println(""
				+ "+------------------------------------------------------------------------+\n"
				+ "|                       Modifier une réservation                         |\n"
				+ "+------------------------------------------------------------------------+\n"
				+ "                                                        ");
		
		hotel.modifierReservation();
				
		System.out.println("                                                        \n"
				+ "   Q - Quitter                                           \n"
				+ "                                                        \n"
				+ "+------------------------------------------------------------------------+\n"
				+ "\n"
				+ "taper: ");	
		
		String choice = scan.next().toUpperCase();
		
		if(!choice.equals("Q")) {
			clearScreen();
		}
	}
	
    private static void timedSleep(int seconds)  {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {}
    }
	
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
        System.out.println();
    }

}
