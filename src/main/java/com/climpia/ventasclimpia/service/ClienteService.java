package com.climpia.ventasclimpia.service;

import com.climpia.ventasclimpia.model.entities.Cliente;
import java.util.List;

/**
 *
 * @author Reinaldo Carrillo
 */
public interface ClienteService {
    void createCustomer(Cliente cliente);
    Cliente getCustomer(Integer id);
    void updateCustomer(Cliente cliente);
    void deleteCustomer(Integer id);
    List<Cliente> getAllCustomers();
    List<Cliente> searchCustomersByName(String name);
    Cliente findCustomerByEmail(String email);
}