
public class Client {
	
	private String type;
	private String nom;
	private String prenom;
	private int nbReservation;
	
	public Client(String type, String nom, String prenom) {
		this.type = type;
		this.nom = nom;
		this.prenom = prenom;
		this.nbReservation = 0;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public int getNbReservation() {
		return nbReservation;
	}
	
	public void setNbReservation(int count) {
		this.nbReservation = count;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String toString() {
		return this.nom + " " + this.prenom + " (" + type + ") \nRéservation n°" + this.nbReservation;
	}

}