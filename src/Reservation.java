import java.util.Date;

public class Reservation {

	private Date arrive;
	private Date depart;
	private int numChambre;
	private Client client;
	private boolean annulee = false;
	
	public Reservation(Date arrive, Date depart, int numChambre, Client client) {
		this.arrive = arrive;
		this.depart = depart;
		this.numChambre = numChambre;
		this.client = client;
	}
	
	public String toString() {
		
		String annulation = "";
		
		if(this.annulee == false) {
			annulation = "Arrivée : " + this.arrive + ", Départ : " + this.depart + "\n";
		}
		else {
			annulation = "Cette reservation est annulée \n";
		}
		
		return "Chambre n°" + this.numChambre + " : \nClient : " + this.client + "\n"
				+ annulation;
		
	}

	public Date getArrive() {
		return arrive;
	}

	public void setArrive(Date arrive) {
		this.arrive = arrive;
	}

	public Date getDepart() {
		return depart;
	}

	public void setDepart(Date depart) {
		this.depart = depart;
	}

	public int getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
		
	public boolean getAnnulation() {
		return this.annulee;
	}
	
	public void setAnnulation() {
		this.annulee = true;
	}
	
}
