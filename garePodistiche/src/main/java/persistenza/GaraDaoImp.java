package persistenza;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modello.Gara;
import persistenza.AbstractDao;


public class GaraDaoImp extends AbstractDao<Gara, Integer> implements GaraDao{

	public List<Gara> findAllByLunghezzaKmOrderByLunghezzaKmAsc(int lunchezzaKm) {
		
		openCurrentSessionwithTransaction();
		
		CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Gara> queryDefinition = queryBuilder.createQuery(Gara.class);
		
		Root<Gara> recordset = queryDefinition.from(Gara.class);
		
		queryDefinition.select(recordset).where(queryBuilder.le(recordset.get("lunchezzaKm"), lunchezzaKm))
		.orderBy(queryBuilder.asc(recordset.get("lunchezzaKm")));
		
		List <Gara> listaGara = session.createQuery(queryDefinition).getResultList();
		
		
		closeCurrentSessionwithTransaction();
		
		return listaGara;
	}
		

}
