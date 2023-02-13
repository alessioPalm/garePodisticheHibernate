package modello;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Relazione {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalTime orarioDiArrivo;
	
	@ManyToOne
	private Gara gara;
	
	@ManyToOne
	private Atleta atleta;
	
	public Relazione () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getOrarioDiArrivo() {
		return orarioDiArrivo;
	}

	public void setOrarioDiArrivo(LocalTime orarioDiArrivo) {
		this.orarioDiArrivo = orarioDiArrivo;
	}

	public Gara getGara() {
		return gara;
	}

	public void setGara(Gara gara) {
		this.gara = gara;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
	

	@Override
	public String toString() {
		return "Relazione [id=" + id + ", orarioDiArrivo=" + orarioDiArrivo
				+ "]";
	}
	
	
	
}
