package com.climpia.ventasclimpia.service.impl;

import com.climpia.ventasclimpia.model.entities.Producto;
import com.climpia.ventasclimpia.repository.persistence.ProductoCrudRepository;
import com.climpia.ventasclimpia.service.ProductoService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Reinaldo Carrillo
 */
@Stateless
public class ProductoServiceImpl implements ProductoService {

    @Inject
    private ProductoCrudRepository productoCrudRepository;

    @Override
    @Transactional
    public void createProduct(Producto producto) {
        productoCrudRepository.save(producto);
    }

    @Override
    public Producto getProduct(Integer id) {
        return productoCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateProduct(Producto producto) {
        productoCrudRepository.update(producto);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        Producto producto = getProduct(id);
        if (producto != null) {
            productoCrudRepository.delete(producto);
        }
    }

    @Override
    public List<Producto> getAllProducts() {
        return productoCrudRepository.findAll(new Producto());
    }

    @Override
    public List<Producto> getProductsByCategory(Integer categoryId) {
        return productoCrudRepository.findByCategoria(categoryId.toString());
    }

    @Override
    public List<Producto> searchProductsByName(String name) {
        return productoCrudRepository.findByNombre(name);
    }

    @Override
    @Transactional
    public void updateProductStock(Integer productId, Integer quantity) {
        Producto producto = getProduct(productId);
        if (producto != null) {
            producto.setStock(producto.getStock() + quantity);
            productoCrudRepository.update(producto);
        }
    }

    @Override
    public boolean isProductAvailable(Integer productId, Integer quantity) {
        Producto producto = getProduct(productId);
        return producto != null && producto.getStock() >= quantity;
    }
}