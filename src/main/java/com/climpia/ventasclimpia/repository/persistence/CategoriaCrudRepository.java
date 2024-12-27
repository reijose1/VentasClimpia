package com.climpia.ventasclimpia.repository.persistence;

import com.climpia.ventasclimpia.model.entities.Categoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Reinaldo José Carrillo
 */
@ApplicationScoped
public class CategoriaCrudRepository extends AbstractCrudRepository<Categoria> {
        
    @PersistenceContext
    private EntityManager em;

    public CategoriaCrudRepository() {
        super (Categoria.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Categoria findCategoria(String nombre) {
        TypedQuery<Categoria> query = em.createQuery(
            "SELECT c FROM categoria c WHERE LOWER(c.nombre) LIKE LOWER(:nombre)",
            Categoria.class
        );
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getSingleResult();
    }
    
    public Categoria findById(Integer idcat) {
        TypedQuery<Categoria> query = em.createQuery(
            "SELECT c FROM categoria c WHERE c.idcat = :idcat",
            Categoria.class
        );
        query.setParameter("idcat", idcat);
        return query.getSingleResult();
    }
    
    public List<Categoria> findAllCategorias() {
        TypedQuery<Categoria> query = em.createQuery(
            "SELECT c FROM Cliente c",
            Categoria.class
        );
        return query.getResultList();
    }
}
