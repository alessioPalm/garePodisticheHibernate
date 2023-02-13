package persistenza;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import modello.Atleta;
import modello.Gara;
import modello.StatisticaByCitta;

public class AtletaDaoImp extends AbstractDao<Atleta, Integer> implements AtletaDao{

	@Override
	public List<StatisticaByCitta> findGroupByCitta() {
		openCurrentSessionwithTransaction();
		
		List <StatisticaByCitta> lista = session.createCriteria(Atleta.class).setProjection(Projections.projectionList()
				.add(Projections.groupProperty("citta").as("citta")).add(Projections.count("citta").as("conteggio")))
		.setResultTransformer(Transformers.aliasToBean(StatisticaByCitta.class)).list();
		
		int totale = 0;
		for (StatisticaByCitta s : lista) {
			totale += s.getConteggio();
		}
		
		for (StatisticaByCitta s : lista) {
			double percentuale = s.getConteggio() * 100 / totale;
			s.setPercentuale(percentuale);
		}
		
		closeCurrentSessionwithTransaction();
		
		return lista;
		
	}

	
}
