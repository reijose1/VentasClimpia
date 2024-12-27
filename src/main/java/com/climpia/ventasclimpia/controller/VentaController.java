package com.climpia.ventasclimpia.controller;

import com.climpia.ventasclimpia.model.entities.Cliente;
import com.climpia.ventasclimpia.model.entities.Venta;
import com.climpia.ventasclimpia.model.entities.Detalle;
import com.climpia.ventasclimpia.model.entities.Producto;
import com.climpia.ventasclimpia.service.ClienteService;
import com.climpia.ventasclimpia.service.VentaService;
import com.climpia.ventasclimpia.service.ProductoService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Reinaldo Carrillo
 */
@Getter @Setter
@Named(value = "ventaManagedBean")
@ViewScoped
public class VentaController implements Serializable {
    
    @EJB
    private VentaService ventaService;
    
    @EJB
    private ClienteService clienteService;
    
    @Inject
    private ProductoService productoService;
    
    private List<Venta> ventas;
    private Venta selectedVenta;
    private List<Detalle> detalles;
    private Detalle newDetalle;
    private Date searchDate;
    private List<Producto> productos;
    private Cliente cliente;
    private List<Cliente> clientes;
    
    @PostConstruct
    public void init() {
        ventas = ventaService.getAllSales();
        selectedVenta = new Venta();
        detalles = new ArrayList<>();
        newDetalle = new Detalle();
        productos = productoService.getAllProducts();
        clientes = clienteService.getAllCustomers();
    }
    
    public String getCliente(Integer id){
        return ventaService.getCustomer(id);
    }
    
    public void prepareNewSale() {
        selectedVenta = new Venta();
        selectedVenta.setFecha(LocalDate.now());
        detalles = new ArrayList<>();
        newDetalle = new Detalle();
    }
    
    public void addDetail() {
        if (newDetalle.getIdprod() != null && newDetalle.getCant().compareTo(BigDecimal.ZERO) > 0) {
            Producto producto = productoService.getProduct(newDetalle.getIdprod().getId());
            if (productoService.isProductAvailable(producto.getId(), newDetalle.getCant().intValue())) {
                newDetalle.setPrecio(producto.getPrecio());
                newDetalle.setSubtotal(newDetalle.getPrecio().multiply(newDetalle.getCant()));
                detalles.add(newDetalle);
                updateTotal();
                newDetalle = new Detalle();
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Insufficient stock"));
            }
        }
    }
    
    public void removeDetail(Detalle detalle) {
        detalles.remove(detalle);
        updateTotal();
    }
    
    private void updateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Detalle detalle : detalles) {
            total = total.add(detalle.getSubtotal());
        }
        selectedVenta.setImporte(total);
    }
    
    public void saveSale() {
        try {
            if (detalles.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Add at least one product"));
                return;
            }
            
            ventaService.createSale(selectedVenta, detalles);
            ventas = ventaService.getAllSales();
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Sale created successfully"));
            prepareNewSale();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }
    
    public void searchByDate() {
        if (searchDate != null) {
            ventas = ventaService.getSalesByDate(searchDate);
        } else {
            ventas = ventaService.getAllSales();
        }
    }
    
    public void viewDetails(Integer ventaId) {
        detalles = ventaService.getSaleDetails(ventaId);
    }

}