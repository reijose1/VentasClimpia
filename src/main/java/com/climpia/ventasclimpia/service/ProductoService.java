package com.climpia.ventasclimpia.service;

import com.climpia.ventasclimpia.model.entities.Producto;
import java.util.List;

/**
 *
 * @author Reinaldo Carrillo
 */
public interface ProductoService {
    void createProduct(Producto producto);
    Producto getProduct(Integer id);
    void updateProduct(Producto producto);
    void deleteProduct(Integer id);
    List<Producto> getAllProducts();
    List<Producto> getProductsByCategory(Integer categoryId);
    List<Producto> searchProductsByName(String name);
    void updateProductStock(Integer productId, Integer quantity);
    boolean isProductAvailable(Integer productId, Integer quantity);
}