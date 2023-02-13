package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.Atleta;
import modello.Gara;
import modello.Relazione;
import modello.Sponsor;
import modello.StatisticaByCitta;
import persistenza.AtletaDaoImp;
import persistenza.GaraDaoImp;

class test {
	
	AtletaDaoImp atletaDao = new AtletaDaoImp();
	
	GaraDaoImp garaDao = new GaraDaoImp (); 
	
	//@BeforeEach
	void setUp () {
		
		
		for(Gara g : garaDao.SelTutti()) {
			garaDao.Elimina(g);
		}
		
		for(Atleta a : atletaDao.SelTutti()) {
			atletaDao.Elimina(a);
		}
		
		Gara g = new Gara(2465, "prova", 23);
		garaDao.Inserisci(g);
		
		
		Relazione r = new Relazione();
		r.setGara(g);
		
		Atleta a = new Atleta("alessio", "palmese", "napoli");
		Sponsor s = new Sponsor("coca", "dnio", true);
		a.setSponsor(s);
		r.setAtleta(a);
		
		List <Relazione> lista = new ArrayList();
		lista.add(r);
		
		a.setListaRelazioneAtleta(lista);
		atletaDao.Inserisci(a);
		
		
	}
	

	@Test
	void test() {
		
		List <Gara> lista = garaDao.findAllByLunghezzaKmOrderByLunghezzaKmAsc(100);
		
		
		for(Gara g : lista) {
			System.out.println(g);
		}
		
	}
	
	@Test
	void test2() {
		
		for(StatisticaByCitta a : atletaDao.findGroupByCitta()) {
			System.out.println(a);
		}
		
	}

}
