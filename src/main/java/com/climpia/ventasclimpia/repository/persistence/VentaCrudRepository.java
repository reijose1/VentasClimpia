package com.climpia.ventasclimpia.repository.persistence;

import com.climpia.ventasclimpia.model.entities.Detalle;
import com.climpia.ventasclimpia.model.entities.Venta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class VentaCrudRepository extends AbstractCrudRepository<Venta> {
    
    @PersistenceContext
    private EntityManager em;
    
    private DetalleCrudRepository detalleCrudRepository;
    
    public VentaCrudRepository() {
        super(Venta.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Venta> findAll() { 
        TypedQuery<Venta> query = em.createQuery("SELECT v FROM Venta v", Venta.class); 
        return query.getResultList();  
    } 
    
    public List<Venta> findByFecha(Date fecha) {
        TypedQuery<Venta> query = em.createQuery(
            "SELECT v FROM Venta v WHERE v.fecha = :fecha",
            Venta.class
        );
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }
    
    public List<Venta> findByCliente(Integer clienteId) {
        TypedQuery<Venta> query = em.createQuery(
            "SELECT v FROM Venta v WHERE v.cliente.id = :clienteId",
            Venta.class
        );
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }
    
    public List<Venta> findByVendedor(String vendedor) {
        TypedQuery<Venta> query = em.createQuery(
            "SELECT v FROM Venta v WHERE v.vendedor = :vendedor",
            Venta.class
        );
        query.setParameter("vendedor", vendedor);
        return query.getResultList();
    }
    
    public List<Detalle> getSaleDetails(Integer ventaId) {
        TypedQuery<Detalle> query = detalleCrudRepository.getEntityManager().createQuery(
            "SELECT d FROM Detalle d WHERE d.venta.id = :ventaId", 
            Detalle.class  
        ); 
        query.setParameter("ventaId", ventaId); 
        return query.getResultList();
    }
}