package modello;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sponsor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String tipologia;
	
	private boolean italiano;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sponsor", orphanRemoval = true)
	private List <Atleta> listaRelazioneAtletaSponsor;

	public Sponsor(String nome, String tipologia, boolean italiano) {
		this.nome = nome;
		this.tipologia = tipologia;
		this.italiano = italiano;
	}
	
	public Sponsor () {
		
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

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public boolean isItaliano() {
		return italiano;
	}

	public void setItaliano(boolean italiano) {
		this.italiano = italiano;
	}
	
	

	public List<Atleta> getListaRelazioneAtletaSponsor() {
		return listaRelazioneAtletaSponsor;
	}

	public void setListaRelazioneAtletaSponsor(List<Atleta> listaRelazioneAtletaSponsor) {
		this.listaRelazioneAtletaSponsor = listaRelazioneAtletaSponsor;
	}

	@Override
	public String toString() {
		return "Sponsor [id=" + id + ", nome=" + nome + ", tipologia=" + tipologia + ", italiano=" + italiano + "]";
	}
	
	
}
