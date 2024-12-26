package com.climpia.ventasclimpia.controller;

import com.climpia.ventasclimpia.model.entities.Categoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Reinaldo Carrillo
 */

@Getter @Setter
@Named (value = "categoriaManagedBean")
@ApplicationScoped
public class CategoryController implements Serializable {
    
    @PersistenceContext(unitName = "SalesPU")
    private EntityManager em;
    
    private List<Categoria> categories;
    
    public List<Categoria> getCategories() {
        if (categories == null) {
            categories = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        }
        return categories;
    }
    
    public void setCategories(List<Categoria> categories) {
        this.categories = categories;
    }
    
    public void refreshCategories() {
        categories = null;
        getCategories();
    }
}