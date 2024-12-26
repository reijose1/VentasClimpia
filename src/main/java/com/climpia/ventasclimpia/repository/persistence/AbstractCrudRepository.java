package com.climpia.ventasclimpia.repository.persistence;

import com.climpia.ventasclimpia.repository.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author Reinaldo Carrillo
 */
public abstract class AbstractCrudRepository<T> implements GenericRepository<T> {

    private final Class<T> entityClass;

    @PersistenceContext(unitName = "SalesPU")
    protected EntityManager em;

    public AbstractCrudRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @Override
    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    @Override
    public T findById(Object entityId) {
        return getEntityManager().find(entityClass, entityId);
    }

    @Override
    public String delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
        return "Was succesfully removed";
    }

    @Override
    public List<T> findAll(T entity) {
        CriteriaQuery query = getEntityManager().getCriteriaBuilder().createQuery();
        query.select(query.from(entityClass));
        return getEntityManager().createQuery(query).getResultList();
    }

}
