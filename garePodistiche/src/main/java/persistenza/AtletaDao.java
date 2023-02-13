package persistenza;

import java.util.List;

import modello.Atleta;
import modello.StatisticaByCitta;

public interface AtletaDao extends GenericRepository <Atleta, Integer> {

	List <StatisticaByCitta> findGroupByCitta();
}
