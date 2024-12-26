package com.climpia.ventasclimpia.repository.persistence;

import com.climpia.ventasclimpia.model.entities.Producto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ProductoCrudRepository extends AbstractCrudRepository<Producto> {
    
    @PersistenceContext
    private EntityManager em;
    
    public ProductoCrudRepository() {
        super(Producto.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Producto> findByNombre(String nombre) {
        TypedQuery<Producto> query = em.createQuery(
            "SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:nombre)",
            Producto.class
        );
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }
    
    public List<Producto> findByCategoria(String categoria) {
        TypedQuery<Producto> query = em.createQuery(
            "SELECT p FROM Producto p WHERE p.categoria = :categoria",
            Producto.class
        );
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }
}