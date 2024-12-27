package com.climpia.ventasclimpia.service.impl;

import com.climpia.ventasclimpia.model.entities.Cliente;
import com.climpia.ventasclimpia.model.entities.Venta;
import com.climpia.ventasclimpia.model.entities.Detalle;
import com.climpia.ventasclimpia.model.entities.Usuario;
import com.climpia.ventasclimpia.repository.persistence.ClienteCrudRepository;
import com.climpia.ventasclimpia.repository.persistence.DetalleCrudRepository;
import com.climpia.ventasclimpia.repository.persistence.VentaCrudRepository;
import com.climpia.ventasclimpia.service.VentaService;
import com.climpia.ventasclimpia.service.ProductoService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Stateless
public class VentaServiceImpl implements VentaService {

    @Inject
    private VentaCrudRepository ventaCrudRepository;

    @Inject
    private DetalleCrudRepository detalleCrudRepository;
    
    @Inject
    private ClienteCrudRepository clienteCrudRepository;

    @Inject
    private ProductoService productoService;

    @Override
    @Transactional
    public void createSale(Venta venta, List<Detalle> detalles) {
        // Validate stock availability
        for (Detalle detalle : detalles) {
            if (!productoService.isProductAvailable(detalle.getIdprod().getId(), detalle.getCant().intValue())) {
                throw new RuntimeException("Insufficient stock for product: " + detalle.getIdprod().getNombre());
            }
        }

        // Create sale
        ventaCrudRepository.save(venta);

        // Create details and update stock
        for (Detalle detalle : detalles) {
            detalle.setIdventa(venta);
            detalleCrudRepository.save(detalle);
            productoService.updateProductStock(detalle.getIdprod().getId(), -detalle.getCant().intValue());
        }
    }

    @Override
    public Venta getSale(Integer id) {
        return ventaCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateSale(Venta venta) {
        ventaCrudRepository.update(venta);
    }

    @Override
    @Transactional
    public void deleteSale(Integer id) {
        // Restore stock before deleting 
        List<Detalle> detalles = getSaleDetails(id);
        for (Detalle detalle : detalles) {
            productoService.updateProductStock(detalle.getIdprod().getId(), detalle.getCant().intValue());
            detalleCrudRepository.delete(detalle);
        }
        // Deleting the sale 
        Venta venta = ventaCrudRepository.findById(id);
        if (venta != null) {
            ventaCrudRepository.delete(venta);
        }
    }

    @Override
    public List<Venta> getAllSales() {
        return ventaCrudRepository.findAll();
    }

    @Override
    public List<Venta> getSalesByCustomer(Usuario cliente) {
        return ventaCrudRepository.findByCliente(cliente.getId());
    }
    
    @Override
    public String getCustomer(Integer id) {
        String clienteN = clienteCrudRepository.findById(id).getNombre();
        String clienteA = clienteCrudRepository.findById(id).getApellido();
        return clienteN + " " + clienteA;
    }

    @Override
    public List<Venta> getSalesByDate(Date fecha) {
        return ventaCrudRepository.findByFecha(fecha);
    }

    @Override
    public List<Venta> getSalesBySeller(String vendedor) {
        return ventaCrudRepository.findByVendedor(vendedor);
    }

    @Override
    public List<Detalle> getSaleDetails(Integer ventaId) {
        return ventaCrudRepository.getSaleDetails(ventaId);
    }
}
