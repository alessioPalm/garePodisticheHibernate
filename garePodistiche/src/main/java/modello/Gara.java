package modello;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Gara implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
	
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int codice;
	
	private String descrizione;
	
	private int lunchezzaKm;
	
	private LocalDateTime data;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "gara", orphanRemoval = true)
	private List <Relazione> listaRelazioneGara;

	public Gara(int codice, String descrizione, int lunchezzaKm) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.lunchezzaKm = lunchezzaKm;
	}
	
	public Gara () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getLunchezzaKm() {
		return lunchezzaKm;
	}

	public void setLunchezzaKm(int lunchezzaKm) {
		this.lunchezzaKm = lunchezzaKm;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Gara [id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", lunchezzaKm=" + lunchezzaKm
				+ ", data=" + data + ", listaRelazioneGara=" + listaRelazioneGara + "]";
	}

	
	
	
	
	
}
