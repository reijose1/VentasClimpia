package com.climpia.ventasclimpia.repository.persistence;

import com.climpia.ventasclimpia.model.entities.Detalle;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class DetalleCrudRepository extends AbstractCrudRepository<Detalle> {
    
    @PersistenceContext
    private EntityManager em;
    
    public DetalleCrudRepository() {
        super(Detalle.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Detalle> findByVenta(Integer ventaId) {
        TypedQuery<Detalle> query = em.createQuery(
            "SELECT d FROM Detalle d WHERE d.venta.id = :ventaId",
            Detalle.class
        );
        query.setParameter("ventaId", ventaId);
        return query.getResultList();
    }
}