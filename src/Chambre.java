import java.util.concurrent.atomic.AtomicInteger;

public class Chambre {

	private int numChambre;
	private int etatReservation;
	private double tarif;
	private String typeChambre;
	
	private static final AtomicInteger count = new AtomicInteger();
	
	public Chambre(String typeChambre, int nbLit, double tarif) {
		this.typeChambre = typeChambre.toLowerCase();
		this.tarif = tarif;
		this.numChambre = count.incrementAndGet();
		this.etatReservation = 0;
	}

	public int getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public int getEtatReservation() {
		return etatReservation;
	}
	
	public void setEtatReservation(int etatReservation) {
		this.etatReservation = etatReservation;
	}
	
	public String getTypeChambre() {
		return typeChambre;
	}
	
	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}
	
	public String toString() {
		
		String reservation = "Libre";
		
		String str = this.typeChambre;
		String uppercase = str.substring(0, 1).toUpperCase() + str.substring(1);
		this.typeChambre = uppercase;
		
		if(etatReservation == 1) {
			reservation = "Occupée";
		}
		
		return "    Chambre n°" + this.numChambre + " : Type de chambre : " + this.typeChambre + ", Etat : " + reservation + ", Tarif : " + this.tarif
				+ " €" ;
	}
	
	
}
