package persistenza;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistenza.HibernateUtil;

public abstract class AbstractDao <I extends Serializable, Id extends Serializable> implements GenericRepository<I, Id>  {

	
	Session session ;
	
	private Transaction currentTransaction;
		
	protected final Class<I> entityClass;  
	
	CriteriaBuilder builder;
	
	public AbstractDao() { 
		this.entityClass = (Class<I>) ((ParameterizedType)
				this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = session.beginTransaction();
        return session;
    }
	
	
	 public void closeCurrentSessionwithTransaction() {
	        currentTransaction.commit();
	        session.close();
	    }
		
	
	private CriteriaQuery<I> IntCriteria(){  
		builder = this.session.getCriteriaBuilder();
		return builder.createQuery(this.entityClass);
	}
	
	public List <I> SelTutti (){
		openCurrentSessionwithTransaction();
		
		CriteriaQuery<I> query = this.IntCriteria();
		
		List <I> lista = this.session.createQuery(query.select(query.from(this.entityClass))).getResultList();
		
		closeCurrentSessionwithTransaction();
		
		return lista;
	}
	
	
	public I SelById (Id id) {
		
		CriteriaQuery<I> query = this.IntCriteria();
		
		return this.session.createQuery(
				query.where(
						builder.equal(
								query.from(this.entityClass).get("id"), id))).getSingleResult();
	}
	
	
	public void Aggiorna(I entity) {
		this.session.merge(entity);
		flushAndClear(); 
	}
	
	public void Elimina(I entity) {
		openCurrentSessionwithTransaction();
		
		this.session.remove(this.session.contains(entity) ? entity : this.session.merge(entity));  //verifica se l entity e presente nel dataBase
		
		flushAndClear();
		
		closeCurrentSessionwithTransaction();
	}
	
	public void EliminaById(Id id) {
		CriteriaQuery<I> query = this.IntCriteria();
		
		this.session.createQuery(
			query.where(
					builder.equal(
							query.from(this.entityClass).get("id"), id))).executeUpdate();
		
		flushAndClear();
	}
	
	public void Inserisci(I Entity) {
		openCurrentSessionwithTransaction();
		
		
		this.session.persist(Entity);
		
		flushAndClear();
		
		closeCurrentSessionwithTransaction();
		
	}
	
	public void flushAndClear() {
		session.flush();
		session.clear();
	}
	
}
