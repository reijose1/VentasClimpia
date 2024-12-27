package com.climpia.ventasclimpia.service;

import com.climpia.ventasclimpia.model.entities.Venta;
import com.climpia.ventasclimpia.model.entities.Detalle;
import com.climpia.ventasclimpia.model.entities.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Reinaldo Carrillo
 */
public interface VentaService {
    void createSale(Venta venta, List<Detalle> detalles);
    Venta getSale(Integer id);
    void updateSale(Venta venta);
    void deleteSale(Integer id);
    List<Venta> getAllSales();
    List<Venta> getSalesByCustomer(Usuario cliente);
    List<Venta> getSalesByDate(Date fecha);
    List<Venta> getSalesBySeller(String vendedor);
    List<Detalle> getSaleDetails(Integer ventaId);
    String getCustomer(Integer id);
}