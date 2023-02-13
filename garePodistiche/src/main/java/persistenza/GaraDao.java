package persistenza;

import persistenza.GenericRepository;

import java.util.List;

import modello.Gara;

public interface GaraDao extends GenericRepository <Gara, Integer> {

	List <Gara> findAllByLunghezzaKmOrderByLunghezzaKmAsc(int lunchezzaKm);
		
}
