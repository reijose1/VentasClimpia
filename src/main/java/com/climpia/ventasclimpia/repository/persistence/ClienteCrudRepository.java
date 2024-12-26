package com.climpia.ventasclimpia.repository.persistence;

import com.climpia.ventasclimpia.model.entities.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ClienteCrudRepository extends AbstractCrudRepository<Cliente> {
    
    @PersistenceContext
    private EntityManager em;
    
    public ClienteCrudRepository() {
        super(Cliente.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Cliente> findByNombre(String nombre) {
        TypedQuery<Cliente> query = em.createQuery(
            "SELECT c FROM Cliente c WHERE LOWER(c.nombre) LIKE LOWER(:nombre)",
            Cliente.class
        );
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }
    
    public Cliente findByEmail(String email) {
        TypedQuery<Cliente> query = em.createQuery(
            "SELECT c FROM Cliente c WHERE c.email = :email",
            Cliente.class
        );
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}