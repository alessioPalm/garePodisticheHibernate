package modello;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Atleta implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String cognome;
	
	private String citta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Sponsor sponsor; 
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "atleta", orphanRemoval = true)
	private List <Relazione> listaRelazioneAtleta;

	public Atleta(String nome, String cognome, String citta) {
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
	}
	
	public Atleta () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public List<Relazione> getListaRelazioneAtleta() {
		return listaRelazioneAtleta;
	}

	public void setListaRelazioneAtleta(List<Relazione> listaRelazioneAtleta) {
		this.listaRelazioneAtleta = listaRelazioneAtleta;
	}

	@Override
	public String toString() {
		return "Atleta [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", citta=" + citta + "]";
	}
	
	
	
	
	
}
