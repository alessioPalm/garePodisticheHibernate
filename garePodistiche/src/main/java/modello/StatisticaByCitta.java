package modello;

public class StatisticaByCitta {

	private String citta;
	
	private long conteggio;

	public String getCitta() {
		return citta;
	}
	
	private double percentuale;

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public long getConteggio() {
		return conteggio;
	}

	public void setConteggio(long conteggio) {
		this.conteggio = conteggio;
	}
	
	

	public double getPercentuale() {
		return percentuale;
	}

	public void setPercentuale(double percentuale) {
		this.percentuale = percentuale;
	}

	@Override
	public String toString() {
		return "StatisticaByCitta [citta=" + citta + ", conteggio=" + conteggio + ", percentuale=" + percentuale + "]";
	}

	
	
	
	
	
}
