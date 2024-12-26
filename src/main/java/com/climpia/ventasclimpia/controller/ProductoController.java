package com.climpia.ventasclimpia.controller;

import com.climpia.ventasclimpia.model.entities.Producto;
import com.climpia.ventasclimpia.service.ProductoService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
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
@Named (value = "productoManagedBean")
@ViewScoped
public class ProductoController implements Serializable {
    
    @EJB
    private ProductoService productoService;
    
    private List<Producto> productos;
    private Producto selectedProduct;
    private String searchTerm;
    
    @PostConstruct
    public void init() {
        productos = productoService.getAllProducts();
        selectedProduct = new Producto();
    }
    
    public void searchProducts() {
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            productos = productoService.searchProductsByName(searchTerm);
        } else {
            productos = productoService.getAllProducts();
        }
    }
    
    public void saveProduct() {
        try {
            if (selectedProduct.getId() == null) {
                productoService.createProduct(selectedProduct);
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Product created successfully"));
            } else {
                productoService.updateProduct(selectedProduct);
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Product updated successfully"));
            }
            productos = productoService.getAllProducts();
            selectedProduct = new Producto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error processing product"));
        }
    }
    
    public void deleteProduct(Integer id) {
        try {
            productoService.deleteProduct(id);
            productos = productoService.getAllProducts();
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Product deleted successfully"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error deleting product"));
        }
    }
    
    public void prepareNewProduct() {
        selectedProduct = new Producto();
    }
    
    public void editProduct(Producto product) {
        selectedProduct = product;
    }

}